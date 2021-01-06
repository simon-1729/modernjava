package com.modernjava.demo.service.Impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleColor;

@Service
public class AppleServiceImpl implements com.modernjava.demo.service.AppleService {
	public String sortApples() {
		List<Apple> apples = addApples();
		apples.stream().map(Apple::getWeightGrams).forEach(System.out::println);
		
	//******** Sorting Apples **********************************************
		/*
		 * The below is the old school way! There is a better way.		
		 */
		
		/*
		Collections.sort(apples, new Comparator<Apple>() {
			@Override
			public int compare(Apple a1, Apple a2) {
				return a1.getWeightGrams().compareTo(a2.getWeightGrams());				
			}			
		});
		*/
		
		/*
		 * This is the way... the Java 8 way!		
		 */
		apples.sort(Comparator.comparing(Apple::getWeightGrams));
		
	//**********************************************************************
		System.out.println("\n_______ AFTER________________");
		apples.stream().map(Apple::getWeightGrams).forEach(System.out::println);		
		return "The Apples have been sorted by weight";
	}

	public String filterApplesByColor(AppleColor appleColor) {		
		List<Apple> apples = addApples();
		List<Apple> result = new ArrayList<>();
		
		for(Apple apple: apples) {
			if(appleColor.equals(apple.getColor())){
				result.add(apple);
			}
		}
		result.stream().map(Apple::getColor).forEach(System.out::println);
		
		return "The Apples have been filtered by color";
	}

	public String filterApplesByWeight(Double minWeight) {		
		List<Apple> apples = addApples();
		List<Apple> result = new ArrayList<>();
		
		for(Apple apple: apples) {
			if(apple.getWeightGrams() > minWeight ){
				result.add(apple);
			}
		}
		result.stream().map(Apple::getWeightGrams).forEach(System.out::println);
		
		return "The Apples have been filtered by minimum weight";
	}
	
	private List<Apple> addApples(){
		
		Apple a1 = new Apple(AppleColor.RED, 38.1 );
		Apple a2 = new Apple(AppleColor.GREEN, 32.3);
		Apple a3 = new Apple(AppleColor.GREEN, 36.7);
		
		List<Apple> apples = new ArrayList<>();
		apples.add(0, a1);
		apples.add(1, a2);
		apples.add(2, a3);
		
		return apples;
	}
}
