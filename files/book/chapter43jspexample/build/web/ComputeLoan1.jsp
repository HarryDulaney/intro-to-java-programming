<!-- ComputeLoan1.jsp -->
<html>
  <head>
    <title>ComputeLoan Using the Loan Class</title>
  </head>
  <body>
    <%@ page import = "chapter43.Loan" %>
    <% double loanAmount = Double.parseDouble(
         request.getParameter("loanAmount"));
       double annualInterestRate = Double.parseDouble(
         request.getParameter("annualInterestRate"));
       int numberOfYears = Integer.parseInt(
         request.getParameter("numberOfYears"));
       Loan loan = 
         new Loan(annualInterestRate, numberOfYears, loanAmount);
    %>
    Loan Amount: <%= loanAmount %><br />
    Annual Interest Rate: <%= annualInterestRate %><br />
    Number of Years: <%= numberOfYears %><br />
    <b>Monthly Payment: <%= loan.getMonthlyPayment() %><br />
    Total Payment: <%= loan.getTotalPayment() %><br /></b>
  </body>
</html>
