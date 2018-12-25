<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>购物车</title>
    <link rel="stylesheet" type="text/css" href="files/CSS/home.css"/>
    <script src = "react/build/react.js"></script>
    <script src = "react/build/react-dom.js"></script>
    <script src = "react/build/browser.min.js"></script>
    <script src = "files/JS/Log.js" type="text/babel"></script>
</head>
<style>
.tbstyle {
	background-color:rgba(123,123,233,0.3);
    font-size:30px;
    position: relative;
    margin:auto;
    top:0px;
}	
.itemstyle{
	text-align:right;
	width:200px;
}	
.inputstyle{
	text-align:left;
	font-size:30px;
	height:30px;
	width:240px;
}
.hintstyle{
	color:red;
	text-align:left;
	font-size:20px;
	width:200px;
}
</style>
<body>
	<div id = "log"></div>
 	<form action="order" method="post">
 		<table class = "tbstyle">
 			<tr>
 				<td class = "itemstyle">用户名：</td>
 				<td><label name="username" class = "inputstyle">
 						<%=session.getAttribute("username") %>
 					</label></td>
 				<td class = "hintstyle"><p id = "nameError"></p></td>
 			</tr>
 			<tr>
 				<td class = "itemstyle">收件人姓名：</td>
 				<td><input name="name" type="text" class = "inputstyle"/></td>
 				<td class = "hintstyle"><p id = "passwordError">*</p></td>
 			</tr>
 			<tr>
 				<td class = "itemstyle">收件地址：</td>
 				<td><input name="address" type="text" class = "inputstyle" /></td>
 				<td class = "hintstyle"><p id = "relpasswordError">*</p></td>
 			</tr>
 			<tr>
 				<td class = "itemstyle">手机号码：</td>
 				<td><input name="phone" type="text" class = "inputstyle" /></td>
 				<td class = "hintstyle"><p>请确保号码有效</p></td>
 			</tr>
 			<tr>
 				<td class = "itemstyle"></td>
 				<td>
 					<input type="submit" value="下单"  style="font-size:20px"/>
 					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 					<input type="reset" value="重置" style="font-size:20px"/>
 				</td>
 			</tr>
 		</table>
 	</form>
    <div id = "booklist"></div>
</body>
</html>
<script type = "text/babel">
var ListStyle = {
	backgroundColor:'rgba(123,123,233,0.3)',
	width: 660,
	height: 240,
	textAlign: 'left',
    position: 'relative',
    margin:'auto',
    top: 0
};
var list = 
	<div style = {ListStyle}>
		<iframe src="order?action=tmporder" 
			width="660" height="240" style = {{border:0}}></iframe>
		<a href="order?action=clear"><button style={{fontSize:20,float:'right'}}>清空</button></a>
	</div>
ReactDOM.render(list,document.getElementById("booklist"));
</script>