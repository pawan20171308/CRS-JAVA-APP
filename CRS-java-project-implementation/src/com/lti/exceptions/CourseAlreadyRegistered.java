/**
 * 
 */
package com.lti.exceptions;

/**
 * @author user256
 *
 */
public class CourseAlreadyRegistered extends Exception{
	
	public String getMessage() {
		String msg="Course is already registered!";
		return msg;
	}

}
