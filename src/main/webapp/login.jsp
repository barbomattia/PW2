<jsp:include page="intestazione.jsp" />
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->

<main>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/struttura.css">

    <sectionLogin>
        <div class="riquadro">
            <form action="${pageContext.request.contextPath}/login" method="POST">
                <h2>Login</h2>
                <div class="inputlogin">
                    <ion-icon name="mail-outline"></ion-icon>
                    <input type="text" required value="admin" name="username" id="loginUsername">
                    <label>Username</label>
                    <!--
                        <input type="text" required value="admin" name="username" id="loginUsername">
                        <input type="password" required value="21Adm1n!" name="password" id="loginPassword">

                        <input type="text" required value="barbo02" name="username" id="loginUsername">
                        <input type="password" required value="rinoGattuso" name="password" id="loginPassword">
                     -->
                </div>
                <div class="inputlogin">
                    <ion-icon name="lock-closed-outline"></ion-icon>
                    <input type="password" required value="21Adm1n!" name="password" id="loginPassword">
                    <label>Password</label>
                </div>
                <div class="dimenticato">
                    <a href="#">Password dimenticata</a>
                </div>
                <button class="button-standard" type="submit">Login</button>
                <div class="registrazione">
                    <p>Non hai un account? <a href="signUp.jsp">Registrati</a></p>
                </div>
            </form>
        </div>
    </sectionLogin>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</main>

<jsp:include page="footer.jsp"/>

