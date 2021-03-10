<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<head>
    <title>Tak for bestilling!</title>
</head>

<h1>Hej ${sessionScope.email} </h1>

<h1>Tak for din bestilling, vi har den klar når du henter den.</h1>

<div class="text-center">
    <a href="FrontController?target=redirect&destination=customerpage">Lav ny bestilling</a>
</div>
<br>
<form name="logout" method="post" action="FrontController">
    <input type="hidden" name="target" value="logout">
    <input id="logout" type="submit" name="logout" value="Log af">
</form>

<%@include file="../includes/footer.inc"%>