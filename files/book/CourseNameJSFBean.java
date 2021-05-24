package jsf2demo;

import java.sql.*;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "courseName")
@ApplicationScoped
public class CourseNameJSFBean {
  private PreparedStatement studentStatement = null;
  private String choice; // Selected course
  private String[] titles; // Course titles

  /** Creates a new instance of CourseName */
  public CourseNameJSFBean() {
    initializeJdbc();
  }

  /** Initialize database connection */
  private void initializeJdbc() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded");
      
      // Connect to the sample database
      Connection connection = DriverManager.getConnection(
        "jdbc:mysql://localhost/javabook", "scott", "tiger");

      // Get course titles
      PreparedStatement statement = connection.prepareStatement(
        "select title from course");
      
      ResultSet resultSet = statement.executeQuery();
      
      // Store resultSet into array titles
      ArrayList<String> list = new ArrayList<>();
      while (resultSet.next()) {
        list.add(resultSet.getString(1));
      }
      titles = new String[list.size()]; // An array for titles
      list.toArray(titles); // Copy strings from list to array
        
      // Define a SQL statement for getting students
      studentStatement = connection.prepareStatement(
        "select Student.ssn, "
        + "student.firstName, Student.mi, Student.lastName, "
        + "Student.phone, Student.birthDate, Student.street, "
        + "Student.zipCode, Student.deptId "
        + "from Student, Enrollment, Course "
        + "where Course.title = ? "
        + "and Student.ssn = Enrollment.ssn "
        + "and Enrollment.courseId = Course.courseId;");
    } 
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public String[] getTitles() {
    return titles;
  }

  public String getChoice() {
    return choice;
  }

  public void setChoice(String choice) {
    this.choice = choice;
  }

  public ResultSet getStudents() throws SQLException {
    if (choice == null) {
      if (titles.length == 0)
        return null;
      else
        studentStatement.setString(1, titles[0]);
    } 
    else {
      studentStatement.setString(1, choice); // Set course title
    }
    
    // Get students for the specified course
    return studentStatement.executeQuery();
  }
}
