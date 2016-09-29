<%-- 
    Document   : admin_bill_lab_detail_show
    Created on : 23 ก.ค. 2552, 0:03:40
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
Config1 config1 = new Config1();
AdminTBillLabDetail bill_lab_detail = new AdminTBillLabDetail();
AdminTBillLabDB abldb = new AdminTBillLabDB();
AdminTBillLab bill_lab = new AdminTBillLab();
Vector v_bill_lab = new Vector();
Vector v_bill_lab_detail = new Vector();
String abl_id = "", text="", dateOrder="",tr_bill_lab_detail="",date="",bill_lab_year="";
String bill_lab_month="",bill_lab_period="", bill_lab_desc="", flag="";
try{
    if(request.getParameter("abl_id")!=null){
        abl_id = request.getParameter("abl_id");
    }
    if(request.getParameter("date_order")!=null){
        dateOrder = request.getParameter("date_order");
    }
    if(request.getParameter("bill_lab_year")!=null){
        bill_lab_year = new String (request.getParameter("bill_lab_year").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("bill_lab_month")!=null){
        bill_lab_month = new String (request.getParameter("bill_lab_month").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("bill_lab_period")!=null){
        bill_lab_period = new String (request.getParameter("bill_lab_period").getBytes("ISO8859_1"),"TIS-620");
    }
    //bill_lab_id = bill_lab_id.substring(1, bill_lab_id.length());
    dateOrder = dateOrder.substring(0, 4)+"-"+dateOrder.substring(4, 6)+"-"+dateOrder.substring(6, 8);
    //if(dateOrder.length() >=1){
    //    dateOrder = dateOrder.substring(1);
    //}
    tr_bill_lab_detail = abldb.getTRBillLabDetail(abl_id, dateOrder, "date_day");
    bill_lab_period = config1.getPeriodNamet(bill_lab_period, "id_name");
    bill_lab_month = config1.getMonthNamet(bill_lab_month, "id_name");
    bill_lab_desc = "ประจำงวด "+bill_lab_period+" เดือน "+bill_lab_month+" ปี "+bill_lab_year;
    if(flag.equals("updatepatient")){
        //bill_lab_detaildb.setPatientFullNameT("",bill_lab_id);
        }
}
catch(Exception ex){
    text = ex.getMessage();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

    </head>
    <body><form>

        <fieldset class="style14r">
        <legend>ตรวจสอบข้อมูล:</legend>
        <input type="button" value="ตรวจสอบทั้งหมด" name="btn_check_day_all" >
        <input type="button" value="อนุมัติรายการ" name="btn_update_day_all" >
        <%out.print(bill_lab_desc);%>
        <!--<input type="button" value="ปรับปรุงชื่อ Patient" name="btn_update_patient_fullnamet"
               onclick="changesubmitpatientfullnamet();" >-->
        <input type="button" value="ปรับปรุงชื่อ LAB" name="btn_update_lab_namet" >
      </fieldset>
        <table border="0" width="100%" align="center">
            <thead>
        <tr align="center" class='style14r'>
            <th width="3" align="center">ลำดับ</th>
            <th width="10">อนุมัติ</th>
            <th width="15">HN NO</th>
            <th width="200">ชื่อ-นามสกุลผู้ป่วย</th>
            <th width="25">LAB </th>
            <th width="200">รายการ LAB</th>
            <th width="7">จน</th>
            <th width="7">จนอนุมัติ</th>
            <th width="50">ราคา</th>
            <th width="10">ส่วนลด</th>
            <th width="50">ราคาสุทธิ</th>
            <th width="50">ราคาอนุมัติ</th>
    </tr></thead>
    <tbody>
        <%out.print(tr_bill_lab_detail); %>
                </tbody>
                <input type="hidden" value="<%out.print(bill_lab_year); %>" name="txt_bill_lab_year" id="txt_bill_lab_year"/>
                <input type="hidden" value="<%out.print(bill_lab_month); %>" name="txt_bill_lab_month" id="txt_bill_lab_month"/>
                <input type="hidden" value="<%out.print(bill_lab_period); %>" name="txt_bill_lab_period" id="txt_bill_lab_period"/>
                <input type="hidden" value="<%out.print(abl_id); %>" name="txt_abl_id_id" id="txt_abl_id_id"/>
                <input type="hidden" value="<%out.print(dateOrder); %>" name="txt_date_order" id="txt_date_order"/>
            </table>
            </form>
    </body>
    <script type='text/javascript'>


// On Key Down event handler

// On Key Press event handler
function changedetailshow(date_order, hn_no){
        window.open("admin_bill_lab_detail_check_view.jsp?date_order="+date_order+"&hn_no="
        +hn_no,'_blank','width=750, height=400, left=200,top=100,channelmode=no,status=yes,fullscreen=no,menubar=no,resizable=no,scrollbars=yes,location=no,directories=no',true);
    //return false;
    }
function changesubmitpatientfullnamet() {
            var bill_lab_id = document.getElementById("txt_bill_lab_id").value;
          var bill_lab_year = document.getElementById("txt_bill_lab_year").value;
          var bill_lab_month = document.getElementById("txt_bill_lab_month").value;
          var bill_lab_period = document.getElementById("txt_bill_lab_period").value;
          var date_order = document.getElementById("txt_date_order").value;
            document.forms[0].action = "admin_bill_lab_detail_view.jsp?flag=updatepatientfullnamet&date_order="+date_order
                +"&bill_lab_id="+bill_lab_id+"&bill_lab_year="+bill_lab_year+"&bill_lab_month="+bill_lab_month
                +"&bill_lab_period="+bill_lab_period;
            document.forms[0].submit();
            return false;
      }
</script>

</html>
