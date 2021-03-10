<%@ page import="DBAccess.OrderMapper" %>
<%@ page import="FunctionLayer.LoginSampleException" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc"%>




<h1>Hej ${sessionScope.email} </h1>
<br>
<h3>Alle bestillinger: </h3>
<br>

<div class="row">
    <div class="col-sm">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Ordre ID</th>
                <th scope="col">Bruger ID</th>
                <th scope="col">Pris</th>
                <th scope="col">Tidspunkt</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${requestScope.orderList}">
                <tr>

                    <td>${order.ID}</td>
                    <td>${order.customerID}</td>
                    <td>${order.price}</td>
                    <td>${order.time}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>




        <div class="text-center">
            <a href="FrontController?target=redirect&destination=employeepage">Til medarbejdersiden</a>
        </div>
    </div>
    <%@include file="../includes/footer.inc"%>

