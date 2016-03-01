<jsp:useBean id="TestModel" scope="request" type="com.russ4stall.webapp.home.TestModel"/>
<%--
  Created by IntelliJ IDEA.
  User: russellf
  Date: 3/1/2016
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>TEST JSP</h1>
<p>${TestModel.name}</p>
</body>
</html>
