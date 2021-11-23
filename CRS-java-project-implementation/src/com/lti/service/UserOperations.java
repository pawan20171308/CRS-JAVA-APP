/**
 * 
 */
package com.lti.service;

import com.lti.bean.Admin;
import com.lti.bean.Proffessor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.dao.ProfessorDaoInterface;
import com.lti.dao.StudentDaoInterface;
import com.lti.dao.StudentDaoOperationsImpl;
import com.lti.dao.UserDaoInterface;
import com.lti.dao.UserDaoOperationsImpl;
import com.lti.exceptions.InvalidLoginException;

/**
 * @author user256
 *
 */
public class UserOperations implements UserInterface{
	StudentDaoInterface studentDao = new StudentDaoOperationsImpl();
	UserDaoInterface userDao = new UserDaoOperationsImpl();
	public User validateUser(String username, String password)
			throws InvalidLoginException {
		// TODO Auto-generated method stub
		  //UserDaoInterface userDao= new UserDaoOperationsImpl();
		User user= userDao.validateUser(username, password)	;
		if(user == null)
			throw new InvalidLoginException();
		return user;
	}

	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public void createProfessor(Proffessor professor) {
		// TODO Auto-generated method stub
		
	}

	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}


	public void updateStudent(int sudentId, Student student) {
		// TODO Auto-generated method stub
		
	}

	public void updateProfessor(int professsorId, Proffessor professor) {
		// TODO Auto-generated method stub
		
	}

	public void updateAdmin(int adminId, Admin admin) {
		// TODO Auto-generated method stub
		
	}

	public void displayStudents() {
		// TODO Auto-generated method stub
		
	}

	public void displayProfessors() {
		// TODO Auto-generated method stub
		
	}

	public void displayAdmins() {
		// TODO Auto-generated method stub
		
	}

	public Student fetchStudent(int studentId) {
		
		return userDao.fetchStudent(studentId);   
	}
	
	
	public Proffessor fetchProfessor(int professorId){
	//	System.out.println("professorId >> "+professorId);
			return userDao.fetchProfessor(professorId);
	}

	@Override
	public Admin fetchAdmins(int userId) {
		// TODO Auto-generated method stub
		return userDao.fetchAdmins(userId);
	}

}
