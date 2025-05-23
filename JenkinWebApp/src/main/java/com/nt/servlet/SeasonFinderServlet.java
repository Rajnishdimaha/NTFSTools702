package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/season")
public class SeasonFinderServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     System.out.println("SeasonFinderServlet.doGet()");
		//get printWriter
		
		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");
		
		//get system date and time 
		
		LocalDateTime ldt=LocalDateTime.now();
		
		//get current month value
		int month=ldt.getMonthValue();
		
		//generate the current season name
		
		String seasonName=null;
		
		if(month>=3 && month<=6)
		{
			seasonName="Summer Season";
			
		}
		else if(month>=7 && month<=10)
		{
			seasonName="Rainy Season";
			
		}else {
			seasonName="Winter Season";
		}
		
		//write the result to browser as response
		pw.println("<h1 style='color:green; text-aling:center'>"+seasonName+"</h1>");  
		
		//add home hyperlink
		pw.println("<a href='index.jsp'> Home <img src='Images/home.png' width='50'> </a>");
	//close the stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("SeasonFinderServlet.doPost()");
		doGet(req,resp);
	}

}
