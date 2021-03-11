/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Download extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     */
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
response.setContentType("text/html;charset=UTF-8");
        String file = request.getParameter("file");
        try {
            download(request, response, file);
        } catch (ServletException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
        }
}

private void download(HttpServletRequest request, HttpServletResponse response, String file) throws ServletException , IOException
    {
int l = 0;
/*try{
ServletContext sc = getServletConfig().getServletContext();
response.setContentType((sc.getMimeType(file)!=null)? sc.getMimeType(file):"applicationtxt");
response.setHeader("Content-Disposition", "attachment; filename=\""+file);
InputStream is = sc.getResourceAsStream("/"+file);
try{
  Class.forName("com.mysql.jdbc.Driver");
                 Connection    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelery","root","root");
                 PreparedStatement pst=con.prepareStatement("SELECT * FROM items");
                 ResultSet rs=pst.executeQuery();
                FileWriter o = new FileWriter("output.txt");
                   // FileOutputStream o = new fileOutputStream(new file(output.txt))) {
                  //  out.println("File selected");
          //  out.println(rs.getString("serial_no"));
            //out.println(rs.getString("name"));
           // out.println(rs.getString("category"));
          BufferedWriter bw = new BufferedWriter(o);
           
            while(rs.next())
                {
                    bw.write(rs.getString("serial_no"),0,rs.getString("serial_no").length());
                    
                    bw.write(Integer.parseInt(rs.getString("serial_no")));
                 
                    bw.write(rs.getString("name"));
                    
                    bw.write(rs.getString("category"));
                    
                    bw.write(rs.getString("status"));
                    
                    bw.write(rs.getString("price"));
                    
                    bw.write(rs.getString("gold_wt"));
                    
                    bw.write(rs.getString("dia_wt"));
                    bw.newLine();
                   
                } 
            o.close();
}catch(Exception e){
    
}
             //o.flush();
/*byte b [] = new byte [1024];
while((is != null) && (l = is.read(b)) != -1)
            {
o.write(b, 0, l);
            }
o.flush();
        }catch(Exception ex){}
*/
    }
}

