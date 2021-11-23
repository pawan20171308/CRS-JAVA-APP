/**
 * 
 */
package com.lti.service;

import com.lti.bean.Proffessor;

/**
 * @author user256
 *
 */
public interface ProfessorInterface {
	public void selectCourse(int courseId ,Proffessor professor);
	public void deselectCourse(int courseId, Proffessor professor);
	public void displaySelectedCoursesProfessor(Proffessor professor);
}
