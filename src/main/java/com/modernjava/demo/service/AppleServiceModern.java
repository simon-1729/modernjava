package com.modernjava.demo.service;

import java.util.List;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleFilterType;

public interface AppleServiceModern {

	public List<Apple> 
	filterApplesWithModernJava(AppleFilterType filterType);

}
