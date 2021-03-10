<%@ page import="DBAccess.OrderMapper" %>
<%@ page import="DBAccess.UserMapper" %>
<%@ page import="FunctionLayer.LoginSampleException" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>


<h1>Hej ${sessionScope.email}</h1>
<br>
<h3>Her er en oversigt over alle kunder </h3>
<br>

<div class="row">
    <div class="col-sm">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">KundeID</th>
                <th scope="col">Email</th>
                <th scope="col">Kodeord</th>
                <th scope="col">Rolle</th>
                <th scope="col">Balance</th>

            </tr>
            </thead>
            <tbody>
            <tr>
            <c:forEach var="customer" items="${requestScope.customerList}">
                <td>${customer.userID}</td>
                <td>${customer.email}</td>
                <td>${customer.password}</td>
                <td>${customer.role}</td>
                <td>${customer.balance}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h3>Indtast id på den kunde, hvis ordrer, du ønsker at se:</h3>
        <form name="customersOrder" action="FrontController" method="POST">
            <label for="userID">KundeID:</label>
            <input type="hidden" name="target" value="customersOrder">
            <input id="userID" type="text" name="userID" value=" " align="left">
            <input type="submit" value="Se ordrer">
        </form>







        <div class="text-center">
            <a href="FrontController?target=redirect&destination=employeepage">Til medarbejdersiden</a>
        </div>
    </div>

    <%@include file="../includes/footer.inc"%>
