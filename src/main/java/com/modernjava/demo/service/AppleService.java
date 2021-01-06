package com.modernjava.demo.service;

import com.modernjava.demo.model.AppleColor;

public interface AppleService {

	public String sortApples();

	public String filterApplesByColor(AppleColor appleColor);

	public String filterApplesByWeight(Double minWeight);
}
