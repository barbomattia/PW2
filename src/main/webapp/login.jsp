<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="intestazione.jsp" />

<main id="loginBody">
    <link rel="stylesheet" type="text/css" href="css/login.css">

    <form action="${pageContext.request.contextPath}/login" method="POST">
        <input class="elementLogin" type="text" placeholder="Inserire l'Username" name="username" id="loginUsername" value="admin"/>
        <input class="elementLogin" type="password" placeholder="Inserire la Password" name="password" id="loginPassword" value="admin"/>
        <input class="elementLogin" type="submit" value="Login"/>
    </form>




</main>

<jsp:include page="footer.jsp"/>