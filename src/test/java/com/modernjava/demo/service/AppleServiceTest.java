package com.modernjava.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleColor;
import com.modernjava.demo.service.AppleService;
import com.modernjava.demo.service.AppleServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppleServiceImpl.class)
class AppleServiceTest {
	private final String BY_WEIGHT = "byWeight";
	private final String BY_COLOR = "byColor";

	@Autowired
	private AppleService appleService;

	@Test
	void testSortApples_expectOrderedByWeight() {
		List<Apple> resultOrdered = appleService.sortApples();

		Boolean ordered = true;

		for(int i=0; i<resultOrdered.size()-1; i++) {
			if(resultOrdered.get(i).getWeight()
				> resultOrdered.get(i+1).getWeight()) {
					ordered = false;
					break;
			}
		}
		assertTrue("Apples not in assending order!", ordered);
	}

	@Test
	void testSortApplesJ8_expectOrderedByWeight() {
		List<Apple> resultOrdered = appleService.sortApplesJ8();

		Boolean ordered = true;

		for(int i=0; i<resultOrdered.size()-1; i++) {
			if(resultOrdered.get(i).getWeight()
				> resultOrdered.get(i+1).getWeight()) {
					ordered = false;
					break;
			}
		}
		assertTrue("Apples not in assending order!", ordered);
	}

	@Test
	void testFilterApples_expectNoRedApples() {
		List<Apple> resultByColor = appleService
				.filterApples(BY_COLOR);

		Boolean redAppleExists = false;

		for( Apple apple: resultByColor) {
			if(apple.getColor().equals(AppleColor.RED)) {
				redAppleExists = true;
				break;
			}
		}
		assertThat(redAppleExists).isFalse();
	}

	@Test
	void testFilterApples_expectNoHeavyApples() {
		List<Apple> resultByWeight = appleService
				.filterApples(BY_WEIGHT);

		Double badApple = 0d;

		for( Apple apple: resultByWeight) {
			if(apple.getWeight() > AppleService.HEAVY_APPLE) {
				badApple = apple.getWeight();
				break;
			}
		}
		assertTrue(badApple+" is too heavy!",
			badApple < AppleService.HEAVY_APPLE);
	}

	@Test
	void testFilterApplesJ8_expectNoRedApples() {
		List<Apple> resultByColor = appleService
			.filterApplesJ8(BY_COLOR);

		Boolean redAppleExists = false;

		for( Apple apple: resultByColor) {
			if(apple.getColor().equals(AppleColor.RED)) {
				redAppleExists = true;
				break;
			}
		}
		assertThat(redAppleExists).isFalse();
	}

	@Test
	void testFilterApplesJ8Test_expectNoHeavyApples() {
		List<Apple> resultByWeight = appleService
				.filterApplesJ8(BY_WEIGHT);

			Double badApple = 0d;

			for( Apple apple: resultByWeight) {
				if(apple.getWeight() > AppleService.HEAVY_APPLE) {
					badApple = apple.getWeight();
					break;
				}
			}
			assertTrue(badApple+" is too heavy!",
				badApple < AppleService.HEAVY_APPLE);
	}

}
