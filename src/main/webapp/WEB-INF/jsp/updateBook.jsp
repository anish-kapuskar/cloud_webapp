<%-- 
    Document   : updateBook
    Created on : 20 Apr, 2020, 6:44:44 PM
    Author     : Lord Aegon
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
                <h2>Update/Edit Book Upload</h2>
        <form action="updateBook.htm" method="post">
            Id<input type="text" name="id" value="${message.getId()}" readonly><br><br>
            ISBN<input type="text" name="isbn" value="${message.getIsbn()}" ><br><br>
            Title<input type="text" name="title" value="${message.getTitle()}" ><br><br>
            Authors<input type="text" name="authors" value="${message.getAuthors()}" ><br><br>
            Date<input type="text" name="date" value="${message.getDate()}"><br><br>
            Quantity<input type="text" name="quantity" value="${message.getQuantity()}"><br><br>
            Price<input type="text" name="price" value="${message.getPrice()}"><br><br>
            Seller<input type="text" name="seller" value="${message.getSeller()}"><br><br>
            <input type="hidden" name="time" id ='time' value="">
            <script>
                var t = new Date();
                document.getElementById("time").value = t;
            </script>
            <br><br>
            <input type="hidden" name="option" value="updateBook">
            <input type="submit" name="submit" value="Update Book">
        </form>
            </div>
    </body>
</html>
