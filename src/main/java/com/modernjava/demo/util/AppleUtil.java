package com.modernjava.demo.util;

import java.util.List;

import com.modernjava.demo.model.Apple;

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
}
