<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();  
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.tbstyle {
	background-color:rgba(123,123,233,0.3);
    font-size:30px;
    position: relative;
    margin:auto;
    top:40px;
}	
.nstyle{
	text-align:right;
	width:200px;
}	
.instyle{
	text-align:left;
	font-size:30px;
	height:30px;
	width:240px;
}
.estyle{
	color:red;
	text-align:left;
	font-size:20px;
	width:200px;
}
</style>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录</title>
 	<base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="files/CSS/home.css"/>
    <script src = "react/build/react.js"></script>
    <script src = "react/build/react-dom.js"></script>
    <script src = "react/build/browser.min.js"></script>
    <script src = "files/JS/Log.js" type="text/babel"></script>
</head>
<body>
	<div id = "log"></div>
 	<form action="login" method="post" >
 		<table class = "tbstyle">
 			<tr>
 				<td class = "nstyle">用户名：</td>
 				<td><input name="username" type="text" class = "instyle"/></td>
 				<td class = "estyle"><p id = "nameError">*</p></td>
 			</tr>
 			<tr>
 				<td class = "nstyle">密码：</td>
 				<td><input name="password" type="password" class = "instyle"/></td>
 				<td class = "estyle"><p id = "nameError">*</p></td>
 			</tr>
 			<tr>
 				<td class = "nstyle"></td>
 				<td><input type="submit" value="登录" style = "font-size:30px"/></td>
 				<td class = "estyle"><p id = "nameError"></p></td>
 			</tr>
 		</table>
 	</form>
</body>
</html>