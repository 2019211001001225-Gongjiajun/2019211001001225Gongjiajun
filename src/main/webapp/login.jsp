<%--
  Created by IntelliJ IDEA.
  User: 俊
  Date: 2021/4/4
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
Login  <br>
<form method="post" action="login">
    UserName :<input type="text" name="username"><br/>
    Password :<input type="text" name="password"><br/>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp" %>
