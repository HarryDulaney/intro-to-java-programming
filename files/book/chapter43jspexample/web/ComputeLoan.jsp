<!-- ComputeLoan.jsp -->
<html>
  <head>
    <title>ComputeLoan</title>
  </head>
  <body>
  <% double loanAmount = Double.parseDouble(
       request.getParameter("loanAmount"));
     double annualInterestRate = Double.parseDouble(
       request.getParameter("annualInterestRate"));
     double numberOfYears = Integer.parseInt(
       request.getParameter("numberOfYears"));
     double monthlyInterestRate = annualInterestRate / 1200;
     double monthlyPayment = loanAmount * monthlyInterestRate /
      (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
     double totalPayment = monthlyPayment * numberOfYears * 12; %>
  Loan Amount: <%= loanAmount %><br />
  Annual Interest Rate: <%= annualInterestRate %><br />
  Number of Years: <%= numberOfYears %><br />
  <b>Monthly Payment: <%= monthlyPayment %><br />
  Total Payment: <%= totalPayment %><br /></b>
  </body>
</html>
