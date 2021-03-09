package com.modernjava.demo.service;

import static com.modernjava.demo.model.Apple.HEAVY_APPLE;
import static com.modernjava.demo.model.AppleFilterType.BYCOLOR;
import static com.modernjava.demo.model.AppleFilterType.BYWEIGHT;
import static com.modernjava.demo.model.AppleFilterType.SORT;
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
class AppleServiceModernTest {

	@Autowired
	private AppleServiceModern appleService;

	@Test
	void testFilterApplesWithModernJava_expectOrderedByWeight() {
		List<Apple> expectOrderByWeight
			= appleService.filterApplesWithModernJava(SORT);

		assertTrue("Fail on apples not ordered by Weight",
			AppleUtil.isOrderedByWeight(expectOrderByWeight));
	}

	@Test
	void testFilterApplesWithModernJava_expectNoRedApples() {
		List<Apple> expectNoRedApples
			= appleService.filterApplesWithModernJava(BYCOLOR);

		Boolean redAppleExists = expectNoRedApples.stream()
			.anyMatch(a -> a.getColor().equals(AppleColor.RED));

		assertFalse("Fail on red apple exists", redAppleExists);
	}

	@Test
	void testFilterApplesWithModernJava_expectNoHeavyApples() {
		List<Apple> expectNoHeavyApples
			= appleService.filterApplesWithModernJava(BYWEIGHT);

		Boolean heavyAppleExists = expectNoHeavyApples.stream()
			.anyMatch(a -> a.getWeight() > HEAVY_APPLE);

		assertFalse("Fail on heavy apple exists", heavyAppleExists);
	}
}
