
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>body{background-color:lightblue;}table{background-color: whitesmoke}</style>
    </head>
    <body>
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
                <tr><td>Serial no</td><td>Name</td><td>Category</td><td> Price </td><td>Gold Weight</td><td>Diamond Weight</td><td>Status</td><td>Image</td>
            </tr>
            <%
                try{
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelery","root","root");
                PreparedStatement pst=con.prepareStatement("select * from items where status='available'");
                rs=pst.executeQuery();
                while(rs.next()){
                    %>
                    <tr><td><%=rs.getString("serial_no")%></td>
                        <td><%=rs.getString("name")%></td>
                        <td><%=rs.getString("category")%></td>
                        <td><%=rs.getString("price")%></td>
                        <td><%=rs.getString("gold_wt")%></td>
                        <td><%=rs.getString("dia_wt")%></td>
                        <td><%=rs.getString("status")%></td>
                        <td width="25%"><img src="<%=rs.getString("image") %>" height="400" width="400"></td>
                    </tr>
             <%
                }
                con.close();
                }
                catch(Exception e){
                    
                }
                %>
            </table>
            
        </div>
    </body>
</html>
