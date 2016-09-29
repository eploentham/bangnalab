package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bangnalab.AdminTBillLab;
import bangnalab.AdminTBillLabDB;
import java.sql.*;
import java.util.*;
import bangnaLibrary.*;
import javax.swing.JOptionPane;;

public final class billinglab_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/billinglab_header.jsp");
  }

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");

//Config1 config1 = new Config1();
AdminTBillLabDB abldb = new AdminTBillLabDB();
AdminTBillLab bill_lab = new AdminTBillLab();
ComboDB combodb = new ComboDB();
BBranch branch = new BBranch();
String text="",date_startdb="",date_enddb="",cbo_branch="",cbo_year="",year_id="",branch_id="",date_start="",date_end="",day="";
try{
    //Connection connbangna = config1.getConnectionBangna();
    //Connection connmainhis = config1.getConnectionMainHIS();
    //Statement stbangna = connbangna.createStatement();
    String sql="", year="", attend_department_namet="", attend_remark="", attend_user_id="";
    String attend_time="";
    String ma_date="", ma_user_id="", ma_description="", attend_description="";
    String noti_repair_id="", status="", row_color="",flagunactive="", txtflagunactive="", txt_color="";
    String txt_color1="</font>";
    Integer row=0;
    if(request.getParameter("cbo_branch")!=null) {
        branch_id = new String (request.getParameter("cbo_branch").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_year")!=null) {
        year_id = new String (request.getParameter("cbo_year").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_date_start")!=null) {
        date_start = new String (request.getParameter("txt_date_start").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_date_end")!=null) {
        date_end = new String (request.getParameter("txt_date_end").getBytes("ISO8859_1"),"TIS-620");
    }
    if(branch_id.equals("")){
        branch = abldb.config1.getBranchActive();
        branch_id = branch.getBranchId();
    }
    cbo_branch = combodb.getComboBranch(branch_id);
    cbo_year = combodb.getComboYearHospital(year_id);
    day=abldb.config1.getMonthEndDay(year_id, "12");
    date_startdb = year_id+"-"+"01"+"-01";
    date_enddb = year_id+"-"+"12"+"-"+day;
    if(request.getParameter("flagunactive")!=null){
        flagunactive = new String (request.getParameter("flagunactive").getBytes("ISO8859_1"),"TIS-620");
    }
    if(!year_id.equals("")){
        year = year_id;
    }else {
        year = abldb.config1.getDateDBHospital("yyyy");
    }
    //if(Integer.parseInt(year)>2500){
    //    year = String.valueOf(Integer.parseInt(year)-543);
    //}
    //Vector v_bill_lab = abldb.getBillLab(branch_id,year,"year");
    //for(Integer i=0;i<=v_bill_lab.size()-1;i++){
    //    bill_lab = (AdminTBillLab)v_bill_lab.get(i);
    //    row++;
        
    //    text+="<tr class='style14r' "+row_color+"> <td align='center' width='30'>"+row.toString()+"</td>"
    //        +"<td width='150'><div align='left'><A HREF='billinglab_add.jsp?abl_id="+bill_lab.getBillLabId()
    //        +"&flagpage=viewdetail' name='admin_bill_lab_add' id='admin_bill_lab_add'> "+txt_color+bill_lab.getBillLabDescription()+txt_color1+"</a></div></td>"
    //        +"<td width='150'>"+txt_color+bill_lab.getBillLabYear()+" "+abldb.config1.getMonthNamet(bill_lab.getBillLabMonth(),"id_name")+" "+abldb.config1.getPeriodNamet(bill_lab.getBillLabPeriod(),"id_name")+txt_color1+"</td>"
    //        +"<td width='150'>"+txt_color+bill_lab.getBillLabRemark()+txt_color1+"</td>"
    //        +"<td width='50'>"+txt_color+bill_lab.getTotalRecordReceive()+txt_color1+"</td>"
    //        +"<td width='50'>"+txt_color+bill_lab.getTotalAmountReceive()+txt_color1+"</td>"
    //        +"</tr>";
    //}
    //if(text.equals("")){
     //   text="<tr class='style14r' "+row_color+"> <td align='center'>1</td><td>ไม่พบข้อมูล</td><td></td><td></td></tr>";
     //   }
}catch(Exception ex){
    //JOptionPane.showMessageDialog(null, ex.getMessage());
    text = ex.getMessage();
}

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <!--<link rel=\"shortcut icon\" type=\"image/ico\" href=\"http://www.sprymedia.co.uk/media/images/favicon.ico\" />-->\n");
      out.write("        <title>DataTables example</title>\n");
      out.write("        <style type=\"text/css\" title=\"currentStyle\">\n");
      out.write("                @import \"css/tab.css\";\n");
      out.write("                @import \"css/demo_table.css\";\n");
      out.write("                @import \"css/jquery-ui-1.7.2.custom.css\";\n");
      out.write("                @import \"css/jquery.treeTable.css\";\n");
      out.write("        </style>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-1.4.2.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/ui.core.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/ui.datepicker.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/ui.dialog.js\"></script>\n");
      out.write("\n");
      out.write("        <!--<script type=\"text/javascript\" src=\"js/jquery.treeview.min.js\" >\n");
      out.write("        </script><script type=\"text/javascript\" src=\"js/jquery.dataTables.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-ui-1.7.2.custom.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.treeTable.js\"></script>\n");
      out.write("        -->\n");
      out.write("        <script type=\"text/javascript\" charset=\"TIS-620\">\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $(\"#btn_search\").click(showSearch);\n");
      out.write("                hideLoader();\n");
      out.write("                showSearch();\n");
      out.write("                $(\"#loading\").hide();\n");
      out.write("                $(\"#tab1\").css(\"background-image\",\"url('../images/tabright_click.gif')\");\n");
      out.write("                $(\"#tab11\").html(\"<font color='red'><b>\"+$(\"#tab11\").html()+\"</b></font>\");\n");
      out.write("\n");
      out.write("            });\n");
      out.write("function showLoader() {\n");
      out.write("    $(\"#loading\").show();\n");
      out.write("}\n");
      out.write("function hideLoader() {\n");
      out.write("    $(\"#loading\").hide();\n");
      out.write("}\n");
      out.write("function showSearch() {\n");
      out.write("    //$(\"#back_import_search.jsp\", {year: $(\"#cbo_year\").val(),branch_id: $(\"#cbo_branch\").val()});\n");
      out.write("    showLoader();\n");
      out.write("    $(\"#divView\").load(\"billinglab_f_search.jsp\",\n");
      out.write("    {branch_id : $(\"#cbo_branch\").val(),flagpage : \"billinglab_view\", year_id : $(\"#cbo_year :selected\").val()},\n");
      out.write("    function() {hideLoader();});\n");
      out.write("    //$(\"#t_back_contact_view\").show();\n");
      out.write("}\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"admin_bill_lab_view\" id=\"admin_bill_lab_view\" action=\"admin_bill_lab_view.jsp\" method=\"POST\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<div id=\"tabs\">\n");
      out.write("                                <ul>\n");
      out.write("                                        <!-- CSS Tabs -->\n");
      out.write("<li id=\"tab1\"><a id=\"tab11\" href=\"billinglab_view.jsp\"><span>ข้อมูลการรับวางบิล</span></a></li>\n");
      out.write("<li id=\"tab2\"><a id=\"tab22\" href=\"billinglab_add.jsp?flagpage=new\"><span>รับวางบิลใหม่</span></a></li>\n");
      out.write("<!--<li id=\"tab3\"><a id=\"tab33\" href=\"admin_bill_lab_detail_check_view.jsp?date_order=25520714&hn_no=1403072\"><span>ข้อมูลการวางบิลเก่าๆ</span></a></li>-->\n");
      out.write("<!--<li id=\"tab4\"><a id=\"tab44\" href=\"Support.html\"><span>รายงานการวางบิลต่างๆ</span></a></li>-->\n");
      out.write("<!--<li><a href=\"noti_repair_view.jsp?noti_repair_id=&flagpage=viewdetail&flagunactive=1\"><span>UnActive ข้อมูล</span></a></li>-->\n");
      out.write("<!--<li id=\"tab5\"><a id=\"tab55\" href=\"noti_repair_audit.jsp\"><span>ตรวจสอบใบวางบิล</span></a></li>-->\n");
      out.write("<!--<li><a href=\"About.html\"><span>About</span></a></li>-->\n");
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                        </div>\n");
      out.write("<br>");
      out.write("\n");
      out.write("       <table width=\"100%\"><tr><td>\n");
      out.write("                            <label>&nbsp;&nbsp;สาขา :&nbsp;<select name=\"cbo_branch\" id=\"cbo_branch\">\n");
      out.write("                                ");
out.print(cbo_branch); 
      out.write("\n");
      out.write("                </select></label>\n");
      out.write("                <label>&nbsp;&nbsp;ปี :&nbsp;<select name=\"cbo_year\" id=\"cbo_year\">\n");
      out.write("                                ");
out.print(cbo_year); 
      out.write("\n");
      out.write("                    </select></label>\n");
      out.write("<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("        <A HREF=\"#\" onClick=\"changesubmitprint();\" NAME=\"anchor\" ID=\"anchor\"> พิมพ์ข้อมูล&nbsp;<img src=\"images/printer-a.png\" alt=\"\" width=\"16\" align=\"middle\"\n");
      out.write("      height=\"16\" border=\"0\"></A></label>\n");
      out.write("                    <input type=\"button\" title=\"\" name=\"btn_seacrh\" id=\"btn_search\"  value=\"ค้นหา\" >\n");
      out.write("<input type=\"hidden\" name=\"txt_date_start\" id=\"txt_date_start\" value=\"");
 out.print(date_startdb);
      out.write("\" size=\"4\">\n");
      out.write("<input type=\"hidden\" name=\"txt_date_end\" id=\"txt_date_end\" value=\"");
 out.print(date_enddb);
      out.write("\" size=\"4\">\n");
      out.write("                </td><td><div id=\"loading\"><img src=\"images/ajax-loader1.gif\" name=\"loader\" id=\"loader\" alt=\"\"/></div>\n");
      out.write("    </td></tr></table>\n");
      out.write("                    <div id=\"divView\"></div>\n");
      out.write("                    </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
