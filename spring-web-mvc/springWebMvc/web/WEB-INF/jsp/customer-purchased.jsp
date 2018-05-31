<%-- 
    Document   : customer-purchased
    Created on : May 31, 2018, 12:37:00 AM
    Author     : Rio.Rai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Purchased Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <h2 style="margin-left: 600px">Products</h2>

            <table class="table table-bordered" style="margin-left: 180px; width: 1000px">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Customer_ID</th>
                        <th scope="col">Customer_NAME</th>
                        <th scope="col">Product_NAME</th>
                        <th scope="col">Prices</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Feature</th>
                    </tr>
                </thead>
                <tbody>
                <% int i = 0;%>
                <c:forEach var="item" items="${customerList}">
                    <tr>
                        <th scope="row"><%=i++%></th>
                        <td>${item.customerId}</td>
                        <td>${item.customerName}</td>
                        <td>${item.productName}</td>
                        <td>${item.prices}</td>
                        <td>${item.quantity}</td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
