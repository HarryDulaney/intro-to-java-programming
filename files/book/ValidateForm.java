package jsf2demo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ValidateForm {
  private String name;
  private String ssn;
  private String ageString;
  private String heightString;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getSsn() {
    return ssn;
  }
  
  public void setSsn(String ssn) {
    this.ssn = ssn;
  }
  
  public String getAgeString() {
    return ageString;
  }
  
  public void setAgeString(String ageString) {
    this.ageString = ageString;
  }
  
  public String getHeightString() {
    return heightString;
  }
  
  public void setHeightString(String heightString) {
    this.heightString = heightString;
  }
  
  public String getResponse() {
    if (name == null || ssn == null || ageString == null 
            || heightString == null) {
      return "";
    }
    else {
      return "You entered " +
        " Name: " + name +
        " SSN: " + ssn +
        " Age: " + ageString +
        " Heihgt: " + heightString;
    }
  }
}
