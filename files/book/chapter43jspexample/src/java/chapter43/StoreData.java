package chapter43;

import java.sql.*;
import chapter42.Address;

public class StoreData {
  // Use a prepared statement to store a student into the database
  private PreparedStatement pstmt;

  public StoreData() {
    initializeJdbc();
  }

  /** Initialize database connection */
  private void initializeJdbc() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      
      // Connect to the sample database
      Connection connection = DriverManager.getConnection
        ("jdbc:mysql://localhost/javabook" , "scott", "tiger");

      // Create a Statement
      pstmt = connection.prepareStatement("insert into Address " +
        "(lastName, firstName, mi, telephone, email, street, city, "
        + "state, zip) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
  }

  /** Store a student record to the database */
  public void storeStudent(Address address) throws SQLException {
    pstmt.setString(1, address.getLastName());
    pstmt.setString(2, address.getFirstName());
    pstmt.setString(3, address.getMi());
    pstmt.setString(4, address.getTelephone());
    pstmt.setString(5, address.getEmail());
    pstmt.setString(6, address.getStreet());
    pstmt.setString(7, address.getCity());
    pstmt.setString(8, address.getState());
    pstmt.setString(9, address.getZip());
    pstmt.executeUpdate();
  }
}
