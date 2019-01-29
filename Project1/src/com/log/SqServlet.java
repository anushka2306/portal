package com.log;

import java.io.*;

import javax.servlet.http.Cookie;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet
{
   public void service(HttpServletRequest req,HttpServletResponse res)
   {
	   //int k= (int) req.getAttribute("k");
	   //int k=Integer.parseInt(req.getParameter("k"));
	   //HttpSession session=req.getSession();
       //int k=(int) session.getAttribute("k");
	   int k=0;
	   Cookie cookies[]= req.getCookies();
	   
	   for(Cookie c: cookies)
	   {
		   if(c.getName().equals("k"))
			   k=Integer.parseInt(c.getValue());
	   }
	   
	   PrintWriter out = null;
		try {
			out = res.getWriter();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	       out.println("result:"+k);
	   System.out.println("sq called");
   }
 }