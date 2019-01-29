package com.log;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet extends HttpServlet
{
   public void service(HttpServletRequest req,HttpServletResponse res)
   {
       int i=Integer.parseInt(req.getParameter("num1"));
       int j=Integer.parseInt(req.getParameter("num2"));
       int k=i+j;
       
       Cookie cookie= new Cookie("k",k+"");
       res.addCookie(cookie);
       //HttpSession session=req.getSession();
       //session.setAttribute("k",k);
       try {
		res.sendRedirect("sq?k="+k);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       /*req.setAttribute("k",k);
       RequestDispatcher rd=req.getRequestDispatcher("sq");
		try {
			//rd.forward(req,res);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
   }
}
