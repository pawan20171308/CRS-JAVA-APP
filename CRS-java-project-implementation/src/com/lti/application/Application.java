/**
 * 
 */
package com.lti.application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Proffessor;
import com.lti.bean.Report;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.constants.SQLConstantQueries;
import com.lti.exceptions.InvalidLoginException;
import com.lti.exceptions.MaxCoursesOptedException;
import com.lti.service.AdminInterface;
import com.lti.service.AdminOperations;
import com.lti.service.CourseInterface;
import com.lti.service.CourseOperations;
import com.lti.service.GradeInterface;
import com.lti.service.GradeOperations;
import com.lti.service.ProfessorInterface;
import com.lti.service.ProfessorOperations;
import com.lti.service.StudentInterface;
import com.lti.service.UserInterface;
import com.lti.service.UserOperations;
import com.lti.service.StudentOperations;
/**
 * @author user256
 *
 */
public class Application {


	static List<Course> courses= new ArrayList<Course>();
	
	static List<Report> reports=new ArrayList<Report>();
	/**
	 * @param args
	 */
	//static boolean registrationSucess = true;
	
	public static void main(String[] args) {

		StudentInterface operations=new StudentOperations();
		
		
		System.out.println("############# WELCOME TO COURSE RESGISTRATION SYSTEM APPLICATION ######################");
		Scanner in = new Scanner(System.in);
		try{
		System.out.print("\n 1.Student Registration \n 2.Login \n 3.Update Password \n 4. Exit");
		//StudentInterface operations=new StudentOperations();
	//	List<Student> arr=new ArrayList<Student>();
		
		Student student=new Student();
		User user= new User();
		Proffessor professor = new Proffessor();
		
		 Admin admin = new Admin();
		 boolean adminLogin = false , studentLogin = false, professorLogin= false;
		System.out.println("\n select your choice :");
		int selection = Integer.parseInt(in.next());
		do{
		switch(selection){
			case 1: 
				    System.out.println("***********************************REGISTER HERE****************************************");	
					System.out.println("\n	......Register Here......");
					
					operations.registerStudent(student);
					break;
					
			case 2:	
					String username,password;
					System.out.println();
					System.out.println("1. Student Login :");
					System.out.println("2. Professor Login :");
					System.out.println("3. Admin Login :");
					System.out.println();
				
					int choice = Integer.parseInt(in.next());
					
					if(choice==1 || choice == 2 || choice ==3){
						System.out.println("Enter Username:");
						username=in.next();
						System.out.println("Enter password :");
						password=in.next();
						UserInterface userOperation= new UserOperations();
						try{
							//loginStatus=operations.Login(s,id,pass);
							user= userOperation.validateUser(username, password);
							//
//							student=null;
//							professor=null;
//							admin = null;
							System.out.println("Role Id is "+user.getRoleId()+"\n User Id is "+user.getUserId()+"\n");
						
								if(user.getRoleId()==SQLConstantQueries.ROLE_STUDENT)
								{
									try{
										student = userOperation.fetchStudent(user.getUserId());
										studentLogin = true;
									   }catch(Exception e){
										System.exit(0);
									}
									if(student==null){
										System.out.println("Your Registration is not yet approved!\nPlease Contact Admin.");
									}
								}else if(user.getRoleId()==SQLConstantQueries.ROLE_ADMIN){
									admin=userOperation.fetchAdmins(user.getUserId());
									adminLogin = true;
									System.out.println("Admin Login Id: "+admin.getAdminId()+"\n User Name: "+admin.getAdminName());
								}else if(user.getRoleId()==SQLConstantQueries.ROLE_PROF){
									professor=userOperation.fetchProfessor(user.getUserId());
									professorLogin = true;
								}
						//
						
						//System.out.println(user.getUserId());
						//student = userOperation.fetchStudent(user.getUserId());
						//professor = userOperation.fetchProfessor(user.getUserId());
						
						//System.out.println("student: "+student);
						//System.out.println("professor: "+professor);
						}catch(InvalidLoginException e){
							System.out.println("Invalid Login Exception occured!\n"+e.getMessage());
							e.printStackTrace();
							return;
						}
				      }				
				      break;				
			case 3:break;	
					
			case 4: System.exit(0);
					break;		
		}
		 System.out.println("press any key other than 4 to do more operations else press 4 to exit");
		 
		 if(student != null && studentLogin){
		    	 try {
					//viewStudentMenu(student);
		    		 CRSStudentMenu.viewStudentMenu(student);
			     }catch (MaxCoursesOptedException e) {
					e.printStackTrace();
				 }
	       }else if(professor != null && professorLogin){
	        	 //viewProfessorMenu(professor);
	    	     CRSProffessorMenu.viewProfessorMenu(professor);
	        }else if(admin != null && adminLogin){
	        	 //viewAdminMenu(admin);
	        	CRSAdminMenu.viewAdminMenu(admin);
	       }
		
		selection = in.nextInt();
     } while (selection != 3);


		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			in.close();
		}
		
	}
	

/*	public static void viewStudentMenu(Student s) throws MaxCoursesOptedException{
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
		case 7: System.exit(0);
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
*/
	
	/*public static void viewProfessorMenu(Proffessor professor ) {
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
	*/
	
	/*public static void viewAdminMenu(Admin a) {

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
		case 6:System.exit(0); 
				break;
		}
		 System.out.println("press any key other than 11 to do more operations else press 7 to exit");
		 selection = in.nextInt();
     } while (selection != 6);

	}*/

	
}
