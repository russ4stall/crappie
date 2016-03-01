<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:useBean id="model" scope="request" type="com.russ4stall.webapp.home.TestModel"/>--%>
<%--
  Created by IntelliJ IDEA.
  User: russellf
  Date: 3/1/2016
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css">
</head>
<body>
<p>
  <c:if test="${!empty model.getClass().getDeclaredFields()}">
    <h2>Object Attributes <em>&dollar;{object.name}</em></h2>
    <ul>
      <c:forEach var="attr" items="${model.getClass().getDeclaredFields()}">
        <c:catch><li><strong>${attr.name}: </strong>${model[attr.name]}</li></c:catch>
      </c:forEach>
    </ul>
  </c:if>
</p>
</body>
</html>
