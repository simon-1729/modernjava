package com.modernjava.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Apple {
	public final static Double HEAVY_APPLE = 33.0;

	private AppleColor color;
	private Double weight;

	public static boolean isGreenApple(Apple apple) {
		return AppleColor.GREEN.equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return (apple.getWeight() > HEAVY_APPLE);
	}
}
