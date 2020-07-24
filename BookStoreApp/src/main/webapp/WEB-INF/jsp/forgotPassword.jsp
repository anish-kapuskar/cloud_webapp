<%--
  Created by IntelliJ IDEA.
  User: anishkapuskar
  Date: 7/20/20
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot password</title>
</head>
<body>

<h2>Request password reset:</h2>

<div style="border: 1px solid; padding:30px; opacity: 0.8;background-color: white;">

    <form action="forgot.htm" method="POST">
        Email : <input type="text" name="email"  required>
        <br><br>
        <input type="submit" value="Reset Password" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;">
    </form>



</div>
</form>
</body>
</html>
