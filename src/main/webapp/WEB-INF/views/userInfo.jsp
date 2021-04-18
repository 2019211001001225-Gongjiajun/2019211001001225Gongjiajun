<%--
  Created by IntelliJ IDEA.
  User: 俊
  Date: 2021/4/11
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.gongjiajun.model.User" %>
<%@include file="header.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" language="java"%>
<h2>User Info</h2>
<%
    User user=(User) request.getAttribute("user");
%>
<table border="1" >
    <tr>
        <td>Username</td><td><%=user.getUsername()%></td> </tr>
    <td>Password</td><td><%=user.getPassword()%></td> </tr>
    <td>Email</td> <td><%=user.getEmail()%></td> </tr>
    <td>Gender</td><td><%=user.getGender()%></td> </tr>
    <td>Birthdate</td> <td><%=user.getBirthdate()%></td>
    </tr>
</table>

<%@include file="footer.jsp" %>