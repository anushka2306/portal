package com.anushka;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ses")
	public class SesServlet extends HttpServlet
	{
	   public void service(HttpServletRequest req,HttpServletResponse res)
	   {
	       int i=Integer.parseInt(req.getParameter("num1"));
	       int j=Integer.parseInt(req.getParameter("num2"));
	       int k=i+j;
	       PrintWriter out = null;
			try {
				out = res.getWriter();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		    out.println("<html><body bgcolor='cyan'>");   
			out.println("result:"+k);
		    out.println("</body></html>");
	   }
}
