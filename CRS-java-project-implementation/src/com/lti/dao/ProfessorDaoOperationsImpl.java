/**
 * 
 */
package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.constants.SQLConstantQueries;
import com.lti.bean.Course;
import com.lti.bean.Proffessor;
import com.lti.utils.DBUtils;

/**
 * @author shree
 *
 */
public class ProfessorDaoOperationsImpl implements ProfessorDaoInterface {

	@Override
	public void selectCourse(int courseId, Proffessor professor) {
		// TODO Auto-generated method stub
		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.SELECT_COURSE);

			int professorId= professor.getProfessorId();

			stmt.setInt(1, professorId);
			stmt.setInt(2, courseId);


			//Executing query
			stmt.executeUpdate();
			System.out.println("Course with courseId="+courseId+" selected to teach!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void deselectCourse(int courseId, Proffessor professor) {
		
		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		PreparedStatement stmt= null;
		try {

			stmt=connection.prepareStatement(SQLConstantQueries.DISSELECT_COURSE);
			stmt.setInt(1, courseId);
			//Executing query
			int rs = stmt.executeUpdate();
			if(rs>0)
			{
				System.out.println(professor.getName()+" has Course deselected"+courseId +"!");
				return;

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Course not found for "+professor.getName()+" !");
		
	}

	@Override
	public List<Course> displaySelectedCoursesProfessor(Proffessor professor) {
		
		//Establishing the connection
		Connection connection= DBUtils.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_PROFESSOR_SELECTED_COURSES);
			stmt.setInt(1, professor.getProfessorId());

			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of course
			while(rs.next())
			{
				Course course = new Course();
				course.setCourseId(rs.getInt("CourseID"));
				course.setCourseName(rs.getString("courseName"));
				course.setNumberOfStudentsEnrolled(rs.getInt("NumberOfStudentsEnrolled"));
				list.add(course);

			}

			//returning list of courses
			return list;
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}

}
