/**
 * 
 */
package com.lti.service;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.exceptions.CourseNotFoundException;

/**
 * @author shree
 *
 */
public interface CourseInterface {
	public void displayCourses(Student student);
	public void insertCourse(Course course) ;
	public void deleteCourse(int courseId)throws CourseNotFoundException;
	public void displayCoursesProfessor();
}
