import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;

public class BookInfoservlet extends HttpServlet 
{
	public void  service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{ 
		String name=request.getParameter("NAME");
		String id=request.getParameter("ID");
		String author=request.getParameter("AUTHOR");
		String published=request.getParameter("PUBLISHED");
		String pages=request.getParameter("PAGES");
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "kumar");
		PreparedStatement ps=con.prepareStatement("insert into book(name,id,author,published,pages) values('"+name+"','"+id+"','"+author+"','"+published+"','"+pages+"')");
		 ps.executeUpdate();
		PrintWriter out=response.getWriter();
		out.print("Data is successfully inserted!");
		}//try

		catch(Exception e)
		{
		System.out.print(e);
		e.printStackTrace();
		}
	}
}
