import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Update extends HttpServlet
{


public void service(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException
{
	PrintWriter out=response.getWriter();
    response.setContentType("text/html");
    HttpSession session=request.getSession(false);
	String id=(String)session.getAttribute("id");
    
   
	String name=request.getParameter("NAME1");
	String author=request.getParameter("AUTHOR1");
	String published=request.getParameter("PUBLISHED1");
	String pages=request.getParameter("PAGES1");
   
try
{
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "kumar");
    PreparedStatement ps=con.prepareStatement("update book set NAME='"+name+"',AUTHOR='"+author+"',PUBLISHED='"+published+"',PAGES='"+pages+"' where ID='"+id+"'");
    int i=ps.executeUpdate();
if(i>0){out.print("Data is successfully updated!");}
else{
	out.print("there is some problem in update");
}
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
}
}

