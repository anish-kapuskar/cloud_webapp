<%--
  Created by IntelliJ IDEA.
  User: anishkapuskar
  Date: 6/2/20
  Time: 3:38 PM
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




    <br>

    <h3>Please browse through these book listings, ${uname}: </h3>
    <br>

    <c:if test="${empty book}">

        <h4>No Results Found.!</h4>

    </c:if>

    <c:if test="${not empty book}">

        <table border="1">
            <tr>
                <th>ISBN </th>
                <th>Title </th>
                <th>Authors </th>
                <th>Date Published </th>
                <th>Quantity </th>
                <th>Price</th>
                <th>Seller</th>
                <th>Time of upload/update</th>

            </tr>
            <c:forEach var="book" items="${book}">
                <tr>
                    <td><c:out value=" ${book.getIsbn()} " /></td>
                    <td><c:out value=" ${book.getTitle()} " /></td>
                    <td><c:out value=" ${book.getAuthors()} " /></td>
                    <td><c:out value=" ${book.getDate()} " /></td>
                    <td><c:out value=" ${book.getQuantity()} " /></td>
                    <td><c:out value=" ${book.getPrice()} " /></td>
                    <td><c:out value=" ${book.getSeller()} " /></td>
                    <td><c:out value=" ${book.getTime()} " /></td>

                    <td>
                        <a href="cart.htm?option=cart&id=${book.getId()}&uname=${uname}">Add to Cart</a>
                    </td>
                </tr>
            </c:forEach>
        </table>



    </c:if>
    <br><br><br>

    <div style="border: 1px solid; padding:30px;opacity: 0.8;background-color: white;">
        <form action="cart.htm" method="post">
            <input type="hidden" name="uname" value="${uname}">

            <input type="hidden" name="option" value="viewCart" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;">
            <input type="submit" name="submit" value="View Cart">

        </form>  <br></div>

    <a href="/BookStoreApp_war">Home</a>
</div>
</body>
</html>


