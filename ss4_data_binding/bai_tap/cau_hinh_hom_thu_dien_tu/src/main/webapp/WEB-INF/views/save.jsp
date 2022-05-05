<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Settings</title>
</head>
<body>
<table>
    <tr>
        <th>Languages:</th>
        <td>${settings.languages}</td>
    </tr>
    <tr>
        <th>Page Size:</th>
        <td>${settings.pageSize}</td>
    </tr>
    <tr>
        <th>Spams filter:</th>
        <td>${settings.spamsFilter}</td>
    </tr>
    <tr>
        <th>Signature:</th>
        <td>${settings.signature}</td>
    </tr>
</table>
</body>
</html>
