<jsp:include page="intestazione.jsp" />

<main id="signUpBody">
    <link rel="stylesheet" type="text/css" href="css/signUp.css">

    <section>
        <div class="riquadro">
            <h2>Registrazione</h2>
            <form class="form" onsubmit="return controllaCampi()" action="${pageContext.request.contextPath}/signUp" method="POST">
                <div class="column">
                    <div class="inputregistrazione">
                        <label>Nome</label>
                        <input type="text" placeholder="nome" required name="name">
                    </div>
                    <div class="inputregistrazione">
                        <label>Cognome</label>
                        <input type="text" placeholder="cognome" required name="surname">
                    </div>
                </div>

                <div class="column">
                    <div class="inputregistrazione">
                        <label>Email</label>
                        <input type="email" placeholder="email" required name="mail" id="idMail">
                    </div>
                    <div class="inputregistrazione">
                        <label>Username</label>
                        <input type="text" placeholder="username" required name="username">
                    </div>
                </div>

                <div class="column">
                    <div class="inputregistrazione">
                        <label>Telefono</label>
                        <input type="Number" placeholder="numero di telefono" required name="telefono" id="idNumeroDiTelefono">
                    </div>
                    <div class="inputregistrazione">
                        <label>Data di nascita</label>
                        <input type="date" placeholder="data di nascita" required id="idDataDiNascita">
                    </div>
                </div>

                <div class="column">
                    <div class="inputregistrazione">
                        <label>Password</label>
                        <input type="password" placeholder="password" required name="password" id="idPassword1">
                    </div>
                    <div class="inputregistrazione">
                        <label>Conferma Password</label>
                        <input type="password" placeholder="conferma password" required id="idPassword2">
                    </div>
                </div>

                <div class="affiliazione-box">
                    <h3>Affiliazione</h3>
                    <div class="affiliazione">
                        <div class="tipo-affiliazione">
                            <input type="radio" required id="affiliazione1" name="role">
                            <label for="affiliazione1">simpatizzante</label>
                        </div>
                        <div class="tipo-affiliazione">
                            <input type="radio" required id="affiliazione2" name="role">
                            <label for="affiliazione2">aderente</label>
                        </div>
                    </div>

                </div>

                <div class="bottoni">
                    <button type="submit">Registrati</button>
                    <button type="reset">Reset</button>
                </div>

                <div class="login">
                    <p>Hai già un account? <a href="login.jsp">Login</a></p>
                </div>


                <!--<label for="affiliazione">Tipo di affiliazione:</label>
                <select class="signupElement" id="affiliazione" name="role">
                    <option value="aderente"> Aderente</option>
                    <option value="simpatizzante"> Simpatizzante</option>
                </select>



                <div class="affiliazione">
                    <span class="titolo-affiliazione">Tipo affiliazione</span>
                    <div class="tipo-affiliazione">
                        <input type="radio" required>
                        <label>simpatizzante</label>
                        <input type="radio" required>
                        <label>aderente</label>
                    </div>
                </div>

                <button type="submit">Registrati</button>
                <button type="reset">Reset</button>
                 type="submit"
                <div class="login">
                    <p>Hai già un account? <a href="login.jsp">Accedi</a></p>
                </div>
                -->
            </form>
        </div>
    </section>
    <script src="./javascript/signUp.js"></script>
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
