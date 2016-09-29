<%--
    Document   : noti_repair_upload_file
    Created on : 11 ก.ค. 2552, 12:32:32
    Author     : pop
--%>

<%@page import="bangnalab.AdminTBillLabDB"%>
<%@page import="bangnalab.AdminTBillLab"%>
<%@page import="bangnaLibrary.Config1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.io.File" %>
<%@ page language="java" import="javazoom.upload.*,java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="upBean" scope="page" class="javazoom.upload.UploadBean" >
  <jsp:setProperty name="upBean" property="folderstore" value="/var/www/intranet/billlab/" />
<%
  //Properties props = new Properties();/var/www/intranet/billlab/
  //props.put("user","postgres");D:\\Data\\UpLoad\\
  //props.put("password","postgres");//jdbc:postgresql://localhost:5432/hospital_osv3
  //upBean.setDatabasestore("org.postgresql.Driver","jdbc:postgresql::@mydbhost:1521:ORCL", props);
%>
</jsp:useBean>
<%
String bill_lab_id="", noti_repair_id1="", flag="", path_file="/var/www/intranet/billlab/", upload="";
Config1 config1 = new Config1();
AdminTBillLab billlab = new AdminTBillLab();
AdminTBillLabDB billlabdb = new AdminTBillLabDB();
bill_lab_id = (String)session.getAttribute("admin_bill_lab.bill_lab_id");
upload = (String)session.getAttribute("admin_bill_lab.upload");
//flag = (String)session.getAttribute("noti_repair.flag");
billlab.setBillLabId(bill_lab_id);
if(request.getParameter("flag")!=null){
        flag = new String (request.getParameter("flag").getBytes("ISO8859_1"),"TIS-620");
        if(flag.equals("import")){
            //billlabdb.setSaveBillLabDetailFromMDB(bill_lab_id,file1+".txt");
            billlabdb.setSaveBillLabDetailFromText(bill_lab_id,path_file+bill_lab_id+".txt");
            }
    }
//noti_repair_id = new String (config1.StringNull(request.getParameter("noti_repair_id")));
//noti_repair_id1 = new String (config1.StringNull(request.getParameter("txt_noti_repair_id")));
//if(noti_repair_id.equals("")){
//    noti_repair_id =noti_repair_id1;
//    }


%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
                @import "js/dojo1.3.1/dojo/resources/dojo.css";
                @import "dojo1.3.1/dijit/themes/dijit.css";
                @import "../FileInput/FileInput.css";
        </style>
    </head>
    <body MARGINWIDTH=0 MARGINHEIGHT=0 TOPMARGIN=0 RIGHTMARGIN=0 LEFTMARGIN=0>
        <ul class="style1">
        <%
        try{
            Integer chk=0;
              if (MultipartFormDataRequest.isMultipartFormData(request)){
                 // Uses MultipartFormDataRequest to parse the HTTP request.
                 MultipartFormDataRequest mrequest = new MultipartFormDataRequest(request);
                 String todo = null;
                 if (mrequest != null) todo = mrequest.getParameter("todo");
                 if ((todo != null) && (todo.equalsIgnoreCase("upload")) ){
                    Hashtable files = mrequest.getFiles();
                    if ( (files != null) && (!files.isEmpty())){
                        UploadFile file = (UploadFile) files.get("uploadfile");
                        //notirepair.getNotiRepairPictureFileName();
                        //notirepair.setNotiRepairPictureRepairDelete();
                        //boolean exists = (new File("D:\\Data\\UpLoad\\"+noti_repair_id+".jpg")).exists();
                        //if (exists) {
                            // File or directory exists
                        //    boolean success = (new File("D:\\Data\\UpLoad\\"+noti_repair_id+".jpg")).delete();
                        //} else {
                            // File or directory does not exist
                        //}
                        billlab.setBillBlabDelete(path_file+bill_lab_id+".txt");
                        file.setFileName(bill_lab_id+".txt");
                        if (file != null) out.println("<li>Form field : uploadfile"+"<BR> Uploaded file : "
                                +file.getFileName()+" ("+file.getFileSize()+" bytes)");
                        // Uses the bean now to store specified by jsp:setProperty at the top.
                        upBean.store(mrequest, "uploadfile");
                        //billlabdb.setSaveBillLabDetailFromMDB(bill_lab_id,"/var/www/intranet/billlab/"+file.getFileName());
                        billlabdb.setDeleteBillLabDetailByBillLabId(bill_lab_id);
                        chk=billlabdb.setSaveBillLabDetailFromText(bill_lab_id,path_file+file.getFileName());
                        out.print("<a href='#' onClick='importdata();'>นำเข้าข้อมูลเรียบร้อย จำนวน "+chk.toString()+" รายการ Click เพื่อนำเข้าข้อมูลใหม่</a>");
                        //out.print("<a href='javascript:window.close();'>Close Window</a>");
                        out.print("");
                        session.setAttribute("admin_bill_lab.upload","1");
                        upload="1";
                        //response.sendRedirect("noti_repair_add.jsp?flagpage=adddetail&noti_repair_id="+bill_lab_id+"&txt_form=daily");
                    }else{
                      out.println("<li>No uploaded files");
                    }
                 }else out.println("<BR> todo="+todo);
              }
          }catch(Exception ex){
            out.println(ex.getMessage());
        }
        %>
        </ul>
        <form method="post" action="admin_bill_lab_upload_file.jsp" name="upform" enctype="multipart/form-data">
            <table width="60%" border="0" cellspacing="1" cellpadding="1" align="center" class="style1">
                <tr>
                    <td align="left" bgcolor="#C1DAD7"><b>Select a file to upload [<%out.print(bill_lab_id);%> ]:</b></td>
                </tr>
                <tr>
                  <td align="left"><% if(upload.equals("0")) { %>
                    <input type="file" name="uploadfile" size="50"><% }%>
                    </td>
                </tr>
                <tr>
                  <td align="left">
                        <input type="hidden" name="todo" value="upload">
                        <% if(upload.equals("0")) { %>
                    <input type="submit" name="Submit" value="Upload"> 
                    <input type="reset" name="Reset" value="Cancel"><% }%>
                    <input type="hidden" name="txt_noti_repair_id" value="<%out.print(bill_lab_id);%>" />
                    </td>
                </tr>
              </table>
              <br>
              <br>
              <!--<table border="0" cellspacing="1" cellpadding="0" align="center">
                <tr>
                  <td bgcolor="#666666">
                    <table width="100%" border="0" cellspacing="1" cellpadding="0" align="center" class="style1">
                      <tr>
                        <td bgcolor="#FFFFFF"><b><font color="#0000FF">&nbsp;
                          HTML tags used in this form : </font></b></td>
                      </tr>
                      <tr>
                        <td bgcolor="#FFFFFF">&nbsp;&lt;<b>form</b>
                          <b>method</b>=&quot;<b><font color="#FF0000">post</font></b>&quot;
                          <b>action</b>=&quot;<b><font color="#FF0000">SimpleUpload.jsp</font></b>&quot;
                          name=&quot;upload&quot; <b>enctype</b>=&quot;<b><font color="#FF0000">multipart/form-data</font></b>&quot;&gt;</td>
                      </tr>
                      <tr>
                        <td bgcolor="#FFFFFF">&nbsp;&lt;<b>input</b>
                          <b>type</b>=&quot;<b><font color="#FF0000">file</font></b>&quot;
                          <b>name</b>=&quot;<font color="#FF0000"><b>uploadfile</b></font>&quot;
                          size=&quot;50&quot;&gt;</td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
              <p align="center">&nbsp;</p>
              <p align="center">&nbsp;</p>
              <p align="center"><font size="-1" face="Courier New, Courier, mono">Copyright
                &copy; <a href="http://www.javazoom.net" target="_blank">JavaZOOM</a> 1999-2006</font></p>-->
            </form>
    </body>
    <script>
        function closepage(){
            
        }
        function importdata(){
            document.forms[0].action = "admin_bill_lab_upload.jsp?flag=import";
            //document.forms[0].submit();
            //return false;
        }
    </script>
</html>
