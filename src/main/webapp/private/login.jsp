<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        background-image: url('veronica-dudarev-3vHm4yLG_do-unsplash.jpg');
        min-height: 100%;
        background-position: center;
        background-size: cover;
    }
</style>
<body>

<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
    <div class="w3-display-middle">
        <h1 class="w3-jumbo w3-animate-top">Welcome To Herpetology</h1>
        <hr class="w3-border-grey" style="margin:auto;width:40%">
        <p class="w3-large w3-center">
            <c:url value="/login" var="loginProcessingUrl"/>
        <form action="${loginProcessingUrl}" method="post">
            <fieldset>
                <legend>Please Login</legend>
                <!-- use param.error assuming FormLoginConfigurer#failureUrl contains the query parameter error -->
                <c:if test="${param.error != null}">
                    <div>
                        Failed to login.
                        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                            Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                        </c:if>
                    </div>
                </c:if>
                <!-- the configured LogoutConfigurer#logoutSuccessUrl is /login?logout and contains the query param logout -->
                <c:if test="${param.logout != null}">
                    <div>
                        You have been logged out.
                    </div>
                </c:if>
                <p>
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username"/>
                </p>
                <p>
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password"/>
                </p>
                <!-- if using RememberMeConfigurer make sure remember-me matches RememberMeConfigurer#rememberMeParameter -->
                <p>
                    <label for="remember-me">Remember Me?</label>
                    <input type="checkbox" id="remember-me" name="remember-me"/>
                </p>
                <div>
                    <button type="submit" class="btn">Log in</button>
                </div>
            </fieldset>
        </form>
        </p>
    </div>
</div>

</body>
</html>
