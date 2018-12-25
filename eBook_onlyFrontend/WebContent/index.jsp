<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>摘书阁</title>
    <link rel="stylesheet" type="text/css" href="files/CSS/home.css"/>
    <script src = "react/build/react.js"></script>
    <script src = "react/build/react-dom.js"></script>
    <script src = "react/build/browser.min.js"></script>
    <script src="files/JS/index.js" type="text/babel"></script>
    <script src="files/JS/Login.js" type="text/babel"></script>
</head>
<body>
    <div id = "Login" userName = "<%= session.getAttribute("username")%>"></div>
    <div class = "main">
        <div id = "D1"></div>
        <div id = "D2"></div><hr />
        <div id = "D3"></div>
    </div>
</body>
</html>