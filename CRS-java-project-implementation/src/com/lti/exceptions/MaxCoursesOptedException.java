/**
 * 
 */
package com.lti.exceptions;

/**
 * @author user256
 *
 */
public class MaxCoursesOptedException extends Exception{
	public String getMessage() {
		String msg="MaxCoursesOptedException - The No. of Course Opted is reached Maximum Limit";
		return msg;
	}
}
