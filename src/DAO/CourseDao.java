package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Model.Course;

public class CourseDao {
 
      
         String dbUrl="jdbc:mysql://localhost:3306/school";
        String username="root";
        String passwd="Auca@2023";
         
        public String recordCourse(Course cs){
            try{
                 Connection con=DriverManager.getConnection(dbUrl,username,passwd);
                 PreparedStatement ps=con.prepareStatement("insert into courses(id,cname,lecturer) values(?,?,?) ");
                 ps.setInt(1,cs.getId());
                 ps.setString(2,cs.getCname());
                 if (cs.getLecturer() != null) {
                     ps.setString(3, cs.getLecturer());
                 } else {
                	 ps.setString(3,"Unknown");
                 }
               
                  int rowAffected=ps.executeUpdate();
                      con.close();
                      if(rowAffected>0){
                          return "data saved";
                      }else{
                          return "not data saved";
                      }
            }catch(Exception ex){
                ex.printStackTrace();
            }
           return "Server Error"; 
        }

        public String updateCourse(Course sm) {
            try{
                 Connection con = DriverManager.getConnection(dbUrl, username, passwd);
                String sql="update courses set cname=?,lecturer=? where id=?";
                PreparedStatement ps = con.prepareStatement(sql);
               
                ps.setString(1,sm.getCname());
                ps.setString(2,sm.getLecturer());
                ps.setInt(3,sm.getId());
               ;
               int rowsAffected = ps.executeUpdate();
               con.close();
               if(rowsAffected>=1){
//                  con.close();
                   return "Data updated Successful";
               }else{
                 con.close();
                   return "Data Not Saved";
               }
                
            }catch(Exception ex){
                ex.printStackTrace();
               return "Server Error!";
            }
        }
        public String deleteCourse(Course sobj){
            try{
                  Connection con = DriverManager.getConnection(dbUrl, username, passwd);
                  String sql="delete from courses where id=?";
                  PreparedStatement ps = con.prepareStatement(sql);
               ps.setInt(1, sobj.getId());
                int rowsAffected = ps.executeUpdate();
               con.close();
               if(rowsAffected>=1){
//                  con.close();
                   return "Course deleted Successful";
               }else{
                 con.close();
                   return "Course Not deleted";
               }
            }catch(Exception ex){
                
            }
                       return "Server Error!";

        }
    	 public ResultSet searchCourse(Course sobj){
  		   
 	        try {
 	              Connection con =DriverManager.getConnection(dbUrl, username, passwd);
 	           PreparedStatement pst =con.prepareStatement("select * from courses where id=?");
 	           pst.setInt(1, sobj.getId());
 	           return pst.executeQuery();
 	          
 	        } catch (Exception ex) {
 	            ex.printStackTrace();
 	        }
 	        return null;
 	    
 	    }
    	   public ResultSet AllCourses(){
               try {
   	              Connection con =DriverManager.getConnection(dbUrl, username, passwd);
   	           PreparedStatement pst =con.prepareStatement("select * from courses ");
   	         
   	           return pst.executeQuery();
   	          
   	        } catch (Exception ex) {
   	            ex.printStackTrace();
   	        }
   	        return null;
           }
           
           
       }
        
        
        
    