<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Upload the song.</title>
</head>
<body>
<h2>Upload the song.</h2>
<table>
    <form:form modelAttribute="uploadTheSong" method="post">
        <table>
            <tr>
                <th>The song:</th>
                <td>
                    <form:input path="theSong"/>
                </td>
            </tr>
            <tr>
                <th>Singer:</th>
                <td>
                    <form:input path="singer"/>
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <form:select path="category">
                        <form:option value="pop">pop</form:option>
                        <form:option value="pop-ballad">pop-ballad</form:option>
                        <form:option value="R&B">R&B</form:option>
                        <form:option value="rap">rap</form:option>
                        <form:option value="rock">rock</form:option>
                        <form:option value="country-music">country-music</form:option>
                    </form:select>
                </td>
            </tr>

            <tr>
                <th>Link:</th>
                <td>
                    <form:input path="link"/>
                </td>
            </tr>
        </table>
        <input type="submit" value="Upload">
    </form:form>
</table>
</body>
</html>
