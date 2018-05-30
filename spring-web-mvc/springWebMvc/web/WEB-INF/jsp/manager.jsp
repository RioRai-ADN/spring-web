<%-- 
    Document   : manager
    Created on : May 29, 2018, 1:10:07 PM
    Author     : Rio.Rai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Page</title>

        
    </head>
    <body>
        <h1>Hello ${sessionScope.userName }</h1>

        <jsp:include page="header.jsp"></jsp:include>
    </body>
</html>
