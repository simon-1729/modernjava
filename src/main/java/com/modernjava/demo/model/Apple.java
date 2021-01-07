package com.modernjava.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Apple {

	private AppleColor color;
	private Double weight;

	@Override
	public String toString() {
		return String.format("Apple{color='%s', weight=%.2f}",
			color, weight);
	}
}
