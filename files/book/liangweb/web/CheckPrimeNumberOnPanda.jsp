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
    <%= getLast100Numbers("/mnt/ide/primenumber/BryantPrimeNumbers.dat") %>
    
    <h1>Ivan Sopin</h1>
    <%= getLast100Numbers("/mnt/ide/primenumber/SopinPrimeNumbers2.dat") %>

    <h1>Ivan Sopin</h1>
    <%= getLast100Numbers("/mnt/ide/primenumber/SopinPrimeNumbers.dat") %>
    
    <h1>Brian Maxon</h1>
    <%= getLast100Numbers("/mnt/ide/primenumber/MaxonPrimeNumbers.dat") %>
    
    <h1>Tristan Lawrence</h1>
    <%= getLast100Numbers("/mnt/ide/primenumber/LawrencePrimeNumbers.dat") %>

    <h1>Steven Vaughn</h1>
    <%= getLast100Numbers("/mnt/ide/primenumber/VaughnPrimeNumbers.dat") %>
    
    <%!
    public static String getLast100Numbers(String filename) {
      final int NUMBER_OF_PRIMES = 100;
      try {

        // Read 100 numbers
        DataInputStream input =
          new DataInputStream(new BufferedInputStream(
          new FileInputStream(filename)));

        java.util.ArrayList<Long> numbers = new java.util.ArrayList<Long>();

        // (input.available() / 8) * 8 ensures getting right data
        input.skip((input.available() / 8) * 8 - 8 * NUMBER_OF_PRIMES);
        while (input.available() > 0) {
          numbers.add(input.readLong());
        }

        input.close();
        
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
