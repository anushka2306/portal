package com.anushka;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class login extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	{
		String un=request.getParameter("un");
		String pw=request.getParameter("pw");
		
		if(un.equals("anushka") && pw.equals("intern"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username",un);
			try {
				response.sendRedirect("welcomr.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
