package com.modernjava.demo.util;

import java.util.Arrays;
import java.util.List;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleColor;

public class AppleUtil {

	private AppleUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static Boolean isOrderedByWeight(List<Apple> apples) {
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

	/*
	 * Toy data... how do you like them apples!
	 */
	public static List<Apple> addApples() {
		return Arrays.asList(
			new Apple(AppleColor.GREEN, 188.1),
			new Apple(AppleColor.GREEN, 132.3),
			new Apple(AppleColor.RED, 156.7)
		);
	}
}
