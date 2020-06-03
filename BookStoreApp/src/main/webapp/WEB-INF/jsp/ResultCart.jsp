<%--
  Created by IntelliJ IDEA.
  User: anishkapuskar
  Date: 6/2/20
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body bgcolor="skyblue" >
<div style="border: 1px solid; padding:30px; opacity: 0.8;background-color: white;">

    <h3>Here is your Cart, User ${uname}: </h3>
    <br>

    <c:if test="${empty cart}">

        <h4>No Results Found.!</h4>

    </c:if>

    <c:if test="${not empty cart}">

        <table border="1">
            <tr>
                <th>ISBN </th>
                <th>Title </th>
                <th>Authors </th>
                <th>Date Published </th>
                <th>Quantity </th>
                <th>Price</th>
                <th>Buyer</th>
                <th>Time of buying</th>

            </tr>
            <c:forEach var="cart" items="${cart}">
                <tr>
                    <td><c:out value=" ${cart.getIsbn()} " /></td>
                    <td><c:out value=" ${cart.getTitle()} " /></td>
                    <td><c:out value=" ${cart.getAuthors()} " /></td>
                    <td><c:out value=" ${cart.getDate()} " /></td>
                    <td><c:out value=" ${cart.getQuantity()} " /></td>
                    <td><c:out value=" ${cart.getPrice()} " /></td>
                    <td><c:out value=" ${cart.getBuyer()} " /></td>
                    <td><c:out value=" ${cart.getTime()} " /></td>

                    <td>
                       <a href="deleteCart.htm?option=delete&id=${cart.getId()}&uname=${uname}">Remove from Cart</a>
                    </td>
                </tr>
            </c:forEach>
        </table>



    </c:if>
    <br><br><br>


    <a href="/BookStoreApp_war">Home</a>
</div>
</body>
</html>



