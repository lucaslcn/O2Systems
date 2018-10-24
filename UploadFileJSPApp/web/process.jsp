<%-- 
    Document   : process
    Created on : Oct 18, 2018, 6:36:05 PM
    Author     : Lucas
--%>

 <%@ page import="java.io.*"%>
 <%@page import="com.oreilly.servlet.MultipartRequest" %>
 <%@ page import="java.util.*" %>
 <%
try
   {
    MultipartRequest mrequest = new MultipartRequest(request, "D:/file");
    String file_name = mrequest.getParameter("fname");//receive fname
    File cod = mrequest.getParameter("cod");//receive code
    Enumeration files = mrequest.getFileNames();

    while(files.hasMoreElements())
{
    String upload=(String)files.nextElement();

    File filename=new File(mrequest.getOriginalFileName(upload));
    
    filename.renameTo(cod);
}
}
catch(Exception ex)
{
System.out.println("Error creating file: " + ex );
}%>