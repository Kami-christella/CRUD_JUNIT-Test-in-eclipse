import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.StudentDao;




import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import Model.Student;

class ClassTest {

	  private StudentDao studentDao;

    @BeforeEach
    public void setUp() throws Exception {
       
         studentDao = new StudentDao();
    }

    @AfterEach
    public void tearDown() throws Exception {
       
    }

    @Test
    public void testRegistering() {
        Student student = new Student();
        student.setId(5);
        student.setFirstName("mmm");
        student.setLastName("lol");
        student.setCountry("Rwanda");

       
		String result = studentDao.recordStudent(student);
        assertEquals("Successfully inserted", result);
    }

    @Test
    public void testUpdating() {
        Student student = new Student();
        student.setId(3);
        student.setFirstName("third");
        student.setLastName("Lola");
        student.setCountry("Rwanda");

       String result = studentDao.updateStudent(student);
        assertEquals("Successfully Updated", result);
    }

    @Test
    public void testDelete() {
        Student student = new Student();
        student.setId(5);

        String result = studentDao.deleteStudent(student);
        assertEquals("Successfully Deleted", result);
    }

  @Test
  public void testSearching() throws SQLException {
        Student student = new Student();
        student.setId(247);

        ResultSet resultSet = (ResultSet) studentDao.searchStudent(student);
        assertNotNull(resultSet);

      
        assertTrue(resultSet.next());

      
        int id = resultSet.getInt("id");
        String firstname = resultSet.getString("firstname");
        String country = resultSet.getString("country");

        
        assertEquals(2, id);
        assertEquals("kik", firstname);
        assertEquals("Rwanda", country);
    }

    @Test
    public void testStudentLists() throws SQLException {
    	
    	ResultSet resultSet = (ResultSet) studentDao.Allstudents();
        assertNotNull(resultSet);

      
        assertTrue(resultSet.next());

       
        int id = resultSet.getInt("id");
        String firstname = resultSet.getString("firstname");
        String country = resultSet.getString("country");

      
        assertEquals(241, id);
        assertEquals("Kami", firstname);
        assertEquals("Kenya", country);
    }
}
