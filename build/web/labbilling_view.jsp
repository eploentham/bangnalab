<%-- 
    Document   : labbilling_view
    Created on : Feb 7, 2011, 3:50:29 PM
    Author     : root
--%>

<%@page import="bangnaLibrary.ComboDB"%>
<%@page import="bangnaLibrary.Config1"%>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
String cbo_branch="",cbo_year="",cbo_month="",date_startdb="",date_enddb="",text="",cbo_period="",flagpage="";
String branch_id="";
Config1 config1 = new Config1();
ComboDB combodb = new ComboDB();
if(request.getParameter("flagpage")!=null) {
    flagpage = new String (request.getParameter("flagpage").getBytes("ISO8859_1"),"TIS-620");
}
//BackTPatientVisit patient_visit = new BackTPatientVisit();
//BackTPatientImport patient_import = new BackTPatientImport();
//BackTPatientVisitDB patient_visitdb = new BackTPatientVisitDB();

cbo_branch = combodb.getComboBranch(branch_id);
//cbo_month=config1.getComboMonth(foods_order.getDateStart());
cbo_year=combodb.getComboYearHospital("");
cbo_month=combodb.getComboMonth("");
//if(sub_system.equals("") || sub_system.equals("null")){
//    sub_system = (String)session.getAttribute("sub_sustem.sub_system");
//}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=TIS-620">
        <title>DataTables example</title>
		<style type="text/css" title="currentStyle">
                        @import "css/tab.css";
                        @import "css/demo_table.css";
                        @import "css/jquery-ui-1.7.2.custom.css";
                        @import "css/jquery.treeTable.css";
		</style>
                <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
                <script type="text/javascript" src="js/ui.core.js"></script>
                <script type="text/javascript" src="js/ui.dialog.js"></script>
		<script type="text/javascript" charset="TIS-620">
                $(document).ready(function() {
                    setdivold();
                    $("#chk_old").change(setdivold);
                    $("#anchorPrint").click(showDialogPrint);
                    $("#btn_search").click(showSearch);
                    hideLoader();
                    showSearch();
                    $("#tab1").css("background-image","url('../images/tabright_click.gif')");
                    $("#tab11").html("<font color='red'><b>"+$("#tab11").html()+"</b></font>");
                    //hideLoader();
                    //alert("aaaa");
                    //$("#txt_date_end").datepicker({ dateFormat: 'dd-mm-yy' });
                    });
function showDialogPrint(){
$("#dialogPrint").dialog("destroy");
$("#dialogPrint").dialog({
        bgiframe: true,        modal: true,        width: 400 ,        height: 250,
        buttons: {
            Ok: function() {
                    saveDoc();
                    $(this).dialog('close');
            },
            Cancel: function() {
                    $(this).dialog('close');
            }
        }
    });
}
    function setdivold(){
        //alert("aa");
        if($("#chk_old").attr("checked").toString()=="true"){
            $("#div_old").show();
            $("#txt_flagpage").val("view_status_y");
        }else{
            $("#div_old").hide();
            $("#txt_flagpage").val("view_status_d");
        }
    }
    function showLoader() {
        $("#loading").show();
    }
    function hideLoader() {
        $("#loading").hide();
    }
    function showSearch() {
        //$("#back_import_search.jsp", {year: $("#cbo_year").val(),branch_id: $("#cbo_branch").val()});
        showLoader();
        $("#divView").load("labbilling_f_search.jsp",
        {branch_id : $("#cbo_branch").val(),flagpage : "labbilling_view", year_id : $("#cbo_year :selected").val()},
        function() {hideLoader();});
        //$("#t_back_contact_view").show();
    }
        </script>
    </head>
    <body>
        <title>วางบิล lab</title>
        <form name="labbilling_view" id="labbilling_view" action="labbilling_view.jsp" method="POST">
            <%@include  file="labbilling_header.jsp" %>
            <table width="100%"><tr><td width="260">
                            <label>&nbsp;&nbsp;สาขา :&nbsp;<select name="cbo_branch" id="cbo_branch">
                                <%out.print(cbo_branch); %>
                </select></label></td>
                <td width="100">
                    <label><input type="checkbox" id="chk_old" name="chk_old" value="">ดูข้อมูลเก่า</label>
                </td><td width="300">
                    <div id="div_old"><label>&nbsp;&nbsp;ปี :&nbsp;<select name="cbo_year" id="cbo_year">
                                <%out.print(cbo_year); %>
                </select></label>
                    <!--<label>&nbsp;&nbsp;เดือน :&nbsp;<select name="cbo_month" id="cbo_month">
                                <%//out.print(cbo_month); %>
                </select></label>--></div>
                </td><td>
<input type="button" name="btn_seacrh" id="btn_search" value=" ค้นหา...      " />
<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <A HREF="#" NAME="anchorPrint" ID="anchorPrint"> พิมพ์ข้อมูล&nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle"
      height="16" border="0"></A></label>
<input type="hidden" name="txt_date_start" id="txt_date_start" value="<% out.print(date_startdb);%>" size="4"/>
<input type="hidden" name="txt_date_end" id="txt_date_end" value="<% out.print(date_enddb);%>" size="4"/>
<input type="hidden" name="txt_flagpage" id="txt_flagpage" value="<% out.print(flagpage);%>" size="4"/>
                </td><td><div id="loading">  <img src="images/ajax-loader1.gif" name="loader" id="loader" alt=""/></div>
                </td></tr></table>
                <div id="divView"></div>
                
        </form>
    </body>
</html>
