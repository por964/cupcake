<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<html>
<head>
    <title>Ordrer</title>
</head>
<body>
<h1>Hej ${sessionScope.email}</h1>
${requestScope.meddelelse}
<br>
<div class="row">
    <div class="col-sm">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ItemID</th>
                <th scope="col">TopID</th>
                <th scope="col">BottomID</th>
                <th scope="col">Antal</th>
                <th scope="col">Pris</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="OrderItem" items="${requestScope.customersOrderList}">
                <tr>
                    <td>${OrderItem.itemID}</td>
                    <td>${OrderItem.topID}</td>
                    <td>${OrderItem.bottomID}</td>
                    <td>${OrderItem.quantity}</td>
                    <td>${OrderItem.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="text-center">
            <a href="FrontController?target=redirect&destination=employeepage">Til medarbejdersiden</a>
        </div>
    </div>
</div>
</body>
</html>
<%@include file="../includes/footer.inc"%>