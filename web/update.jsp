<%-- 
    Document   : update.jsp
    Created on : Nov 2, 2019, 8:36:16 PM
    Author     : user
--%>

<%@page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head><style>body{background-color:lightblue;}table{background-color: whitesmoke}</style></head>
    <body>
        <form method="post" action="update">
            <table border="3">
                <tr>
                    <td>Serial Number</td>
                    <td><input type="text" name="serial" value=""></td>
                </tr>
                <tr>
                    <th>Name </th>
                    <td><input type="text" name="name" value=""></td>
                </tr>
                <tr>
                    <th>Category</th>
                    <td><input ype="text" name="category" value=""></td>
                </tr>
                <tr>
                    <th>Status</th>
                    <td><input type="text" name="status" value=""></td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td><input type="text" name="price" value=""></td>
                </tr>
                <tr>
                    <td>Gold Weight</td>
                    <td><input type="text" name="gw" value=""></td>
                </tr>
                <tr>
                    <td>Diamond Weight</td>
                    <td><input type="text" name="dw" value=""></td>
                </tr>
                 <tr>
                    <th>Image Name</th>
                    <td><input type="text" name="image" value=""></td>
</tr>
            </table>
            <br>
            <input type="radio" name="meth" value="insert">  Insert  
            <input type="radio" name="meth" value="update">  Update  
            <input type="radio" name="meth" value="delete">  Delete  
            <br><br><br>
            <div><input type="submit" value="Proceed">  <input type="button" value="Back" onclick="window.location='yes.jsp'"></div>
        </form>   
    </body>    
<html>