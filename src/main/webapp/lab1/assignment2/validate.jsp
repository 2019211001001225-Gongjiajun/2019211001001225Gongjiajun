<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>



<c:choose>
    <c:when test="${param.username.equals('admin')&&param.password.equals('admin')}">

        <c:url var="welcome" value="welcome.jsp">
            <c:param name="username" value="admin"/>
        </c:url>

        <c:redirect url="${welcome}"/>
    </c:when>

    <c:otherwise>

        <c:set value="username password error" var="message" scope="request"/>

        <c:import url="login.jsp"/>
    </c:otherwise>
</c:choose>
</body>
</html>