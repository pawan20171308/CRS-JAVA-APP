/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Proffessor;
import com.lti.dao.ProfessorDaoInterface;
import com.lti.dao.ProfessorDaoOperationsImpl;

/**
 * @author user256
 *
 */
public class ProfessorOperations implements ProfessorInterface{
	
	ProfessorDaoInterface professorDao= new ProfessorDaoOperationsImpl();
	
	@Override
	public void selectCourse(int courseId, Proffessor professor) {
		// TODO Auto-generated method stub
		professorDao.selectCourse(courseId, professor);
	}

	@Override
	public void deselectCourse(int courseId, Proffessor professor) {
		// TODO Auto-generated method stub
		professorDao.deselectCourse(courseId, professor);
	}

	@Override
	public void displaySelectedCoursesProfessor(Proffessor professor) {
		// TODO Auto-generated method stub
		System.out.println("********************************LIST OF SELECTED COURSES******************************");	
		System.out.println("COURSE ID      COURSE TITLE                         NUMBER OF STUDENTS ENROLLED");
		List<Course> courses = professorDao.displaySelectedCoursesProfessor(professor);
		courses.forEach(course -> System.out.println(course.getCourseId()+"               "+course.getCourseName()+"                               			"+course.getNumberOfStudentsEnrolled()));

		System.out.println("*****************************************************************************************");
	
		
	}

}
