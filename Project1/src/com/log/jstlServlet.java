package com.log;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstlServlet")
	public class jstlServlet extends HttpServlet
	{
	   public void service(HttpServletRequest request,HttpServletResponse response)
	   {
		   String name = "anu";
		   request.setAttribute("label",name);
		   RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		   try {
			rd.forward(request,response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	   }
	}


