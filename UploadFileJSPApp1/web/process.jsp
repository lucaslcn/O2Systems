<%-- 
    Document   : process
    Created on : Oct 18, 2018, 6:36:05 PM
    Author     : Lucas
--%>

<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%

    MultipartRequest m=new MultipartRequest(request, "D:/file");

    out.println("Upload realizado com sucesso!");

    %> 