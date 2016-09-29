<%-- 
    Document   : admin_bill_lab_view
    Created on : 22 ก.ค. 2552, 15:31:33
    Author     : pop
--%>
<%@page import="bangnalab.AdminTBillLab"%>
<%@page import="bangnalab.AdminTBillLabDB"%>
<%@page import ="java.sql.*" %>
<%@page import ="java.util.*" %>
<%@page import ="bangnaLibrary.*" %>
<%@page import ="javax.swing.JOptionPane;" %>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
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
%>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <!--<link rel="shortcut icon" type="image/ico" href="http://www.sprymedia.co.uk/media/images/favicon.ico" />-->
        <title>DataTables example</title>
        <style type="text/css" title="currentStyle">
                @import "css/tab.css";
                @import "css/demo_table.css";
                @import "css/jquery-ui-1.7.2.custom.css";
                @import "css/jquery.treeTable.css";
        </style>
        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="js/ui.core.js"></script>
        <script type="text/javascript" src="js/ui.datepicker.js"></script>
        <script type="text/javascript" src="js/ui.dialog.js"></script>

        <!--<script type="text/javascript" src="js/jquery.treeview.min.js" >
        </script><script type="text/javascript" src="js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
        <script type="text/javascript" src="js/jquery.treeTable.js"></script>
        -->
        <script type="text/javascript" charset="TIS-620">
            $(document).ready(function(){
                $("#btn_search").click(showSearch);
                hideLoader();
                showSearch();
                $("#loading").hide();
                $("#tab1").css("background-image","url('../images/tabright_click.gif')");
                $("#tab11").html("<font color='red'><b>"+$("#tab11").html()+"</b></font>");

            });
function showLoader() {
    $("#loading").show();
}
function hideLoader() {
    $("#loading").hide();
}
function showSearch() {
    //$("#back_import_search.jsp", {year: $("#cbo_year").val(),branch_id: $("#cbo_branch").val()});
    showLoader();
    $("#divView").load("billinglab_f_search.jsp",
    {branch_id : $("#cbo_branch").val(),flagpage : "billinglab_view", year_id : $("#cbo_year :selected").val()},
    function() {hideLoader();});
    //$("#t_back_contact_view").show();
}
        </script>
    </head>
    <body>
        <form name="admin_bill_lab_view" id="admin_bill_lab_view" action="admin_bill_lab_view.jsp" method="POST">
        <%@include  file="billinglab_header.jsp" %>
       <table width="100%"><tr><td>
                            <label>&nbsp;&nbsp;สาขา :&nbsp;<select name="cbo_branch" id="cbo_branch">
                                <%out.print(cbo_branch); %>
                </select></label>
                <label>&nbsp;&nbsp;ปี :&nbsp;<select name="cbo_year" id="cbo_year">
                                <%out.print(cbo_year); %>
                    </select></label>
<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <A HREF="#" onClick="changesubmitprint();" NAME="anchor" ID="anchor"> พิมพ์ข้อมูล&nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle"
      height="16" border="0"></A></label>
                    <input type="button" title="" name="btn_seacrh" id="btn_search"  value="ค้นหา" >
<input type="hidden" name="txt_date_start" id="txt_date_start" value="<% out.print(date_startdb);%>" size="4">
<input type="hidden" name="txt_date_end" id="txt_date_end" value="<% out.print(date_enddb);%>" size="4">
                </td><td><div id="loading"><img src="images/ajax-loader1.gif" name="loader" id="loader" alt=""/></div>
    </td></tr></table>
                    <div id="divView"></div>
                    </form>
    </body>
</html>
