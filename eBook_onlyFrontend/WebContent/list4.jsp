<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>随遇而安</title>
    <link rel="stylesheet" type="text/css" href="files/CSS/page.css"/>
    <script src = "react/build/react.js"></script>
    <script src = "react/build/react-dom.js"></script>
    <script src = "react/build/browser.min.js"></script>
    <script src = "files/JS/Login.js" type="text/babel"></script>
    <script src = "files/JS/Log.js" type="text/babel"></script>
    <script src = "files/JS/TextOfPage4.js" type="text/babel"></script>
    <script src = "files/JS/ButtonOfPage1.js" type="text/babel"></script>
    <script src = "files/JS/ButtonOfPage2.js" type="text/babel"></script>
    <script src = "files/JS/ButtonOfPage3.js" type="text/babel"></script>
    <script src = "files/JS/BookList.js" type="text/babel"></script>
</head>
<body>
    <div id = "Login" userName = "<%= session.getAttribute("username")%>"></div>
    <div class = "leftbox">
        <div id = log></div>
        <div id = "B1"></div>
        <div id = "B2"></div>
        <div id = "B3"></div>
        <div id = "T4"></div>
    </div>
    <div id = "booklist"></div>
</body>
</html>

		
		
