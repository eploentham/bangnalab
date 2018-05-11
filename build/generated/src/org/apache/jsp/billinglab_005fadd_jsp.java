package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javazoom.upload.UploadFile;
import javazoom.upload.MultipartFormDataRequest;
import bangnaLibrary.ComboDB;
import bangnalab.AdminTBillLab;
import bangnalab.AdminTBillLabDB;
import bangnaLibrary.Config1;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.JOptionPane;;

public final class billinglab_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      javazoom.upload.UploadBean upBean = null;
      synchronized (_jspx_page_context) {
        upBean = (javazoom.upload.UploadBean) _jspx_page_context.getAttribute("upBean", PageContext.PAGE_SCOPE);
        if (upBean == null){
          upBean = new javazoom.upload.UploadBean();
          _jspx_page_context.setAttribute("upBean", upBean, PageContext.PAGE_SCOPE);
          out.write('\r');
          out.write('\n');
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("upBean"), "folderstore", "/var/www/intranet/billlab/", null, null, false);
          out.write('\r');
          out.write('\n');
        }
      }
      out.write('\r');
      out.write('\n');

Config1 config1 = new Config1();
ComboDB combodb = new ComboDB();
AdminTBillLabDB abldb = new AdminTBillLabDB();
Vector v_abl = new Vector();
String text = "", abl_id="",cbo_year="", cbo_month="", cbo_period="";
String abl_date="", date_bill_receive="", date_bill_make="";
String total_record_approve="", total_amount_receive="", total_amount_approve="", total_record_receive="";
String tr_abl_detail="", flag="",total_amount_unapprove="",total_record_unapprove="";
String branch_id="",cbo_branch="",flagpage="",uploadfile="",text1="",todo="",upload="";
String path_file="/var/www/intranet/billlab/";
//String path_file="c:/lab/";
String btlId="",description="", remark="",year_id="", month_id="", period_id="",save="",billing_date="";
Boolean chk_new = false;
try{
    if(request.getParameter("abl_id")!=null){
        abl_id = request.getParameter("abl_id");
    }
    if(request.getParameter("flagpage")!=null){
        flagpage = request.getParameter("flagpage");
    }
    abldb.abl = abldb.getBillLabByPK(abl_id);
    if(abldb.abl.getBillLabId().equals("")){
        billing_date = abldb.config1.getDateDBHospital("yyyyMMdd");
        abldb.abl.setBillLabDate(billing_date);
        //mkcdb.initMktCl(branch_id);
        chk_new = true;
    }else if(flagpage.equals("search") || flagpage.equals("viewdetail")){
        //text = ltbdb.getTrLabBillingGroup2(branch_id, abl_id);
        chk_new = false;
    }
    //v_bill_lab_detail = bill_lab_detaildb.getBillLabDetail(bill_lab_id,"date");
    
    if(request.getParameter("cbo_branch")!=null) {
        branch_id = request.getParameter("cbo_branch");
    }
    if(branch_id.equals("")){
        branch_id = abldb.abl.getBranchId();
    }
    if(request.getParameter("abl_date")!=null){
        abl_date = request.getParameter("abl_date");
    }
    if(request.getParameter("date_bill_receive")!=null){
        date_bill_receive = request.getParameter("date_bill_receive");
    }
    if(request.getParameter("date_bill_make")!=null){
        date_bill_make = request.getParameter("date_bill_make");
    }
    if(request.getParameter("flag")!=null){
        flag = request.getParameter("flag");
    }
    if(abl_date.equals("")){
        abl_date = config1.getDate("ddMMyyyy");
    }
    if(date_bill_receive.equals("")){
        date_bill_receive = config1.getDate("ddMMyyyy");
    }
    if(date_bill_make.equals("")){
        date_bill_make = config1.getDate("ddMMyyyy");
    }
    
    //total_record_receive = config1.StringFormat(abldb.abl.getTotalRecordReceive().toString(),"integer");
    total_record_approve = config1.StringFormat(abldb.abl.getTotalRecordApprove().toString(),"integer");
    total_record_unapprove = config1.StringFormat(abldb.abl.getTotalRecordUnApprove().toString(),"integer");
    //total_amount_receive = config1.StringFormat(abldb.abl.getTotalAmountReceive().toString(),"integer");
    total_amount_approve = config1.StringFormat(abldb.abl.getTotalAmountApprove().toString(),"integer");
    total_amount_unapprove = config1.StringFormat(abldb.abl.getTotalAmountUnApprove().toString(),"integer");
    if(flag.equals("updatepatient")){
        abldb.setPatientFullNameT(branch_id,abl_id);
        abldb.setLabNameT(branch_id,abl_id);
    }else if(flag.equals("auditbilllabid")){
        abldb.setBillLabAuditAllBillId(branch_id,abl_id);
    }else if(flag.equals("updateapprove")){
        abldb.setBillLabApproveAllBillId(abl_id);
    }
    if (MultipartFormDataRequest.isMultipartFormData(request)){
        //MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
        MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request,null,-1,MultipartFormDataRequest.CFUPARSER,"utf-8",true);
        if(request.getParameter("btlId")!=null) {
            btlId = request.getParameter("btlId");
        }
        if(mrequest.getParameter("uploadfile")!=null) {
            uploadfile = mrequest.getParameter("uploadfile");
        }
        if (mrequest != null) todo = mrequest.getParameter("todo");
        if ((todo != null) && (todo.equalsIgnoreCase("upload"))) {
            Hashtable files = mrequest.getFiles();
            if ( (files != null) && (!files.isEmpty())) {
                UploadFile file1 = (UploadFile) files.get("uploadfile");
                config1.setDeleteFile(path_file+file1.getFileName());
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
                abldb.abl.setBranchId(branch_id);
                abldb.abl.setBillLabDate("");
                abldb.abl.setBillLabDescription(description);
                abldb.abl.setBillLabId("");
                abldb.abl.setBillLabMonth(month_id);
                abldb.abl.setBillLabPeriod(period_id);
                abldb.abl.setBillLabRemark(remark);
                abldb.abl.setBillLabStatus("1");
                abldb.abl.setBillLabYear(year_id);
                abldb.abl.setDateBillMake("");
                abldb.abl.setDateBillReceive("");
                abldb.abl.setTotalAmountApprove(0.0);
                abldb.abl.setTotalAmountReceive(0.0);
                abldb.abl.setTotalAmountUnApprove(0.0);
                abldb.abl.setTotalRecordApprove(0);
                abldb.abl.setTotalRecordReceive(0);
                abldb.abl.setTotalRecordUnApprove(0.0);
                abldb.abl.setBillLabDate(billing_date);
                abldb.abl.setBillLabActive("1");
                //abldb.abl.setBranchId(branchId);
                abldb.abl.setFilename(path_file+file1.getFileName());
                abl_id = abldb.SaveBillLab(abldb.abl, "");

                //save ="<A HREF='#' NAME='anchor_save_lab' ID='anchor_save_lab'> บันทึกข้อมูลผล lab &nbsp;<img src='images/savedrafticon.gif' alt='' width='16' " +
        //"align='middle' height='16' border='0'></A>";
                //file1="<input type='hidden' name='txt_file' id='txt_file' size='50'";
                text = "&nbsp;&nbsp;&nbsp;&nbsp;"+save;
                upload="1";
            }
        }
    }
}catch(Exception ex){
    text = ex.getMessage();
}
abldb.abl = abldb.getBillLabByPK(abl_id);
cbo_branch = combodb.getComboBranch(branch_id);
cbo_month=combodb.getComboMonth(abldb.abl.getBillLabMonth());
cbo_year=combodb.getComboYearHospital(abldb.abl.getBillLabYear());
cbo_period=combodb.getComboPeriod(abldb.abl.getBillLabPeriod());
tr_abl_detail = abldb.getTRBillLabDetail(abl_id,"", "date");
if(abldb.abl.getBillLabDate().equals("")){
    String date = config1.DateFormatShow2DB(config1.getDateDBHospital("ddMMyyyy"),"ddMMyyyy");
    abldb.abl.setBillLabDate(date);
}//bill_lab_detaildb.setBillLabAuditAllBillId(branch_id,bill_lab_id);

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("        \r\n");
      out.write("        <style type=\"text/css\" title=\"currentStyle\">\r\n");
      out.write("                @import \"css/tab.css\";\r\n");
      out.write("                @import \"css/demo_table.css\";\r\n");
      out.write("                @import \"css/jquery-ui-1.7.2.custom.css\";\r\n");
      out.write("                @import \"css/jquery.treeTable.css\";\r\n");
      out.write("        </style>\r\n");
      out.write("       \r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-1.4.2.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/ui.core.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/ui.datepicker.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/ui.dialog.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            $(document).ready(function(){\r\n");
      out.write("                $(\"#dialogVoid\").hide();\r\n");
      out.write("                $(\"#dialogSave\").hide();\r\n");
      out.write("                $(\"#loading_text\").hide();\r\n");
      out.write("                $(\"#dialogAudit\").hide();\r\n");
      out.write("                $(\"#dialogApprove\").hide();\r\n");
      out.write("                //$(\"#dialogVoid\").hide();\r\n");
      out.write("                //$(\"#divView\").hide();\r\n");
      out.write("                $(\"#anchor_save\").click(showDialogNew);\r\n");
      out.write("                $(\"#anchor_void\").click(showDialogVoid);\r\n");
      out.write("                $(\"#anchor_print\").click(showDialogPrint);\r\n");
      out.write("                $(\"#report_print\").click(changesubmitprint);\r\n");
      out.write("                $(\"#anchor_audit\").click(showDialogAudit);\r\n");
      out.write("                $(\"#anchor_approve\").click(showDialogApprove);\r\n");
      out.write("                $(\"#anchor_save_old\").click(showDialogOld);\r\n");
      out.write("                $(\"#dialogPrint\").hide();\r\n");
      out.write("                $(\"#loading\").hide();\r\n");
      out.write("                $(\"#anchor_set\").click(setYear);\r\n");
      out.write("                $(\"#txt_abl_date\").datepicker({ dateFormat: 'dd-mm-yy' });\r\n");
      out.write("                $(\"#txt_date_bill_receive\").datepicker({ dateFormat: 'dd-mm-yy' });\r\n");
      out.write("                $(\"#txt_date_bill_make\").datepicker({ dateFormat: 'dd-mm-yy' });\r\n");
      out.write("                $(\"#tab2\").css(\"background-image\",\"url('../images/tabright_click.gif')\");\r\n");
      out.write("                $(\"#tab22\").html(\"<font color='red'><b>\"+$(\"#tab22\").html()+\"</b></font>\");\r\n");
      out.write("            });\r\n");
      out.write("function showDialogNew(){\r\n");
      out.write("$(\"#dialogSave\").dialog(\"destroy\");\r\n");
      out.write("$(\"#dialogSave\").dialog({\r\n");
      out.write("        bgiframe: true,\r\n");
      out.write("        modal: true,\r\n");
      out.write("        width: 400 ,\r\n");
      out.write("        height: 250,\r\n");
      out.write("        buttons: {\r\n");
      out.write("            Ok: function() {\r\n");
      out.write("                    saveBillingLab(\"save_billinglab\");\r\n");
      out.write("                    $(this).dialog('close');\r\n");
      out.write("            },\r\n");
      out.write("            Cancel: function() {\r\n");
      out.write("                    $(this).dialog('close');\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("function showDialogOld(){\r\n");
      out.write("$(\"#dialogSave\").dialog(\"destroy\");\r\n");
      out.write("$(\"#dialogSave\").dialog({\r\n");
      out.write("        bgiframe: true,        modal: true,        width: 400 ,        height: 250,\r\n");
      out.write("        buttons: {\r\n");
      out.write("                Ok: function() {\r\n");
      out.write("                        saveBillingLab(\"save_billinglab_old\");\r\n");
      out.write("                        $(this).dialog('close');\r\n");
      out.write("                },\r\n");
      out.write("                Cancel: function() {\r\n");
      out.write("                        $(this).dialog('close');\r\n");
      out.write("                }\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("function showDialogAudit(){\r\n");
      out.write("$(\"#dialogAudit\").dialog(\"destroy\");\r\n");
      out.write("$(\"#dialogAudit\").dialog({\r\n");
      out.write("        bgiframe: true,        modal: true,        width: 400 ,        height: 250,\r\n");
      out.write("        buttons: {\r\n");
      out.write("            Ok: function() {\r\n");
      out.write("                    auditBillingLab();\r\n");
      out.write("                    $(this).dialog('close');\r\n");
      out.write("            },\r\n");
      out.write("            Cancel: function() {\r\n");
      out.write("                    $(this).dialog('close');\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("function showDialogApprove(){\r\n");
      out.write("$(\"#dialogApprove\").dialog(\"destroy\");\r\n");
      out.write("$(\"#dialogApprove\").dialog({\r\n");
      out.write("        bgiframe: true,        modal: true,        width: 400 ,        height: 250,\r\n");
      out.write("        buttons: {\r\n");
      out.write("            Ok: function() {\r\n");
      out.write("                    approveBillingLab();\r\n");
      out.write("                    $(this).dialog('close');\r\n");
      out.write("            },\r\n");
      out.write("            Cancel: function() {\r\n");
      out.write("                    $(this).dialog('close');\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("function showDialogPrint(){\r\n");
      out.write("$(\"#dialogPrint\").dialog(\"destroy\");\r\n");
      out.write("$(\"#dialogPrint\").dialog({\r\n");
      out.write("        bgiframe: true,        modal: true,        width: 400 ,        height: 350\r\n");
      out.write("    });\r\n");
      out.write("    $(\"#oading_text\").hide();\r\n");
      out.write("}\r\n");
      out.write("function showDialogVoid(){\r\n");
      out.write("$(\"#dialogVoid\").dialog(\"destroy\");\r\n");
      out.write("$(\"#dialogVoid\").dialog({\r\n");
      out.write("        bgiframe: true,        modal: true,        width: 400 ,        height: 250,\r\n");
      out.write("        buttons: {\r\n");
      out.write("                Ok: function() {\r\n");
      out.write("                        voidLab();\r\n");
      out.write("                        $(this).dialog('close');\r\n");
      out.write("                },\r\n");
      out.write("                Cancel: function() {\r\n");
      out.write("                        $(this).dialog('close');\r\n");
      out.write("                }\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("function showLoader() {\r\n");
      out.write("    $(\"#loading\").show();\r\n");
      out.write("}\r\n");
      out.write("function hideLoader() {\r\n");
      out.write("    $(\"#loading\").hide();\r\n");
      out.write("}\r\n");
      out.write("function hideLoaderRefresh(){\r\n");
      out.write("    $(\"#loading\").hide();\r\n");
      out.write("    window.location=\"billinglab_add.jsp?flagpage=viewdetail&abl_id=\"+$(\"#txt_abl_id\").val();\r\n");
      out.write("}\r\n");
      out.write("function setYear(){//$(\"#cbo_contact :selected\").val();\r\n");
      out.write("    //alert(\"aaa \"+$(\"#cbo_year :selected\").val());\r\n");
      out.write("    var des = $(\"#txt_description\").val();\r\n");
      out.write("    $(\"#txt_description\").val(\"ประจำปี \"+ $(\"#cbo_year :selected\").text()+ \" เดือน \"+ $(\"#cbo_month :selected\").text()+ \" \"+ $(\"#cbo_period :selected\").text());\r\n");
      out.write("}\r\n");
      out.write("function changesubmitprint(){\r\n");
      out.write("    document.forms[0].action = \"rpt_report_view.jsp?txt_form=\"+$(\"#txt_form\").val()\r\n");
      out.write("        +\"&cbo_branch=\"+$(\"#cbo_branch\").val()+\"&rpt_billinglab_voucher=\"+$(\"#rpt_billinglab_voucher\").attr(\"checked\")\r\n");
      out.write("        +\"&year_id=\"+$(\"#cbo_year\").val()+\"&month_id=\"+$(\"#cbo_month\").val()\r\n");
      out.write("        +\"&period_id=\"+$(\"#cbo_period\").val()+\"&abl_id=\"+$(\"#txt_abl_id\").val()\r\n");
      out.write("        +\"&rpt_billinglab=\"+$(\"#rpt_billinglab\").attr(\"checked\");\r\n");
      out.write("    document.forms[0].submit();\r\n");
      out.write("}\r\n");
      out.write("function saveBillingLab(flag){\r\n");
      out.write("    showLoader();\r\n");
      out.write("    $(\"#divView\").load(\"billinglab_f_save.jsp\",\r\n");
      out.write("        {branch_id : $(\"#cbo_branch\").val(),flagpage : flag, year_id : $(\"#cbo_year :selected\").val(),\r\n");
      out.write("        month_id : $(\"#cbo_month :selected\").val(), period_id : $(\"#cbo_period :selected\").val(),\r\n");
      out.write("        description : $(\"#txt_description\").val(), remark : $(\"#txt_remark\").val(), abl_id : $(\"#txt_abl_id\").val()},\r\n");
      out.write("        function() { window.location=\"billinglab_add.jsp?flagpage=view&abl_id=\"+$(\"#txt_abl_id\").val();});\r\n");
      out.write("}\r\n");
      out.write("function showDetail(orderDate){\r\n");
      out.write("    //alert(\"aaa\");\r\n");
      out.write("    window.open(\"billinglab_detail_view.jsp?abl_id=\"+$(\"#txt_abl_id\").val()\r\n");
      out.write("        +\"&branch_id=\"+$(\"#cbo_branch\").val()+\"&flagpage=view_day&date_order=\"+orderDate,\r\n");
      out.write("    '_blank','width=1020, height=800, left=0,top=0,channelmode=no,status=no,fullscreen=no,menubar=no,resizable=no,scrollbars=yes,location=no,directories=no',true);\r\n");
      out.write("}\r\n");
      out.write("function voidLab(){\r\n");
      out.write("    alert(\"aaa\");\r\n");
      out.write("    //showLoader();\r\n");
      out.write("    $(\"#divView\").load(\"billinglab_f_save.jsp\",\r\n");
      out.write("        {branch_id : $(\"#cbo_branch\").val(),flagpage : \"void_billing_lab\", abl_id : $(\"#txt_abl_id\").val()},\r\n");
      out.write("        function() {hideLoader();});\r\n");
      out.write("        window.location=\"billinglab_view.jsp?flagpage=view\";\r\n");
      out.write("}\r\n");
      out.write("function auditBillingLab(){\r\n");
      out.write("    showLoader();\r\n");
      out.write("    $(\"#divView\").load(\"billinglab_f_save.jsp\",\r\n");
      out.write("        {branch_id : $(\"#cbo_branch\").val(),flagpage : \"audit_billing_lab\", abl_id : $(\"#txt_abl_id\").val()},\r\n");
      out.write("        function() {hideLoaderRefresh();});\r\n");
      out.write("        \r\n");
      out.write("}\r\n");
      out.write("function approveBillingLab(){\r\n");
      out.write("    showLoader();\r\n");
      out.write("    $(\"#divView\").load(\"billinglab_f_save.jsp\",\r\n");
      out.write("        {branch_id : $(\"#cbo_branch\").val(),flagpage : \"approve_billing_lab\", abl_id : $(\"#txt_abl_id\").val()},\r\n");
      out.write("        function() {hideLoaderRefresh();});\r\n");
      out.write("        //window.location=\"billinglab_add.jsp?flagpage=view\";\r\n");
      out.write("}\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <form name=\"billinglab_add\" id=\"billinglab_add\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<div id=\"tabs\">\r\n");
      out.write("                                <ul>\r\n");
      out.write("                                        <!-- CSS Tabs -->\r\n");
      out.write("<li id=\"tab1\"><a id=\"tab11\" href=\"billinglab_view.jsp\"><span>ข้อมูลการรับวางบิล</span></a></li>\r\n");
      out.write("<li id=\"tab2\"><a id=\"tab22\" href=\"billinglab_add.jsp?flagpage=new\"><span>รับวางบิลใหม่</span></a></li>\r\n");
      out.write("<!--<li id=\"tab3\"><a id=\"tab33\" href=\"admin_bill_lab_detail_check_view.jsp?date_order=25520714&hn_no=1403072\"><span>ข้อมูลการวางบิลเก่าๆ</span></a></li>-->\r\n");
      out.write("<!--<li id=\"tab4\"><a id=\"tab44\" href=\"Support.html\"><span>รายงานการวางบิลต่างๆ</span></a></li>-->\r\n");
      out.write("<!--<li><a href=\"noti_repair_view.jsp?noti_repair_id=&flagpage=viewdetail&flagunactive=1\"><span>UnActive ข้อมูล</span></a></li>-->\r\n");
      out.write("<!--<li id=\"tab5\"><a id=\"tab55\" href=\"noti_repair_audit.jsp\"><span>ตรวจสอบใบวางบิล</span></a></li>-->\r\n");
      out.write("<!--<li><a href=\"About.html\"><span>About</span></a></li>-->\r\n");
      out.write("\r\n");
      out.write("                                </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("<br>");
      out.write("\r\n");
      out.write("            <table><tr><td>\r\n");
      out.write("            <table border=\"0\" width=\"100%\" align=\"center\">\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    ");
 if(!flagpage.equals("new")) { 
      out.write("<tr><th colspan=\"3\" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("    <label><A HREF=\"#\" NAME=\"anchor_audit\" ID=\"anchor_audit\">\r\n");
      out.write("        1. ตรวจข้อมูล<img src=\"images/printer-a.png\" alt=\"\" align=\"top\" border=\"0\"></A></label>\r\n");
      out.write("        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        <label><A HREF=\"#\" NAME=\"anchor_approve\" ID=\"anchor_approve\">\r\n");
      out.write("        2. อนุมัติข้อมูล<img src=\"images/printer-a.png\" alt=\"\" align=\"top\" border=\"0\"></A></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("            </th> </tr>\r\n");
      out.write("                    <tr>");
 } 
      out.write("\r\n");
      out.write("                        <th >สาขา</th>\r\n");
      out.write("                        <td><select name=\"cbo_branch\" id=\"cbo_branch\" >");
out.print(cbo_branch); 
      out.write("</select>\r\n");
      out.write("                            <label>&nbsp;ปี&nbsp;<select name=\"cbo_year\" id=\"cbo_year\" >\r\n");
      out.write("                                ");
out.print(cbo_year); 
      out.write("\r\n");
      out.write("                </select></label>\r\n");
      out.write("                <label>&nbsp;เดือน&nbsp;<select name=\"cbo_month\" id=\"cbo_month\" >");
out.print(cbo_month); 
      out.write("</select></label>\r\n");
      out.write("                <label>&nbsp;งวด&nbsp;<select name=\"cbo_period\" id=\"cbo_period\" >");
out.print(cbo_period); 
      out.write("</select></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("    <A HREF=\"#\" NAME=\"anchor_set\" ID=\"anchor_set\">สร้าง&nbsp;<img src=\"images/navigate_check.gif\" alt=\"\" align=\"button\" border=\"0\"></A>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("                ");
 if(!flagpage.equals("new")){ 
      out.write("<A HREF='#' NAME='anchor_save_old' ID='anchor_save_old'> บันทึกข้อมูล &nbsp;<img src='images/savedrafticon.gif' alt='' width='16' align='middle' height='16' border='0'></A>");
 } 
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td><div id=\"loading\">  <img src=\"images/ajax-loader1.gif\" name=\"loader\" id=\"loader\" alt=\"\"></div></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>รายละเอียด</th>\r\n");
      out.write("            <td colspan=\"2\"><input type=\"text\" name=\"txt_description\" id=\"txt_description\" title=\"afdasfsadf\" value=\"");
 out.print(abldb.abl.getBillLabDescription());
      out.write("\" size=\"40\" />\r\n");
      out.write("    &nbsp;&nbsp;<label>หมายเหตุ&nbsp;<input type=\"text\" name=\"txt_remark\" id=\"txt_remark\" value=\"");
 out.print(abldb.abl.getBillLabRemark());
      out.write("\" size=\"30\"/></label></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>วันทำข้อมูล</th>\r\n");
      out.write("    <td colspan=\"2\" ><input type=\"text\" size=\"8\" name=\"txt_abl_date\" id=\"txt_abl_date\" value=\"");
 out.print(abldb.config1.DateFormatDB2Show(abldb.abl.getBillLabDate(),"ddMMyyyy"));
      out.write("\" readonly />\r\n");
      out.write("    <label>เลขที่นำเข้า<input type=\"text\" size=\"10\" name=\"txt_abl_id\" id=\"txt_abl_id\" value=\"");
 out.print(abldb.abl.getBillLabId());
      out.write("\" readonly /></label>\r\n");
      out.write("    &nbsp;&nbsp;&nbsp;\r\n");
      out.write("    &nbsp;&nbsp;&nbsp; <A HREF=\"#\" NAME=\"anchor_void\" ID=\"anchor_void\">\r\n");
      out.write("                ยกเลิกรายการนี้&nbsp;<img src=\"images/trash1.gif\" alt=\"\" align=\"top\" border=\"0\"></A>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("    <label><A HREF=\"#\" NAME=\"anchor_print\" ID=\"anchor_print\">\r\n");
      out.write("        พิมพ์รายงาน<img src=\"images/printer-a.png\" alt=\"\" align=\"top\" border=\"0\"></A></label></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
 if((flagpage.equals("new"))) { 
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>นำเข้าข้อมูล</th>\r\n");
      out.write("<td><input type=\"file\" name=\"uploadfile\" id=\"uploadfile\" size=\"45\" value=\"");
out.print(uploadfile);
      out.write("\">&nbsp;&nbsp;");
 out.print(text1); 
      out.write("\r\n");
      out.write("                            </td>\r\n");
      out.write("<td ><input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Upload\"> <input type=\"hidden\" name=\"todo\" id=\"todo\" value=\"upload\">\r\n");
      out.write("                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                            ");
 if(upload.equals("1")) { 
      out.write("\r\n");
      out.write("            <A HREF='#' NAME='anchor_save' ID='anchor_save'> บันทึกข้อมูล &nbsp;<img src='images/savedrafticon.gif' alt='' width='16' align='middle' height='16' border='0'></A>");
 } 
      out.write("\r\n");
      out.write("                            </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("<tr ><th>รายละเอียด</th><td colspan=\"2\">\r\n");
      out.write("                <label>ข้อมูลได้รับ&nbsp;<input type=\"text\" name=\"txt_total_record_receive\" id=\"txt_total_record_receive\"\r\n");
      out.write("                value=\"");
 out.print(config1.IntegerFormat(abldb.abl.getTotalRecordReceive().toString()));
      out.write("\" size=\"6\" readonly /></label>\r\n");
      out.write("&nbsp;<label>&nbsp;ข้อมูลอนุมัติ&nbsp;<input type=\"text\" name=\"txt_total_record_approve\" id=\"txt_total_record_approve\"\r\n");
      out.write("             value=\"");
 //out.print(total_record_approve);
      out.write("\" size=\"4\" readonly></label>\r\n");
      out.write("&nbsp;<label>&nbsp;ข้อมูลไม่อนุมัติ&nbsp;<input type=\"text\" name=\"txt_total_record_unapprove\" id=\"txt_total_record_unapprove\"\r\n");
      out.write("             value=\"");
 //out.print(total_record_unapprove);
      out.write("\" size=\"4\" readonly></label>\r\n");
      out.write(" &nbsp;&nbsp;&nbsp;&nbsp;<label>&nbsp;เงินวางบิล&nbsp;<input type=\"text\" name=\"txt_total_amount_receive\" id=\"txt_total_amount_receive\"\r\n");
      out.write("             value=\"");
 out.print(config1.NumberFormat(abldb.abl.getTotalAmountReceive()));
      out.write("\" size=\"10\" readonly></label>\r\n");
      out.write("    &nbsp;&nbsp;เงินอนุมัติ <input type=\"text\" name=\"txt_total_amount_approve\" id=\"txt_total_amount_approve\"\r\n");
      out.write("           value=\"");
 //out.print(total_amount_approve);
      out.write("\" size=\"10\" readonly/>\r\n");
      out.write(" &nbsp;<label>&nbsp;เงินไม่อนุมัติ <input type=\"text\" name=\"txt_total_amount_unapprove\" id=\"txt_total_amount_unapprove\"\r\n");
      out.write("           value=\"");
 //out.print(total_amount_unapprove);
      out.write("\" size=\"10\" readonly></label>\r\n");
      out.write("            </td></tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("                    </td> </tr><tr><td>");
 //out.print(text); 
      out.write("</td> </tr> </table>\r\n");
      out.write("\r\n");
      out.write("<div id=\"dialogVoid\" title=\"ยกเลิกรายการ\">\r\n");
      out.write("    <table widht=\"100%\"><tr><th colspan=\"2\" >ต้องการยกเลิกรายการนี้</th></tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th class=\"style14b\">เลขที่นำเข้า</th><td>");
out.print(abldb.abl.getBillLabId()); 
      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"dialogSave\" title=\"บันทึกรายการ\">\r\n");
      out.write("    <table widht=\"100%\"><tr><th colspan=\"2\" >ต้องการบันทึก</th></tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th class=\"style14b\">เลขที่นำเข้า</th><td>");
out.print(abldb.abl.getBillLabId()); 
      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"dialogAudit\" title=\"ตรวจรายการ\">\r\n");
      out.write("    <table widht=\"100%\"><tr><th colspan=\"2\" >ต้องการตรวจรายการ</th></tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th class=\"style14b\">เลขที่นำเข้า</th><td>");
out.print(abldb.abl.getBillLabId()); 
      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("</div>\r\n");
      out.write("  <div id=\"dialogApprove\" title=\"อนุมัติรายการ\">\r\n");
      out.write("    <table widht=\"100%\"><tr><th colspan=\"2\" >ต้องการอนุมัติรายการ</th></tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th class=\"style14b\">เลขที่นำเข้า</th><td>");
out.print(abldb.abl.getBillLabId()); 
      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("</div>\r\n");
      out.write("      <div id=\"divView\" ></div>\r\n");
      out.write("      <div id=\"dialogPrint\">\r\n");
      out.write("            <table><tr><th scope=\"row\" ><div align=\"left\">รายงาน :</div></th></tr>\r\n");
      out.write("        <tr><td class=\"style14b\"><div align=\"left\">\r\n");
      out.write("          <label><input type=\"radio\" name=\"txt_report_name\" value=\"lab_bill\" id=\"rpt_billinglab_voucher\"  >001 (ใบสั่งจ่าย lab)</label>\r\n");
      out.write("          <br><label><input type=\"radio\" name=\"txt_report_name\" value=\"lab_bill_item\" id=\"rpt_billinglab\" >002 (ใบบันทึกการจ่ายเงิน lab)</label>\r\n");
      out.write("          <br><br><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("        <A HREF=\"#\" NAME=\"report_print\" ID=\"report_print\"> พิมพ์ข้อมูล &nbsp;<img src=\"images/printer-a.png\" alt=\"\" width=\"16\" align=\"middle\"\r\n");
      out.write("      height=\"16\" border=\"0\"></A></label>\r\n");
      out.write("          </div>\r\n");
      out.write("<input type=\"hidden\" name=\"txt_flag\" id=\"txt_flag\">\r\n");
      out.write("        <input type=\"hidden\" name=\"txt_form\" id=\"txt_form\" value=\"daily\">\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr><td><div id=\"loading_text\">  <img src=\"images/ajax-loader1.gif\" name=\"loader\" id=\"loader\" alt=\"\"></div></td> </tr> </table>\r\n");
      out.write("        </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--<table border=\"0\" width=\"720\" align=\"center\">\r\n");
      out.write("    <thead>\r\n");
      out.write("        <tr align=\"center\" class='style14r'><td width=\"5\" align=\"center\">ลำดับที่</td>\r\n");
      out.write("            <td width=\"8\">วันที่</td>\r\n");
      out.write("            <td width=\"10\">จำนวนผู้ป่วย</td>\r\n");
      out.write("            <td width=\"10\">จำนวนรายการ</td>\r\n");
      out.write("            <td width=\"10\">จำนวนเงินวางบิล</td>\r\n");
      out.write("            <td width=\"20\">จำนวนที่ตรวจพบ</td>\r\n");
      out.write("            <td width=\"20\">จำนวนที่ตรวจไม่พบ</td>\r\n");
      out.write("            <td width=\"10\">จำนวนเงินอนุมัติ</td>\r\n");
      out.write("    </tr></thead>\r\n");
      out.write("    <tbody>\r\n");
      out.write("        \r\n");
      out.write("                </tbody>\r\n");
      out.write("</table>-->\r\n");
out.print(tr_abl_detail); 
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
