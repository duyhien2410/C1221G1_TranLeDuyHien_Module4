<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h2>Settings</h2>
<form:form action="" modelAttribute="setting" method="post">
    <table>
        <tr>
            <th>Languages:</th>
            <td>
                <form:select path="languages">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Page Size:</th>
            <td>
                Show
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <th>Spams filter:</th>
            <td>
                <form:checkbox path="spamsFilter"/>
                <span>Enable spams filter</span>
            </td>
        </tr>
        <tr>
            <th>Signature:</th>
            <td>
                <form:textarea cols="30" rows="10" path="signature"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="Update">
    <input type="reset" value="Cancel">
</form:form>
</body>
</html>
