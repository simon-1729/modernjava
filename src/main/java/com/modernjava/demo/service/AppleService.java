package com.modernjava.demo.service;

import java.util.List;

import com.modernjava.demo.model.Apple;

public interface AppleService {
	/*
	 * Old school java.
	 */
	public String sortApples();

	/*
	 * Old school java.
	 */
	public String filterApples(String filterType);

	/*
	 * The Java 8 way.
	 */
	public String sortApplesJ8();

	/*
	 * The Java 8 way.
	 */
	public List<Apple> filterApplesJ8(String filterType);
}
