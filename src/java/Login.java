/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Login extends HttpServlet 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter pw=response.getWriter();
       String username=request.getParameter("name");
             String password=request.getParameter("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelery", "root", "root");
             PreparedStatement s = con.prepareStatement("select name, password from info");
            //s.setString(1, username);
            //s.setString(2, password);
            ResultSet rs=s.executeQuery();
            int val=0;
            while(rs.next()){
            
            if(rs.getString("name").equals(username)&&rs.getString("password").equals(password))
            { val=0; break;}
            
            else
                val++;
            }
            if(val>0) response.sendRedirect("no.html");
            else response.sendRedirect("yes.jsp");
        }
        catch(Exception e)
        {
          pw.println(e);
        }
    }
}