package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.constants.SQLConstantQueries;
import com.lti.utils.DBUtils;

public class GradeDaoOperations implements GradeDaoInterface {

	@Override
	public List<Course> displayGrades(Student student) {
		
				Connection connection= DBUtils.getConnection();
				PreparedStatement stmt= null;

				try {

					//Declaring prepared statement and executing query
					stmt= connection.prepareStatement(SQLConstantQueries.VIEW_GRADES);
					stmt.setInt(1, student.getStudentId());

					ResultSet rs = stmt.executeQuery();
					List<Course> list= new ArrayList<Course>();

					//Creating ArrayList of course
					while(rs.next())
					{
						Course c = new Course();

						c.setCourseId(rs.getInt("courseId"));
						c.setCourseName(rs.getString("courseName"));
						c.setGrade(rs.getString("grade"));
						

						list.add(c);
					}
					//returning list of courses
					return list;
				}
				catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				
				return null;
	}

	@Override
	public void uploadGrades(int studentId, int courseId, String grade) {
	
		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt=null;

		try {
			//Declaring prepared statement and executing query
			 stmt = connection.prepareStatement(SQLConstantQueries.UPLOAD_GRADES);
			 
			stmt.setInt(1, courseId );
			stmt.setInt(2,studentId );
			stmt.setString(3, grade);

			//Executing query
			stmt.executeUpdate();
			System.out.println("Grade uploaded for Student with StudentID :"+studentId +" for the following courseId : "+courseId);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
