/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Register extends HttpServlet {
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
String n = request.getParameter("n");
String p = request.getParameter("e");
String e = request.getParameter("p");
String Q1 = request.getParameter("Q1");
String Q2= request.getParameter("Q2");
PrintWriter out = response.getWriter();
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelery", "root", "root");
PreparedStatement s = con.prepareStatement("insert into info values (?, ?, ?, ?, ?)");
s.setString(1, n);
s.setString(2, e);
s.setString(3, p);
s.setString(4, Q1);
s.setString(5, Q2);
s.execute();
out.println("Inserted");

}
catch(Exception ex)
{
out.println("Fail"); }
    }
}
