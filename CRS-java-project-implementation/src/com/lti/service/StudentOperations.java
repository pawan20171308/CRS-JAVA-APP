/**
 * 
 */
package com.lti.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.Report;
import com.lti.bean.Student;
import com.lti.dao.StudentDaoInterface;
import com.lti.dao.StudentDaoOperationsImpl;
import com.lti.exceptions.*;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
/**
 * @author user256
 *
 */
public class StudentOperations implements StudentInterface{

	Scanner in = new Scanner(System.in);
	StudentDaoInterface studentDao = new StudentDaoOperationsImpl();
	
	public void displayCourses() {		
		
		studentDao.displayCourses();   
		
	}

	public void optCourse(Student s1,int courseId) throws MaxCoursesOptedException {
		studentDao.optCourse(s1, courseId);
	}

	public void dropCourse(Student s1, int courseId) {
		// TODO Auto-generated method stub
		studentDao.dropCourse(s1, courseId);
	
	}

	public void viewRegisteredCourses(Student s1) {
	
		studentDao.viewRegisteredCourses(s1);
	
	}

	public void updateCourseDetails(Student s1,int courseId,int newCourseId) {
		// TODO Auto-generated method stub
		studentDao.updateCourseDetails(s1, courseId, newCourseId);
	}

	public void viewReport(Student s1) {
		// TODO Auto-generated method stub
		studentDao.viewReport(s1);
//		System.out.println("Report Details are ");
//		for(Report r1: reports){
//			
//			if(r1.getStudentId()==s1.getStudentId()){
//				System.out.println("\nStudent Id "+r1.getStudentId()+"\nStudent Name "+s1.getFname()+"\nCourse "+r1.getCourse()+"\nGrade "+r1.getGrade());
//			}
//		}
		
	}

	public void registerStudent(Student s){
		
		System.out.print("Enter Your First Name: \n");
		s.setFname(in.nextLine());
		
		
		System.out.print("Enter Your Sirname :\n");
		s.setSname(in.nextLine());
		
		
		System.out.print("Enter Your Email Id :\n");
		s.setEmailId(in.nextLine());
		
		
		System.out.print("Enter Password :\n");
		s.setPassword(in.nextLine());
		
		
		System.out.print("Enter Your Student Id :\n");
		s.setStudentId(Integer.parseInt(in.next()));
		
		
//			System.out.println("S : before :::"+s);
			AddStudent(s);
	}
	
	public void AddStudent(Student s) {
		// TODO Auto-generated method stub
		studentDao.AddStudent(s);
  
	}

	public boolean Login(Student s,String id,String pass) throws InvalidLoginException {
		// TODO Auto-generated method stub
		if(id.equals(s.getEmailId()) && pass.equals(s.getPassword()))
		{
			System.out.println("Login Success");
			return true;
		}
		else
		{
			System.out.println("Login Fail");
			throw new InvalidLoginException();
			//return false;
			
		}
		}

}
