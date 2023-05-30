<jsp:include page="intestazione.jsp" />

<main id="loginBody">
    <link rel="stylesheet" type="text/css" href="css/login.css">

    <h1 class="elementLogin" id="title">Login</h1>

    <form class="elementLogin" action="${pageContext.request.contextPath}/login" method="POST">
        <input class="elementLogin" type="text" placeholder="Inserire l'Username" name="username" id="loginUsername" value="admin"/>
        <br><br>
        <input class="elementLogin" type="password" placeholder="Inserire la Password" name="password" id="loginPassword" value="admin"/>
        <br><br>
        <input class="elementLogin" type="submit" value="Login"/>
    </form>

    <a id="description"></a>

    <form action="signUp.jsp" class="elementLogin">
        <p>Non hai un account?</p>
        <button type="submit">Registrati</button>
    </form>



</main>

<jsp:include page="footer.jsp"/>