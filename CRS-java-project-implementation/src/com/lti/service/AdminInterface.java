/**
 * 
 */
package com.lti.service;

import com.lti.bean.Course;
import com.lti.bean.Proffessor;
import com.lti.bean.Student;
import com.lti.bean.User;

/**
 * @author user256
 *
 */
public interface AdminInterface {

	public int approveStudent(int studentId);
	public boolean addProf(Proffessor p,User u);
	public boolean createCourse(Course course);

}
