<!-- TestAddressWebService.jsp -->
<%@ page import = "chapter42.Address" %>
<%@ page import = "chapter42.AddressWebService" %>
<%@ page import = "chapter42.AddressService" %>
<jsp:useBean id = "addressId" 
  class = "chapter42.Address" scope = "session"></jsp:useBean>
<jsp:setProperty name = "addressId" property = "*" />

<html>
<head>
  <title>Address Information</title>
</head>
<body>    
  <form method = "post" action = "TestAddressWebService.jsp">
  Last Name <font color = "#FF0000">*</font>
  <input type = "text" name = "lastName"         
    <%if (addressId.getLastName() != null) {
      out.print("value = \"" + addressId.getLastName() + "\"");}%>        
   size = "20" />&nbsp;

  First Name <font color = "#FF0000">*</font>
  <input type = "text" name = "firstName"  
    <%if (addressId.getFirstName() != null) {
      out.print("value = \"" + addressId.getFirstName() + "\"");}%>        
   size = "20" />&nbsp;

  MI 
  <input type = "text" name = "mi" 
    <%if (addressId.getMi() != null) {
      out.print("value = \"" + addressId.getMi() + "\" "); } %>        
   size = "3" />&nbsp;

  <p>Telephone 
  <input type = "text" name = "telephone" 
    <%if (addressId.getTelephone() != null) {
      out.print("value = \"" + addressId.getTelephone() + "\" ");}%>        
   size = "20" />&nbsp;

  Email 
  <input type = "text" name = "email" 
    <%if (addressId.getEmail() != null) {
      out.print("value = \"" + addressId.getEmail() + "\" ");}%>        
   size = "28" />&nbsp;
  </p>
    
  <p>Street 
  <input type = "text" name = "street"                          
    <%if (addressId.getStreet() != null) {
      out.print("value = \"" + addressId.getStreet() + "\" ");}%>        
   size = "50" />&nbsp;    
  </p>
    
  <p>City 
  <input type = "text" name = "city" 
    <%if (addressId.getCity() != null) {
      out.print("value = \"" + addressId.getCity() + "\" ");}%>        
  size = "23" />&nbsp;    

  State 
  <select size = "1" name = "state">
    <option value = "GA">Georgia-GA</option>
    <option value = "OK">Oklahoma-OK</option>
    <option value = "IN">Indiana-IN</option>
  </select>&nbsp;
  
  Zip 
  <input type = "text" name = "zip"                    
    <%if (addressId.getZip() != null) {
      out.print("value = \"" + addressId.getZip() + "\" "); } %>        
   size = "9" />&nbsp;
  </p>
  
  <p><input type = "submit" name = "Submit" value = "Search">
     <input type = "submit" name = "Submit" value = "Store">
     <input type = "reset" value = "Reset">
  </p>
  </form>
  <p><font color = "#FF0000">* required fields</font></p>

  <% 
  if (request.getParameter("Submit") != null) {       
    AddressWebService addressWebService = new AddressWebService();
    AddressService proxy = addressWebService.getAddressServicePort();
    
    if (request.getParameter("Submit").equals("Store")) { 
      proxy.storeAddress(addressId);
      out.println(addressId.getFirstName() + " " + 
        addressId.getLastName() + " has been added to the database");
    } 
    else if (request.getParameter("Submit").equals("Search")) {
      Address address = proxy.getAddress(addressId.getFirstName(),
        addressId.getLastName());
      if (address == null)
        out.print(addressId.getFirstName() + " " +
          addressId.getLastName() + " is not in the database");
      else
        addressId = address;
    }
  }
  %>  
</body>
</html> 
