/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-11-10 18:02:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Checkout</title>\n");
      out.write("<link\n");
      out.write("\thref=\"//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\"\n");
      out.write("\trel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("<script\n");
      out.write("\tsrc=\"//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\n");
      out.write("<link\n");
      out.write("\thref=\"//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css\"\n");
      out.write("\trel=\"stylesheet\">\n");
      out.write("<link href=\"cart.css\" rel=\"stylesheet\">\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Lobster\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<style>\n");
      out.write("  .subhead-text{\n");
      out.write("    color: dodgerblue;\n");
      out.write("    font-family: Lobster;\n");
      out.write("    font-size: 80px;}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("   <link rel=\"stylesheet\" href=\"CSS/style.css\">\n");
      out.write("<style>\n");
      out.write("    .navbar {\n");
      out.write("      margin-bottom: 50px;\n");
      out.write("      border-radius: 0;\n");
      out.write("    }\n");
      out.write("     .jumbotron {\n");
      out.write("      margin-bottom: 0;\n");
      out.write("    }\n");
      out.write("    footer {\n");
      out.write("      background-color: #f2f2f2;\n");
      out.write("      padding: 25px;\n");
      out.write("    }\n");
      out.write("    .deco{\n");
      out.write("    text-align: center;\n");
      out.write("    font-family: Lobster;\n");
      out.write("\t}\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<script src='https://cdn.rawgit.com/Siddharth11/gradStop.js/master/gradstop.js'></script>\n");
      out.write("    <script  src=\"CSS/index.js\"></script>\n");
      out.write("<div class=\"background\">\n");
      out.write(" \n");
      out.write("\n");
      out.write("<div class=\"jumbotron\">\n");
      out.write("  <div class=\"container text-center\">\n");
      out.write("    <div class=\"subhead-text\">Order Confirmed!</div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-inverse\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>                        \n");
      out.write("      </button>\n");
      out.write("    \n");
      out.write("    </div>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("      \t<li><a href=\"logout.jsp\"><h4><span class=\"glyphicon glyphicon-user\"></span> Log Out</h4></a></li> \n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t<p> <h3 class=\"deco\">Great! Your order with order_id ");
      out.print(session.getAttribute("order_id_key"));
      out.write(" has been confirmed. <br>\n");
      out.write("\t\tIt will reach you within 30 minutes! <br>\n");
      out.write("\t\tKeep ");
      out.print(session.getAttribute("total_bill"));
      out.write("$ ready. <br>\n");
      out.write("\t\tThank you for ordering with us! <br></h3>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
