/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedWriter;
import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */
public class printing extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
               out.println("<html>");
               out.println("<head><style>body{background-color:lightblue;}</style></head>");
               out.println("<body>");
               
               try{
  Class.forName("com.mysql.jdbc.Driver");
                 Connection    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelery","root","root");
                 PreparedStatement pst=con.prepareStatement("SELECT * FROM items");
                 ResultSet rs=pst.executeQuery();
               FileWriter o = new FileWriter("C://Users/user/Downloads/output.txt");
    
           
            while(rs.next())
                {
                    o.write("serial no=");
                    o.write(rs.getString("serial_no"));
                    o.write("| ");
                    o.write("name=");
                    o.write(rs.getString("name"));
                    o.write("| ");
                    o.write("category=");
                    o.write(rs.getString("category"));
                    o.write("| ");
                    o.write("status=");
                    o.write(rs.getString("status"));
                    o.write("| ");
                    o.write("price=");
                    o.write(rs.getString("price"));
                    o.write("| ");
                    o.write("gold wt=");
                    o.write(rs.getString("gold_wt"));
                    o.write("| ");
                    o.write("dia wt=");
                    o.write(rs.getString("dia_wt"));
                    o.write("\r\n");
                    o.write("\r\n");
                }
            o.flush();
            o.close();
            out.println("The file has been downloaded to Downloads");
               //out.println("<a href=Download?file=output.txt>Download</a>");
               out.println("</body>");
               out.println("</html>");
               }
       catch(Exception ex){
               
               }
    }
}
