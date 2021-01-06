package com.modernjava.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Apple {
	
	public Apple(AppleColor color, double weightGrams) {
		this.color = color;
		this.weightGrams = weightGrams;
	}
	private AppleColor color;
	private Double weightGrams;
}
