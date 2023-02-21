package com.bnpcodingexercise.exception;

import java.util.Date;

public class ErrorMessage {

	private String appName;
	private int statusCode;
	private Date timestamp;
	private String message;
	
	public ErrorMessage(String appName, int statusCode, Date timestamp, String message) {
		super();
		this.appName = appName;
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
