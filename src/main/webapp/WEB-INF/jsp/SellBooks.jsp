<%--
  Created by IntelliJ IDEA.
  User: anishkapuskar
  Date: 6/1/20
  Time: 1:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
 <form name='addbooksform' action="addBooks.htm"  method="POST" >
    <h2>Sell Books: ${uname}</h2>
    <h2>Please enter the book details below :</h2>

    <tr>
        <td> <label for='isbn'><b>ISBN</b></label></td>
        <td> <input type='text'  name='isbn' required><br></td>
    </tr>
    <tr>
        <td><label for='title'><b>Title</b></label> </td>
        <td> <input type='text'  name='title' required><br></td>
    </tr>
    <tr>
        <td><label for='authors'><b>Authors</b></label> </td>
        <td><input type='text'  name='authors' required><br> </td>
    </tr>
    <tr>
        <td><label for='date'><b>Publication Date</b></label> </td>
        <td><input type='date'  name='date' required><br> </td>
    <tr>
        <td><label for='quantity'><b>Quantity (Max. 999)</b></label> </td>
        <td><input type='number'  name='quantity' pattern="^([0-9]|[1-9][0-9]|[1-9][0-9][0-9])$" required> </td>
    </tr>
    <tr>
        <td><label for='price'><b>Price (Min. 0.01 and Max. 9999.99)</b></label> </td>
        <td><input type='text'  name='price'  required> </td>
    </tr>
     <tr>

         <td><input type='file'  name='file'> </td>
     </tr>
     <tr>

         <td><input type='file'  name='file2'> </td>
     </tr>
     <tr>

         <td><input type='file'  name='file3'> </td>
     </tr>
    <tr>

        <td><input type='hidden'  name='seller' value='${uname}'  required> </td>
    </tr>
    <tr>

        <td><input type='hidden'  name='time' id ='time' value=""  required> </td>
    </tr>
    <script>
        var t = new Date();
        document.getElementById("time").value = t;
    </script>
    </table><br>


    <input type="submit" name="submit" value="Add Book"/>


</form>

 <form action="s3controller.htm" method="post">
     <input type="submit" name="option" value="Add image"/><br>
 </form>

</body>
</html>
