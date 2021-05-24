package chapter37; 

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ImageContent extends HttpServlet {
  /** Process the HTTP Get request */
  public void doGet(HttpServletRequest request, HttpServletResponse
      response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String country = request.getParameter("country");

    out.println("<img src = \"/liangweb/images/" + country + ".gif" 
      + "\" align=left>");

    // Read description from a file and send it to the browser
    java.util.Scanner in = new java.util.Scanner(
      new File("c:\\book\\" + country + ".txt"));

    // Read a line from the text file and send it to the browser
    while (in.hasNext()) {
      out.println(in.nextLine());
    }

    out.close();
  }
}
