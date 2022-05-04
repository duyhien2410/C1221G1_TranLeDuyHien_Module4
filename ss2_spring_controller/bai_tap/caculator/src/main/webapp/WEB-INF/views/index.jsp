<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Caculator</h2>
  <form action="/caculator">
    <input type="number" name="number1" placeholder="Input number 1" value="0">
    <input type="number" name="number2" placeholder="Input number 2" value="0">

    <input type="submit" name="caculator" value="+">
    <input type="submit" name="caculator" value="-">
    <input type="submit" name="caculator" value="*">
    <input type="submit" name="caculator" value="/">
  </form>

  <p>Result: ${result}</p>

  </body>
</html>
