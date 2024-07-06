package com.j2ee.app02.servlet;


import com.j2ee.app02.action.UserAction;
import com.j2ee.app02.factory.UserActionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        String uname=req.getParameter("uname");
        String upwd=req.getParameter("upwd");
        String uemail=req.getParameter("uemail");
        String umobile=req.getParameter("umobile");

        UserAction userAction= UserActionFactory.getUserAction();
        String status=userAction.registration(uname,upwd,uemail,umobile);

        out.println("<html>");
        out.println("<body>");
        out.println("<br><br><br><br><br>");
        out.println("<h1 style='color:red;text-align:center'>");
        out.println("Status="+status);
        out.println("</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
