package com.modernjava.demo.exception;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppleExceptionDetails {
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private String timestamp;
	private String request;
	private String message;

	public AppleExceptionDetails(String request, String message) {
		this.timestamp = dateFormat.format(new Date());
		this.request = request;
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getRequest() {
		return request;
	}
}
