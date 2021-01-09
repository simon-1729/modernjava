package com.modernjava.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleColor;

@Service
public class AppleServiceImpl implements AppleService {

	private static final Logger logger = LoggerFactory
			.getLogger(AppleServiceImpl.class);
	/*
	 * This is how we use to sort apple lists.
	 */
	public List<Apple> sortApples() {
		List<Apple> apples = addApples();

		logger.info("BEFORE: {}", apples);

		Collections.sort(apples, new Comparator<Apple>() {
			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeight()
					.compareTo(a2.getWeight());
			}
		});
		logger.info("AFTER: {}", apples);
		return apples;
	}

	/*
	 * This is the way... this is Java 8.
	 */
	public List<Apple> sortApplesJ8() {
		List<Apple> apples = addApples();
		logger.info("BEFORE: {}", apples);

		apples.sort(Comparator.comparing(Apple::getWeight));

		logger.info("AFTER: {}", apples);
		return apples;
	}

	public List<Apple> filterApples(String filterType) {
		if (filterType.equalsIgnoreCase("byColor")) {
			return filterApplesByColor(AppleColor.GREEN);

		} else if (filterType.equalsIgnoreCase("byWeight")) {
			return filterApplesByWeight();
		} else {
			return new ArrayList<>();
		}
	}

	/*
	 * The following two methods can be simplified with
	 * the use of Java 8 Predicates. See filterApplesJ8Helper
	 * below.
	 */
	private List<Apple> filterApplesByColor(AppleColor appleColor) {
		List<Apple> apples = addApples();
		List<Apple> result = new ArrayList<>();

		for(Apple apple: apples) {
			if(appleColor.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		logger.info("Filter out red apples: {}", result);
		return result;
	}

	private List<Apple> filterApplesByWeight() {
		List<Apple> apples = addApples();
		List<Apple> result = new ArrayList<>();

		for(Apple apple: apples) {
			if(apple.getWeight() < HEAVY_APPLE) {
				result.add(apple);
			}
		}
		logger.info("Filter out heavy apples: {}", result);
		return result;
	}
	/*
	 * Use lambdas to pass anonymous function parameter.
	 * In this case the function acts as a predicate for
	 * the filterApplesJ8Helper
	 */
	public List<Apple> filterApplesJ8(String filterType) {
		List<Apple> apples = addApples();

		if (filterType.equalsIgnoreCase("byColor")) {
			return filterApplesJ8Helper(
				(Apple a) -> AppleColor.GREEN.equals
					(a.getColor()), apples);

		} else if (filterType.equalsIgnoreCase("byWeight")) {
			return filterApplesJ8Helper(
				(Apple a) -> (HEAVY_APPLE > a.getWeight()),
					apples);
		} else {
			return new ArrayList<>();
		}
	}

	/*
	 * Reduce the redundancy from filterApplesByColor and
	 * filterApplesByWeight with the following...
	 * the Java 8 way.
	 */
	private List<Apple> filterApplesJ8Helper(
		Predicate<Apple> predicate, List<Apple> apples) {

		List<Apple> result = new ArrayList<>();

		for(Apple apple: apples) {
			if(predicate.test(apple)) {
				result.add(apple);
			}
		}
		logger.info("JAVA 8 FILTERING: {}", result);
		return result;
	}

	/*
	 * Toy data... how do you like them apples!
	 */
	private List<Apple> addApples() {
		return Arrays.asList(
			new Apple(AppleColor.RED, 38.1),
			new Apple(AppleColor.GREEN, 32.3),
			new Apple(AppleColor.GREEN, 36.7)
		);
	}
}
