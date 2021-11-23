/**
 * 
 */
package com.lti.service;

import com.lti.bean.Admin;
import com.lti.bean.Proffessor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.exceptions.InvalidLoginException;

/**
 * @author user256
 *
 */
public interface UserInterface {
	public User validateUser(String username, String password)throws InvalidLoginException;
	 public void createStudent(Student student) ;
	 public void createProfessor(Proffessor professor);
	 public void createAdmin(Admin admin);
	
	  public void updateStudent(int sudentId,Student student);
	  public void updateProfessor(int professsorId,Proffessor professor) ;
	  public void updateAdmin(int adminId,Admin admin) ;
	 public void displayStudents();
	 public void displayProfessors();
	 public void displayAdmins() ;
	 public Student fetchStudent(int studentId);
	 public Proffessor fetchProfessor(int professorId);
	public Admin fetchAdmins(int userId);
}
