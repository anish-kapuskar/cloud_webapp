<%--
  Created by IntelliJ IDEA.
  User: anishkapuskar
  Date: 5/31/20
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body bgcolor="skyblue">
<h1>User Portal</h1>
<div style="border: 1px solid; padding:30px; opacity: 0.8;background-color: white;">
    <form action="login.htm" method="get">

        <input type="submit" name="option" value="Login" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;"/>
    </form> <br><br>
    <form action="register.htm" method="get">

        <input type="submit" name="option" value="Register" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;"/>
    </form>
</div>
</body>
</html>
