<%--
  Created by IntelliJ IDEA.
  User: 俊
  Date: 2021/3/15
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="register">
    UserName :<input type="text" name="username"><br/>
    password :<input type="text" name="password"><br/>
    Email :<input type="text" name="email"><br/>
    Gender:<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
    Date of Birth :<input type="text name=" name="birthDate"><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
