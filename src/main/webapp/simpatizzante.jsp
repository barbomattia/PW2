<jsp:include page="intestazione.jsp" />

<main id="mainSimpatizzante">

    <link rel="stylesheet" type="text/css" href="css/simpatizzante.css">

    <h1 class="classSimpatizzante">Area simpatizzante, utente ${username}</h1>

    <div class="classSimpatizzante">
        <p id="elencoDati">Dati personali:</p>
        <button onclick="visualizzaDati()">Visualizza</button>
    </div>
    <br>
    <form class="classSimpatizzante">
        <p>Iscriviti ad un'attivit&agrave;:</p>
        <button>Seleziona un'attivit&agrave;</button>
    </form>
    <br>
    <form class="classSimpatizzante">
        <p>Elimina account:</p>
        <button>Cancella dati</button>
    </form>
    <br>
    <div class="classSimpatizzante">
        <a href="${pageContext.request.contextPath}/logout">Effettua il logout</a>
    </div>
    <br>
    <script src="./javascript/simpatizzante.js"></script>

</main>

<jsp:include page="footer.jsp" />

