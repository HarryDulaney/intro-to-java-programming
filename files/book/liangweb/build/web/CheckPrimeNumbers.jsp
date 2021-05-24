<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import = "java.net.*" %>
<%@ page import = "java.io.*" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Display Current Largest One Hundred Prime Numbers</title>
  </head>
  <body>
    
    <center>Display Current Largest One Hundred Prime Numbers</center>
    <%= new java.util.Date() %>
    
    <h1>Donna Bryant</h1>
    <%= getLast100Numbers("BryantPrimeNumbers.dat") %>
    
    <h1>Ivan Sopin</h1>
    <%= getLast100Numbers("SopinPrimeNumbers2.dat") %>

    <h1>Ivan Sopin</h1>
    <%= getLast100Numbers("SopinPrimeNumbers.dat") %>
    
    <h1>Brian Maxon</h1>
    <%= getLast100Numbers("MaxonPrimeNumbers.dat") %>
    
    <h1>Tristan Lawrence</h1>
    <%= getLast100Numbers("LawrencePrimeNumbers.dat") %>

    <h1>Steven Vaughn</h1>
    <%= getLast100Numbers("VaughnPrimeNumbers.dat") %>
    
    <%!
    public static String getLast100Numbers(String filename) {
      try {
        // Create a socket to connect to the server
        // Socket socket = new Socket("localhost", 8000);
        // Socket socket = new Socket("130.254.204.36", 8000);
        // Socket socket = new Socket("panda.Armstrong.edu", 8000);
        Socket socket = new Socket("130.254.204.34", 8000);
        
        // Create an output stream to send the file name to the server
        DataOutputStream toServer = new DataOutputStream(
          socket.getOutputStream());
        toServer.writeUTF(filename);
        
        // Create an input stream to receive data from the server
        ObjectInputStream fromServer = new ObjectInputStream(
          socket.getInputStream());
        
        // Create an output stream to send data to the server
        java.util.ArrayList<Long> numbers
          = (java.util.ArrayList<Long>)(fromServer.readObject());
        
        String result = "";
        for (int i = 0; i < numbers.size(); i++) {
          result += numbers.get(i) + " ";
        }
        
        return result;
      } catch (Exception ex) {
        return "Server stopped";
      }
    }
    %>
  </body>
</html>
