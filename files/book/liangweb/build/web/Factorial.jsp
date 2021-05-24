<html>
  <head>
    <title>
      Factorial
    </title>
  </head>
  <body>

  <% for (int i = 0; i <= 10; i++) { %>
       Factorial of <%= i %> is
         <%= computeFactorial(i) %> <br />
  <% } %>

  <%! private long computeFactorial(int n) {
        if (n == 0)
          return 1;
        else
          return n * computeFactorial(n - 1);
      }
  %>

  </body>
</html>

