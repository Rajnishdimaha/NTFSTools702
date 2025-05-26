package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/season")
public class SeasonFinderServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        LocalDateTime ldt = LocalDateTime.now();
        int month = ldt.getMonthValue();

        String seasonName;
        if (month >= 3 && month <= 6)
            seasonName = "Summer Season";
        else if (month >= 7 && month <= 10)
            seasonName = "Rainy Season";
        else
            seasonName = "Winter Season";

        pw.println("<h1 style='color:green; text-align:center'>" + seasonName + "</h1>");
        pw.println("<a href='index.jsp'>Home <img src='Images/home.png' width='50'></a>");
        pw.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);
    }
}
