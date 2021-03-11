<%-- 
    Document   : yes.jsp
    Created on : Nov 2, 2019, 3:38:48 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="bodystyule.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>body{background-color:lightblue;}table{background-color: whitesmoke}</style>
    </head>
    
    <body>
        
        <form action="printing" method="Post">
            <br/><br/><br/>
            <input type="button" value="Sign Out" onclick="window.location='index.html';"><br/><br/>
            
          <!--  <input type="button" value="UPDATE" onclick="window.location='update.jsp';"> -->
            <input type="button" value="Filter" onclick="window.location='filterpage.html';">
            <input type="button" value="Update" onclick="window.location='update.jsp';">
            <input type="button" value="Customer Details" onclick="window.location='customer.jsp';">
            <input type="button" value="Register New User" onclick="window.location='register.html';">
          <input type="submit" value="Download Product List">
            <br/><br/><br/>
        </form>
    </body>
    <body>
       <!--  <form method="post" action="update">
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
            <div><input type="submit" value="Procede"> <-- <input type="button" value="Back" onclick="window.location='yes.jsp'"></div>
        </form>-->   
        <form>
        <h1>Results:</h1>
        <div><%
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch(Exception e){
                
            }
            Connection con=null;
            ResultSet rs=null;
            %>
            <table border="3" width="100%">
                <tr>
                    <th>Serial no</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th> Price </th>
                    <th>Tax(GST)</th>
                    <th>Gold Weight</th>
                    <th>Diamond Weight</th>
                    <th>Status</th>
                    <th>Image</th>
            </tr>
            <%
                try{
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelery","root","root");
                PreparedStatement pst=con.prepareStatement("select * from items");
                rs=pst.executeQuery();
                while(rs.next()){
                    %>
                    <tr><td><%=rs.getString("serial_no")%></td>
                        <td><%=rs.getString("name")%></td>
                        <td><%=rs.getString("category")%></td>
                        <td><%=rs.getString("price")%></td>
                        <td><%=rs.getInt("price")*3/100%></td>
                        <td><%=rs.getString("gold_wt")%></td>
                        <td><%=rs.getString("dia_wt")%></td>
                        <td><%=rs.getString("status")%></td>
                        <td width="25%"><img src="<%=rs.getString("image") %>" height="400" width="400"></td>
                    </tr>
             <%
                }
                }
                catch(Exception e)
                {
                out.println(e);
                    
                }
                %>
            </table>
            
        </div>
            <br>
            <br>
            <br>
            
        </form>
    </body>
    
</html>
