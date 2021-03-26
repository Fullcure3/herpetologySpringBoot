<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<title>Herpetology Database</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="tableStyling.css">
<style>
    body,h1 {font-family: "Raleway", sans-serif}
    body, html {height: 100%}
    .bgimg {
        background-image: url('reptile background.jpg');
        min-height: 100%;
        background-position: center;
        background-size: cover;
    }
</style>
<body>

<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
    <div class="w3-display-topright w3-padding-large w3-xlarge">

    </div>
    <div class="w3-display-middle">
        <h1 class="w3-large w3-animate-top">
            <table class="content-table">
                <thead>
                <tr>
                    <th>Class</th>
                    <th>Name</th>
                    <th>Genus</th>
                    <th>Species</th>
                    <th>Activity</th>
                </tr>
                </thead>

                <c:forEach var="herp" items="${herps}">
                    <tbody>
                    <tr>
                        <td>${herp.herpClass}</td>
                        <td>${herp.commonName}</td>
                        <td>${herp.genus}</td>
                        <td>${herp.species}</td>
                        <td>${herp.type}</td>
                    </tbody>
                </c:forEach>
            </table>
        </h1>
        <hr class="w3-border-grey" style="margin:auto;width:40%">
        <p class="w3-large w3-center">John Steffen</p>
    </div>
    <div class="w3-display-topleft w3-padding-large">
        <form action="herpetology" method="get">
            Enter common name : <input type="text" name="commonName" required/><br>
            Enter habitat : <input type="radio" id="aquatic" value="aquatic" name="habitat" required>
            <label for="aquatic">Aquatic</label>
            <input type="radio" id="terrestrial" value="terrestrial" name="habitat"/>
            <label for="terrestrial">Terrestrial</label>
            <input type="radio" id="fossorial" value="fossorial" name="habitat"/>
            <label for="all">Fossorial</label>
            <input type="radio" id="all" value="[a-z]|[A-Z]" name="habitat"/>
            <label for="all">All</label><br>
            <input type="submit" value="Search"/>
        </form>
        <form action="undo" method="get">
            <input type="submit" value="Undo"/>
        </form>
    </div>
</div>
</body>
</html>


