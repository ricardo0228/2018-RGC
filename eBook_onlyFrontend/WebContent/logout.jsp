<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();  
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注销</title>
 	<base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="files/CSS/home.css"/>
</head>

<body>
 	<%
    	session.invalidate();
    	response.sendRedirect("index.jsp");
	%>
</body>
</html>