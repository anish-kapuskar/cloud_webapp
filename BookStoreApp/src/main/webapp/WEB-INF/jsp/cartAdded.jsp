<%--
  Created by IntelliJ IDEA.
  User: anishkapuskar
  Date: 6/2/20
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>User:${uname}, ${message}</h1>

<div style="border: 1px solid; padding:30px;opacity: 0.8;background-color: white;">
    <form action="cart.htm" method="post">
        <input type="hidden" name="uname" value="${uname}">

        <input type="hidden" name="option" value="viewCart" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;">
        <input type="submit" name="submit" value="View Cart">

    </form>  <br></div>

<a href="/BookStoreApp_war">Go back</a>
</body>
</html>
