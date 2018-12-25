<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();  
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册</title>
 	<base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="files/CSS/home.css"/>
    <link rel="stylesheet" type="text/css" href="files/CSS/user.css"/>
    <script src = "react/build/react.js"></script>
    <script src = "react/build/react-dom.js"></script>
    <script src = "react/build/browser.min.js"></script>
    <script src = "files/JS/Log.js" type="text/babel"></script>
</head>
<script>
	var password;
	var test1 = false, test2 = false, test3 = false;
	function testUser(str)
	{
		var xmlhttp;    
		if (str==""){
			document.getElementById("nameError").innerHTML="<p style = \"color:red\">*</p>";
			return;
  		}
  		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){
  			if (xmlhttp.readyState==4 && xmlhttp.status==200){
  				if(xmlhttp.responseText == "true"){
  					document.getElementById("nameError").innerHTML="<p style = \"color:red\">该用户名已被使用</p>";
  		  			test1 = false;
  				}
  				else{
  					document.getElementById("nameError").innerHTML="<p style = \"color:lightgreen\">可使用</p>";
  					test1 = true;
  				}
    		}
  		}
		xmlhttp.open("GET","register?action=testUser&username="+str,true);
		xmlhttp.send();
	}
	function testPassword(str)
	{
		var xmlhttp;    
		if (str==""){
			document.getElementById("passwordError").innerHTML="<p style = \"color:red\">*</p>";
			return;
  		}
  		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){
  			if (xmlhttp.readyState==4 && xmlhttp.status==200){
  				if(xmlhttp.responseText == "false"){
  					document.getElementById("passwordError").innerHTML="<p style = \"color:red\">密码必须包含字母和数字</p>";
  		  			test2 = false;
  				}
  				else{
  					document.getElementById("passwordError").innerHTML="<p style = \"color:lightgreen\">可使用</p>";
  					test2 = true;
  				}
    		}
  		}
		xmlhttp.open("GET","register?action=testPassword&password="+str,true);
		xmlhttp.send();
		password = str;
	}
	function testRelword(str)
	{
		if (str==""){
			document.getElementById("relpasswordError").innerHTML="<p style = \"color:red\">*</p>";
			return;
  		}
  		if(str != password){
  			document.getElementById("relpasswordError").innerHTML="<p style = \"color:red\">确认密码不同</p>";
  			test3 = false;
  		}
  		else{
  			document.getElementById("relpasswordError").innerHTML="<p style = \"color:lightgreen\">可使用</p>";
  			test3 = true;
  		}
	}
	function checkForm(){
		if (test1 && test2 && test3){
			return true;
		}
		else {
			alert("请确认信息填写无误后提交");
			return false;
		}
	}
</script>
<body>
	<div id = "log"></div>
 	<form action="register" method="post" onsubmit="return checkForm()">
 		<table class = "tbstyle">
 			<tr>
 				<td class = "nstyle">用户名：</td>
 				<td><input name="username" type="text" class = "instyle" onkeyup="testUser(this.value)"/></td>
 				<td  id = "nameError" class = "warningstyle"><p style = "color:red">*</p></td>
 			</tr>
 			<tr>
 				<td class = "nstyle">密码：</td>
 				<td><input name="password" type="password" class = "instyle" onkeyup="testPassword(this.value)"/></td>
 				<td  id = "passwordError" class = "warningstyle"><p style = "color:red">*</p></td>
 			</tr>
 			<tr>
 				<td class = "nstyle">确认密码：</td>
 				<td><input name="relpassword" type="password" class = "instyle" onkeyup="testRelword(this.value)"/></td>
 				<td  id = "relpasswordError" class = "warningstyle"><p style = "color:red">*</p></td>
 			</tr>
 			<tr>
 				<td class = "nstyle">邮箱：</td>
 				<td><input name="email" type="text" class = "instyle" /></td>
 				<td  id = "emailError" class = "warningstyle"><p style = "color:red">&nbsp;</p></td>
 			</tr>
 			<tr>
 				<td class = "nstyle">手机号码：</td>
 				<td><input name="phone" type="text" class = "instyle" /></td>
 				<td  id = "phoneError" class = "warningstyle"><p style = "color:red">&nbsp;</p></td>
 			</tr>
 			<tr>
 				<td class = "nstyle"></td>
 				<td>
 					<input type="submit" value="注册"  style="font-size:20px"/>
 					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 					<input type="reset" value="重置" style="font-size:20px"/>
 				</td>
 			</tr>
 		</table>
 	</form>
</body>
</html>