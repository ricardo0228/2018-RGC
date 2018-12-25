<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>冉冉新星</title>
    <link rel="stylesheet" type="text/css" href="files/CSS/manager.css"/>
    <script src = "react/build/react.js"></script>
    <script src = "react/build/react-dom.js"></script>
    <script src = "react/build/browser.min.js"></script>
    <script src = "files/JS/Log.js" type="text/babel"></script>
</head>
<script>
	function listUser(){
		var xmlhttp;   
  		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){
  			if (xmlhttp.readyState==4 && xmlhttp.status==200){
  				document.getElementById("list").innerHTML="<iframe src=\"manager?action=list\" class=frame></iframe>";
  			}
  		}
		xmlhttp.open("GET","manager?action=listUser",true);
		xmlhttp.send();
	}
	function listBook(){
		var xmlhttp;   
  		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){
  			if (xmlhttp.readyState==4 && xmlhttp.status==200){
  				document.getElementById("list").innerHTML="<iframe src=\"manager?action=list\" class=frame></iframe>";
  			}
  		}
		xmlhttp.open("GET","manager?action=listBook",true);
		xmlhttp.send();
	}
	function listOrder(){
		var xmlhttp;   
  		xmlhttp=new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){
  			if (xmlhttp.readyState==4 && xmlhttp.status==200){
  				document.getElementById("list").innerHTML="<iframe src=\"manager?action=list\" class=frame></iframe>";
  			}
  		}
		xmlhttp.open("GET","manager?action=listOrder",true);
		xmlhttp.send();
	}
</script>
<body onload = "listUser()">
    <div id = log></div>
	<p class = welcome>欢迎来到后台管理界面</p>
	<div class = leftbox>
		<div class = option onclick="listUser()">
			<p class = lstyle>用户管理</p>
		</div>
		<div class = option onclick="listBook()">
			<p class = lstyle>书籍管理</p>
		</div>
		<div class = option onclick="listOrder()">
			<p class = lstyle>订单管理</p>
		</div>
	</div>
	<div class = list id = list>
		<iframe src="" class=frame></iframe>
	</div>
</head>

		
		
