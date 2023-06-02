<jsp:include page="intestazione.jsp" />

<main id="mainSimpatizzante">

    <link rel="stylesheet" type="text/css" href="css/simpatizzante.css">

    <h1 class="classSimpatizzante">Area simpatizzante, utente ${username} - id = ${id}</h1>

    <div class="classSimpatizzante">
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
    <div class="classSimpatizzante">
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

    <div>
        <div class="classSimpatizzante">
            <button type="submit" class="btn" onclick="mostraEliminaAccount()">Elimina account</button>
            <div class="popup" id="idPopupEliminaAccount">
                <h2>Sei sicuro di voler eliminare l'account?</h2>
                <!-- eliminaAccount() ANCORA DA IMPLEMENTARE -->
                <button onclick="eliminaAccount()">Si (tornerai alla schermata home) (DA IMPLEMENTARE)</button>
                <button onclick="chiudiMostraEliminaAccount()">No</button>
            </div>
        </div>
    </div>

    <br>

    <div class="classSimpatizzante">
        <a href="${pageContext.request.contextPath}/logout">Effettua il logout</a>
    </div>
    <br>
    <br>
    <br>
    <script src="./javascript/simpatizzante.js"></script>


</main>


<jsp:include page="footer.jsp" />

