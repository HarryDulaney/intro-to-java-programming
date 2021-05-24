import java.sql.*;
import javax.sql.RowSet;
import com.sun.rowset.JdbcRowSetImpl;

public class ScrollUpdateRowSet {
  public static void main(String[] args)
      throws SQLException, ClassNotFoundException {
    // Load the JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver loaded");

    // Create a row set
    RowSet rowSet = new JdbcRowSetImpl();

    // Set RowSet properties
    rowSet.setUrl("jdbc:mysql://localhost/javabook");
    rowSet.setUsername("scott");
    rowSet.setPassword("tiger");
    rowSet.setCommand("select state, capital from StateCapital");
    rowSet.execute();

    System.out.println("Before update ");
    displayRowSet(rowSet);

    // Update the second row
    rowSet.absolute(2); // Move cursor to the 2nd row
    rowSet.updateString("state", "New S"); // Update the column
    rowSet.updateString("capital", "New C"); // Update the column
    rowSet.updateRow(); // Update the row in the data source

    // Insert after the second row
    rowSet.last();
    rowSet.moveToInsertRow(); // Move cursor to the insert row
    rowSet.updateString("state", "Florida");
    rowSet.updateString("capital", "Tallahassee");
    rowSet.insertRow(); // Insert the row
    rowSet.moveToCurrentRow(); // Move the cursor to the current row

    // Delete fourth row
    rowSet.absolute(4); // Move cursor to the fifth row
    rowSet.deleteRow(); // Delete the second row

    System.out.println("After update ");
    displayRowSet(rowSet);

    // Close the connection
    rowSet.close();
  }

  private static void displayRowSet(RowSet rowSet)
      throws SQLException {
    ResultSetMetaData rsMetaData = rowSet.getMetaData();
    rowSet.beforeFirst();
    while (rowSet.next()) {
      for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
        System.out.printf("%-12s\t", rowSet.getObject(i));
      System.out.println();
    }
  }
}
