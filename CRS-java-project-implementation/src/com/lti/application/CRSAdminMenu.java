/**
 * 
 */
package com.lti.application;

import java.util.Scanner;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Proffessor;
import com.lti.bean.User;
import com.lti.constants.SQLConstantQueries;
import com.lti.service.AdminInterface;
import com.lti.service.AdminOperations;

/**
 * @author shree
 *
 */
public class CRSAdminMenu {
	
	public static void viewAdminMenu(Admin a) {

		AdminInterface operations=new AdminOperations();
		System.out.println("##############Admin Menu######################");
		
		System.out.print("\n 1.Add Course \n 2.Drop Course \n 3.Add Professor \n 4. Drop Professor \n5. Approve Student 6.Exit");
		//StudentInterface operations=new StudentOperations();
		//List<Student> arr=new ArrayList<Student>();
		
		//Student s=new Student();
		
		Scanner in = new Scanner(System.in);
		System.out.println("\n select your choice :");
		int selection = Integer.parseInt(in.next());
		do{
		switch(selection)
		{
		case 1:Course course=new Course();
				System.out.println("Enter Course Id \n");
				course.setCourseId(in.nextInt());
				System.out.println("Enter Course Name \n");
				course.setCourseName(in.next());
				System.out.println("Enter Course Dept \n");
				course.setDept(in.next());
				System.out.println("Enter Pre Req \n");
				course.setPreReq(in.next());
				System.out.println("Enter Bill \n");
				course.setBill(in.nextDouble());
				System.out.println("Enter Prof \n");
				course.setProf(in.next());
				System.out.println("Enter Semester \n");
				course.setSemester(in.next());
				boolean status= operations.createCourse(course);//false ; //operations.createCourse(course);
				if(status){
					System.out.println("Course Added Successfully!");
				}
				else{
					System.out.println("Some Error occured!");
				}
				//arr.add(s);
				//operations.AddStudent(arr,s);
				//System.out.println(arr);
				break;
				
		case 2:	//String id,pass;
				
				break;
		case 3:
				Proffessor p=new Proffessor(); 
				User u=new User();
				System.out.println("Enter Prof Id\n");
				p.setProfessorId(in.nextInt());
				System.out.println("Enter Prof Name\n");
				p.setName(in.next());
				System.out.println("Enter Prof Designation\n");
				p.setDesignation(in.next());
			//	System.out.println("Enter Prof Department\n");
		//		p.setDepartment(in.next());
				//System.out.println("Enter Prof DOJ\n");
	//			p.setDOJ(in.next());
				System.out.println("Enter Prof Email Id\n");
				u.setUserName(in.next());
				u.setUserId(p.getProfessorId());
				u.setRoleId(SQLConstantQueries.ROLE_PROF);
				u.setUserPassword(p.getName()+""+p.getProfessorId());
				//u.setLastLoginDate(LocalDateTime.now());
				//u.setLastLoginDate(LocalDateTime.now());
				boolean st=false;
				try{
				 st=operations.addProf(p,u);
				}
				catch(Exception e){
					System.out.println("Exception Occured!");
				}
				if(st){
					System.out.println("Professor "+p.getName()+" Added Successfully!");
				}
				else
					System.out.println("Some Error Occured!");
			 break;  
				
		case 4: //System.out.println("Courses Opted by you are \n");
				
				break;
		case 5: System.out.println("Enter Student Id to approve\n");
				int studentId=in.nextInt();
				int n=operations.approveStudent(studentId);
				if(n>0){
					System.out.println("Student Id "+studentId+" Approved Successfully!");
				}
				else{
					System.out.println("Some Error Occured");
				}
				break;
		case 6:System.out.println("Exiting Application!");
				System.exit(0); 
				break;
		}
		 System.out.println("press any key other than 11 to do more operations else press 7 to exit");
		 selection = in.nextInt();
     } while (selection != 6);

	}
}
