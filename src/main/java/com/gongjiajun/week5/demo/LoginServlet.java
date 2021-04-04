package com.gongjiajun.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletContext;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    PreparedStatement prepare=null;
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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username"); //name of input type-<input type="text" name="username"><br/>
        String password = request.getParameter("password"); //<input type="text" name="password"><br/>
        System.out.println(username + password);
        PrintWriter writer=response.getWriter();
        try{
            if (con != null) {
                String sqlselect = "select * from usertable where username=? and password=?;";
                prepare = con.prepareStatement(sqlselect);
                prepare.setString(1,username);
                prepare.setString(2,password);
                rs = prepare.executeQuery();
                while (rs.next()){
                    writer.println("Login Success!!!");
                    writer.println("Welcome,"+username);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
