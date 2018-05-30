<%-- 
    Document   : add-provider
    Created on : May 29, 2018, 11:30:16 PM
    Author     : Rio.Rai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Addition Providers Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <h2 style="margin-left: 600px">Addition Provider</h2>
        <spring:form style="width: 970px; margin-left: 200px" commandName="providerForm" method="POST">
            <div class="form-row">
                <div class="col">
                    <input type="text" class="form-control" placeholder="Provider ID" name="providerId">
                </div>
                <div class="col">
                    <input type="text" class="form-control" placeholder="Provider NAME" name="providerName">
                </div>
            </div>
            <br>

            <button type="submit" class="btn btn-success" style="margin-left: 800px">Success</button>
        </spring:form>

            <div id="Message" style="margin-left: 500px">
                <p style="color: green">${scc}</p>
                <p style="color: red">${err}</p>
            </div>

    </body>
</html>
