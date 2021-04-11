package com.gongjiajun.week3.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        name = "RegisterServlet", value = "/register"
)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    PreparedStatement prepare=null;
    Statement st=null;
    ResultSet rs=null;
    public void init(){
        ServletContext config= getServletConfig().getServletContext();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get parameter from request
        String username = request.getParameter("username"); //name of input type-<input type="text" name="username"><br/>
        String password = request.getParameter("password"); //<input type="text" name="password"><br/>
        String email = request.getParameter("email"); //<input type="text" name="email"><br/>
        String gender = request.getParameter("gender"); //<input type="radio" name="gender">
        String birthdate = request.getParameter("birthdate"); //<input type="text" name="birthdate">
        PrintWriter writer=response.getWriter();
//        String sqlselect ="select * from usertable";
        String ID=request.getParameter("ID");

        try {
              String sqlinsert = "insert into usertable values('" + username + "','" + password + "','" + email + "','" + gender + "','" + birthdate + "')";
//            String sqlselect ="select * from usertable";
//            prepare = con.prepareStatement(sqlinsert);
//            prepare.setString(1,ID);
//            prepare.setString(2,username);
//            prepare.setString(3,password);
//            prepare.setString(4,email);
//            prepare.setString(5,gender);
//            prepare.setString(6,birthdate);
//            st=con.createStatement();
//            rs=st.executeQuery(sqlselect);
//            prepare.executeUpdate();
//            response.setContentType("text/html");
//            writer.println("<table border=\\\"2\\\"width=\\\"80%\\\"borderColor=\\\"yellow\\\"bgcolor=\\\"#ABE3F7\\\">");
//            writer.println("<tr>");
//            writer.println("<td>"+ID+"</td>");
//            writer.println("<td>"+username+"</td>");
//            writer.println("<td>"+password+"</td>");
//            writer.println("<td>"+email+"</td>");
//            writer.println("<td>"+gender+"</td>");
//            writer.println("<td>"+birthdate+"</td>");
//            writer.println("</tr>");
//            while (rs.next()){
//                writer.println("<tr>");
//                writer.println("<td>" + rs.getString("ID") + "</td>");
//                writer.println("<td>" + rs.getString("username") + "</td>");
//                writer.println("<td>" + rs.getString("password") + "</td>");
//                writer.println("<td>" + rs.getString("email") + "</td>");
//                writer.println("<td>" + rs.getString("gender") + "</td>");
//                writer.println("<td>" + rs.getDate("birthdate") + "</td>");
//                writer.println("</tr>");
//            }
//            writer.println("</table>");
            request.getRequestDispatcher("userList.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("login.jsp");
    }
}