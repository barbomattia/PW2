
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->



<!--<link rel="stylesheet" type="text/css" href="css/${role}.css">-->


<main>
    <link rel="stylesheet" type="text/css" href="css/aderente.css">


        <div class="barra">
            <ul class="lista">
                <li class="elemento">
                    <a href="profilo.jsp">
                        <div class="icon">
                            <ion-icon name="accessibility-outline" ></ion-icon>
                            <ion-icon name="accessibility-outline" ></ion-icon>
                        </div>
                        <div class="testo"><span data-text="Profilo">Profilo</span></div>
                    </a>
                </li>
                <li class="elemento">
                    <a href="iscrizioni.jsp">
                        <div class="icon">
                            <ion-icon name="bus-outline"></ion-icon>
                            <ion-icon name="bus-outline"></ion-icon>
                        </div>
                        <div class="testo"><span data-text="Iscriviti">Iscriviti</span></div>
                    </a>
                </li>
                <li class="elemento">
                    <a href="donazioni.jsp">
                        <div class="icon">
                            <ion-icon name="gift-outline"></ion-icon>
                            <ion-icon name="gift-outline"></ion-icon>
                        </div>
                        <div class="testo"><span data-text="Dona">Dona</span></div>
                    </a>
                </li>
                <li class="elemento">
                    <a href="#">
                        <div class="icon">
                            <ion-icon name="log-out-outline"></ion-icon>
                            <ion-icon name="log-out-outline"></ion-icon>
                        </div>
                        <div class="testo"><span data-text="Logout">Logout</span></div>
                    </a>
                </li>
                <li class="elemento">
                    <a href="#">
                        <div class="icon">
                            <ion-icon name="trash-outline"></ion-icon>
                            <ion-icon name="trash-outline"></ion-icon>
                        </div>
                        <div class="testo"><span data-text="Elimina">Elimina</span></div>
                    </a>
                </li>
            </ul>
        </div>










    <!--
    <script>
        localStorage.setItem("id", "${id}");
        localStorage.setItem("username", "${username}");
        localStorage.setItem("role", "${role}");
    </script>


    <h1 class="classSimpOrAd">Area  <span id="idRuoloUtente"> ${role}</span>, utente ${username} - id = ${id}</h1>

    <div class="classSimpOrAd">
        <button type="submit" class="btn" onclick="mostraDati()">Visualizza dati personali</button>
        <div class="popup" id="idPopupMostraDati">
            <h2>Dati utente ${username}</h2>
            <p>Ruolo: ${role}</p>
            <p>Name: ${name}</p>
            <p>Surname: ${surname}</p>
            <p>Data di nascita: ${date_of_birth}</p>
            <p>Indirizzo mail: ${mail}</p>
            <p>Numero di telefono: ${phone_number}</p>
            <button onclick="chiudiMostraDati()">Chiudi</button>
        </div>
    </div>

    <br>

    <div class="classSimpOrAd">
        <button type="submit" class="btn" onclick="selezionaAttivita()">Seleziona un'attivit&agrave; dati personali</button>
        <div class="popup" id="idPopupIscrizioneAttivita">
            <h2>Seleziona una o pi&ugrave; attivit&agrave; alla quale iscriverti:</h2>
            <input type="checkbox" value="Scuola">Scuola
            <br>
            <input type="checkbox" value="Bus">Bus
            <br>
            <input type="checkbox" value="Mensa">Mensa
            <br>
            <br>
            <button onclick="chiudiSelezionaAttivita()">Chiudi</button>

        </div>
    </div>

    <br>

    <div class="classSimpOrAd">
        <button type="submit" class="btn" onclick="mostraEffettuaDonazione('${role}')">Effettua una donazione</button>
        <div class="popup" id="idPopupDonazione">
            //<form action="${pageContext.request.contextPath}/DonazioniUtenti" method="POST">
                <h2>Immetti l'importo che vuoi donare:</h2>
                <input type="number" placeholder="Inserisci importo:" id="idImportoDonazione" required>&euro;
                <br>
                <br>
                <textarea placeholder="Inserisci causale donazione" id="idMessaggioDonazione" required></textarea>
                <br>
                <br>
                <button type="submit" onclick="effettuaDonazione()">Dona</button>
                //<button type="submit">Dona</button>
                <button onclick="chiudiEffettuaDonazione()">Chiudi</button>
                //</form>
        </div>
        <script>

        </script>
    </div>

    <br>

    <div>
        <div class="classSimpOrAd">
            <button type="submit" class="btn" onclick="mostraEliminaAccount()">Elimina account</button>
            <div class="popup" id="idPopupEliminaAccount">
                <h2>Sei sicuro di voler eliminare l'account?</h2>
                <button onclick="eliminaAccount()">Si (tornerai alla schermata home)</button>
                <button onclick="chiudiMostraEliminaAccount()">No</button>
            </div>
            <script>
                function eliminaAccount(){
                    window.location.href = "${pageContext.request.contextPath}/eliminaAccount?id=" + ${id};
                }
            </script>
        </div>
    </div>

    <br>

    <div class="classSimpOrAd">
        <a href="${pageContext.request.contextPath}/logout">Effettua il logout</a>
    </div>
    <br>
    <br>
    <br>
    <script src="./javascript/simpOrAd.js"></script>-->
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('simpOrAd.jsp')"></script>

</main>




