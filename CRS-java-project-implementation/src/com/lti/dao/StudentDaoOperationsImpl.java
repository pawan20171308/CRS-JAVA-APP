package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.lti.bean.Course;
import com.lti.bean.Report;
import com.lti.bean.Student;
import com.lti.constants.SQLConstantQueries;
import com.lti.exceptions.CourseNotFoundException;
import com.lti.exceptions.InvalidLoginException;
import com.lti.exceptions.MaxCoursesOptedException;
import com.lti.exceptions.ReportNotFoundException;

import com.lti.utils.DBUtils;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class StudentDaoOperationsImpl implements StudentDaoInterface {
	Connection con = DBUtils.getConnection();
	
	public void displayCourses() {
		Statement stmt= null;		
		try {
			 stmt= con.createStatement();
		     ResultSet rs = stmt.executeQuery(SQLConstantQueries.VIEW_COURSE);

			List<Course> courses= new ArrayList<Course>();

			//Creating ArrayList of courses
			while(rs.next())
			{
				Course course = new Course();
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setDept(rs.getString("dept"));
				course.setPreReq(rs.getString("preReq"));
				course.setProf(rs.getString("prof"));
				course.setSemester(rs.getString("semester"));
				course.setBill(rs.getDouble("bill"));
				courses.add(course);
			}

			//returning list of courses //Before Java 8
//			 for (Course value : courses) {
//		       	    
//		       	    System.out.println("Course Id: " + value.getCourseId()+" Course Name: "+value.getCourseName());
//		      }
			 
			//returning list of courses //From Java 8
	       courses.forEach(value -> System.out.println("*Id: " + value.getCourseId()+" 	||	 Course Name: "+value.getCourseName()+"	"));
	 
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	
		
	}

	public void optCourse(Student student, int courseId)
			throws MaxCoursesOptedException {
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt= con.prepareStatement(SQLConstantQueries.FETCH_COURSE);
			
			stmt.setInt(1, student.getStudentId());
			
		    ResultSet rs = stmt.executeQuery();;
		    int count=0;
		    while(rs.next())
			{
		    	if(rs.last())
		    	{
		    		count=rs.getRow();
		    	}
			}
		    
			if(count>=4){
				System.out.println("\nAlready registered for 4 courses!");
				throw new MaxCoursesOptedException();
				
			}
			count = 0;
			stmt = con.prepareStatement(SQLConstantQueries.ADD_COURSE);
			
			int studentId= student.getStudentId();

			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);

			//Executing query
			stmt.executeUpdate();
			System.out.println("\nCourse with having courseId as "+courseId+" is added!");
			System.out.println();
			System.out.println("=========================================================================================");
			

		}
		catch(MaxCoursesOptedException ex)
		{
			ex.getMessage();
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void dropCourse(Student student, int courseId) {
		
		PreparedStatement stmt= null;

		try {
					
			stmt= con.prepareStatement(SQLConstantQueries.DROP_STUDENT_COURSE);
			stmt.setInt(1,courseId);
			stmt.setInt(2,student.getStudentId());
			
		    int count = stmt.executeUpdate();
			if(count >=1){
				System.out.println("\nCourse "+courseId+" deleted for student who's name is "+student.getFname()+" and student id is "+student.getStudentId());
			}else{
				throw new CourseNotFoundException();
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void viewRegisteredCourses(Student s1) {
		
		PreparedStatement stmt= null;
		
		try {
			 stmt = con.prepareStatement(SQLConstantQueries.VIEW_SELECTED_COURSES);
			 stmt.setInt(1, s1.getStudentId());
		     ResultSet rs = stmt.executeQuery();

		     List<Integer> arr=new ArrayList<Integer>();

			 //Creating ArrayList of courses
			 while(rs.next()){
				arr.add(rs.getInt(1));
			 }
			 
			 
			 
			 if(arr.size()==0){
					System.out.println("\nNo Courses Opted for "+s1.getFname()+"!");
				}
				else
					System.out.println("Course Id's of the Opted courses are as : "+arr);
			 
			
			
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	public void updateCourseDetails(Student s1, int courseId, int newCourseId) {
		//System.out.println("s1:"+s1+"/n courseId :"+courseId+"/n mewCourseId"+newCourseId);
		PreparedStatement stmt= null;
		
		try {
		
			stmt=con.prepareStatement(SQLConstantQueries.UPDATE_COURSE_DETAILS_STUDENT);
			stmt.setInt(1, newCourseId);
			stmt.setInt(2, courseId);
			stmt.setInt(3, s1.getStudentId());
			
			int i=stmt.executeUpdate();
			System.out.println("Update Course details :"+i);
			if(i > 0 )
			{
				System.out.println(i+" Course Details Record Updated Successfully!");
			}else{
				throw new CourseNotFoundException();
			}


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} catch (CourseNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void viewReport(Student s1) {
		//System.out.println("Report Details are "+s1);
		
		PreparedStatement stmt= null;
		
		try {
			
			stmt=con.prepareStatement(SQLConstantQueries.VIEW_RECORD);
			stmt.setInt(1, s1.getStudentId());
			List<Report> reportList = new ArrayList<Report>();
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Report report = new Report();
				report.setCourse(rs.getString("course"));
				report.setGrade(rs.getString("grade"));
				report.setReportId(rs.getInt("reportId"));
				report.setStudentId(rs.getInt("studentId"));
				reportList.add(report);
			}
			
			
			if(reportList.size() > 0)
			{	
				System.out.println();
				System.out.println("=========================================================================================");
				reportList.forEach(report -> System.out.println("\n Student Id :"+report.getStudentId()+" || Name :"+s1.getFname()+" || Course :"+report.getCourse()+" || Grade :"+report.getGrade()));
				System.out.println("=========================================================================================");
			}
			else
			 throw new ReportNotFoundException();
				
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} catch (ReportNotFoundException e) {
			
			e.printStackTrace();
		}	
	}

	public void AddStudent(Student student){
			   // System.out.println("Inside AddStudent : "+student);
				Connection connection = DBUtils.getConnection();
				PreparedStatement stmt= null;

				try {
					//Declaring prepared statement and executing query
					stmt = connection.prepareStatement(SQLConstantQueries.INSERT_STUDENT);
								
					stmt.setInt(1, student.getStudentId());
					stmt.setString(2, student.getFname());
					stmt.setString(3,  student.getSname());
					stmt.setString(4, student.getEmailId());
					stmt.setString(5, student.getPassword());
					
					stmt.setInt(6, student.getOptedCounter());
					stmt.setInt(7, student.getAltCounter());
					    
					stmt.setString(8, SQLConstantQueries.INACTIVE_STATUS.toString());
					//Executing query
					stmt.executeUpdate();
		
					stmt = connection.prepareStatement(SQLConstantQueries.INSERT_USER);
					stmt.setInt(1, student.getStudentId());
					stmt.setString(2, student.getEmailId());
					stmt.setString(3, student.getPassword());
					stmt.setInt(4, SQLConstantQueries.ROLE_STUDENT);
					LocalDate dt = LocalDate.now();
				    stmt.setString(5, dt.toString());
					
//					stmt.setInt(1, 156);
//					stmt.setString(2, "sdfghgfdsd@sdfdfghj.ccc");
//					stmt.setString(3, "ARTTTT");
//					stmt.setInt(4, 1);
//					LocalDate dt = LocalDate.now();
//				    stmt.setString(5, "10-05-2021");
				    
					stmt.executeUpdate();
					
					System.out.println("Student"+" added!"+student);
					System.out.println();
					System.out.println("*****************************************************************************************");	
						
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());

				}catch(Exception e){
					e.printStackTrace();
				}
	}
	
/*	
	public Student fetchStudent(int studentId){

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {
			stmt=connection.prepareStatement(SQLConstantQueries.FETCH_STUDENT);
			stmt.setInt(1, studentId);

			ResultSet rs = stmt.executeQuery();

			if(rs.next() )
			{
				Student student= new Student();
				student.setStudentId(studentId);
				student.setFname(rs.getString("fname"));
				student.setSname(rs.getString("sname"));
				student.setEmailId(rs.getString("emailId"));
				student.setOptedCounter(rs.getInt("optedCounter"));
				
				return student;
			}


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;

	}*/

}
