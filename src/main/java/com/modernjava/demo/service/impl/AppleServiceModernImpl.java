package com.modernjava.demo.service.impl;

import static com.modernjava.demo.model.Apple.HEAVY_APPLE;
import static com.modernjava.demo.model.AppleFilterType.*;
import static com.modernjava.demo.util.AppleUtil.addApples;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleColor;
import com.modernjava.demo.model.AppleFilterType;
import com.modernjava.demo.service.AppleServiceModern;

@Service
public class AppleServiceModernImpl implements AppleServiceModern {

	private static final Logger logger = LoggerFactory
		.getLogger(AppleServiceModernImpl.class);

	private static final 
		Map<AppleFilterType, Function<List<Apple>, List<Apple>>>
			filters = new EnumMap<>(AppleFilterType.class);

	/*
	 * Sort Apples by weight.
	 */
	private static List<Apple> sortJ8(List<Apple> apples) {
		apples.sort(Comparator.comparing(Apple::getWeight));
		return apples;
	}

	/*
	 * Filter Apples by weight.
	 */
	private final UnaryOperator<List<Apple>> byWeightFn =
		(List<Apple> apples) -> apples.stream()
			.filter(a -> a.getWeight() < HEAVY_APPLE)
			.collect(Collectors.toList());

	/*
	 * Filter Apples by color.
	 */
	private final UnaryOperator<List<Apple>> byColorFn =
		(List<Apple> apples) -> apples.stream()
			.filter(a -> AppleColor.GREEN.equals(a.getColor()))
			.collect(Collectors.toList());

	private AppleServiceModernImpl() {
		filters.put(SORT, AppleServiceModernImpl::sortJ8);
		filters.put(BYWEIGHT, byWeightFn);
		filters.put(BYCOLOR, byColorFn);

		logger.info("Added {} filters", filters.size());
	}

	/* 
	 * @param An enum representing the filter type.
	 * @return A filtered or sorted List<Apple>. 
	 */
	public List<Apple> 
		filterApplesWithModernJava(AppleFilterType filterType) {
			return filters.get(filterType).apply(addApples());
	}
}
