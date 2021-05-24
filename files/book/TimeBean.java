package jsf2demo;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class TimeBean {
  public TimeBean() {
  }
  
  public String getTime() {
    return new java.util.Date().toString();
  }

}
