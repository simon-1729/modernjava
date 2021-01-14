package com.modernjava.demo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleColor;
import com.modernjava.demo.service.impl.AppleServiceLegacyImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppleServiceLegacyImpl.class)
class AppleServiceLegacyTest {
	private final String BY_WEIGHT = "byWeight";
	private final String BY_COLOR = "byColor";

	@Autowired
	private AppleServiceLegacy appleService;

	@Test
	void testSortApples_expectOrderedByWeight() {
		List<Apple> expectOrderByWeight = appleService.sortApples();

		assertTrue("Fail on apples not ordered by Weight",
			isOrderedByWeight(expectOrderByWeight));
	}

	@Test
	void testSortApplesJ8_expectOrderedByWeight() {
		List<Apple> expectOrderByWeight = appleService.sortApplesJ8();

		assertTrue("Fail on apples not ordered by Weight",
			isOrderedByWeight(expectOrderByWeight));
	}

	@Test
	void testFilterApples_expectNoRedApples() {
		List<Apple> expectNoRedApples = appleService
			.filterApples(BY_COLOR);

		Boolean redAppleExists = expectNoRedApples.stream()
			.anyMatch(a -> a.getColor().equals(AppleColor.RED));

		assertFalse("Fail on red apple exists", redAppleExists);
	}

	@Test
	void testFilterApplesJ8_expectNoRedApples() {
		List<Apple> expectNoRedApples = appleService
			.filterApplesJ8(BY_COLOR);

		Boolean redAppleExists = expectNoRedApples.stream()
			.anyMatch(a -> a.getColor().equals(AppleColor.RED));

		assertFalse("Fail on red apple exists", redAppleExists);
	}

	@Test
	void testFilterApples_expectNoHeavyApples() {
		List<Apple> expectNoHeavyApples = appleService
			.filterApples(BY_WEIGHT);

		Boolean heavyAppleExists = expectNoHeavyApples.stream()
			.anyMatch(a -> a.getWeight() > AppleServiceLegacy.HEAVY_APPLE);

		assertFalse("Fail on heavy apples exists", heavyAppleExists);
	}

	@Test
	void testFilterApplesJ8_expectNoHeavyApples() {
		List<Apple> expectNoHeavyApples = appleService
			.filterApplesJ8(BY_WEIGHT);

		Boolean heavyAppleExists = expectNoHeavyApples.stream()
			.anyMatch(a -> a.getWeight() > AppleServiceLegacy.HEAVY_APPLE);

		assertFalse("Fail on heavy apples exists", heavyAppleExists);
	}

	private Boolean isOrderedByWeight(List<Apple> apples) {
		Boolean isOrdered = true;
		for(int i=0; i<apples.size()-1; i++) {
			if(apples.get(i).getWeight()
				> apples.get(i+1).getWeight()) {
					isOrdered = false;
					break;
			}
		}
		return isOrdered;
	}

}