package com.gongjiajun.week4.demo;

import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet(
//        urlPatterns = {"/jdbc"},
//        initParams = {
//                @WebInitParam(name= "driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
//                @WebInitParam(name= "url",value = "jdbc:sqlserver://localhost:1433;DatabaseName=userdb"),
//                @WebInitParam(name= "username",value = "sa"),
//                @WebInitParam(name= "password",value = "gjj123456789"),
//        },loadOnStartup = 1
//)
public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        String username="sa";
        String password="gjj123456789";

//        ServletConfig config=getServletConfig();
//        String driver=config.getInitParameter("driver");//<param-name>driver</param-name>
//        String url=config.getInitParameter("url");
//        String username=config.getInitParameter("username");
//        String password=config.getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);//ok(java code) --ok(use config-in web.xml)--ok(use @webServlet)
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //connection within do get
        System.out.println("i am in doGet()");
        String sql="select * from usertable";
        try {
            ResultSet rs= con.createStatement().executeQuery(sql);
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("   <head>");
            writer.println("       <meta charset='UTF-8'>");
            writer.println("       <title>查询所有人员</title>");
            writer.println("   </head>");
            writer.println("   <body>");
            writer.println("       <table border='1'>");
            writer.println("           <tr>");
            writer.println("               <td>ID</td>");
            writer.println("               <td>UserName</td>");
            writer.println("               <td>Password</td>");
            writer.println("               <td>Email</td>");
            writer.println("               <td>Gender</td>");
            writer.println("               <td>Birthdate</td>");
            writer.println("           </tr>");
            while(rs.next()){
                writer.println("           <tr>");
                writer.println("               <td>"+rs.getInt("ID")+"</td>");
                writer.println("               <td>"+rs.getString("UserName")+"</td>");
                writer.println("               <td>"+rs.getString("Password")+"</td>");
                writer.println("               <td>"+rs.getString("Email")+"</td>");
                writer.println("               <td>"+rs.getString("Gender")+"</td>");
                writer.println("               <td>"+rs.getDate("Birthdate")+"</td>");
                writer.println("           </tr>");
            }
            writer.println("       </table>");
            writer.println("   </body>");
            writer.println("</html>");
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    public void destroy(){
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
