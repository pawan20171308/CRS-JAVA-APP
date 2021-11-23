/**
 * 
 */
package com.lti.exceptions;

/**
 * @author user256
 *
 */
public class InvalidLoginException extends Exception{

	public String getMessage() {
		String msg="Username/ password incorrect! Please try again.. ";
		return msg;
	}

}
