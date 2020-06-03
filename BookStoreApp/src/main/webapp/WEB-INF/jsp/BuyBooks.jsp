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

<h2>Edit your uploaded Books: ${uname2}</h2>

    <div style="border: 1px solid; padding:30px; opacity: 0.8;background-color: white;">

        <form action="browseBook.htm" method="POST">
            <input type="hidden" name="key" value="${uname2}"  required>
            <br>
            <input type="hidden"  name="by" value="seller">
            <br>
<input type="submit" value="Edit/Update/Delete your uploaded books" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;">
  </form>



    </div>
</form>
</body>
</html>
