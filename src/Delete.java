import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException
	{
	 PrintWriter out=response.getWriter();
	 response.setContentType("text/html");
String id=request.getParameter("ID1");
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "kumar");
PreparedStatement ps=con.prepareStatement("delete book where ID='"+id+"'"); 

int i=ps.executeUpdate();
if(i>0){out.print("Data is successfully deleted!");}
else{out.print("data is not successfully deleted");}
}
catch(Exception e)
{
	System.out.print(e);
	e.printStackTrace();
}
	}
}
