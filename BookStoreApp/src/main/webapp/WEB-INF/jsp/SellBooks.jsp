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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
<form name='addbooksform' action="addBooks.htm"  method="post">
    <h2>Sell Books: ${uname}</h2>
    <h2>Please enter the book details below :</h2>
    <br>
    <tr>
        <td> <label for='isbn'><b>ISBN</b></label></td> <br>
        <td> <input type='text'  name='isbn' required><br></td>
    </tr><br>
    <tr>
        <td><label for='title'><b>Title</b></label> </td><br>
        <td> <input type='text'  name='title' required><br></td>
    </tr><br>
    <tr>
        <td><label for='authors'><b>Authors</b></label> </td><br>
        <input type="text" id="txt1" value="" /><br>
        <input type="text" id="txt2" value="" /><br>
        <input type="text" id="txt3" value="" /><br>
        <button onclick="add()">Add Authors</button>
    <td><input type='hidden' id ="join" name='authors' value="" required><br> </td>
        <script>
            function add() {
                var values = $("#txt1, #txt2, #txt3").map(function () {
                    return this.value;
                }).get().join(",");
                document.getElementById('join').value = values;
            }
        </script>
    </tr><br>
    <tr>
        <td><label for='date'><b>Publication Date</b></label> </td><br>
        <td><input type='date'  name='date' required><br> </td>
    <tr><br>
        <td><label for='quantity'><b>Quantity (Max. 999)</b></label> </td><br>
        <td><input type='number'  name='quantity' pattern="^([0-9]|[1-9][0-9]|[1-9][0-9][0-9])$" required> </td>
    </tr><br>
    <tr>
        <td><label for='price'><b>Price (Min. 0.01 and Max. 9999.99)</b></label> </td><br>
        <td><input type='text'  name='price'  required> </td>
    </tr><br>
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
</body>
</html>
