package com.modernjava.demo.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modernjava.demo.model.Apple;

@RestController
@RequestMapping(value = "/sort")
public class ModernJavaController {

	@GetMapping(path = "/apples")
	public String getDate() {
		
//******** Sorting Apples **********************************************
		Apple a1 = new Apple("red", 38.1 );
		Apple a2 = new Apple("green", 32.3);
		Apple a3 = new Apple("green", 36.7);
		
		List<Apple> apples = new ArrayList<>();
		apples.add(0, a1);
		apples.add(1, a2);
		apples.add(2, a3);
		
		for(Apple a: apples) {
			System.out.println("Before :"+a.getWeightGrams());
		}
		System.out.println("\n_______________________");
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
 * This is the better way. It's the Java 8 way.		
 */
		apples.sort(Comparator.comparing(Apple::getWeightGrams));
		
		apples.stream().map(Apple::getWeightGrams).forEach(System.out::println);
//**********************************************************************		
		return "The apples have been sorted!";
	}
}
