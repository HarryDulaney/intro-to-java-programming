<!-- StoreStudent.jsp -->
<%@ page import = "chapter42.Address" %>
<jsp:useBean id = "addressId" class = "chapter42.Address" 
  scope = "session"></jsp:useBean>
<jsp:useBean id = "storeDataId" class = "chapter43.StoreData" 
  scope = "application"></jsp:useBean>
       
<html>
  <body>   
    <%    
      storeDataId.storeStudent(addressId);

      out.println(addressId.getFirstName() + " " + 
        addressId.getLastName() +
        " is now registered in the database");
      out.close(); // Close stream
    %>
  </body>
</html>
