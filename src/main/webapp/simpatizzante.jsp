<jsp:include page="intestazione.jsp" />

<main id="mainSimpatizzante">
    <h1 class="classSimpatizzante">Area simpatizzante, utente ${username} - id = ${id}</h1>

    <form class="classSimpatizzante" id="formVisualizzaDati">
        <p id="elencoDati">Dati personali:</p>
        <button onclick="visualizzaDati('${id}', '${username}')">Visualizza</button>
    </form>
    <br>
    <form class="classSimpatizzante">
        <p>Iscriviti ad un'attivit&agrave;:</p>
        <button>Seleziona un'attivit&agrave;</button>
    </form>
    <br>
    <form class="classSimpatizzante">
        <p>Elimina account:</p>
        <button>Cancella dati</button>

        <link rel="stylesheet" type="text/css" href="css/simpatizzante.css">


    </form>
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

