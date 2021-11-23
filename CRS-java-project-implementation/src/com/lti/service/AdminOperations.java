/**
 * 
 */
package com.lti.service;

import com.lti.bean.Course;

import com.lti.bean.Proffessor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.dao.AdminDaoInterface;
import com.lti.dao.AdminDaoOperationsImpl;

/**
 * @author user256
 *
 */
public class AdminOperations implements AdminInterface{

	AdminDaoInterface admin = new AdminDaoOperationsImpl();

	public void addProfessor() {
		// TODO Auto-generated method stub
		
	}

	public void assignCourse() {
		// TODO Auto-generated method stub
		
	}

	public void approveStudent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int approveStudent(int studentId) {
		
		return admin.approveStudent(studentId);
	}

	public boolean addProf(Proffessor p,User u){
		//AdminDaoInterface adminDaoOperation=new AdminDaoOperationsImpl();
		boolean status=admin.addProf(p,u);
		
		return status;
	}

	public boolean createCourse(Course course) {
		// TODO Auto-generated method stub
		//AdminDaoInterface adminOperation=new AdminDaoOperationsImpl();
		boolean status=admin.createCourse(course);
		return status;
	}

}
