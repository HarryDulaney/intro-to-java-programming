package chapter42;

public class Address {    
  private String firstName;
  private String mi;
  private String lastName;
  private String telephone;
  private String street;
  private String city;
  private String state;
  private String email;
  private String zip;
    
  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMi() {
    return this.mi;
  }

  public void setMi(String mi) {
    this.mi = mi;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getTelephone() {
    return this.telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStreet()  {
    return this.street;
  }
    
  public void setStreet(String street)  {
    this.street = street;
  }
            
  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return this.zip;
  }
    
  public void setZip(String zip) {
    this.zip = zip;
  }
}
