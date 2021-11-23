/**
 * 
 */
package com.lti.exceptions;

/**
 * @author user256
 *
 */
public class CourseNotFoundException extends Exception{
	public String getMessage() {
		String msg="Course is Removed or will update shortly";
		return msg;
	}

}
