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
import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.constants.SQLConstantQueries;
import com.lti.exceptions.CourseNotFoundException;
import com.lti.utils.DBUtils;

/**
 * @author shree
 *
 */
public class CourseDaoOperationsImpl implements CourseDaoInterface {

	/* (non-Javadoc)
	 * @see com.lti.dao.CourseDaoInterface#displayCourses(com.lti.bean.Student)
	 */
	@Override
	public List<Course> displayCourses(Student student) {
		Connection connection= DBUtils.getConnection();

		//Declaring prepared statement and executing query
		PreparedStatement stmt= null;
		try {
			//System.out.println("Heyy student "+student);
			stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_COURSES);
			//System.out.println("Heyy getStudentId "+student.getStudentId());
			stmt.setInt(1, student.getStudentId());
			

			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of Course
			while(rs.next())
			{
				Course c = new Course();
				
				c.setCourseName(rs.getString("courseName"));
				c.setCourseId(rs.getInt("courseId"));
				c.setBill(rs.getInt("bill"));
				c.setDept(rs.getString("dept"));
				c.setNumberOfStudentsEnrolled(rs.getInt("numberOfStudentsEnrolled"));
				c.setPreReq(rs.getString("preReq"));
				c.setProf(rs.getString("prof"));
				c.setSemester(rs.getString("semester"));
				c.setGrade(rs.getString("grade"));
				list.add(c);
			}

			return list;
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.lti.dao.CourseDaoInterface#insertCourse(com.lti.bean.Course)
	 */
	@Override
	public void insertCourse(Course course) {
		
		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		//Establishing the connection
		PreparedStatement stmt = null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_COURSE);
	
			
			stmt.setInt(1, course.getCourseId());
			stmt.setString(2, course.getCourseName());
			stmt.setString(3, course.getPreReq());
			stmt.setString(4, course.getSemester());
			stmt.setString(5, course.getDept());
			stmt.setString(6, course.getProf());
			stmt.setDouble(7,course.getBill());
			stmt.setInt(8, course.getNumberOfStudentsEnrolled());
			stmt.setString(9, course.getGrade());
			//Executing query
			stmt.executeUpdate();
			System.out.println("Course added!");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.lti.dao.CourseDaoInterface#deleteCourse(int)
	 */
	@Override
	public void deleteCourse(int courseId) throws CourseNotFoundException {
		
		//Establishing the connection
		Connection connection = DBUtils.getConnection();
		//Establishing the connection
		PreparedStatement stmt = null;
		try {

			stmt=connection.prepareStatement(SQLConstantQueries.DELETE_COURSE+courseId);
			//Executing query
			int rs = stmt.executeUpdate();
			if(rs>0)
			{
				System.out.println("Course with courseId "+courseId+" deleted !");
				return;

			}
			throw new CourseNotFoundException();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		

	}

	/* (non-Javadoc)
	 * @see com.lti.dao.CourseDaoInterface#displayCoursesProfessor()
	 */
	@Override
	public List<Course> displayCoursesProfessor() {
		Connection connection= DBUtils.getConnection();

		//Declaring prepared statement and executing query
		PreparedStatement stmt= null;

		try {
			stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_COURSES_PROFESSOR);
			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of courses
			while(rs.next())
			{
				Course c = new Course();
				
				c.setCourseName(rs.getString("courseName"));
				c.setCourseId(rs.getInt("courseId"));
				c.setBill(rs.getInt("bill"));
				c.setDept(rs.getString("dept"));
				c.setNumberOfStudentsEnrolled(rs.getInt("numberOfStudentsEnrolled"));
				c.setPreReq(rs.getString("preReq"));
				c.setProf(rs.getString("prof"));
				c.setSemester(rs.getString("semester"));
				
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

}
