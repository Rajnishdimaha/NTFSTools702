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
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        System.out.println("SeasonFinderServlet.doGet()");

        // Set content type
        res.setContentType("text/html");

        // Get PrintWriter to write response
        PrintWriter pw = res.getWriter();

        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        int month = now.getMonthValue();

        // Determine season
        String seasonName;
        if (month >= 3 && month <= 6) {
            seasonName = "Summer Season";
        } else if (month >= 7 && month <= 10) {
            seasonName = "Rainy Season";
        } else {
            seasonName = "Winter Season";
        }

        // Generate HTML response
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<meta charset='UTF-8'>");
        pw.println("<title>Season Finder</title>");
        pw.println("<style>");
        pw.println("body { text-align: center; font-family: Arial, sans-serif; }");
        pw.println("h1 { color: green; }");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");
        pw.printf("<h1>%s</h1>%n", seasonName);
        pw.println("<br>");
        pw.println("<a href='index.jsp'>");
        pw.println("Home <img src='Images/home.png' width='50' alt='Home'>");
        pw.println("</a>");
        pw.println("</body>");
        pw.println("</html>");

        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("SeasonFinderServlet.doPost()");
        doGet(req, res);
    }
}
