/**
 * 
 */
package com.lti.service;

import com.lti.bean.Student;

/**
 * @author shree
 *
 */
public interface GradeInterface {

	public void displayGrades(Student student);
	public void uploadGrades(int studentId, int courseId, String grade);
	
}
