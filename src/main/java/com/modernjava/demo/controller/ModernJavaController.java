package com.modernjava.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleColor;
import com.modernjava.demo.service.AppleService;

@RestController
@RequestMapping(value = "/apples")
public class ModernJavaController {

	@Autowired
	private AppleService appleService;

	@GetMapping(path = "/sorted")
	public String sorted() {
		return appleService.sortApples();
	}

	/*
	 * Sorting the Java 8 way.
	 */
	@GetMapping(path = "/sortedJ8")
	public String sortedJ8() {
		return appleService.sortApplesJ8();
	}

	@GetMapping(path = "/filtered/{filterType}")
	public String filtered(@PathVariable String filterType) {

		if (filterType.equalsIgnoreCase("byColor")) {
			return appleService
					.filterApplesByColor(AppleColor.GREEN);
		} else if (filterType.equalsIgnoreCase("byWeight")) {
			return appleService
					.filterApplesByWeight();
		} else {
			return "Nothing to see here!";
		}
	}

	/*
	 * Filtering apples the Java 8 way!
	 */
	@GetMapping(path = "/filteredJ8/{filterType}")
	public String filteredJ8(@PathVariable String filterType) {

		if (filterType.equalsIgnoreCase("byColor")) {
			return appleService
					.filterApplesJ8(Apple::isGreenApple);
		} else if (filterType.equalsIgnoreCase("byWeight")) {
			return appleService
					.filterApplesJ8(Apple::isHeavyApple);
		} else {
			return "No filtering to see here!";
		}
	}
}
