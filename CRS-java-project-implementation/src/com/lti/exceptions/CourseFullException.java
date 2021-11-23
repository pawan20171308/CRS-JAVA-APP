/**
 * 
 */
package com.lti.exceptions;

/**
 * @author user256
 *
 */
public class CourseFullException extends Exception{
	public String getMessage() {
		String msg="Course is already full";
		return msg;
	}
}
	
