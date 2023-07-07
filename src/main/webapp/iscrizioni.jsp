<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />

<link rel="stylesheet" type="text/css" href="css/iscrizioni.css">

<main>

    <div class="conteiner">
        <div class="box">
            <h3>Scuola</h3>
            <p>
                Iscrivendoti come volontario nella scuola di Tum4World, farai parte di una comunità solidale che crede nell'importanza dell'istruzione per tutti. Avrai l'opportunità di promuovere l'uguaglianza e l'accesso all'istruzione, regalando speranza e nuove prospettive ai giovani studenti. La tua partecipazione può fare la differenza nella loro vita e nel loro futuro.
            </p>
            <button>Iscriviti</button>
            <span class="count">1</span>
        </div>

        <div class="box">
            <h3>Navetta</h3>
            <p>
                Lavorare come autista volontario per Tum4World ti consentirà di fare la differenza nella vita di coloro che dipendono dal servizio di navetta per accedere a cibo, istruzione o altre risorse importanti. La tua iscrizione ti aprirà le porte a un'esperienza gratificante e significativa, offrendo un supporto fondamentale alle persone in situazioni di vulnerabilità.
            </p>
            <button>Iscriviti</button>
            <span class="count">2</span>
        </div>

        <div class="box">
            <h3>Mensa</h3>
            <p>
                L'iscrizione all'associazione di Tum4World è il primo passo per unirti al team di volontari impegnati nella mensa. Che tu sia un cuoco, amante della cucina, o semplicemente vuoi dare una mano nella mensa potrai condividere il tuo tempo, le tue competenze e la tua passione per aiutare gli altri, fornendo pasti e speranza alle persone che ne hanno bisogno.
            </p>
            <button>Iscriviti</button>
            <span class="count">3</span>
        </div>
    </div>

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('iscrizioni.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>