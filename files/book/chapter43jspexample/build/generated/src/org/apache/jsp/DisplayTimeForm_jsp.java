package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import chapter43.TimeBean;

public final class DisplayTimeForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!-- DisplayTimeForm.jsp -->\n");
      out.write("\n");
      chapter43.TimeBean timeBeanId = null;
      synchronized (application) {
        timeBeanId = (chapter43.TimeBean) _jspx_page_context.getAttribute("timeBeanId", PageContext.APPLICATION_SCOPE);
        if (timeBeanId == null){
          timeBeanId = new chapter43.TimeBean();
          _jspx_page_context.setAttribute("timeBeanId", timeBeanId, PageContext.APPLICATION_SCOPE);
          out.write('\n');
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <title>\n");
      out.write("      Display Time Form\n");
      out.write("    </title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("  <h3>Choose locale and time zone</h3>\n");
      out.write("  <form method = \"post\" action = \"DisplayTime.jsp\">\n");
      out.write("    Locale <select size = \"1\" name = \"localeIndex\">\n");
      out.write("    ");
 for (int i = 0; i < timeBeanId.getAllLocale().length; i++) {
      out.write("\n");
      out.write("\t      <option value = \"");
      out.print( i );
      out.write("\"> \n");
      out.write("\t        ");
      out.print( timeBeanId.getAllLocale()[i] );
      out.write("\n");
      out.write("           </option>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("\t      </select><br />\n");
      out.write("    Time Zone <select size = \"1\" name = \"timeZoneIndex\">\n");
      out.write("    ");
 for (int i = 0; i < timeBeanId.getAllTimeZone().length; i++) {
      out.write("\n");
      out.write("\t      <option value = \"");
      out.print( i );
      out.write("\"> \n");
      out.write("\t        ");
      out.print( timeBeanId.getAllTimeZone()[i] );
      out.write("\n");
      out.write("              </option>\n");
      out.write("\t   ");
}
      out.write("\n");
      out.write("\t   </select><br />\n");
      out.write("    <input type = \"submit\" name = \"Submit\" \n");
      out.write("      value = \"Get Time\" />\n");
      out.write("    <input type = \"reset\" value = \"Reset\" />\n");
      out.write("    </form>\n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
