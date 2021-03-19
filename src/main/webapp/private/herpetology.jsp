<%--
  Created by IntelliJ IDEA.
  User: Christian
  Date: 2/22/2021
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Whooh!</title>
</head>
<body>
${pageContext.response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")}
Welcome to Herpetology <form action="/logout" method="get">
    <input type="submit" value="Logout"/>
</form>

<form action="herpetology" method="get">
    Enter common name : <input type="text" name="commonName" required/><br>
    Enter habitat : <input type="radio" id="aquatic" value="aquatic" name="habitat" required>
    <label for="aquatic">Aquatic</label>
    <input type="radio" id="terrestrial" value="terrestrial" name="habitat"/>
    <label for="terrestrial">Terrestrial</label>
    <input type="radio" id="fossorial" value="fossorial" name="habitat"/>
    <label for="all">Fossorial</label>
    <input type="radio" id="all" value="[a-z]" name="habitat"/>
    <label for="all">All</label><br>
    <input type="submit"/>
</form>
<form action="undo" method="get">
    <input type="submit" value="Undo"/>
</form>
<c:forEach var="herp" items="${herps}">
    <c:out value="${herp.herpClass}"/>
    <c:out value="${herp.commonName}"/>
    <c:out value="${herp.family}"/>
    <c:out value="${herp.genus}"/>
    <c:out value="${herp.species}"/><br>
<%--    <c:out value="${herp.type}"/>--%>
<%--    <c:out value="${herp.description}"/>--%>

</c:forEach>

</body>
</html>