<%-- 
    Document   : rpt_text_file
    Created on : Oct 16, 2010, 9:33:57 AM
    Author     : root
--%>

<%@page import="bangnalab.LabBillingDB"%>
<%@page import="java.util.Vector"%>
<%@page import="bangnaLibrary.BBranch"%>
<%@page import="bangnaLibrary.ComboDB"%>
<%@page import="bangnaLibrary.Config1"%>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
String branch_id="",month_id="", txt="",year_id="",txt_char="",ltb_id="";
Config1 config1 = new Config1();
ComboDB combodb = new ComboDB();
BBranch branch = new BBranch();
Vector v_doctordf = new Vector();
LabBillingDB ltbdb = new LabBillingDB();
try {
    if(request.getParameter("cbo_branch")!=null) {
        branch_id = new String (request.getParameter("cbo_branch").getBytes("ISO8859_1"),"TIS-620");
    }
    if(branch_id.equals("")){
        branch = config1.getBranchActive();
        branch_id = branch.getBranchId();
    }
    if(request.getParameter("ltb_id")!=null) {
        ltb_id = new String (request.getParameter("ltb_id").getBytes("ISO8859_1"),"TIS-620");
    }
    ltbdb.setTextLabBilling(branch_id, ltb_id);

} catch (Exception ex) {
    txt = ex.getMessage();
}
%>
