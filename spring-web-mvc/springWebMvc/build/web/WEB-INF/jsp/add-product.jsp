<%-- 
    Document   : add-product
    Created on : May 30, 2018, 3:10:48 PM
    Author     : Rio.Rai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Addition Product Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <h2 style="margin-left: 500px">Addition Product</h2>

            <div id="Message" style="margin-left: 320px">
                <h4 style="color: green">${scc}</h4><!--xuat thong bao thanh cong-->
                <h4 style="color: red">${err}</h4><!--xuat thong loi-->
            </div>
        <spring:form commandName="productForm" method="POST" style="width: 600px; margin-left: 300px; background-color: #f1eaee; padding-left: 10px; padding-right: 10px">

            <!--Product Id (String)-->
            <div class="form-group">
                <label for="exampleFormControlInput1">Product ID</label>
                <input type="text" name="productId" class="form-control" id="exampleFormControlInput1" placeholder="Example: GFS3">
            </div>

            <!--Product Name(String)-->
            <div class="form-group">
                <label for="exampleFormControlInput1">Product Name</label>
                <input type="text" name="productName" class="form-control" id="exampleFormControlInput1" placeholder="Gears Frontier S3">
            </div>

            <!--Provider selection (loadProviderList)-->
            <div class="form-group">
                <label for="exampleFormControlSelect1">Provider</label>
                <select class="form-control" name="providerId" id="exampleFormControlSelect1">
                    <c:forEach var="item" items="${providerList}">
                        <option value="${item.providerId}">${item.providerName}</option>
                    </c:forEach>

                </select>
            </div>

            <!--Product Quantity-->
            <div class="col-md-3 mb-3">
                <label for="validationServer04">Quantity</label>
                <input type="number" name="productQuantity" class="form-control is-invalid" id="validationServer04" placeholder="" required>
                <div class="invalid-feedback">
                    Please input quantity!
                </div>
            </div>

            <!--Products Unit-->
            <div class="col-md-3 mb-3">
                <label for="validationServer04">Unit</label>
                <input type="text" name="productUnit" class="form-control is-invalid" id="validationServer04" placeholder="" required>
                <div class="invalid-feedback">
                    Please input Unit Product!
                </div>
            </div>

            <!--Product Price(double)-->
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Prices</span>
                </div>
                <input type="text" name="productPrice" class="form-control" aria-label="Amount (to the nearest dollar)">
                <div class="input-group-append">
                    <span class="input-group-text">$</span>
                </div>
            </div>

            <button type="submit" class="btn btn-success">Success</button>
        </spring:form>
    </body>
</html>
