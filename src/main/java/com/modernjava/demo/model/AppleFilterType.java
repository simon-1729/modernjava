package com.modernjava.demo.model;

public enum AppleFilterType {

	BYWEIGHT("byWeight"),
	BYCOLOR("byColor"),
	SORT("sort");

	private final String value;

	AppleFilterType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
