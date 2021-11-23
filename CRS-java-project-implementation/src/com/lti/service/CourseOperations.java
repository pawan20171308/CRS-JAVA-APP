/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.dao.CourseDaoInterface;
import com.lti.dao.CourseDaoOperationsImpl;
import com.lti.exceptions.CourseNotFoundException;

/**
 * @author shree
 *
 */
public class CourseOperations implements CourseInterface {

	CourseDaoInterface courseDao = new CourseDaoOperationsImpl();
	
	/* (non-Javadoc)
	 * @see com.lti.service.CourseInterface#displayCourses(com.lti.bean.Student)
	 */
	@Override
	public void displayCourses(Student student) {
		System.out.println("=========================================================================================");
		System.out.println("****************************************LIST OF AVAILABLE COURSES*****************************************1****");
		System.out.println("COURSE ID      COURSE NAME                          COUSRE PREREQUISITE                         PROFESSOR         ");
		List<Course> courses = courseDao.displayCourses(student);
		for(Course course:courses) {
			if(course.getNumberOfStudentsEnrolled() <10) {
				System.out.println(course.getCourseId()+"               "+course.getCourseName()+"          		     "+course.getPreReq()+"              			    "+course.getProf());
			}
		}
		System.out.println("*****************************************************************************************************************");
	

	}

	/* (non-Javadoc)
	 * @see com.lti.service.CourseInterface#insertCourse(com.lti.bean.Course)
	 */
	@Override
	public void insertCourse(Course course) {
		courseDao.insertCourse(course);		
	}

	/* (non-Javadoc)
	 * @see com.lti.service.CourseInterface#deleteCourse(int)
	 */
	@Override
	public void deleteCourse(int courseId) throws CourseNotFoundException {
		courseDao.deleteCourse(courseId);

	}

	/* (non-Javadoc)
	 * @see com.lti.service.CourseInterface#displayCoursesProfessor()
	 */
	@Override
	public void displayCoursesProfessor() {
		System.out.println("****************************LIST OF AVAILABLE COURSES************************************");
		System.out.println("COURSE ID      COURSE NAME                          COUSRE PREREQUISITE             ");
		List<Course> courses = courseDao.displayCoursesProfessor();
		courses.forEach(course -> System.out.println(course.getCourseId()+"               "+course.getCourseName()+"               "+course.getPreReq()));

		System.out.println("******************************************************************************************");


	}

}
