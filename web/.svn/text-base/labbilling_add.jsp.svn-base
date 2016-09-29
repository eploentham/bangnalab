<%-- 
    Document   : labbilling_add
    Created on : Mar 1, 2011, 11:38:19 AM
    Author     : root
--%>

<%@page import="javazoom.upload.UploadFile"%>
<%@page import="java.util.Hashtable"%>
<%@page import="javazoom.upload.MultipartFormDataRequest"%>
<%@page import="bangnalab.LabBillingDB"%>
<%@page import="bangnaLibrary.BBranch"%>
<%@page import="bangnaLibrary.ComboDB"%>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<jsp:useBean id="upBean" scope="page" class="javazoom.upload.UploadBean" >
<jsp:setProperty name="upBean" property="folderstore" value="/var/www/intranet/lab/" />
</jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
LabBillingDB ltbdb = new LabBillingDB();
ComboDB combodb = new ComboDB();
BBranch branch = new BBranch();
String cbo_year="", cbo_branch="",branch_id="", ltb_id="",flagpage="", billing_date="", text="",upload="",text1="";
String cbo_month="",cbo_period="",uploadfile="",todo="",path_file="/var/www/intranet/lab/",save="",description="", remark="";
String year_id="", month_id="", period_id="";
Boolean chk_new = false;

if(branch_id.equals("")){
    branch = ltbdb.config1.getBranchActive();
    branch_id = branch.getBranchId();
}
if(request.getParameter("ltb_id")!=null) {
    ltb_id = request.getParameter("ltb_id");
}
if(request.getParameter("flagpage")!=null) {
    flagpage = request.getParameter("flagpage");
}

ltbdb.ltb = ltbdb.getLabTBillingByPK(branch_id, ltb_id, "");
branch_id = ltbdb.ltb.getBranchId();
if(ltbdb.ltb.getLabBillingId().equals("")){
    billing_date = ltbdb.config1.getDateDBHospital("yyyyMMdd");
    ltbdb.ltb.setLabBillingDate(billing_date);
    //mkcdb.initMktCl(branch_id);
    chk_new = true;
}else if(flagpage.equals("search") || flagpage.equals("view")){
    text = ltbdb.getTrLabBillingGroup2(branch_id, ltb_id);
    chk_new = false;
}
if (MultipartFormDataRequest.isMultipartFormData(request)){
    //MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
    MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request,null,-1,MultipartFormDataRequest.CFUPARSER,"tis-620",true);
    if(request.getParameter("ltb_id")!=null) {
        ltb_id = request.getParameter("ltb_id");
    }
    if(mrequest.getParameter("uploadfile")!=null) {
        uploadfile = mrequest.getParameter("uploadfile");
    }
    if (mrequest != null) todo = mrequest.getParameter("todo");
    if ((todo != null) && (todo.equalsIgnoreCase("upload"))) {
        Hashtable files = mrequest.getFiles();
        if ( (files != null) && (!files.isEmpty())) {
            UploadFile file1 = (UploadFile) files.get("uploadfile");
            ltbdb.setDeleteFile(path_file+file1.getFileName());
            if (file1 != null) text1=" Uploaded file : "+file1.getFileName()+" ("+file1.getFileSize()+" bytes)";
            // Uses the bean n/var/www/intranet/ssn/ow to store specified by jsp:setProperty at the top.
            upBean.store(mrequest, "uploadfile");
            if(mrequest.getParameter("cbo_branch")!=null) {
                branch_id = mrequest.getParameter("cbo_branch");
            }
            if(mrequest.getParameter("txt_description")!=null) {
                description = mrequest.getParameter("txt_description");
            }
            if(mrequest.getParameter("txt_remark")!=null) {
                remark = mrequest.getParameter("txt_remark");
            }
            if(mrequest.getParameter("cbo_year")!=null) {
                year_id = mrequest.getParameter("cbo_year");
            }
            if(mrequest.getParameter("cbo_month")!=null) {
                month_id = mrequest.getParameter("cbo_month");
            }
            if(mrequest.getParameter("cbo_period")!=null) {
                period_id = mrequest.getParameter("cbo_period");
            }
            ltbdb.ltb.setBranchId(branch_id);
            ltbdb.ltb.setCntLab(0.0);
            ltbdb.ltb.setCntNoHn(0.0);
            ltbdb.ltb.setCntNoLabId(0.0);
            ltbdb.ltb.setCntNoPriceSale1(0.0);
            ltbdb.ltb.setCntNoPriceSale2(0.0);
            ltbdb.ltb.setDescription(description);
            ltbdb.ltb.setLabBillingActive("1");
            ltbdb.ltb.setLabBillingDate(billing_date);
            ltbdb.ltb.setLabBillingId("");
            ltbdb.ltb.setMothId(month_id);
            ltbdb.ltb.setPeriodId(period_id);
            ltbdb.ltb.setRemark(remark);
            ltbdb.ltb.setStatusImport("");
            ltbdb.ltb.setSumLab(0.0);
            ltbdb.ltb.setYearId(year_id);
            ltbdb.ltb.setFilename(path_file+file1.getFileName());
            ltb_id = ltbdb.setSaveLabTBilling(ltbdb.ltb);
            
            //save ="<A HREF='#' NAME='anchor_save_lab' ID='anchor_save_lab'> บันทึกข้อมูลผล lab &nbsp;<img src='images/savedrafticon.gif' alt='' width='16' " +
    //"align='middle' height='16' border='0'></A>";
            //file1="<input type='hidden' name='txt_file' id='txt_file' size='50'";
            text = "&nbsp;&nbsp;&nbsp;&nbsp;"+save;
            upload="1";
        }
    }
}
ltbdb.ltb = ltbdb.getLabTBillingByPK(branch_id, ltb_id, "");//ต้องดึงซ้ำ เพราะตอนนำ excel จะเป็นการ save lab_bill ใหม่
cbo_year=combodb.getComboYearHospital(ltbdb.ltb.getYearId());
cbo_month=combodb.getComboMonth(ltbdb.ltb.getMothId());
cbo_period=combodb.getComboPeriod(ltbdb.ltb.getPeriodId());
cbo_branch = combodb.getComboBranch(branch_id);
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
                    //setdivold();
                    //$("#chk_old").change(setdivold);
                    hideLoader();
                    $("#dialogVoid").hide();
                    $("#dialogSave").hide();
                    $("#dialogPrint").hide();
                    $("#loading_text").hide();
                    $("#anchor_save").click(showDialogNew);
                    $("#anchor_save_old").click(showDialogOld);
                    $("#anchor_print").click(showDialogPrint);
                    $("#anchor_void").click(showDialogVoid);
                    $("#report_print").click(changesubmitprint);
                    $("#report_doc").click(printTextFile);
                    $("#rpt_lab_bill_item").change(setVisiblePrint);
                    $("#rpt_lab_bill").change(setVisiblePrint);
                    $("#rpt_lab_bill_text").change(setVisibleDoc);
                    $("#anchor_set").click(setYear);
                    setVisiblePrint();
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
    function setVisiblePrint(){
        $("#report_print").show();
        $("#report_doc").hide();
    }
    function setVisibleDoc(){
        $("#report_print").hide();
        $("#report_doc").show();
    }
    function changesubmitprint(){
        document.forms[0].action = "rpt_report_view.jsp?txt_form="+$("#txt_form").val()
            +"&cbo_branch="+$("#cbo_branch").val()+"&rpt_lab_bill="+$("#rpt_lab_bill").attr("checked")
            +"&year_id="+$("#cbo_year").val()+"&month_id="+$("#cbo_month").val()
            +"&period_id="+$("#cbo_period").val()+"&ltb_id="+$("#txt_ltb_id").val()
            +"&rpt_lab_bill_item="+$("#rpt_lab_bill_item").attr("checked");
        document.forms[0].submit();
    }
function showDialogNew(){
$("#dialogSave").dialog("destroy");
$("#dialogSave").dialog({
        bgiframe: true,        modal: true,        width: 400 ,        height: 250,
        buttons: {
                Ok: function() {
                        saveLab("save_lab");
                        $(this).dialog('close');
                },
                Cancel: function() {
                        $(this).dialog('close');
                }
        }
    });
}
function showDialogOld(){
$("#dialogSave").dialog("destroy");
$("#dialogSave").dialog({
        bgiframe: true,        modal: true,        width: 400 ,        height: 250,
        buttons: {
                Ok: function() {
                        saveLab("save_lab_old");
                        $(this).dialog('close');
                },
                Cancel: function() {
                        $(this).dialog('close');
                }
        }
    });
}
function showDialogVoid(){
$("#dialogVoid").dialog("destroy");
$("#dialogVoid").dialog({
        bgiframe: true,        modal: true,        width: 400 ,        height: 250,
        buttons: {
                Ok: function() {
                        voidLab();
                        $(this).dialog('close');
                },
                Cancel: function() {
                        $(this).dialog('close');
                }
        }
    });
}
function showDialogPrint(){
$("#dialogPrint").dialog("destroy");
$("#dialogPrint").dialog({
        bgiframe: true,        modal: true,        width: 400 ,        height: 350
    });
    $("#loading_text").hide();
}
function saveLab(flag){
    showLoader();
    $("#divView").load("labbilling_f_save.jsp",
        {branch_id : $("#cbo_branch").val(),flagpage : flag, year_id : $("#cbo_year :selected").val(),
        month_id : $("#cbo_month :selected").val(), period_id : $("#cbo_period :selected").val(),
        description : $("#txt_description").val(), remark : $("#txt_remark").val(), ltb_id : $("#txt_ltb_id").val()},
        function() {hideLoader();});
}
function voidLab(){
    showLoader();
    $("#divView").load("labbilling_f_save.jsp",
        {branch_id : $("#cbo_branch").val(),flagpage : "void_lab_bill", ltb_id : $("#txt_ltb_id").val()},
        function() {hideLoader();});
        window.location="labbilling_view.jsp?flagpage=view";
}
function showLabBillingItemEdit(row){
    //alert("aaa");
    var branchId = $("#cbo_branch").val();
    var ltbId = $("#txt_ltb_id").val();
    var paidNamet = $("#txt_paid_namet"+row).val();
    window.open("labbilling_edit.jsp?ltb_id="+ltbId+"&branch_id="+branchId+"&flagpage=edit&paid_namet="+paidNamet,'_blank','width=1000, height=800, left=0,top=0,channelmode=no,status=no,fullscreen=no,menubar=no,resizable=no,scrollbars=yes,location=no,directories=no',true);
}
function printTextFile(){
    $("#loading_text").show();
    $("#divView").load("labbilling_f_save.jsp",
        {branch_id : $("#cbo_branch").val(),flagpage : "text_lab",  ltb_id : $("#txt_ltb_id").val()},
        function() {$("#loading_text").hide(); $("#dialogPrint").hide();});
}
function setYear(){//$("#cbo_contact :selected").val();
    //alert("aaa "+$("#cbo_year :selected").val());
    var des = $("#txt_description").val();
    $("#txt_description").val("ประจำปี "+ $("#cbo_year :selected").text()+ " เดือน "+ $("#cbo_month :selected").text()+ " "+ $("#cbo_period :selected").text());
}
        </script>
    </head>
    <body>
        <form name="labbilling_add" id="labbilling_add" method="post" enctype="multipart/form-data">
            <%@include  file="labbilling_header.jsp" %>
            <table><tr><td>
            <table border="0" width="100%" align="center">
                <tbody>
                    <tr>
                        <th >สาขา</th>
                        <td><select name="cbo_branch" id="cbo_branch" ><%out.print(cbo_branch); %></select>
                            <label>&nbsp;ปี&nbsp;<select name="cbo_year" id="cbo_year" >
                                <%out.print(cbo_year); %>
                </select></label>
                <label>&nbsp;เดือน&nbsp;<select name="cbo_month" id="cbo_month" ><%out.print(cbo_month); %></select></label>
                <label>&nbsp;งวด&nbsp;<select name="cbo_period" id="cbo_period" ><%out.print(cbo_period); %></select></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <A HREF="#" NAME="anchor_set" ID="anchor_set">
                สร้าง&nbsp;<img src="images/navigate_check.gif" alt="" align="button" border="0"></A>&nbsp;&nbsp;&nbsp;
                <% if(!flagpage.equals("new")){ %><A HREF='#' NAME='anchor_save_old' ID='anchor_save_old'> บันทึกข้อมูล &nbsp;<img src='images/savedrafticon.gif' alt='' width='16' align='middle' height='16' border='0'></A><% } %>
                        </td>
                        <td><div id="loading">  <img src="images/ajax-loader1.gif" name="loader" id="loader" alt=""></div></td>
                    </tr>
                    <tr>
                        <th>รายละเอียด</th>
            <td ><input type="text" name="txt_description" id="txt_description" title="afdasfsadf" value="<% out.print(ltbdb.ltb.getDescription());%>" size="40" />
    &nbsp;&nbsp;<label>หมายเหตุ&nbsp;<input type="text" name="txt_remark" id="txt_remark" value="<% out.print(ltbdb.ltb.getRemark());%>" size="30"/></label></td>
    <td><label><A HREF="#" NAME="anchor_print" ID="anchor_print">
        พิมพ์รายงาน&nbsp;เตรียมข้อมูล<img src="images/printer-a.png" alt="" align="top" border="0"></A></label>
        &nbsp;&nbsp;&nbsp;
                        </td>
                    </tr>
                    <tr>
                        <th>จำนวน</th>
                        <td colspan="2" ><input type="text" name="txt_cnt_cnt_lab" id="txt_cnt_cnt_lab" value="<% out.print(ltbdb.config1.IntegerFormat(ltbdb.ltb.getCntLab()));%>" size="10" disabled />
                        <label>มูลค่า
                            <input type="text" name="txt_sum_lab" id="txt_sum_lab" value="<%out.print(ltbdb.config1.NumberFormat(ltbdb.ltb.getSumLab()));%>" size="10" disabled/></label>
&nbsp;&nbsp;&nbsp;<label>&nbsp;วันทำข้อมูล
                            <input type="text" size="8" name="txt_lab_billing_date" id="txt_lab_billing_date" value="<% out.print(ltbdb.config1.DateFormatDB2Show(ltbdb.ltb.getLabBillingDate(),"ddMMyyyy"));%>" readonly /></label>
    <label>เลขที่นำเข้า<input type="text" size="10" name="txt_ltb_id" id="txt_ltb_id" value="<% out.print(ltbdb.ltb.getLabBillingId());%>" readonly /></label>
                        &nbsp;&nbsp;&nbsp;
            <A HREF="#" NAME="anchor_void" ID="anchor_void">
                ยกเลิกรายการนี้&nbsp;<img src="images/trash1.gif" alt="" align="top" border="0"></A></td>
                    </tr>
                    <% if((flagpage.equals("new"))) { %>
                    <tr>
                        <th>นำเข้าข้อมูล</th>
                        <td><input type="file" name="uploadfile" id="uploadfile" size="45" value="<%out.print(uploadfile);%>">&nbsp;&nbsp;<% out.print(text1); %>
                            </td>
                        <td ><input type="submit" name="submit" id="submit" value="Upload"> <input type="hidden" name="todo" id="todo" value="upload">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <% if(upload.equals("1")) { %>
            <A HREF='#' NAME='anchor_save' ID='anchor_save'> บันทึกข้อมูล &nbsp;<img src='images/savedrafticon.gif' alt='' width='16' align='middle' height='16' border='0'></A><% } %>
                            </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
                    </td> </tr><tr><td><% out.print(text); %></td> </tr> </table>
                
<div id="dialogVoid" title="ยกเลิกรายการ">
    <table widht="100%"><tr><th colspan="2" >ต้องการยกเลิกรายการนี้</th></tr>
        <tr>
            <th class="style14b">เลขที่นำเข้า</th><td><%out.print(ltbdb.ltb.getLabBillingId()); %></td>
      </tr>
    </table>

</div>
<div id="dialogSave" title="บันทึกรายการ">
    <table widht="100%"><tr><th colspan="2" >ต้องการบันทึก</th></tr>
        <tr>
            <th class="style14b">เลขที่นำเข้า</th><td><%out.print(ltbdb.ltb.getLabBillingId()); %></td>
      </tr>
    </table>
</div>
      <div id="divView" ></div>
        <div id="dialogPrint">
            <table><tr><th scope="row" ><div align="left">รายงาน :</div></th></tr>
        <tr><td class="style14b"><div align="left">
          <label><input type="radio" name="txt_report_name" value="lab_bill" id="rpt_lab_bill"  >001 (ใบวางบิล lab)</label>
          <br><label><input type="radio" name="txt_report_name" value="lab_bill_item" id="rpt_lab_bill_item" >002 (รายละเอียด ใบวางบิลตามประเภท lab)</label>
          <br><label><input type="radio" name="txt_report_name" value="lab_bill_text" id="rpt_lab_bill_text" >003 (gen text file วางบิล lab)</label>
          <br><br><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <A HREF="#" NAME="report_print" ID="report_print"> พิมพ์ข้อมูล &nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle"
      height="16" border="0"></A></label>
          <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <A HREF="#" NAME="report_doc" ID="report_doc"> เตรียมข้อมูล&nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle"
      height="16" border="0"></A></label>
          </div>
<input type="hidden" name="txt_flag" id="txt_flag">
        <input type="hidden" name="txt_form" id="txt_form" value="daily">
        </td>
      </tr>
      <tr><td><div id="loading_text">  <img src="images/ajax-loader1.gif" name="loader" id="loader" alt=""></div></td> </tr> </table>
        </div>
        </form>
    </body>
</html>
