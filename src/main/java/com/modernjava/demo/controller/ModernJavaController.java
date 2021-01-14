package com.modernjava.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleFilterType;
import com.modernjava.demo.service.AppleServiceModern;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/apples")
public class ModernJavaController {

	@Autowired
	private AppleServiceModern appleService;

	@ApiOperation(value = "Sort, or filter by color or weight",
		notes ="", 	response = ResponseEntity.class,
		responseContainer = "List", tags = {})
	@GetMapping(path = "/{filterType}")
	public ResponseEntity<List<Apple>> filterApplesWithModernJava(
		@PathVariable AppleFilterType filterType) {

		return ResponseEntity.status(200)
			.body(appleService
				.filterApplesWithModernJava(filterType));
	}
}
