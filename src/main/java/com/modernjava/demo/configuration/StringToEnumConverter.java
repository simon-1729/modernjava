package com.modernjava.demo.configuration;

import org.springframework.core.convert.converter.Converter;

import com.modernjava.demo.model.AppleFilterType;

public class StringToEnumConverter implements Converter<String, AppleFilterType> {
	@Override
	public AppleFilterType convert(String source) {
		return AppleFilterType.valueOf(source.toUpperCase());
	}
}
