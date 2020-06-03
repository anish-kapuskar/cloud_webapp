<%--
  Created by IntelliJ IDEA.
  User: anishkapuskar
  Date: 6/2/20
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>View your Cart: ${uname}</h2>

<div style="border: 1px solid; padding:30px; opacity: 0.8;background-color: white;">

    <form action="dispCart.htm" method="POST">
        <input type="hidden" name="key" value="${uname}"  required>
        <br>
        <input type="hidden"  name="by" value="buyer">
        <input type="hidden"  name="uname" value="${uname}">
        <br>
        <input type="submit" value="View Cart" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;">
    </form>



</div>
</form>
</body>
</html>
