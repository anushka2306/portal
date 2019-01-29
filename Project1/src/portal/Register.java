package portal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		String aname=request.getParameter("name");
		String un=request.getParameter("un");
		String pw=request.getParameter("pw");
		String emid=request.getParameter("emid");
		String phn=request.getParameter("phn");
		String sql ="insert into user_reg(aname,un,pw,emid,phn) values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/register","root","");	
		    PreparedStatement st = con.prepareStatement(sql);
		    st.setString(1,aname);
		    st.setString(2,un);
		    st.setString(3,pw);
		    st.setString(4,emid);
		    st.setString(5,phn);
		    st.executeUpdate();
		    System.out.println("Registered successfully");
	        } catch (Exception e)
	        {
		      e.printStackTrace();
	        }	
	}

}