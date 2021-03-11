<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Customer DETAILS PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>body{background-color:lightblue;}table{background-color: whitesmoke}</style>
    </head>
    <body>
        <form method="post" action="customer">
            <div>Registration Details</div>
            Serial Number:  <input type="text" name="serial_no"><br/>
            Name:   <input type="text" name="name"><br/>
            Email:  <input type="text" name="email"><br>
            Phone Number:   <input type="text" name="phone"><br>
            <div>&nbsp;</div><br/>
           
      
            <input type="submit" value="Insert"><br/><br/>
           <!-- <input type="button" value="Delete"><br/><br/>-->
            <input type="button" value="Back " onclick="window.location='yes.jsp';">
        </form>
    </body>
  
        <body>
        <form>
        <h1>Results:</h1>
        <div><%
            try{
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch(Exception e)
            {
             out.println(e);   
            }
            Connection con=null;
            ResultSet rs=null;
            %>
            <table border="3" width="50%" height="75%">
                <tr>
                    <th>Serial no.</th>
                    <th> Name </th>
                    <th>Email id</th>
                    <th> Phone No. </th>
            </tr>
            <%
                try{
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelery","root","root");
                PreparedStatement pst=con.prepareStatement("select * from customer");
                rs=pst.executeQuery();
                while(rs.next()){
                    %>
                    <tr>
                        <td><%=rs.getString("serial_no")%></td>
                        <td><%=rs.getString("name")%></td>
                        <td><%=rs.getString("email")%></td>
                        <td><%=rs.getString("phone_no")%></td>
                        
                    </tr>
             <%
                }
                }
                catch(Exception e)
                {
                 out.println("Error");
                 out.println(e);
                }
                %>
            </table>
            
        </div>
            <br/>
            <br/>
            <br/>
            
        </form>
    </body>
</html>
