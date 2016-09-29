<%-- 
    Document   : labbilling_f_search
    Created on : Mar 1, 2011, 11:33:12 AM
    Author     : root
--%>

<%@page import="bangnalab.LabBillingDB"%>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
String branch_id="", flagpage="", year_id="", txt="";
LabBillingDB ltbdb = new LabBillingDB();
try {
    if(request.getParameter("branch_id")!=null) {
        branch_id = new String (request.getParameter("branch_id").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("flagpage")!=null) {
        flagpage = new String (request.getParameter("flagpage").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("year_id")!=null) {
        year_id = new String (request.getParameter("year_id").getBytes("ISO8859_1"),"TIS-620");
    }
    if(flagpage.equals("labbilling_view")){
        txt = ltbdb.getTrLabTBillingView(branch_id, year_id);
    }
} catch (Exception ex) {
    txt = ex.getMessage();
}
out.print(txt);
%>