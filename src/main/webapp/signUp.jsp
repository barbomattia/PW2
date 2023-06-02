<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="intestazione.jsp" />

<main id="signUpBody">
    <link rel="stylesheet" type="text/css" href="css/signUp.css">

    <section style="background-image: url('Images/sfondoSignUp.jpg')">
        <div class="riquadro">
            <form action="${pageContext.request.contextPath}/signUp" method="POST">
                <h2>Registrazione</h2>
                <div class="userinfo">
                    <div class="inputregistrazione">
                        <input type="text" required>
                        <label>Nome</label>
                    </div>
                    <div class="inputregistrazione">
                        <input type="text" required>
                        <label>Cognome</label>
                    </div>
                    <div class="inputregistrazione">
                        <input type="text" required>
                        <label>Data di nascita</label>
                    </div>
                    <div class="inputregistrazione">
                        <input type="text" required>
                        <label>Telefono</label>
                    </div>
                    <div class="inputregistrazione">
                        <ion-icon name="mail-outline"></ion-icon>
                        <input type="email" required>
                        <label>Email</label>
                    </div>
                    <div class="inputregistrazione">
                        <input type="text" required>
                        <label>Username</label>
                    </div>
                    <div class="inputregistrazione">
                        <ion-icon name="lock-closed-outline"></ion-icon>
                        <input type="password" required>
                        <label>Password</label>
                    </div>
                    <div class="inputregistrazione">
                        <ion-icon name="lock-closed-outline"></ion-icon>
                        <input type="password" required>
                        <label>Conferma Password</label>
                    </div>
                </div>
                <div class="affiliazione">
                    <span class="titolo-affiliazione">Tipo affiliazione</span>
                    <div class="tipo-affiliazione">
                        <input type="radio" required>
                        <label>simpatizzante</label>
                        <input type="radio" required>
                        <label>aderente</label>
                    </div>
                </div>
                <button>Registrati</button>
                <div class="login">
                    <p>Hai già un account? <a href="login.jsp">Accedi</a></p>
                </div>
            </form>
        </div>
    </section>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</main>

        <!-- <h1 class="signupElement" id="title"> Registrati qua</h1>
             <input style="margin: 5px" class="signupElement" type="text" placeholder="Nome" name="name" required/>

            <input style="margin: 5px" class="signupElement" type="text" placeholder="Cognome" name="surname" required>

            <br><br>

            <input class="signupElement" type="date" name="date" required>
            <p><sup>*</sup>Devi essere maggiorenne</p>


            <input class="signupElement" type="email" placeholder="youremail@domain" name="mail" required>

            <br><br>

            <input class="signupElement" type="integer" id="phoneNumber" placeholder="Numero di telefono" name="phone_number" required>

            <br><br>

            <label for="affiliazione">Tipo di affiliazione:</label>
            <select class="signupElement" id="affiliazione" name="role">
                <option value="aderente"> Aderente</option>
                <option value="simpatizzante"> Simpatizzante</option>
            </select>

            <br><br>

            <input class="signupElement" type="text" placeholder="Username" name="username" required>

            <br><br>

            <input class="signupElement" type="password" placeholder="Password" name="password" required>

            <input class="signupElement" type="password" placeholder="Conferma password" required>

            <br><br>

            <p id="infoPassword"><sup>*</sup> La password deve essere lunga 8 caratteri, deve contenere almeno un carattere numerico, un carattere
                maiuscolo e un carattere tra $, ! e ?</p>

            <br><br>
            <button style="margin: 5px" type="submit">Registrati</button>
            <input style="margin: 5px" type="reset">

            <br><br>
            <br><br>
            <br><br>
            <br><br> -->


<jsp:include page="footer.jsp" />
