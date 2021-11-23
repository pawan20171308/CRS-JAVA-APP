/**
 * 
 */
package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.lti.bean.Admin;
import com.lti.bean.Proffessor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.constants.SQLConstantQueries;
import com.lti.exceptions.InvalidLoginException;
import com.lti.utils.DBUtils;

/**
 * @author user259
 *
 */
public class UserDaoOperationsImpl implements UserDaoInterface{
	Connection connection = DBUtils.getConnection();
	PreparedStatement stmt= null;
	
	public User validateUser(String username, String password)
			throws InvalidLoginException {
		
		try {

			//Declaring prepared statement
			//String sql = "SELECT UserID,RoleID,userName FROM user WHERE userName=? AND userPassword=?";
			stmt=connection.prepareStatement(SQLConstantQueries.VALIDATE_USER);
			stmt.setString(1, username);
			stmt.setString(2,password);
			ResultSet rs = stmt.executeQuery();

			if(rs.next())
			{
				User checkeduser = new User();
				checkeduser.setUserId( rs.getInt("UserID") );
				checkeduser.setRoleId(rs.getInt("RoleID"));
				checkeduser.setUserName(rs.getString("userName"));
				System.out.println("Username :"+rs.getString("userName"));
				return checkeduser;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
//		
		return null;
	}

	
	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	public void createProfessor(Proffessor professor) {
		// TODO Auto-generated method stub
		
	}

	

	
	public void displayStudents() {
		// TODO Auto-generated method stub
		
	}

	public void displayProfessors() {
		// TODO Auto-generated method stub
		
	}

	
	/*public Student fetchStudent(int studentId){
	//	System.out.println("fetchStudent called from UserDaoIMpl");
		//Connection connection = DBUtils.getConnection();
	//	PreparedStatement stmt= null;

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
				
				LocalDateTime lastLogin = LocalDateTime.now();
				
				stmt=connection.prepareStatement(SQLConstantQueries.LAST_LOGIN);
				stmt.setString(1, lastLogin.toString());
				stmt.setInt(2, studentId);
				stmt.executeUpdate();
				int count = stmt.executeUpdate();
				if(count >=1){
					System.out.println();
					System.out.println("Last Login Successful at : "+lastLogin.toString());
				}else{
					System.out.println();
					System.out.println("Last Login Failed at : "+lastLogin.toString());
				}
				
				return student;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;

	}*/
	
	public Student fetchStudent(int studentId){

		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;
		PreparedStatement stmt1=null;
		try {
			String query = "SELECT * FROM student WHERE StudentID=? and approvalStatus=?";
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.setString(2,SQLConstantQueries.ACTIVE_STATUS.toString());
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs+" :;rs");
			//int st=stmt.executeUpdate();
			
			String query1 = "UPDATE User set lastLogin=? WHERE userId=?";
			stmt1=connection.prepareStatement(query1);
			LocalDate localDate = LocalDate.now();
			LocalTime localTime = LocalTime.now();
			LocalDateTime localDateTime = LocalDateTime.now();

			
			stmt1.setString(1, localDateTime.toString());
	
			stmt1.setInt(2, studentId);
			int st=stmt1.executeUpdate();
			//System.out.println("Last Login Update Status in DB "+st);
			if(st<=0){
				System.out.println("Error while Updating Last login in DB");
			}
			if(rs.next() )
			{
				System.out.println("Inside rs.next()");
				Student student= new Student();
				student.setStudentId(studentId);
				student.setFname(rs.getString("fname"));
				student.setSname(rs.getString("sname"));
				student.setEmailId(rs.getString("emailId"));
				student.setOptedCounter(rs.getInt("optedCounter"));
				student.setApprovalStatus(rs.getString("approvalStatus"));
				
				return student;
			}


		} catch (SQLException ex) {
			System.out.println("Exception occurs here!"+ex.getMessage());
		}
		
		return null;
	}
	
	public Proffessor fetchProfessor(int professorId){
	//Connection connection = DBUtils.getConnection();
	//PreparedStatement stmt= null;

	try {
		//Declaring prepared statement
		stmt = null;
		stmt=connection.prepareStatement(SQLConstantQueries.FETCH_PROFESSOR);
		stmt.setInt(1, professorId);

		ResultSet rs = stmt.executeQuery();

		if(rs.next() )
		{
			Proffessor professor= new Proffessor();
			professor.setProfessorId(professorId);
			professor.setName(rs.getString("Name"));
			professor.setPhoneNumber(rs.getLong("PhoneNumber"));
			professor.setGender(rs.getString("Gender"));
			professor.setDesignation(rs.getString("Designation"));

			return professor;
		}


	} catch (SQLException ex) {
		System.out.println(ex.getMessage());
	}
//	
	return null;
	}


	@Override
	public Admin fetchAdmins(int adminId) {
			
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {
			String query = "SELECT * FROM admin WHERE adminID=?";
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, adminId);

			ResultSet rs = stmt.executeQuery();

			if(rs.next() )
			{
				Admin a=new Admin();
				a.setAdminId(rs.getInt("adminId"));
				a.setAdminName(rs.getString("adminName"));
				a.setAdminName(rs.getString("adminPass"));
				a.setAdminName(rs.getString("phoneNumber"));
				return a;
			}


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}

	
	
	
	/*public boolean Login(Student s, String id, String pass)
			throws InvalidLoginException {
		
	//	Connection con= DBUtils.getConnection();
		//PreparedStatement stmt= null;
		
		
		
		String sql = "SELECT usertype as rowcount FROM user where userId=? and password=?";
		int rsCount=0;
		try {
			
			  stmt= connection.prepareStatement(sql);
			 
			  stmt.setString(1, id);
			  stmt.setString(2, pass);
		      ResultSet rs = stmt.executeQuery();//stmt.executeQuery(sql);
		      boolean singleRec=true;
		      //rsCount=rs.getInt("rowcount");
		      
//		      System.out.println("SQL query returns "+rsCount+" rows.");
		      while(rs.next() && singleRec)
				{
		
		    	  singleRec=false;
				}
  
		      if(!singleRec){
		    	  System.out.println("Login Successfull!");
		    	  return true;
		      }
//			List<Course> courses= new ArrayList<Course>();
		     
			//Creating ArrayList of courses
			
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	
		System.out.println("Login Failed!");
		return false;
	}
	*/
}
