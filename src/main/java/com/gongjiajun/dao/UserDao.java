package com.gongjiajun.dao;

import com.gongjiajun.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="insert into usertable" +
                "values("+user.getID()+","+user.getBirthdate()+","+user.getUsername()+","
                +user.getPassword()+","+user.getEmail()+","+user.getGender()+")";
        PreparedStatement st=con.prepareStatement(sql);
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete * from usertable where ID='"+user.getID()+"'";
        PreparedStatement st=con.prepareStatement(sql);
        int rs=st.executeUpdate(sql);
        return rs;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update usertable set Username='"+user.getUsername()+"'"+","+"Gender='"+user.getGender()+"'"+","+"Password='"+user.getPassword()+"'"
                +","+"Email='"+user.getEmail()+"'"+","+"Birthdate='"+user.getBirthdate()+"'"+"where ID='"+user.getID()+"'";
        PreparedStatement st=con.prepareStatement(sql);
        int result=st.executeUpdate();
        return result;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql="select * from usertable where ID='"+id+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        User user=null;
        while(result.next()){
            user=new User();
            user.setID(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthdate(result.getDate("Birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "SELECT * FROM usertable WHERE name=? AND password=?;";
        PreparedStatement st= con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        st.setString(1,username);
        st.setString(2,password);
        User user=null;
        if(rs.next()){
            user=new User();
            user.setID(rs.getInt("id"));
            user.setUsername(rs.getString("name"));
            user.setBirthdate(rs.getDate("birthdate"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select * from usertable where UserName='"+username+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setID(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthdate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select * from usertable where Password='"+password+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setID(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthdate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select * from usertable where Email='"+email+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setID(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthdate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="select * from usertable where Gender='"+gender+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setID(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthdate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="select * from usertable where Birthday='"+birthDate+"'";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setID(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthdate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="select * from usertable";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet result=st.executeQuery();
        List<User> users=new ArrayList<>();
        while(result.next()){
            User user=new User();
            user.setID(result.getInt("ID"));
            user.setUsername(result.getString("UserName"));
            user.setPassword(result.getString("Password"));
            user.setEmail(result.getString("Email"));
            user.setGender(result.getString("Gender"));
            user.setBirthdate(result.getDate("Birthdate"));
            users.add(user);
        }
        return users;
    }
}