<%-- 
    Document   : labbilling_f_save
    Created on : Mar 4, 2011, 11:26:21 PM
    Author     : root
--%>

<%@page import="bangnalab.LabBillingDB"%>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
LabBillingDB ltbdb = new LabBillingDB();
String ltb_id="", flagpage="",branch_id="",txt="",ltb_i_id="",item_number="",item_common_name="",price_net="";
String description="",remark="",yearId="",monthId="",periodId="";
if(request.getParameter("flagpage")!=null) {
    flagpage = request.getParameter("flagpage");
}
if(request.getParameter("branch_id")!=null) {
    branch_id = request.getParameter("branch_id");
}
if(request.getParameter("ltb_id")!=null) {
    ltb_id = request.getParameter("ltb_id");
}
if(request.getParameter("ltb_i_id")!=null) {
    ltb_i_id = request.getParameter("ltb_i_id");
}
if(request.getParameter("item_number")!=null) {
    item_number = request.getParameter("item_number");
}
if(request.getParameter("item_common_name")!=null) {
    item_common_name = request.getParameter("item_common_name");
}
if(request.getParameter("price_net")!=null) {
    price_net = request.getParameter("price_net");
}
if(flagpage.equals("save_lab")){
    ltbdb.setSaveLabBilling(branch_id,ltb_id,"");
    txt = ltbdb.getTrLabBillingGroup2(branch_id, ltb_id);
}else if(flagpage.equals("save_lab_old")){
    if(request.getParameter("description")!=null) {
        description = request.getParameter("description");
    }
    if(request.getParameter("remark")!=null) {
        remark = request.getParameter("remark");
    }
    if(request.getParameter("year_id")!=null) {
        yearId = request.getParameter("year_id");
    }
    if(request.getParameter("month_id")!=null) {
        monthId = request.getParameter("month_id");
    }
    if(request.getParameter("period_id")!=null) {
        periodId = request.getParameter("period_id");
    }
    ltbdb.setUpdateLabTBilling(branch_id, description, remark, yearId, monthId, periodId, ltb_id);
}else if(flagpage.equals("text_lab")){
    ltbdb.setTextLabBilling(branch_id, ltb_id);
}else if(flagpage.equals("item_number")){
    ltbdb.setUpdateLabBillingItemItemNumber(branch_id, ltb_i_id, item_number);
}else if(flagpage.equals("item_common_name")){
    ltbdb.setUpdateLabBillingItemItemCommonName(branch_id, ltb_i_id, item_common_name);
}else if(flagpage.equals("price_net")){
    ltbdb.setUpdateLabBillingItemPriceNet(branch_id, ltb_i_id, price_net);
}else if(flagpage.equals("void_lab_bill")){
    ltbdb.setUpdateLabTBillingVoid(branch_id, ltb_id);
}
out.print(txt);
%>