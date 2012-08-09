package com.mydomain;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloEjbServlet extends HttpServlet {
    @EJB
    private HelloSessionBeanRemote helloSessionBeanRemote;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title> A very simple servlet example</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>"+helloSessionBeanRemote.getTime()+"</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        //request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}