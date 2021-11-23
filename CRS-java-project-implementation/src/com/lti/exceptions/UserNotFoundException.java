package com.lti.exceptions;

public class UserNotFoundException extends Exception{
	
	public String getMessage() {
		String msg="UserNotFoundException - User not found";
		return msg;
	}

}
