<jsp:include page="intestazione.jsp" />

<main id="loginBody">
  <link rel="stylesheet" type="text/css" href="css/login.css">

  <div class="elementLogin">
    <h1 class="elementLogin" id="title">Login</h1>

    <p class="elementLogin">Username:</p>
    <input class="elementLogin" type="text" placeholder="Inserire l'Username" name="username" id="loginUsername" value="admin">
    <br>
    <br>
    <p class="elementLogin">Password:</p>
    <input class="elementLogin" type="password" placeholder="Inserire la Password" name="password" id="loginPassword" value="12@Admin">
    <br>
    <br>
    <button class="elementLogin" type="submit" onclick="login()">Login</button>
    <br>
    <!--<a href="./recuperaCredenziali.html">Recupera credenziali</a>-->
    <br>
    <br>
    <a id="description"></a>

    <form action="signUp.html">
      <p>Non hai un account?</p>
      <button type="submit">Registrati</button>
    </form>
  </div>

</main>

<jsp:include page="footer.jsp"/>