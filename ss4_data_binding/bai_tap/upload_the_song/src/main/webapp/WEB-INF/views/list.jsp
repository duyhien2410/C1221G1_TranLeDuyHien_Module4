<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>List the song</h2>
<table>
    <tr>
        <th>The song</th>
        <th>Singer</th>
        <th>Category</th>
        <th>Link</th>
    </tr>

    <c:forEach var="song" items="${listSong}">
        <tr>
            <td><c:out value="${song.theSong}"/></td>
            <td><c:out value="${song.singer}"/></td>
            <td><c:out value="${song.category}"/></td>
            <td><a href="<c:out value="${song.link}"/>"><c:out value="${song.link}"/></a></td>
        </tr>
    </c:forEach>

    <tr>
        <td>
            <a href="/uploads">Upload the song.</a>
        </td>
    </tr>

</table>
</body>
</html>
