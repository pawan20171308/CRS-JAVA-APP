package com.lti.dao;

import com.lti.bean.Admin;
import com.lti.bean.Proffessor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.exceptions.InvalidLoginException;

public interface UserDaoInterface {
	
	public User validateUser(String username, String password)throws InvalidLoginException;
	 public void createStudent(Student student) ;
	 public void createProfessor(Proffessor professor);
	 public void displayStudents();
	 public void displayProfessors();
	 public Student fetchStudent(int studentId);
	 public Proffessor fetchProfessor(int professorId);
	 public Admin fetchAdmins(int userId);
	 
}
