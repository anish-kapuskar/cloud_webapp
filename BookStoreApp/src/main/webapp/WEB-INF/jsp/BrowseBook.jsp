

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body bgcolor="skyblue" style="background-image: url('https://wallpaperplay.com/walls/full/1/2/9/13978.jpg')">
       <h1>Search Book Appointments</h1>
               <div style="border: 1px solid; padding:30px; opacity: 0.8;background-color: white;">

 <!--      <form action="browseBook.htm" method="GET">
           Keyword : <input type="text" name="key"/><br><br>
           <input type="radio" name="by" value="name"/> Search by Book's Name <br>
           <input type="radio" name="by" value="email"> Search by Email ID<br>
           <input type="radio" name="by" value="date"> Search by Date<br><br>
           <input type="submit" name="submit" value="search"/><br>
       </form>  
 -->
                   
                    <form action="browseBook.htm" method="POST">

                        Search Term: <br>
                       
                          <input type="text" name="key"  required>
                          <br>
                  
                    
                    
                        <input type="radio"  name="by" value="name">
                        Search By Name<br>
                  
                    
                        <input type="radio" name="by" value="email">
                        Search By Email<br>
                     
                  
                        <input type="radio"  name="by" value="date">
                   Search By Date<br>
                   
                    
                    <br/>

                    <input type="submit" value="submit" style="background-color: #4CAF50; border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;">
                


            
            </form>
                   
               </div>
    </body>
</html>
