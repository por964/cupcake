<%@ page import="CupcakeUtil.Initializer" %>
<%--
  Created by IntelliJ IDEA.
  User: claes
  Date: 16-03-2020
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<%@page import="java.text.DecimalFormat" %>

<%
        if (request.getServletContext().getAttribute("bottomList") == null) {
                request.getServletContext().setAttribute("bottomList", Initializer.getBottomList());
        }
        if (request.getServletContext().getAttribute("topList") == null) {
                request.getServletContext().setAttribute("topList", Initializer.getTopList());
        }
%>


        <h1>Hej ${sessionScope.email} </h1>
        <br>
        <br>
        <br>
        <h2>Velkommen til vores webshop, bestil nedenfor.</h2>
<br>

<div class="form-group">
        <form name="basket" action="FrontController" method="POST">
                <input type="hidden" name="target" value="basket">
        <label for="exampleFormControlSelect1">Vælg bund:</label>
        <select class="form-control" name="bottom" id="exampleFormControlSelect1" style="width: 350px">
                <c:forEach var="bottomItems" items="${applicationScope.bottomList}">
                        <option value="${bottomItems.bottomID}">Navn: ${bottomItems.name} Pris: ${bottomItems.price}</option>
                </c:forEach>

        </select>

</div>

<div class="form-group">
        <label for="exampleFormControlSelect2">Vælg top:</label>
        <select class="form-control" name="top" id="exampleFormControlSelect2" style="width: 350px">
                <c:forEach var="topItems" items="${applicationScope.topList}">
                        <option value="${topItems.topID}">Navn: ${topItems.name} Pris: ${topItems.price}</option>
                </c:forEach>
        </select>
</div>
<div class="dropdown">
        <select name="quantity" class="btn btn-secondary dropdown-toggle">
                <option value="" disabled selected>Vælg antal</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
        </select>

</div>
</div>
</th>
<br>

<th>
        <div class="container">
        <input class="btn btn-primary" type="submit" name="submit" value="Læg i kurv"/>
</div>

<th>
</form>
        <br>
        <div class="container"> ${requestScope.selection}</div>
        <div class="col text-center">
                <a href="FrontController?target=redirect&destination=basket" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Vis kurv</a>
        </div>

</th>
</th>


<%@include file="../includes/footer.inc"%>
