/**
 * 
 */
package com.lti.application;

import java.util.Date;
import java.util.Scanner;

import com.lti.bean.Student;
import com.lti.exceptions.MaxCoursesOptedException;
import com.lti.service.CourseInterface;
import com.lti.service.CourseOperations;
import com.lti.service.StudentInterface;
import com.lti.service.StudentOperations;

/**
 * @author shree
 *
 */
public class CRSStudentMenu {

	public static void viewStudentMenu(Student s) throws MaxCoursesOptedException{
		System.out.println();
		System.out.println();
		System.out.println("*****************************************************************************************");
		System.out.println();
		Date currentDate = new Date();
		System.out.println("Succesfully logged in as Student on "+ currentDate);
		System.out.println();
		StudentInterface operations=new StudentOperations();
		System.out.println("\n#################################Student Menu#########################################");
		System.out.println();
		System.out.println("Welcome "+s.getFname()+" "+ s.getSname()+" !");
		System.out.print("\n 1.View Course \n 2.Add Course \n 3.Drop Course \n 4.View Registered Courses \n 5. Update Course \n 6. View Report \n 7. Exit Application2");
		//StudentInterface operations=new StudentOperations();
		//List<Student> arr=new ArrayList<Student>();
		
		//Student s=new Student();
		
		Scanner in = new Scanner(System.in);
		CourseInterface courseOperation= new CourseOperations();
		System.out.println("\n select your choice :");
		int selection = Integer.parseInt(in.next());
		do{
		switch(selection)
		{
		case 1: 
				System.out.println();
				System.out.println();
				System.out.println("=========================================================================================");
				System.out.println();
				System.out.println("Course Catalogue is as below :");
				System.out.println();
				//operations.displayCourses();
				courseOperation.displayCourses(s);
				System.out.println();
				System.out.println("=========================================================================================");
				//arr.add(s);
				//operations.AddStudent(arr,s);
				//System.out.println(arr);
				break;
				
		case 2:	//String id,pass;
				System.out.println();
				System.out.println();
				System.out.println("=========================================================================================");
				//operations.displayCourses();
				courseOperation.displayCourses(s);
				System.out.println("\nSelect Course Id to add :\n");
				System.out.println();
				String courseId=in.next();
				int id=0;
				try{
					id=Integer.parseInt(courseId); 
				}
				catch(Exception e){
					
					System.out.println(e.toString());
				}
				
				if(id!=0){
					try{
					operations.optCourse(s, id);
					}
					catch(MaxCoursesOptedException e){
						//System.out.println("Max Courses Opted Exception Occured.\n"+e.getMessage());
						throw new MaxCoursesOptedException();
					}
					}
				break;
		case 3: System.out.println("Select Course Id to drop :\n");
		String dropId=in.next();
		int drpid=0;
		try{
			drpid=Integer.parseInt(dropId); 
		}
		catch(Exception e){
			
			System.out.println(e.toString());
		}
		
		if(drpid!=0){
			operations.dropCourse(s, drpid);
			}
			 break;  
				
		case 4: //System.out.println("Courses Opted by you are \n");
				operations.viewRegisteredCourses(s);
				break;
		case 5: System.out.println("Please Input new course Id you wish to opt \n");
				String newId=in.next();
				System.out.println("Please Input old course Id you wish to replace \n");
				String oldId=in.next();
				int nId=Integer.parseInt(newId);
				int oId=Integer.parseInt(oldId);
				operations.updateCourseDetails(s, oId, nId);
				break;
		case 6:
			    System.out.println();
				System.out.println("=========================================================================================");
				System.out.println();
				System.out.println();
				System.out.println("Report Details are as below \n");
				operations.viewReport(s);
				break;
		case 7: System.out.println("Exiting Application!"); 
				System.exit(0);
				break;
		}
		 System.out.println();
		 System.out.println();
		 System.out.println("press any key other than 7 to do more operations else press 7 to exit");
		 System.out.println("*****************************************************************************************");
		 selection = in.nextInt();
     } while (selection != 7);
		
		in.close();
	
	}


}
