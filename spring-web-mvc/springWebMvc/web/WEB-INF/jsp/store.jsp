<%-- 
    Document   : store
    Created on : May 31, 2018, 2:43:11 PM
    Author     : Rio.Rai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <h2 style="margin-left: 600px">Check the store</h2>

            <table class="table table-bordered" style="margin-left: 180px; width: 1000px">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Product_ID</th>
                        <th scope="col">Product_NAME</th>
                        <th scope="col">Provider_ID</th>
                        <th scope="col">Status</th>
                        <th scope="col">Feature</th>
                    </tr>
                </thead>
                <tbody>
                <% int i = 0;%>
                <c:forEach var="item" items="${productList}">
                    <tr>
                        <th scope="row"><%=i++%></th>
                        <td>${item.productId}</td>
                        <td>${item.productName}</td>
                        <td>${item.providerId}</td>
                        <c:if test="${item.productQuantity <= 0}">
                            <td style="color: red">Out of Stock</td>
                        </c:if>
                        <c:if test="${item.productQuantity > 0}">
                            <td style="color: green">Stocking</td>
                        </c:if>
                        <td>developing</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
