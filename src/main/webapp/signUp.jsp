<jsp:include page="intestazione.jsp" />
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->

<main>
    <link rel="stylesheet" type="text/css" href="css/signUp.css">
    <link rel="stylesheet" type="text/css" href="css/struttura.css">


    <section class="signUp">
        <div class="riquadro">
            <h2>Registrazione</h2>
            <form id="formSignUp" class="form" onsubmit="return controllaCampi()" onreset="over_reset()" action="${pageContext.request.contextPath}/signUp" method="POST">
                <div class="column">
                    <div class="inputRegistrazione">
                        <label error_label="false">Nome</label>
                        <input type="text" placeholder="Nome" required name="name" id="idName" error="false">
                    </div>
                    <div class="inputRegistrazione">
                        <label error_label="false">Cognome</label>
                        <input type="text" placeholder="Cognome" required name="surname" id="idSurname" error="false">
                    </div>
                </div>

                <div class="column">
                    <div class="inputRegistrazione">
                        <label for="idMail" id="idMail_label" error_label="false">Email</label>
                        <input type="email" placeholder="Email" required name="mail" id="idMail" error="false">
                    </div>
                    <div class="inputRegistrazione">
                        <label id="idUsername_label" error_label="false">Username</label>
                        <input type="text" placeholder="Username" required name="username" id="idUsername" error="false">
                    </div>
                </div>

                <div class="column">
                    <div class="inputRegistrazione">
                        <label for="idNumeroDiTelefono" id="idNumeroDiTelefono_label" error_label="false">Telefono</label>
                        <input type="Number" name="phone_number" placeholder="Numero di telefono" required id="idNumeroDiTelefono" error="false">
                    </div>
                    <div class="inputRegistrazione">
                        <label for="idDataDiNascita" id="idDataDiNascita_label" error_label="false">Data di nascita</label>
                        <input type="date" name="birth" placeholder="Data di nascita" required id="idDataDiNascita" error="false">
                    </div>
                </div>

                <div class="column">
                    <div class="inputRegistrazione">
                        <label for="idPassword1" id="idPassword1_label" error_label="false">Password</label>
                        <input type="password" placeholder="Password" required name="password" id="idPassword1" error="false">
                        <button type="button" class="mostra-password" onclick="mostraOrNascondiPassword('idPassword1')">Mostra/Nascondi password</button>
                    </div>
                    <div class="inputRegistrazione">
                        <label for="idPassword2" id="idPassword2_label" error_label="false">Conferma Password</label>
                        <input type="password" placeholder="Conferma password" required id="idPassword2" error="false">
                        <button type="button" class="mostra-password" onclick="mostraOrNascondiPassword('idPassword2')">Mostra/Nascondi password</button>
                    </div>
                </div>

                <p>Requisiti password: ESATTAMENTE 8 caratteri, di cui almeno tre 'M'/'m' e una 'L'/'l', almeno un carattere numerico compreso tra 0 e 9, almeno un carattere minuscolo e almeno un carattere tra '$', '!' e '?'</p>

                <div class="affiliazione-box">
                    <h3>Affiliazione</h3>
                    <div class="affiliazione">
                        <div class="tipo-affiliazione">
                            <input type="radio" required id="affiliazione1" name="role" value="simpatizzante">
                            <label for="affiliazione1">Simpatizzante</label>
                        </div>
                        <div class="tipo-affiliazione">
                            <input type="radio" required id="affiliazione2" name="role" value="aderente">
                            <label for="affiliazione2">Aderente</label>
                        </div>
                    </div>

                </div>

                <div class="bottoni">
                    <button class="button-standard" type="submit">Registrati</button>
                    <button class="button-standard" type="reset">Reset</button>
                </div>

                <div class="login">
                    <p>Hai gi&agrave; un account? <a href="login.jsp">Login</a></p>
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

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('signUp.jsp')"></script>
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
