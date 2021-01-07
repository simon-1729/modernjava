package com.modernjava.demo.service;

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
	public String filterApplesJ8(String filterType);
}
