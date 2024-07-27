package first;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
public class demoofserv extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		PrintWriter out=response.getWriter();
		out.println("pradip bhosale");
		String name=request.getParameter("name");
		String email=request.getParameter("na");
		int cont=Integer.parseInt(request.getParameter("con"));
		int pass=Integer.parseInt(request.getParameter("pass"));
		String add=request.getParameter("add");
		String quli=request.getParameter("t1");
		String gen=request.getParameter("fg");
		out.println("the qulification is\t"+quli);
		out.println("the gender is\t\t"+gen);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","");
			PreparedStatement ps=con.prepareStatement("insert into stu values(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, cont);
			ps.setInt(4, pass);
			ps.setString(5, add);
			ps.setString(6,quli);
			ps.setString(7, gen);
			int z=ps.executeUpdate();
			if(z>0)
			{
				out.println("save");
			}
			else
			{
				out.println("not save");
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
    }

	

}
