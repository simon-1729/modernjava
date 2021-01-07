package com.modernjava.demo.service;

import java.util.function.Predicate;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleColor;

public interface AppleService {

	public String sortApples();

	public String filterApplesByColor(AppleColor appleColor);

	public String filterApplesByWeight();

	/*
	 * The Java 8 way.
	 */
	public String sortApplesJ8();

	/*
	 * The Java 8 way.
	 */
	public String filterApplesJ8(Predicate<Apple> predicate);
}
