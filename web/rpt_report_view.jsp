<%--
    Document   : rpt_report_view
    Created on : Oct 29, 2009, 10:41:51 PM
    Author     : root
--%>
<%@ page import ="bangnalab.*" %>
<%@ page import ="bangnaLibrary.*" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="net.sf.jasperreports.engine.*" %>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    Config1 config1 = new Config1();
    String branch_id="",branch_name="", text="", header1="",branch_name1="", header2="", date_startdb="", date_enddb="", doctor_id_start="", doctor_id_end="";
    String month_start="", month_end="", year_start="", year_end="", day_start="01", day_end="", month_namet_start="", month_namet_end="";
    String date_start="", date_end="",address="";
    String jdbc = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://172.1.1.1:1433";
    Integer year=0;
    Connection conn=null;
    Statement st;
    ResultSet rs;
    Map par = new HashMap();
    BBranch branch = new BBranch();
    par.put("header1","โรงพยาบาลบางนา 1 1302 ถ.บางนา-ตราด กม.3 แขวงบางนา เขตบางนา กรุงเทพฯ 10260 Tel: (662) 746-8630-8 Fax: (662) 398-9531");
    par.put("header2","BANGNA GENERAL HOSPITAL 1302 Bangna-Trad Road, Bangna,Bangkok Thailand 10260 Email :BANGNA1@BANGNA.CO.TH");
    //rptBangnaOpd rptbangnaOpd = new rptBangnaOpd();
    String reportname = config1.StringNull(request.getParameter("txt_report_name"));
    String rpt_lab_bill = config1.StringNull(request.getParameter("rpt_lab_bill"));
    String rpt_lab_bill_item = config1.StringNull(request.getParameter("rpt_lab_bill_item"));
    String rpt_billinglab_voucher = config1.StringNull(request.getParameter("rpt_billinglab_voucher"));
    String rpt_billinglab = config1.StringNull(request.getParameter("rpt_billinglab"));
    String form = config1.StringNull(request.getParameter("txt_form"));
    branch_id = config1.StringNull(request.getParameter("cbo_branch"));

    //branch = config1.getBranchActive();
    //branch_id = branch.getBranchId();
    //branch_name = config1.getSiteNamet(branch_id);
    branch_name = "บริษัท เพาเวอร์ไดแอกนอสติค ลาโบราทอรี่ จำกัด ";
    address = "79 ม.8 ต.บางครุ อ.พระประแดง จ สมุทรปราการ 10130 โทร.081-3518464 โทรสาร 02-1381175";
    branch = config1.getBranchActive();
    if(rpt_lab_bill.equals("true")){
        reportname = "lab_bill";
    }
    if(rpt_lab_bill_item.equals("true")){
        reportname="lab_bill_item";
    }
    if(rpt_billinglab_voucher.equals("true")){
        reportname="billinglab_voucher";
    }
    if(rpt_billinglab.equals("true")){
        reportname="billinglab";
    }

    //form = "daily";
    //reportname="asset_item";
    if(branch_id.equals("103001")) {
        branch_name1 = "สาขา บางนา 1";
    }
    else if(branch_id.equals("103002")) {
        branch_name1 = "สาขา บางนา 2";
    }
    else if(branch_id.equals("103003")) {
        branch_name1 = "สาขา บางนา 3";
    }
    //else if(branch_id.equals("103005")) {
    //    branch_name1 = "สาขา บางนา 5";
    //}
    //conn = config1.getConnectionHospital(branch_id);
    header1 = branch_name;
    if(form.equals("daily")) {
        if(reportname.equals("lab_bill")) {
            String year_id = config1.StringNull(request.getParameter("year_id"));
            String month_id = config1.StringNull(request.getParameter("month_id"));
            String period_id = config1.StringNull(request.getParameter("period_id"));
            String ltb_id = config1.StringNull(request.getParameter("ltb_id"));
            String date_current = config1.getDateDBHospital("ddMMyyyy");
            //if(!year_id.equals("")){
            //    year = Integer.parseInt(year_id)+543;
            //}
            par.put("header1", header1);
            par.put("header2", "ใบวางบิล lab "+branch_name1);
            par.put("header3", "ประจำ "+config1.getPeriodNamet(period_id, "id_name")
                    +" เดือน "+config1.getMonthNamet(month_id, "id_name")+" ปี "+year_id.toString());
            par.put("header4", address);
            par.put("p_ltb_id", ltb_id);
            par.put("month_id", month_id);
            par.put("branch_id", branch_id);
        }else if(reportname.equals("lab_bill_item")) {
            String year_id = config1.StringNull(request.getParameter("year_id"));
            String month_id = config1.StringNull(request.getParameter("month_id"));
            String period_id = config1.StringNull(request.getParameter("period_id"));
            String date_current = config1.getDate("dd MMMMM yyyy");
            String ltb_id = config1.StringNull(request.getParameter("ltb_id"));
            //if(!year_id.equals("")){
            //    year = Integer.parseInt(year_id)+543;
            //}
            par.put("header1", header1);
            par.put("header2", "รายงานชันสูตรโรค ตามประเภท ประจำ "+branch_name1);
            par.put("header3", "ประจำ เดือน"+config1.getMonthNamet(month_id, "id_name")+" ปี "+year_id.toString()+" "+config1.getPeriodNamet(period_id, "id_name"));
            par.put("year_id", year_id);
            par.put("month_id", month_id);
            par.put("branch_id", branch_id);
            par.put("p_ltb_id", ltb_id);
        }else if(reportname.equals("billinglab_voucher")) {
            String year_id = config1.StringNull(request.getParameter("year_id"));
            String month_id = config1.StringNull(request.getParameter("month_id"));
            String date_current = config1.getDate("dd MMMMM yyyy");
            String abl_id = config1.StringNull(request.getParameter("abl_id"));
            //if(!year_id.equals("")){
            //    year = Integer.parseInt(year_id)+543;
            //}
            par.put("header1", config1.getSiteNametBangkok(branch.getBranchId()));
            par.put("header2", "ใบสั่งจ่าย ");
            par.put("header3", "ประจำ เดือน"+config1.getMonthNamet(month_id, "id_name")+" ปี "+year_id.toString());
            par.put("header4", "จ่ายให้ "+header1);
            par.put("year_id", year_id);
            par.put("month_id", month_id);
            par.put("branch_id", branch_id);
            par.put("p_abl_id", abl_id);
        }else if(reportname.equals("billinglab")) {
            String year_id = config1.StringNull(request.getParameter("year_id"));
            String month_id = config1.StringNull(request.getParameter("month_id"));
            String date_current = config1.getDate("dd MMMMM yyyy");
            String abl_id = config1.StringNull(request.getParameter("abl_id"));
            //if(!year_id.equals("")){
            //    year = Integer.parseInt(year_id)+543;
            //}
            par.put("header1", config1.getSiteNametBangkok(branch.getBranchId()));
            par.put("header2", "ใบบันทึกการจ่ายเงิน ");
            par.put("header3", "ประจำ เดือน"+config1.getMonthNamet(month_id, "id_name")+" ปี "+year_id.toString());
            par.put("header4", "จ่ายให้ "+header1);
            par.put("year_id", year_id);
            par.put("month_id", month_id);
            par.put("branch_id", branch_id);
            par.put("p_abl_id", abl_id);
        }
        conn=config1.getConnectionBangna();
    }else if(form.equals("yearly")){
    }
    try{
        File reportFile = new File(application.getRealPath("/report/"+reportname+".jasper"));
        String rptfile = application.getRealPath("/report/"+reportname+".jasper");
        //out.print(rptfile);
        if (!reportFile.exists())
            throw new JRRuntimeException("File not found. The report desing must be compiled first.");
            byte[] bytes = JasperRunManager.runReportToPdf(rptfile,par,conn);
            response.setContentType("application/pdf");
            response.setContentLength((bytes.length));
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
            outputStream.close();
        }
    catch (Exception ex) {
        text=ex.getMessage();
        System.out.println("Initial SQL Error " + ex.getMessage());
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=TIS-620">
        <title>JSP Page</title>
    </head>
    <body>
        <% out.print(text); %>
    </body>
</html>
