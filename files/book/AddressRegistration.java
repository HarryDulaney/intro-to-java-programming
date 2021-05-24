package jsf2demo;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.sql.*;

@Named
@SessionScoped
public class AddressRegistration implements java.io.Serializable {
  private String lastName;
  private String firstName;
  private String mi;
  private String telephone;
  private String email;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String status = "Nothing stored";
  // Use a prepared statement to store a student into the database
  private PreparedStatement pstmt;

  public AddressRegistration() {
    initializeJdbc();
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMi() {
    return mi;
  }

  public void setMi(String mi) {
    this.mi = mi;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  private boolean isRquiredFieldsFilled() {
    return !(lastName == null || firstName == null
            || lastName.trim().length() == 0
            || firstName.trim().length() == 0);
  }

  public String processSubmit() {
    if (isRquiredFieldsFilled()) {
      return "ConfirmAddress";
    } else {
      return "";
    }
  }

  public String getRequiredFields() {
    if (isRquiredFieldsFilled()) {
      return "";
    } else {
      return "Last Name and First Name are required";
    }
  }

  public String getInput() {
    return "<p style=\"color:red\">You entered <br />"
            + "Last Name: " + lastName + "<br />"
            + "First Name: " + firstName + "<br />"
            + "MI: " + mi + "<br />"
            + "Telephone: " + telephone + "<br />"
            + "Email: " + email + "<br />"
            + "Street: " + street + "<br />"
            + "City: " + city + "<br />"
            + "Street: " + street + "<br />"
            + "City: " + city + "<br />"
            + "State: " + state + "<br />"
            + "Zip: " + zip + "</p>";
  }

  /** Initialize database connection */
  private void initializeJdbc() {
    try {
      // Explicitly load a MySQL driver
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded");
      
      // Establish a connection
      Connection conn = DriverManager.getConnection(
              "jdbc:mysql://localhost/javabook", "scott", "tiger");

      // Create a Statement
      pstmt = conn.prepareStatement("insert into Address (lastName,"
              + " firstName, mi, telephone, email, street, city, "
              + "state, zip) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }

  /** Store an address to the database */
  public String storeStudent() {
    try {
      pstmt.setString(1, lastName);
      pstmt.setString(2, firstName);
      pstmt.setString(3, mi);
      pstmt.setString(4, telephone);
      pstmt.setString(5, email);
      pstmt.setString(6, street);
      pstmt.setString(7, city);
      pstmt.setString(8, state);
      pstmt.setString(9, zip);
      pstmt.executeUpdate();
      status = firstName + " " + lastName
              + " is now registered in the database.";
    } catch (Exception ex) {
      status = ex.getMessage();
    }
    
    return "AddressStoredStatus";
  }

  public String getStatus() {
    return status;
  }
}