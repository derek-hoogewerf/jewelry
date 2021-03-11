import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class update extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String meth = request.getParameter("meth");
        String ser= request.getParameter("serial");
        String name = request.getParameter("name");
        String cat = request.getParameter("category");
        String stat= request.getParameter("status");
        String price=request.getParameter("price");
        String dw= request.getParameter("dw");
        String gw= request.getParameter("gw");
        String img= request.getParameter("image");
        PrintWriter out=response.getWriter();
        String S="Successful";
        Cookie c= new Cookie("meth",S);
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e1){
        }
        
        if(meth.equals("insert")){
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelery", "root", "root");
                PreparedStatement s = con.prepareStatement("INSERT INTO items values (?, ?, ?, ?, ?, ?, ?, ?)");
                s.setString(1, ser);
                s.setString(2, name);
                s.setString(3, cat);
                s.setString(4, stat);
                s.setString(5, price);
                s.setString(6, gw);
                s.setString(7, dw);
                s.setString(8, img);
                s.execute();
                out.println(ser);
                out.println("insert successful/");
                response.addCookie(c);
                //Cookie c[]=request.getCookies();
                con.close();
                for(int i=0;i<10000;i++)
                {continue;}
               response.sendRedirect("yes.jsp");
               }
            catch(Exception e)
            {
                out.println(e);
                out.println("Insert Operation Failed");
            }
            
        }
        else if(meth.equals("update")){
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelery", "root", "root");
                PreparedStatement s = con.prepareStatement("update items set name=?, category=?, status=?, price=?, gold_wt=?, dia_wt=?, image=? where serial_no=?");    
                s.setString(1, name);
                s.setString(2, cat);
                s.setString(3, stat);
                s.setString(4, price);
                s.setString(5, gw);
                s.setString(6, dw);
                s.setString(7, img);
                s.setString(8, ser);
                s.executeUpdate();
                out.println("Replace Operation Success");
                con.close();
                for(int i=0;i<1000;i++)
                {continue;}
                response.addCookie(c);
                response.sendRedirect("yes.jsp");
            }
            catch(Exception e){
                
                out.println(e);
                out.println("Replace Operation Failed");
            }
            
        }
        else{
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jewelery", "root", "root");
                PreparedStatement s = con.prepareStatement("delete from items where serial_no=?");    
                s.setString(1, ser);
                s.executeUpdate();
                out.println("Delete Operation Success");
                con.close();

                for(int i=0;i<1000;i++)
                {continue;}
                                //response.addCookie(c);
                response.sendRedirect("yes.jsp");
            }
            catch(Exception e){
                out.println(e);
                out.println("Delete Operation Failed");
            }
        }
    }
}
