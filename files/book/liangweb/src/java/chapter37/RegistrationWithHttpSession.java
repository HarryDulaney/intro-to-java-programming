package chapter37; 

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class RegistrationWithHttpSession extends HttpServlet {
  // Use a prepared statement to store a student into the database
  private PreparedStatement pstmt;

  /** Initialize variables */
  public void init() throws ServletException {
    initializeJdbc();
  }

  /** Process the HTTP Get request */
  public void doGet(HttpServletRequest request, HttpServletResponse
      response) throws ServletException, IOException {
    // Set response type and output stream to the browser
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Obtain data from the form
    String lastName = request.getParameter("lastName");
    String firstName = request.getParameter("firstName");
    String mi = request.getParameter("mi");
    String telephone = request.getParameter("telephone");
    String email = request.getParameter("email");
    String street = request.getParameter("street");
    String city = request.getParameter("city");
    String state = request.getParameter("state");
    String zip = request.getParameter("zip");

    if (lastName.length() == 0 || firstName.length() == 0) {
      out.println("Last Name and First Name are required");
    }
    else {
      // Create an Address object
      Address address = new Address();
      address.setLastName(lastName);
      address.setFirstName(firstName);
      address.setMi(mi);
      address.setTelephone(telephone);
      address.setEmail(email);
      address.setStreet(street);
      address.setCity(city);
      address.setState(state);
      address.setZip(zip);

      // Get an HttpSession or create one if it does not exist
      HttpSession httpSession = request.getSession();

      // Store student object to the session
      httpSession.setAttribute("address", address);

      // Ask for confirmation
      out.println("You entered the following data");
      out.println("<p>Last name: " + lastName);
      out.println("<p>First name: " + firstName);
      out.println("<p>MI: " + mi);
      out.println("<p>Telephone: " + telephone);
      out.println("<p>Email: " + email);
      out.println("<p>Address: " + street);
      out.println("<p>City: " + city);
      out.println("<p>State: " + state);
      out.println("<p>Zip: " + zip);

      // Set the action for processing the answers
      out.println("<p><form method=\"post\" action=" +
        "RegistrationWithHttpSession>");
      out.println("<p><input type=\"submit\" value=\"Confirm\" >");
      out.println("</form>");
    }

    out.close(); // Close stream
  }

  /** Process the HTTP Post request */
  public void doPost(HttpServletRequest request, HttpServletResponse
      response) throws ServletException, IOException {
    // Set response type and output stream to the browser
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Obtain the HttpSession
    HttpSession httpSession = request.getSession();

    // Get the Address object in the HttpSession
    Address address = (Address)(httpSession.getAttribute("address"));

    try {
      storeStudent(address);

      out.println(address.getFirstName() + " " + address.getLastName()
        + " is now registered in the database");
      out.close(); // Close stream
    }
    catch(Exception ex) {
      out.println("Error: " + ex.getMessage());
    }
  }

  /** Initialize database connection */
  private void initializeJdbc() {
    try {
	 // Load the JDBC driver
	 Class.forName("com.mysql.jdbc.Driver");
	 System.out.println("Driver loaded");
	
	 // Establish a connection
	 Connection conn = DriverManager.getConnection
	   ("jdbc:mysql://localhost/javabook" , "scott", "tiger");
	 System.out.println("Database connected");

      // Create a Statement
      pstmt = conn.prepareStatement("insert into Address " +
        "(lastName, firstName, mi, telephone, email, street, city, "
        + "state, zip) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
  }

  /** Store an address to the database */
  private void storeStudent(Address address) throws SQLException {
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
