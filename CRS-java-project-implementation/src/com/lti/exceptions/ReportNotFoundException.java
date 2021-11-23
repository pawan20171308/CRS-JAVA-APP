package com.lti.exceptions;

public class ReportNotFoundException extends Exception {
	public String getMessage() {
		String msg="Course is already full";
		return msg;
	}
}
