<%-- 
    Document   : welcome2
    Created on : 19 Apr, 2020, 3:59:56 AM
    Author     : Lord Aegon
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
    <script type="text/javascript" >
        function preventBack(){window.history.forward();}
        setTimeout("preventBack()", 0);
        window.onunload=function(){null};
    </script>
</head>
<body>


<h2>     Welcome, User ${email}   </h2>

<div style="border: 1px solid; padding:30px;opacity: 0.8;background-color: white;">


    <form action="browseBook.htm" method="POST">
        <input type="hidden"  name="by" value="all">
        <input type="hidden" name="key" value="${email}"  required>
        <br>

        <input type="hidden" name="uname" value="${email}">
        <input type="submit" value="Browse/Buy New books" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;">
    </form><br><br>

    <div style="border: 1px solid; padding:30px;opacity: 0.8;background-color: white;">
    <form action="book.htm" method="post">
        Upload your Books to Sell:
        <input type="hidden" name="uname" value="${email}">

        <input type="submit" name="option" value="Sell Books" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;"/><br>
    </form>  <br>
    <form action="book.htm" method="post">
        Edit your uploaded Books:
        <input type="hidden" name="uname2" value="${email}">
        <input type="submit" name="option" value="Edit Books" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;"/>
    </form>
    </div>

</div>


<div style="border: 1px solid; padding:30px; opacity: 0.8;background-color: white;">
    <h3>Your Profile Details:</h3><br>
    <p> First Name : ${firstname} </p><br>
    <p> Last Name : ${lastname} </p><br>
    <p> Email Name : ${email} </p><br>
    <br>

    <form action="logout.htm" method="get">
        <input type="submit" value="Logout">
    </form>
    <br> <br> <br> <br>



    <div style="border: 1px solid; padding:30px; opacity: 0.8;background-color: white;">
        <p>
            Update Account:
        </p>
        <form action="update.htm" modelAttribute="user" method="post">
     <!--       Email :  <input type="text" name="email" id="email" value="${email}" disabled> <br>
            Password: <input type="password" name="password" id="password"> <br>
            First Name : <input type="text" name="firstname" id="firstname"><br>
            Last Name : <input type="text" name="lastname" id="lastname"><br> -->
            <input type="hidden" name="username" value="${email}">
            <input type="submit" id="register" name="register" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;">
        </form>
    </div>

</div>





</body>
</html>