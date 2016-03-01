<%--
  Created by IntelliJ IDEA.
  User: russellf
  Date: 3/1/2016
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Admin Form</h1>

<form action="/admin/submitForm">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="user.name"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="user.email"/></td>
        </tr>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>Role</td>
            <td><input type="text" name="role"/></td>
        </tr>
        <tr>
            <td>Some Number</td>
            <td><input type="text" name="someNumber"/></td>
        </tr>
        <tr>
            <td><button type="submit">SUBMIT</button></td>
        </tr>
    </table>
</form>
</body>
</html>
