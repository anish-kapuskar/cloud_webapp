<%-- 
    Document   : Welcome
    Created on : 17-Feb-2020, 4:49:33 PM
    Author     : anish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="jumbotron" style="opacity:0.8">


    <div class="container">


        <div class="card" style="width: 18rem;">

            <div class="card-body">
                <h5 class="card-title">Welcome to the Book Store!</h5>
                <p class="card-text">Login / Register<br></p><br><br>

                <form action="go.htm" method="post">

                    <input type="submit" name="option" value="Go" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;"/>
                </form>

            </div>
        </div>
