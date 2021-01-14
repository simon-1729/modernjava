package com.modernjava.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modernjava.demo.metadata.ApiMetadata;
import com.modernjava.demo.model.Apple;
import com.modernjava.demo.service.AppleServiceLegacy;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/apples")
public class LegacyJavaController {

	@Autowired
	private AppleServiceLegacy appleService;

	@ApiOperation(value = "Sort by weight",
		notes = ApiMetadata.SORTED_NOTES+ApiMetadata.LEGACY_JAVA,
		response = ResponseEntity.class,
		responseContainer = "List", tags = {})
	@GetMapping(path = "/sorted")
	public ResponseEntity<List<Apple>> sorted() {
		return ResponseEntity.status(200)
			.body(appleService.sortApples());
	}

	@ApiOperation(value = "Sort by weight",
		notes = ApiMetadata.SORTED_NOTES+ApiMetadata.FUNCTIONAL_JAVA,
		response = ResponseEntity.class,
		responseContainer = "List", tags = {})
	@GetMapping(path = "/sortedJ8")
	public ResponseEntity<List<Apple>> sortedJ8() {
		return ResponseEntity.status(200)
			.body(appleService.sortApplesJ8());
	}

	@ApiOperation(value = "Filter by color or weight",
		notes =  ApiMetadata.FILTERED_NOTES+ApiMetadata.LEGACY_JAVA,
		response = ResponseEntity.class,
		responseContainer = "List", tags = {})
	@GetMapping(path = "/filtered/{filterType}")
	public ResponseEntity<List<Apple>> filtered(@PathVariable
		String filterType) {

		return ResponseEntity.status(200)
				.body(appleService.filterApples(filterType));
	}

	@ApiOperation(value = "Filter by color or weight",
			notes = ApiMetadata.FILTERED_NOTES
			+ApiMetadata.FUNCTIONAL_JAVA,
			response = ResponseEntity.class,
			responseContainer = "List", tags = {})
	@GetMapping(path = "/filteredJ8/{filterType}")
	public ResponseEntity<List<Apple>> filteredJ8(
		@PathVariable String filterType) {

		return ResponseEntity.status(200)
			.body(appleService.filterApplesJ8(filterType));
	}
}
