<%-- 
    Document   : billinglab_f_search
    Created on : Mar 11, 2011, 5:17:59 PM
    Author     : root
--%>

<%@page import="bangnalab.AdminTBillLabDB"%>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
String branch_id="", flagpage="", year_id="", txt="";
AdminTBillLabDB abldb = new AdminTBillLabDB();
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
    if(flagpage.equals("billinglab_view")){
        txt = abldb.getTrBillingLab(branch_id, year_id);
    }
} catch (Exception ex) {
    txt = ex.getMessage();
}
out.print(txt);
%>
