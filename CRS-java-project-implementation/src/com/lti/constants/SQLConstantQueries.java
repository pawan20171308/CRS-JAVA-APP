/**
 * 
 */
package com.lti.constants;

/**
 * @author user259
 *
 */
public class SQLConstantQueries {
	public static final String LAST_LOGIN = "UPDATE USER set lastLogin=? where userId=?";
	public static final String VALIDATE_USER="SELECT UserID,RoleID,userName FROM user where userName=? AND userPassword=?";
	public static final String FETCH_STUDENT="SELECT * FROM student where StudentID=?";
	public static final String VIEW_SELECTED_COURSES = "SELECT courseId FROM register_course where studentId=?";
	public static final String UPDATE_COURSE_DETAILS_STUDENT = "Update register_course set courseId=? where courseId=? and studentId=?";
	public static final String DROP_STUDENT_COURSE = "DELETE FROM register_course where courseId=? and studentId=?";
	public static final String VIEW_COURSE =  "SELECT courseId, courseName ,dept,preReq,prof, semester , bill FROM course";
	public static final String FETCH_COURSE = "SELECT studentId, courseId FROM register_course where studentId=?";
	public static final String ADD_COURSE ="INSERT INTO register_course VALUES (?,?,false,CURRENT_TIMESTAMP)";
	public static final String FETCH_PROFESSOR="SELECT * FROM professor where ProfessorID=?";
	public static final String INSERT_STUDENT="INSERT INTO student VALUES (?,?,?,?,?,?,?,?)";
	public static final String INSERT_USER="INSERT INTO user VALUES (?,?,?,?,?)";
	public static final String VIEW_RECORD= "SELECT * from Report where studentId=?";
	public static final String SELECT_COURSE="UPDATE professor_course SET ProfessorID = ? WHERE CourseID=? ";
	public static final String DISSELECT_COURSE="UPDATE professor_course SET ProfessorID=0 WHERE CourseID=?" ;
	public static final String DISPLAY_PROFESSOR_SELECTED_COURSES="SELECT course.CourseID, course.courseName, professor_course.NumberOfStudentsEnrolled FROM course INNER JOIN professor_course ON course.CourseID=professor_course.CourseID WHERE ProfessorID=? ";
	public static final String INSERT_COURSE="INSERT INTO course VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String DELETE_COURSE="DELETE FROM course WHERE CourseID=" ;
	public static final String DISPLAY_COURSES= "SELECT * FROM course WHERE courseId= ?";
	public static final String DISPLAY_COURSES_PROFESSOR= "SELECT * FROM course" ;
	public static final String VIEW_GRADES="SELECT course.CourseID, course.CourseTitle,  grade.Grade \r\n" + "FROM course  \r\n" + "INNER JOIN grade  \r\n" + 
			"ON course.CourseID = grade.CourseID \r\n" + "WHERE grade.StudentID=?";
	public static final String UPLOAD_GRADES="INSERT INTO grade VALUES (?,?,?,CURRENT_TIMESTAMP)";
	public static final String ADMIN_ADDCOURSE="INSERT INTO course VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_STUDENT_USER="INSERT INTO user VALUES (?,?,?,?,?)";
	
	public static final String ADMIN_ADDPROF="INSERT INTO professor VALUES (?,?,?,?,?)";
    public static final String APPROVE_STUDENT="UPDATE STUDENT SET APPROVALSTATUS=? where STUDENTID=?";
	public static final int ROLE_STUDENT=1;
	public static final int ROLE_PROF=2;
	public static final int ROLE_ADMIN=3;
	public static final String INACTIVE_STATUS="I";
	public static final String ACTIVE_STATUS="A";
	

}
