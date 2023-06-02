<jsp:include page="intestazione.jsp" />

<main id="loginBody">
    <link rel="stylesheet" type="text/css" href="css/login.css">

    <section style="background-image: url('Images/sfondoLogin.jpg')">
        <div class="riquadro">
            <form action="${pageContext.request.contextPath}/login" method="POST">
                <h2>Login</h2>
                <div class="inputlogin">
                    <ion-icon name="mail-outline"></ion-icon>
                    <input type="text" required>
                    <label>Username</label>
                    <!-- <input type="text" placeholder="Inserire l'Username" name="username" id="loginUsername" value="admin"/> -->
                </div>
                <div class="inputlogin">
                    <ion-icon name="lock-closed-outline"></ion-icon>
                    <input type="password" required>
                    <label>Password</label>
                    <!-- <input type="password" placeholder="Inserire la Password" name="password" id="loginPassword" value="admin"/> -->
                </div>
                <div class="dimenticato">
                    <a href="#">Password dimenticata</a>
                </div>
                <button>Login</button>
                <div class="registrazione">
                    <p>Non hai un account? <a href="signUp.jsp">Registrati</a></p>
                </div>
            </form>
        </div>
    </section>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</main>

<jsp:include page="footer.jsp"/>

