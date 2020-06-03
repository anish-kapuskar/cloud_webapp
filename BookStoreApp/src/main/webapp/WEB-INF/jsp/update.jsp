<%--
  Created by IntelliJ IDEA.
  User: anishkapuskar
  Date: 6/3/20
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
    Document   : register
    Created on : 19 Apr, 2020, 3:58:12 AM
    Author     : Lord Aegon
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>Update User</title>
</head>
<body>
<div style="border: 1px solid; padding:30px;opacity: 0.8;background-color: white;">
    <h1>Update User</h1>
    <form:form id="updateForm" modelAttribute="user" action="updateProcess.htm" method="post">
        <table align="center">
            <tr>
                <td>
                    <form:label path="email">Email : ${username}</form:label>
                </td>
                <td>
                    <form:input type="hidden" path="email" name="email" id="email" value="${username}" readonly="true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="password">Password</form:label>
                </td>
                <td>
                    <form:password path="password" name="password" id="password" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$" required="required" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="firstname">FirstName</form:label>
                </td>
                <td>
                    <form:input path="firstname" name="firstname" id="firstname" required="required" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="lastname">LastName</form:label>
                </td>
                <td>
                    <form:input path="lastname" name="lastname" id="lastname" required="required"/>
                </td>
            </tr>



            <tr>
                <td></td>
                <td>
                    <form:button id="register" name="register" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;">Register</form:button>
                </td>
            </tr>
            <tr></tr>

        </table>
    </form:form>
    <br><br><br>
    <a href="/BookStoreApp_war">Home</a>
</div>
</body>
</html>
