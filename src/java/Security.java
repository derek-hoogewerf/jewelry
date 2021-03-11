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
//import java.sql.SQLException;
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
public class Security extends HttpServlet 
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
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
              
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelery", "root", "root");
                PreparedStatement s = con.prepareStatement("select Q1, Q2 from info");
                ResultSet rs=s.executeQuery();
            /* TODO output your page here. You may use following sample code. */
                  String Q1=request.getParameter("Q1");
                  String Q2=request.getParameter("Q2");
        int val=0;
            while(rs.next())
            {
            
            if(rs.getString("Q1").equals(Q1)&&rs.getString("Q2").equals(Q2))
            { val=0; break;}
            
            else
                val++;
            }
            if(val==0) response.sendRedirect("yes.jsp");
            else response.sendRedirect("index.html");
        } 
        catch (Exception ex) 
        {
            out.println(ex);
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
