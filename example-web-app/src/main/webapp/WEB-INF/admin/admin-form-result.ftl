<#-- @ftlvariable name="" type="com.russ4stall.webapp.admin.AdminFormModel" -->
<html>
<head></head>
<body>
<h1>FreeMarker Template</h1>
    <table>
        <tr>
            <td>User Name:</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>User Email:</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>Username:</td>
            <td>${username}</td>
        </tr>
        <tr>
            <td>Roles:</td>
            <td>
                <#list role as r>
                    <li>${r}</li>
                </#list>
            </td>
        </tr>
        <tr>
            <td>Some Number:</td>
            <td>${someNumber}</td>
        </tr>
    </table>

</body>
</html>