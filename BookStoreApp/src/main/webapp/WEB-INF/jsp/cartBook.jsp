<%--
  Created by IntelliJ IDEA.
  User: anishkapuskar
  Date: 6/2/20
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body style="background-image: url('https://wallpaperplay.com/walls/full/1/2/9/13978.jpg')">
<div style="border: 1px solid; padding:30px;opacity: 0.8;background-color: white;">
    <h2>Add to cart</h2>
    <form action="cart.htm" method="post">
        Id<input type="text" name="id" value="${message.getId()}" readonly><br><br>
        ISBN<input type="text" name="isbn" value="${message.getIsbn()}" readonly><br><br>
        Title<input type="text" name="title" value="${message.getTitle()}" readonly><br><br>
        Authors<input type="text" name="authors" value="${message.getAuthors()}" readonly><br><br>
        Date<input type="text" name="date" value="${message.getDate()}" readonly><br><br>
        Quantity<input type="text" name="quantity" value="${message.getQuantity()}"><br><br>
        Price<input type="text" name="price" value="${message.getPrice()}" readonly><br><br>
        Buyer<input type="text" name="buyer" value="${uname}" readonly><br><br>
        <input type="hidden" name="time" id ='time' value="">
        <script>
            var t = new Date();
            document.getElementById("time").value = t;
        </script>
        <br><br>
        <input type="hidden" name="uname" value="${uname}">
        <input type="hidden" name="option" value="cartBook">
        <input type="submit" name="submit" value="Add to Cart">
    </form>
</div>
</body>
</html>

