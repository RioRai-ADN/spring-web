<%-- 
    Document   : product
    Created on : May 29, 2018, 9:16:17 PM
    Author     : Rio.Rai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <h2 style="margin-left: 600px">Products</h2>

            <table class="table table-bordered" style="margin-left: 180px; width: 1000px">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Product_ID</th>
                        <th scope="col">Product_NAME</th>
                        <th scope="col">Provider_NAME</th>
                        <th scope="col">Feature</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${productList}">
                    <tr>
                        <th scope="row">1</th>
                        <td>${item.productId}</td>
                        <td>${item.productName}</td>
                        <td>${item.providerId}</td>
                        <td>
                            <a href="detail?productId=${item.productId}"><button type="button" class="btn btn-outline-info">Detail</button></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
