<%-- 
    Document   : admin_bill_lab_save
    Created on : 23 ¡.¤. 2552, 0:02:24
    Author     : pop
--%>
<%@page import="bangnalab.AdminTBillLab"%>
<%@page import="bangnalab.AdminTBillLabDB"%>
<%@page import="bangnalab.AdminTBillLabDetail"%>
<%@page import="bangnaLibrary.Config1"%>
<%@page import ="java.net.InetAddress;" %>
<%@page import ="java.sql.*" %>
<%@page import ="javax.swing.JOptionPane;" %>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
//Config1 config1 = new Config1();
//AdminTBillLabDetail abl_d = new AdminTBillLabDetail();
AdminTBillLabDB abldb = new AdminTBillLabDB();
//AdminTBillLab abl = new AdminTBillLab();

String flag="",branch_id="";
String bill_lab_id="", bill_lab_date="", date_bill_receive="", date_bill_make="", bill_lab_description="";
String bill_lab_remark="", bill_lab_period="", bill_lab_month="", bill_lab_year="";
String total_record_approve="", total_amount_receive="", total_amount_approve="", total_record_receive="";

if(request.getParameter("flag")!=null){
    flag = new String (request.getParameter("flag").getBytes("ISO8859_1"),"TIS-620");
}
else{
    flag = "";
    }
if(request.getParameter("txt_bill_lab_id")!=null){
    bill_lab_id = new String (request.getParameter("txt_bill_lab_id").getBytes("ISO8859_1"),"TIS-620");
}
else{
    bill_lab_id = "";
}
abldb.abl.setBillLabId(bill_lab_id);
if(request.getParameter("txt_bill_lab_date")!=null){
    bill_lab_date = new String (request.getParameter("txt_bill_lab_date").getBytes("ISO8859_1"),"TIS-620");
}
else{
    bill_lab_date = "";
}
abldb.abl.setBillLabDate(bill_lab_date);
if(request.getParameter("txt_date_bill_receive")!=null){
    date_bill_receive = new String (request.getParameter("txt_date_bill_receive").getBytes("ISO8859_1"),"TIS-620");
}
else{
    date_bill_receive = "";
}
abldb.abl.setDateBillReceive(date_bill_receive);
if(request.getParameter("txt_date_bill_make")!=null){
    date_bill_make = new String (request.getParameter("txt_date_bill_make").getBytes("ISO8859_1"),"TIS-620");
}else{
    date_bill_make = "";
}
abldb.abl.setDateBillMake(date_bill_make);
if(request.getParameter("txt_bill_lab_description")!=null){
    bill_lab_description = new String (request.getParameter("txt_bill_lab_description").getBytes("ISO8859_1"),"TIS-620");
}else{
    bill_lab_description = "";
}
abldb.abl.setBillLabDescription(bill_lab_description);
if(request.getParameter("txt_bill_lab_remark")!=null){
    bill_lab_remark = new String (request.getParameter("txt_bill_lab_remark").getBytes("ISO8859_1"),"TIS-620");
}else{
    bill_lab_remark = "";
}
abldb.abl.setBillLabRemark(bill_lab_remark);
if(request.getParameter("cbo_bill_lab_period")!=null){
    bill_lab_period = new String (request.getParameter("cbo_bill_lab_period").getBytes("ISO8859_1"),"TIS-620");
}else{
    bill_lab_period = "";
}
abldb.abl.setBillLabPeriod(bill_lab_period);
if(request.getParameter("cbo_bill_lab_month")!=null){
    bill_lab_month = new String (request.getParameter("cbo_bill_lab_month").getBytes("ISO8859_1"),"TIS-620");
}else{
    bill_lab_month = "";
}
abldb.abl.setBillLabMonth(bill_lab_month);
if(request.getParameter("cbo_bill_lab_year")!=null){
    bill_lab_year = new String (request.getParameter("cbo_bill_lab_year").getBytes("ISO8859_1"),"TIS-620");
}else{
    bill_lab_year = "";
}
abldb.abl.setBillLabYear(bill_lab_year);
if(request.getParameter("cbo_branch")!=null){
    branch_id = new String (request.getParameter("cbo_branch").getBytes("ISO8859_1"),"TIS-620");
}else{
        branch_id = "";
        }
abldb.abl.setBranchId(branch_id);
if(bill_lab_description.equals("")){
    bill_lab_description="-";
}
if(request.getParameter("txt_total_record_receive")!=null){
    total_record_receive = new String (request.getParameter("txt_total_record_receive").getBytes("ISO8859_1"),"TIS-620");
}
if(request.getParameter("txt_total_record_approve")!=null){
    total_record_approve = new String (request.getParameter("txt_total_record_approve").getBytes("ISO8859_1"),"TIS-620");
}
if(request.getParameter("txt_total_amount_receive")!=null){
    total_amount_receive = new String (request.getParameter("txt_total_amount_receive").getBytes("ISO8859_1"),"TIS-620");
}
if(request.getParameter("txt_total_amount_approve")!=null){
    total_amount_approve = new String (request.getParameter("txt_total_amount_approve").getBytes("ISO8859_1"),"TIS-620");
}
if(total_amount_approve.equals("")){
    total_amount_approve = "0.0";
}
if(total_amount_receive.equals("")){
    total_amount_receive = "0.0";
}
if(total_record_approve.equals("")){
    total_record_approve = "0.0";
}
if(total_record_receive.equals("")){
    total_record_receive = "0.0";
}
bill_lab_date = abldb.config1.DateFormatShow2DB(bill_lab_date, "ddMMyyyy");
date_bill_receive = abldb.config1.DateFormatShow2DB(date_bill_receive, "ddMMyyyy");
date_bill_make = abldb.config1.DateFormatShow2DB(date_bill_make, "ddMMyyyy");
abldb.abl.setTotalRecordReceive(Integer.parseInt(total_record_receive));
abldb.abl.setTotalRecordApprove(Integer.parseInt(total_record_approve));
abldb.abl.setTotalAmountReceive(Double.parseDouble(total_amount_receive));
abldb.abl.setTotalAmountApprove(Double.parseDouble(total_amount_approve));
if(flag.equals("cancel")){
    abldb.abl.setBillLabActive("3");
}else{
    abldb.abl.setBillLabActive("1");
}
String chk = abldb.SaveBillLab(abldb.abl, "");
if(!chk.equals("")){
    response.sendRedirect("billinglab_add.jsp?bill_lab_id="+chk);
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=TIS-620">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
