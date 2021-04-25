<%@ page import="com.gongjiajun.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 俊
  Date: 2021/4/25
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<h1>User Update</h1>
<%
    User us=(User) session.getAttribute("user");
%>
<form method="post"  action="updateUser">
    <input type="hidden" name="id" value="<%=us.getID()%>">
    username:<input type="text"  name="username" value="<%=us.getUsername()%>"><br/>
    password:<input type="password"  name="password" value="<%=us.getPassword()%>"><br/>
    Email:<input type="text" name="email" value="<%=us.getEmail()%>"><br/>
    Gender:<input type="radio" name="gender" value="male" <%="male".equals(us.getGender())?"checked":""%>>Male
    <input type="radio" name="gender" value="female"<%="female".equals(us.getGender())?"checked":""%>>Female<br/>
    Date of Birth :<input type="text" name="birth" value="<%=us.getBirthdate()%>"><br/>
    <input type="submit" value="Save Changes"/><br/>
</form>
