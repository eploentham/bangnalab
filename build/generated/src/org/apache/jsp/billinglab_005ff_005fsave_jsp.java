package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bangnalab.AdminTBillLabDB;

public final class billinglab_005ff_005fsave_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");

AdminTBillLabDB abldb = new AdminTBillLabDB();
String flagpage="", branch_id="", abl_id="",description="",remark="",year_id="",month_id="",period_id="",txt="";
if(request.getParameter("flagpage")!=null) {
    flagpage = request.getParameter("flagpage");
}
if(request.getParameter("branch_id")!=null) {
    branch_id = request.getParameter("branch_id");
}
if(request.getParameter("abl_id")!=null) {
    abl_id = request.getParameter("abl_id");
}
if(request.getParameter("description")!=null) {
    description = request.getParameter("description");
}
if(request.getParameter("remark")!=null) {
    remark = request.getParameter("remark");
}
if(request.getParameter("year_id")!=null) {
    year_id = request.getParameter("year_id");
}
if(request.getParameter("month_id")!=null) {
    month_id = request.getParameter("month_id");
}
if(request.getParameter("period_id")!=null) {
    period_id = request.getParameter("period_id");
}
if(flagpage.equals("save_billinglab")){
    abldb.setSaveBillingDetailFromText2(abl_id);
    //txt = abldb.getTRBillLabDetail(abl_id,"", "date");
    //response.sendRedirect("billinglab_add.jsp?abl_id="+abl_id);
}else if(flagpage.equals("save_billinglab_old")){
    abldb.setUpateAdminTBillingLab(branch_id, abl_id, year_id, month_id, period_id, description, remark);
}else if(flagpage.equals("void_billing_lab")){
    abldb.setUpdateBillLabVoid(abl_id);
}else if(flagpage.equals("audit_billing_lab")){
    abldb.setBillLabAuditAllBillId(branch_id, abl_id);
}else if(flagpage.equals("approve_billing_lab")){
    abldb.setBillLabApproveAllBillId(abl_id);
}
out.print(txt);

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
