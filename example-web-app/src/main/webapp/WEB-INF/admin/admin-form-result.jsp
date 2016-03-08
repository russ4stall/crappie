<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="model" scope="request" type="com.russ4stall.webapp.admin.AdminFormModel"/>
<html>
<head></head>
<body>
<h1>JSP</h1>
    <table>
        <tr>
            <td>User Name:</td>
            <td>${model.user.name}</td>
        </tr>
        <tr>
            <td>User Email:</td>
            <td>${model.user.email}</td>
        </tr>
        <tr>
            <td>Username:</td>
            <td>${model.username}</td>
        </tr>
        <tr>
            <td>Roles:</td>
            <td>
                <c:forEach var="r" items="${model.role}">
                    <li>${r}</li>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>Some Number:</td>
            <td>${model.someNumber}</td>
        </tr>
    </table>

</body>
</html>