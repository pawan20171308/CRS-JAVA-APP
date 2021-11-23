/**
 * 
 */
package com.lti.bean;

/**
 * @author user256
 *
 */
public class Course {
	private int courseId;
	private String courseName,preReq,semester,dept,prof;
	private double bill;
	private int NumberOfStudentsEnrolled;
	private String grade;
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the preReq
	 */
	public String getPreReq() {
		return preReq;
	}
	/**
	 * @param preReq the preReq to set
	 */
	public void setPreReq(String preReq) {
		this.preReq = preReq;
	}
	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}
	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	/**
	 * @return the prof
	 */
	public String getProf() {
		return prof;
	}
	/**
	 * @param prof the prof to set
	 */
	public void setProf(String prof) {
		this.prof = prof;
	}
	/**
	 * @return the bill
	 */
	public double getBill() {
		return bill;
	}
	/**
	 * @param bill the bill to set
	 */
	public void setBill(double bill) {
		this.bill = bill;
	}
	
	/**
	 * @return the numberOfStudentsEnrolled
	 */
	public int getNumberOfStudentsEnrolled() {
		return NumberOfStudentsEnrolled;
	}
	/**
	 * @param numberOfStudentsEnrolled the numberOfStudentsEnrolled to set
	 */
	public void setNumberOfStudentsEnrolled(int numberOfStudentsEnrolled) {
		NumberOfStudentsEnrolled = numberOfStudentsEnrolled;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
