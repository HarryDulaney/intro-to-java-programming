<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import = "chapter40.Exercise38_13" %>
        <jsp:useBean id = "poll" class = "chapter40.Exercise38_13"
        scope = "application" ></jsp:useBean>

        <% for (int i = 0; i < poll.getQuestions().size(); i++) {
            String yesOrNo = request.getParameter("question" + i);

          if (poll.logIPAddress(request.getRemoteAddr())) {
            if (yesOrNo.equals("Yes"))
                poll.increaseYesCount((String)(poll.getQuestions().get(i)));
            else if (yesOrNo.equals("No"))
                poll.increaseNoCount((String)(poll.getQuestions().get(i)));
          }
        }%>

        <table>
        <% for (int i = 0; i < poll.getQuestions().size(); i++) { %>
        <tr>
            <td>
                <%= poll.getQuestions().get(i) %>
            </td>
            <td>
                (<%= poll.getYesCount((String)(poll.getQuestions().get(i))) %> Yes)
            </td>
            <td>
                (<%= poll.getNoCount((String)(poll.getQuestions().get(i))) %> No)
            </td>
            </tr>
        <%}%>
        </table>

               <jsp:forward page = "Exercise38_2.jsp" />
    </body>
</html>
