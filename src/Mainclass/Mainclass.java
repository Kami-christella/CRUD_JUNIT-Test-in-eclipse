package Mainclass;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.CourseDao;
import DAO.StudentDao;

import Model.Course;
import Model.Student;


public class Mainclass {
	public static void main(String[] args) {
//		 String dbUrl="jdbc:mysql://localhost:3306/school";
//	        String username="root";
//	        String passwd="Auca@2023";
	
		 boolean conditon = true;
	     int id;
	     String firstname;
	     String lastname;
	     String cname;
	     String lecturer;
	     int cid;
	    String country;
//	    List<Student> lresponse;
//	    List<Course> lresponse2;
	    Student sd = new Student();
	     StudentDao dao = new StudentDao();
	     Course cs=new Course();
	     CourseDao dao2 = new CourseDao();
	     String response;
//	     int courseid;
		 while(conditon){
	            System.out.println("==============================");
	            System.out.println("School MGT System");
	            System.out.println("1.Record Student ");
	              System.out.println("2.Update Student ");
	                System.out.println("3.Delete Student ");
	                  System.out.println("4.search Student ");
	                  System.out.println("5.All Students ");
	                  System.out.println("6.Record Course ");
		              System.out.println("7.Update Course ");
		                System.out.println("8.Delete Course ");
		                  System.out.println("9.search Course ");
		                  System.out.println("10.List all Courses ");
	                  
		                  try (Scanner sc = new Scanner(System.in)) {
	                     int choice=sc.nextInt();
	                     switch(choice){
	                         case 1:
	                             try{
	                                 System.out.print("Enter Student ID: ");
	                               id = sc.nextInt();
	                               System.out.println("Enter First Name: ");
	                               firstname = sc.next();
	                               System.out.println("Enter Last Name: ");
	                               lastname = sc.next();
	                               System.out.println("Enter Country: ");
	                               country = sc.next();
	                               
	                               sd.setId(id);
	                               sd.setFirstName(firstname);
	                               sd.setLastName(lastname);
	                               sd.setCountry(country);
	                               response = dao.recordStudent(sd);
	                               System.out.println(response);
	                               
	                                        
	                                    } catch(Exception ex){
	                                        ex.printStackTrace();
	                                    }
	                             break;
	                         case 2:
	                        	  try{
		                                 System.out.print("Enter Student ID to update: ");
		                               id = sc.nextInt();
		                               System.out.println("Enter First Name: ");
		                               firstname = sc.next();
		                               System.out.println("Enter Last Name: ");
		                               lastname = sc.next();
		                               System.out.println("Enter Country: ");
		                               country = sc.next();
		                               
		                               sd.setId(id);
		                               sd.setFirstName(firstname);
		                               sd.setLastName(lastname);
		                               sd.setCountry(country);
		                               response = dao.updateStudent(sd);
		                               System.out.println(response);
		                               
		                                        
		                                    } catch(Exception ex){
		                                        ex.printStackTrace();
		                                    }
	                        	 break;
	                         case 3:
	                        	  try{
		                                 System.out.print("Enter Student ID to Delete: ");
		                               id = sc.nextInt();
		                               sd.setId(id);
		                               response = dao.deleteStudent(sd);
		                               System.out.println(response);  
		                                    } catch(Exception ex){
		                                        ex.printStackTrace();
		                                    }
	                        	 break;
	                         case 4:	                        	
	                        	  System.out.print("Enter Student Id:");
	                        	  id = sc.nextInt();
	                      	  
	                      	    sd.setId(id);
	                      	    ResultSet feed = dao.searchStudent(sd);
	                      	    try {
	                      	    	if ((!feed.next())) {
	                      	    		System.out.println("not found");	
	                      	    	}else {
	                      	    		
	                      	    	
	                      	        do{
	                      	            int studentId = feed.getInt("id");
	                      	           String Firstname = feed.getString("firstname");
	                      	         String Lastname = feed.getString("lastname");
	                      	            String Country = feed.getString("country");
	                      	            System.out.println("Student ID: " + studentId + ", id: " + Firstname + ", firstname: " + Lastname + ",Country:" +Country);
	                      	        }while (feed.next()) ;
	                      	    	}
	                      	    } catch (SQLException ex) {
	                      	        ex.printStackTrace();
                      	    }
	                      	  
	                      	    break;

	                         case 5:
	                        	  System.out.print("List of All Students: ");
	                        	   feed = dao.Allstudents();
		                      	    try {
		                      	    	if ((!feed.next())) {
		                      	    		System.out.println("not found");	
		                      	    	}else {
		                      	    		
		                      	    	
		                      	        do{
		                      	            int studentId = feed.getInt("id");
		                      	           String Firstname = feed.getString("firstname");
		                      	         String Lastname = feed.getString("lastname");
		                      	            String Country = feed.getString("country");
		                      	            System.out.println("Student ID: " + studentId + ", id: " + Firstname + ", firstname: " + Lastname + ",Country:" +Country);
		                      	        }while (feed.next()) ;
		                      	    	}
		                      	    } catch (SQLException ex) {
		                      	        ex.printStackTrace();
	                      	    }
	                        	 
	                      	  
	                      	    break;
	                         case 6:
	                             try{
	                                 System.out.print("Enter course ID: ");
	                               cid = sc.nextInt();
	                               System.out.println("Enter course Name: ");
	                               cname = sc.next();
	                               System.out.println("Enter Lecturer Name: ");
	                               lecturer = sc.next();
	                              
	                             
	                               
	                               cs.setId(cid);
	                               cs.setCname(cname);
	                               cs.setLecturer(lecturer);
	                             
	                               String res = dao2.recordCourse(cs);
	                               System.out.println(res);
	                               
	                                        
	                                    } catch(Exception ex){
	                                        ex.printStackTrace();
	                                    }
	                             break;
	                         case 7:
	                             try{
	                                 System.out.print("Enter course ID to update: ");
	                               cid = sc.nextInt();
	                               System.out.println("Enter course Name: ");
	                               cname = sc.next();
	                               System.out.println("Enter Lecturer Name: ");
	                               lecturer = sc.next();
	                              
	                             
	                               
	                               cs.setId(cid);
	                               cs.setCname(cname);
	                               cs.setLecturer(lecturer);
	                             
	                               response = dao2.updateCourse(cs);
	                               System.out.println(response);
	                               
	                                        
	                                    } catch(Exception ex){
	                                        ex.printStackTrace();
	                                    }
	                             break;   
	                         case 8:
	                             try{
	                                 System.out.print("Enter course ID to delete: ");
	                               cid = sc.nextInt();
	                               cs.setId(cid);
	                             
	                             
	                               response = dao2.deleteCourse(cs);
	                               System.out.println(response);
	                                    } catch(Exception ex){
	                                        ex.printStackTrace();
	                                    }
	                             break; 
	                         case 9:
	                        	  System.out.print("Enter Student Id:");
	                        	  cid = sc.nextInt();
	                      	  
	                      	    cs.setId(cid);
	                      	    ResultSet feed1 = dao2.searchCourse(cs);
	                      	    try {
	                      	    	if ((!feed1.next())) {
	                      	    		System.out.println("not found");	
	                      	    	}else {
	                      	    		
	                      	    	
	                      	        do{
	                      	            int courseId = feed1.getInt("id");
	                      	            cname = feed1.getString("cname");
	                      	          lecturer = feed1.getString("lecturer");
	                      	           
	                      	            System.out.println("Student ID: " + courseId + ", id: " + cname + ", Lecturer: " + lecturer + " " );
	                      	        }while (feed1.next()) ;
	                      	    	}
	                      	    } catch (SQLException ex) {
	                      	        ex.printStackTrace();
                      	    }
	                      	    break;
	                         case 10:	 
	                        	 System.out.print("List of All Courses: ");
	                        	   feed1 = dao2.AllCourses();
		                      	    try {
		                      	    	if ((!feed1.next())) {
		                      	    		System.out.println("not found");	
		                      	    	}else {
		                      	    		
		                      	    	
		                      	        do{
		                      	        	 int courseId = feed1.getInt("id");
			                      	            cname = feed1.getString("cname");
			                      	          lecturer = feed1.getString("lecturer");
			                      	           
			                      	            System.out.println("Student ID: " + courseId + ", id: " + cname + ", Lecturer: " + lecturer + " " );
		                      	        }while (feed1.next()) ;
		                      	    	}
		                      	    } catch (SQLException ex) {
		                      	        ex.printStackTrace();
	                      	    }
		                      	    break;
                     	 
}
}}}}
	

