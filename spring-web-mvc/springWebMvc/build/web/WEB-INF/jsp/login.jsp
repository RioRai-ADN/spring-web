<%-- 
    Document   : login
    Created on : May 28, 2018, 9:30:45 PM
    Author     : Rio.Rai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>

        <h2>Đăng nhập hệ thống</h2>
        <spring:form action="login" commandName="userForm" method="POST">
            <input type="text" placeholder="Email Address" name="userEmail" />
            <input type="password" placeholder="Password" name="password"/>

            <input type="submit" class="btn btn-default" value="Login" />
        </spring:form>
        <p>${msg}</p>
    </body>
</html>
