<%-- 
    Document   : admin_bill_lab_
    Created on : 26 ก.ค. 2552, 22:08:53
    Author     : pop
--%>

<%@page import="bangnalab.AdminTBillLab"%>
<%@page import="bangnalab.AdminTBillLabDB"%>
<%@page import="bangnalab.AdminTBillLabDetail"%>
<%@page import="bangnaLibrary.Config1"%>
<%@page import ="java.sql.*" %>
<%@page import ="java.text.*" %>
<%@page import ="java.util.* " %>
<%@page import ="javax.swing.JOptionPane;" %>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
AdminTBillLabDB abldb = new AdminTBillLabDB();
String date_order="",txt="", hn_no="",url="",tr_bill_lab_detail="";
if(request.getParameter("date_order")!=null){
        date_order = new String (request.getParameter("date_order").getBytes("ISO8859_1"),"TIS-620");
}else{
    date_order = "";
}
if(request.getParameter("hn_no")!=null){
    hn_no = new String (request.getParameter("hn_no").getBytes("ISO8859_1"),"TIS-620");
}else{
    hn_no = "";
}
date_order = date_order.substring(0, 4)+"-"+date_order.substring(4, 6)+"-"+date_order.substring(6, 8);
tr_bill_lab_detail = abldb.getBillLabMainHIS("103001",date_order, hn_no,"");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=TIS-620">
        <link href="css/css.css" rel="stylesheet" type="text/css">
        <SCRIPT LANGUAGE="JavaScript" SRC="js/date.js"></SCRIPT>
    </head>
    <body>
        <table border="0" width="100%" align="center">
            <thead>
        <tr align="center" class='style14r'>
            <th width="3" align="center">ลำดับ</th>
            <th width="200">ชื่อแพทย์ผู้ตรวจ</th>
            <th width="8">สถานะ</th>
            <th width="100">ชื่อ-นามสกุลผู้ป่วย</th>
            <th width="25">รหัส LAB</th>
            <th width="80">รายการ LAB</th>
            <th width="50">code</th>
            <th width="50">ราคา</th>
    </tr></thead>
    <tbody>
        <%out.print(tr_bill_lab_detail); %>
                </tbody>
            </table>
    </body>
</html>
