<%-- 
    Document   : category
    Created on : May 29, 2018, 9:02:10 PM
    Author     : Rio.Rai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Provider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProviderDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Provider Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <h2 style="margin-left: 600px">Provider</h2>
            <table class="table table-bordered" style="margin-left: 180px; width: 1000px">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Provider_ID</th>
                        <th scope="col">Provider_NAME</th>
                        <th scope="col">Feature</th>
                    </tr>
                </thead>
                <tbody>
                <% int i = 0;%>
                <c:forEach var="item" items="${providerList}">
                    <tr>
                        <th scope="row"><%=i++%></th>
                        <td>${item.providerId}</td>
                        <td>${item.providerName}</td>
                        <td>
                            <a href="product-supplier?providerId=${item.providerId}"><button type="button" class="btn btn-outline-dark">View Products Supplier</button></a>
                            <!--<button type="button" class="btn btn-outline-info">Detail</button>
                            <button type="button" class="btn btn-outline-danger">Delete</button>-->
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
