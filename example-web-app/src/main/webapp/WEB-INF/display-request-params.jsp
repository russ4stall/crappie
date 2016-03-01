<%--
  Created by IntelliJ IDEA.
  User: russellf
  Date: 3/1/2016
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <title></title>
</head>
<body>
<p>
    <h2>Request Params</h2>
    <ul>
        <c:forEach var="par" items="${paramValues}">
            <li>
                <strong>${par.key}</strong> = ${par.value[0]}
            </li>
        </c:forEach>
    </ul>
</p>
</body>
</html>
