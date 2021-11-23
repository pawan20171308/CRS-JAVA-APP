/**
 * 
 */
package com.lti.application;

import java.util.Date;
import java.util.Scanner;

import com.lti.bean.Proffessor;
import com.lti.service.CourseInterface;
import com.lti.service.CourseOperations;
import com.lti.service.GradeInterface;
import com.lti.service.GradeOperations;
import com.lti.service.ProfessorInterface;
import com.lti.service.ProfessorOperations;

/**
 * @author shree
 *
 */
public class CRSProffessorMenu {
	
	public static void viewProfessorMenu(Proffessor professor ) {
		int courseId;
		
		CourseInterface courseOperation= new CourseOperations(); 
		ProfessorInterface professorOperation = new ProfessorOperations();
		
		Date currentDate = new Date();
		System.out.println("\nSuccesfully logged in as Professor on "+ currentDate);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Welcome "+professor.getName()+" !");

			System.out.println("Choose an option"); 
			System.out.println("1. View Courses to teach");
			System.out.println("2. Select a course");
			System.out.println("3. Deselect a course");
			System.out.println("4. View Selected Courses");
			System.out.println("5. Upload Grades");
			System.out.println("6. Logout");

			int choice= sc.nextInt();

			switch(choice) {
	
			case 1:
				courseOperation.displayCoursesProfessor();
				continue;

			
			case 2:
				System.out.println("Enter CourseID of the Course to be selected");
				courseId= sc.nextInt();
				professorOperation.selectCourse(courseId, professor);
				continue;

			
			case 3:
				System.out.println("Enter CourseID of the Course to be deselected");
				courseId= sc.nextInt();
				professorOperation.deselectCourse(courseId, professor);
				continue;

			case 4:
				professorOperation.displaySelectedCoursesProfessor(professor);
				continue;

			case 5:
				System.out.println("Enter the CourseID to upload grades");
				courseId= sc.nextInt();
				System.out.println("Enter the StudentID to upload grades");
				int studentId= sc.nextInt();
				System.out.println("Enter the grade");
				String grade= sc.next();
				
				// grade submission
				GradeInterface gradeOperation = new GradeOperations();
				gradeOperation.uploadGrades(studentId, courseId, grade);
				continue;

			case 6:
				currentDate = new Date();
				System.out.println("Succesfully logged out as on "+ currentDate);
				break;

			}
			break;
		}
		sc.close();
	}
	
	
}
