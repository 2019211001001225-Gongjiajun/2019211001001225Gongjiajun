package com.gongjiajun.controller;

import com.gongjiajun.dao.IUserDao;
import com.gongjiajun.dao.UserDao;
import com.gongjiajun.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        con=(Connection)getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        IUserDao IUserDao = new UserDao();
        try {
            User userInfo = IUserDao.findById(con, id);
            request.setAttribute("userInfo",userInfo);
            request.getRequestDispatcher("WEB-INF/views/updateUesr.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("email");
        String Gender=request.getParameter("gender");
        Date date = Date.valueOf(request.getParameter("birth"));
        User user = new User(id, username, password, Email, Gender, date);

        IUserDao IUserDao = new UserDao();
        try {
            int i = IUserDao.updateUser(con, user);
            if (i != 0){
                request.getSession().setAttribute("user",IUserDao.findById(con,id));
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request, response);
            }else {
                request.setAttribute("message","Update Error");
                request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
