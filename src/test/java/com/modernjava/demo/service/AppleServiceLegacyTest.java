package com.modernjava.demo.service;

import static com.modernjava.demo.model.Apple.HEAVY_APPLE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.modernjava.demo.ModernjavaApplication;
import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleColor;
import com.modernjava.demo.util.AppleUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ModernjavaApplication.class)
class AppleServiceLegacyTest {
	private final String BY_WEIGHT = "byWeight";
	private final String BY_COLOR = "byColor";

	@Autowired
	private AppleServiceLegacy appleService;

	@Test
	void testSortApples_expectOrderedByWeight() {
		List<Apple> expectOrderByWeight = appleService.sortApples();

		assertTrue("Fail on apples not ordered by Weight",
			AppleUtil.isOrderedByWeight(expectOrderByWeight));
	}

	@Test
	void testSortApplesJ8_expectOrderedByWeight() {
		List<Apple> expectOrderByWeight = appleService.sortApplesJ8();

		assertTrue("Fail on apples not ordered by Weight",
			AppleUtil.isOrderedByWeight(expectOrderByWeight));
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
			.anyMatch(a -> a.getWeight() > HEAVY_APPLE);

		assertFalse("Fail on heavy apples exists", heavyAppleExists);
	}

	@Test
	void testFilterApplesJ8_expectNoHeavyApples() {
		List<Apple> expectNoHeavyApples = appleService
			.filterApplesJ8(BY_WEIGHT);

		Boolean heavyAppleExists = expectNoHeavyApples.stream()
			.anyMatch(a -> a.getWeight() > HEAVY_APPLE);

		assertFalse("Fail on heavy apples exists", heavyAppleExists);
	}
}
