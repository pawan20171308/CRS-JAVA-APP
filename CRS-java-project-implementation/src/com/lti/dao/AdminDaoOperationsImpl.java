package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lti.bean.Course;
import com.lti.bean.Proffessor;
import com.lti.bean.User;
import com.lti.constants.SQLConstantQueries;
import com.lti.utils.DBUtils;

public class AdminDaoOperationsImpl implements AdminDaoInterface{
	
public int approveStudent(int studentId) {
		
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;
		int n=0;
		try{
			String query=SQLConstantQueries.APPROVE_STUDENT;
			stmt=connection.prepareStatement(query);
			stmt.setString(1,SQLConstantQueries.ACTIVE_STATUS);
			stmt.setInt(2,studentId);
			
			n=stmt.executeUpdate();
			
		}
		catch(SQLException e){
			System.out.println("Exception occured! "+e.toString());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return n;
	}
public boolean addProf(Proffessor p,User u){
	
	Connection connection = DBUtils.getConnection();
	PreparedStatement stmt= null;
	PreparedStatement stmt1= null;
	int n=0;
	int n1=0;
	try{	
		String query=SQLConstantQueries.ADMIN_ADDPROF;
		stmt=connection.prepareStatement(query);
		stmt.setInt(1,p.getProfessorId());
		stmt.setString(2,p.getName());
		stmt.setString(3,p.getGender());
		stmt.setLong(4,p.getPhoneNumber());
		stmt.setString(5,p.getDesignation());
		
		//stmt.setString(5,p.getDOJ());
		n=stmt.executeUpdate();
		
		String query1=SQLConstantQueries.INSERT_STUDENT_USER;
		stmt1=connection.prepareStatement(query1);
		stmt1.setInt(1,u.getUserId());
		stmt1.setString(2,u.getUserName());
		stmt1.setString(3,u.getUserPassword());
		stmt1.setInt(4,u.getRoleId());
		stmt1.setString(5,null);
		n1=stmt1.executeUpdate();
	}
	catch(SQLException e){
		System.out.println("Exception occured! "+e.toString());
	}
	if(n>0 && n1>0)
		return true;
	else
		return false;

}
public boolean createCourse(Course course) {
	// TODO Auto-generated method stub
	Connection connection = DBUtils.getConnection();
	PreparedStatement stmt= null;
	int n=0;
	try{	
		String sql = SQLConstantQueries.ADMIN_ADDCOURSE;
		stmt = connection.prepareStatement(sql);
		stmt.setInt(1,course.getCourseId());
		stmt.setString(2, course.getCourseName());
		stmt.setString(3,course.getPreReq());
		stmt.setString(4,course.getSemester());
		stmt.setString(5,course.getDept());
		stmt.setString(6,course.getProf());
		stmt.setDouble(7,course.getBill());
		stmt.setInt(8,course.getNumberOfStudentsEnrolled());
		stmt.setString(9,course.getGrade());
		n=stmt.executeUpdate();
	}
	catch(SQLException e){
		System.out.println("Exception occured! "+e.toString());
	}
	if(n>0)
		return true;
	else
		return false;
}


}
