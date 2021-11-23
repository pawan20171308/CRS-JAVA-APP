/**
 * 
 */
package com.lti.dao;

import com.lti.bean.Course;
import com.lti.bean.Proffessor;
import com.lti.bean.Proffessor;
import com.lti.bean.User;

/**
 * @author user259
 *
 */
public interface AdminDaoInterface {
	public int approveStudent(int studentId);
	public boolean addProf(Proffessor p,User u);
	public boolean createCourse(Course course);
}
