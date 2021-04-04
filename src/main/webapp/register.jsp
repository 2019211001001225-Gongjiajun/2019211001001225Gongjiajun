<%--
  Created by IntelliJ IDEA.
  User: 俊
  Date: 2021/3/15
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
This is my register Jsp page. <br>
<form method="post" action="register">
    UserName :<input type="text" name="username"><br/>
    Password :<input type="text" name="password"><br/>
    Email :<input type="text" name="email"><br/>
    Gender:<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
    Date of Birth :<input type="text name=" name="birthdate"><br/>
    <input type="submit" value="Register"/>
</form>
<%@include file="footer.jsp" %>