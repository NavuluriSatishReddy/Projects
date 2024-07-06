package com.j2ee.app02.servlet;


import com.j2ee.app02.action.UserAction;
import com.j2ee.app02.factory.UserActionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String uname=request.getParameter("uname");
        String upwd=request.getParameter("upwd");

        UserAction userAction= UserActionFactory.getUserAction();
        String status= userAction.checkLogin(uname,upwd);

        out.println("<html>");
        out.println("<body>");
        out.println("<br><br><br><br><br>");
        out.println("<h1 style='color:red;text-align:center'>");
        out.println("Status="+status);
        out.println("</h1></body></html");
    }



}
