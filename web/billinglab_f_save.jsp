<%-- 
    Document   : billinglab_f_save
    Created on : Mar 9, 2011, 10:08:59 PM
    Author     : root
--%>

<%@page import="bangnalab.AdminTBillLabDB"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
AdminTBillLabDB abldb = new AdminTBillLabDB();
String flagpage="", branch_id="", abl_id="",description="",remark="",year_id="",month_id="",period_id="",txt="";
if(request.getParameter("flagpage")!=null) {
    flagpage = request.getParameter("flagpage");
}
if(request.getParameter("branch_id")!=null) {
    branch_id = request.getParameter("branch_id");
}
if(request.getParameter("abl_id")!=null) {
    abl_id = request.getParameter("abl_id");
}
if(request.getParameter("description")!=null) {
    description = request.getParameter("description");
}
if(request.getParameter("remark")!=null) {
    remark = request.getParameter("remark");
}
if(request.getParameter("year_id")!=null) {
    year_id = request.getParameter("year_id");
}
if(request.getParameter("month_id")!=null) {
    month_id = request.getParameter("month_id");
}
if(request.getParameter("period_id")!=null) {
    period_id = request.getParameter("period_id");
}
if(flagpage.equals("save_billinglab")){
    abldb.setSaveBillingDetailFromText2(abl_id);
    //txt = abldb.getTRBillLabDetail(abl_id,"", "date");
    //response.sendRedirect("billinglab_add.jsp?abl_id="+abl_id);
}else if(flagpage.equals("save_billinglab_old")){
    abldb.setUpateAdminTBillingLab(branch_id, abl_id, year_id, month_id, period_id, description, remark);
}else if(flagpage.equals("void_billing_lab")){
    abldb.setUpdateBillLabVoid(abl_id);
}else if(flagpage.equals("audit_billing_lab")){
    abldb.setBillLabAuditAllBillId(branch_id, abl_id);
}else if(flagpage.equals("approve_billing_lab")){
    abldb.setBillLabApproveAllBillId(abl_id);
}
out.print(txt);
%>