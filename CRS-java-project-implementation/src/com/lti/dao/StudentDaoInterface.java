/**
 * 
 */
package com.lti.dao;


import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Report;
import com.lti.bean.Student;
import com.lti.exceptions.InvalidLoginException;
import com.lti.exceptions.MaxCoursesOptedException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * @author user259
 *
 */
public interface StudentDaoInterface {
	
	  public void displayCourses();
		
		public void optCourse(Student s1,int courseId) throws MaxCoursesOptedException;
		
		public void dropCourse(Student s1, int courseId);
		
		public void viewRegisteredCourses(Student s1);
		
		public void updateCourseDetails(Student s1,int courseId,int newCourseId);
		
		public void viewReport(Student s1);
			
		public void AddStudent(Student s) ;
		
		//public Student fetchStudent(int studentId);
}
