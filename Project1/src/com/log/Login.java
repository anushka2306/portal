package com.log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		String un=request.getParameter("un");
		String pw=request.getParameter("pw");
		String dbun=null;
		String dbpw=null;
		String sql ="select * from user_reg where un=? and pw=?";
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/register","root","1234");	
	    PreparedStatement st = con.prepareStatement(sql);
	    st.setString(2,un);
	    st.setString(3,pw);
	    ResultSet rs =st.executeQuery();
	    while(rs.next())
	    {
	    	dbun=rs.getString(3);
	    	dbpw=rs.getString("pw");
	    }
		if(un.equals(dbun) && pw.equals(dbpw))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username",un);
			response.sendRedirect("welcomr.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");	
		}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}


}
