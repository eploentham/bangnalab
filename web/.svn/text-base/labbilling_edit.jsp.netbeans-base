<%-- 
    Document   : labbilling_edit
    Created on : Mar 7, 2011, 4:31:02 PM
    Author     : root
--%>
<%@page import="bangnaLibrary.ComboDB"%>
<%@page import="bangnalab.LabBillingDB"%>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
LabBillingDB ltbdb = new LabBillingDB();
ComboDB combodb = new ComboDB();
String ltbId = "", flagpage="",paidNamet="", text="",branchId="", cbo_branch="", cbo_year="", cbo_month="", cbo_period="";
if(request.getParameter("ltb_id")!=null) {
    ltbId = request.getParameter("ltb_id");
}
if(request.getParameter("flagpage")!=null) {
    flagpage = request.getParameter("flagpage");
}
if(request.getParameter("paid_namet")!=null) {
    paidNamet = new String(request.getParameter("paid_namet").getBytes("ISO8859_1"),"TIS-620");
}
if(request.getParameter("branch_id")!=null) {
    branchId = request.getParameter("branch_id");
}
ltbdb.ltb = ltbdb.getLabTBillingByPK(branchId, ltbId, "");
cbo_year=combodb.getComboYear(ltbdb.ltb.getYearId());
cbo_month=combodb.getComboMonth(ltbdb.ltb.getMothId());
cbo_period=combodb.getComboPeriod(ltbdb.ltb.getPeriodId());
cbo_branch = combodb.getComboBranch(branchId);
text = ltbdb.getTrLabBillingItemPaidNamet(branchId, ltbId, paidNamet);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=TIS-620">
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
                    //setdivold();
                    //$("#chk_old").change(setdivold);
                    hideLoader();
                    $("#dialogVoid").hide();
                    $("#dialogSave").hide();
                    $("#anchor_save").click(showDialogNew);
                    //showSearch();
                    $("#tab2").css("background-image","url('../images/tabright_click.gif')");
                    $("#tab22").html("<font color='red'><b>"+$("#tab22").html()+"</b></font>");
                    //hideLoader();
                    //alert("aaaa");
                    //$("#txt_date_end").datepicker({ dateFormat: 'dd-mm-yy' });
                    });
    function showLoader() {
        $("#loading").show();
    }
    function hideLoader() {
        $("#loading").hide();
    }
function showDialogNew(){
$("#dialogSave").dialog("destroy");
$("#dialogSave").dialog({
        bgiframe: true,
        modal: true,
        width: 400 ,
        height: 250,
        buttons: {
                Ok: function() {
                        saveLab();
                        $(this).dialog('close');
                },
                Cancel: function() {
                        $(this).dialog('close');
                }
        }
    });
}
function saveLab(){
    showLoader();
    $("#divView").load("labbilling_f_save.jsp",
        {branch_id : $("#cbo_branch").val(),flagpage : "save_lab", year_id : $("#cbo_year :selected").val(),
        month_id : $("#cbo_month :selected").val(), period_id : $("#cbo_period :selected").val(),
        description : $("#txt_description").val(), remark : $("#txt_remark").val(), ltb_id : $("#txt_ltb_id").val()},
        function() {hideLoader();});
}
function setItemNumber(row){
    //alert("aaaa "+row);
    var r=confirm("ต้องการแก้ไขค่า รหัส lab "+$("#txt_item_number"+row).val()+"\n");
    if(r==true){
    //    showLoader();
        $("#divSave").load("labbilling_f_save.jsp",
        {branch_id : $("#cbo_branch").val(), ltb_i_id : $("#txt_ltb_i_id"+row).val(),
            item_number : $("#txt_item_number"+row).val(), flagpage : "item_number"}, function() {hideLoader();});
    }
}
function setItemName(row){
    //alert("bbb "+row);
    var r=confirm("ต้องการแก้ไขค่า ชื่อรายการ lab "+$("#txt_item_name"+row).val()+"\n");
    if(r==true){
    //    showLoader();
        $("#divSave").load("labbilling_f_save.jsp",
        {branch_id : $("#cbo_branch").val(), ltb_i_id : $("#txt_ltb_i_id"+row).val(),
            item_common_name : $("#txt_item_name"+row).val(), flagpage : "item_common_name"}, function() {hideLoader();});
    }
}
function setPriceNet(row){
    //alert("ccc "+row);
    var r=confirm("ต้องการแก้ไขค่า ราคา lab "+$("#txt_price_net"+row).val()+"\n");
    if(r==true){
    //    showLoader();
        $("#divSave").load("labbilling_f_save.jsp",
        {branch_id : $("#cbo_branch").val(), ltb_i_id : $("#txt_ltb_i_id"+row).val(),
            price_net : $("#txt_price_net"+row).val(), flagpage : "price_net"}, function() {hideLoader();});
    }
}
        </script>
    </head>
    <body>
        <table border="0" width="100%" align="center">
                <tbody>
                    <tr>
                        <th >สาขา</th>
                        <td><select disabled name="cbo_branch" id="cbo_branch"><%out.print(cbo_branch); %></select>
                            <label>&nbsp;ปี&nbsp;<select disabled name="cbo_year" id="cbo_year" >
                                <%out.print(cbo_year); %>
                </select></label>
                <label>&nbsp;เดือน&nbsp;<select disabled name="cbo_month" id="cbo_month" ><%out.print(cbo_month); %></select></label>
                <label>&nbsp;งวด&nbsp;<select disabled name="cbo_period" id="cbo_period" ><%out.print(cbo_period); %></select></label>

                        </td>
                        <td><div id="loading">  <img src="images/ajax-loader1.gif" name="loader" id="loader" alt=""></div></td>
                    </tr>
                </tbody>
            </table>
        <% out.print(text); %>
        <div id="divSave"></div>
    </body>
</html>
