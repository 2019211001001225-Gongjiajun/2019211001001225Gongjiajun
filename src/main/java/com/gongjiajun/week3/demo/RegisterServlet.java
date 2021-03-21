package com.gongjiajun.week3.demo;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get parameter from request
        String username = request.getParameter("username"); //name of input type-<input type="text" name="username"><br/>
        String password = request.getParameter("password"); //<input type="text" name="password"><br/>
        String email = request.getParameter("email"); //<input type="text" name="email"><br/>
        String gender = request.getParameter("gender"); //<input type="radio" name="gender">
        String birthDate = request.getParameter("birthDate"); //<input type="text" name="birthDate">

        //print - write into response
        PrintWriter writer = response.getWriter();
        writer.println("<br> username :"+username);
        writer.println("<br> password :"+password);
        writer.println("<br> email :"+email);
        writer.println("<br> gender :"+gender);
        writer.println("<br> birth Date :"+birthDate);
        writer.close();
    }
}
