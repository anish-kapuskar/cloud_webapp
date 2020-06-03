<%-- 
    Document   : login
    Created on : 19 Apr, 2020, 3:59:14 AM
    Author     : Lord Aegon
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <script type="text/javascript" >
        function preventBack(){window.history.forward();}
        setTimeout("preventBack()", 0);
        window.onunload=function(){null};
    </script>

    <title>Login</title>
</head>
<body>
<div style="border: 1px solid; padding:30px;opacity: 0.8;background-color: white;">
    <h1>User Login</h1>
    <form:form id="loginForm" modelAttribute="login" action="loginProcess.htm" method="post">
        <table align="center">
            <tr>
                <td>
                    <form:label path="email">Email: </form:label>
                </td>
                <td>
                    <form:input path="email" name="email" id="email"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="password">Password:</form:label>
                </td>
                <td>
                    <form:password path="password" name="password" id="password" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <form:button id="login" name="login" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;">Login</form:button>
                </td>
            </tr>
            <tr></tr>

        </table>
    </form:form>
    <br><br><br>
    <a href="/BookStoreApp_war">Home</a>
</div>
<table align="center">
    <tr>
        <td style="font-style: italic; color: red;">${message}</td>
    </tr>
</table>

</body>
</html>

