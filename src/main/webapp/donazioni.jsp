<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />



<link rel="stylesheet" type="text/css" href="css/struttura.css">
<link rel="stylesheet" type="text/css" href="css/donazioni.css">

<main>

    <section>
        <jsp:include page="simpOrAd.jsp" />

        <div class="pagina">
            <div class="box">
                <div class="titolo">
                    <header>Donazioni</header>
                    <p>
                        Donare all'associazione di beneficenza Tum4world è un modo significativo per sostenere l'istruzione e l'empowerment di persone di tutte le età. Attraverso i vostri contributi, Tum4world può offrire opportunità educative a coloro che ne hanno bisogno, aprendo le porte a un futuro migliore. I fondi donati aiutano a finanziare programmi educativi, borse di studio e risorse didattiche, consentendo a individui svantaggiati di accedere a una formazione di qualità. Donare a Tum4world significa investire nell'istruzione come strumento di cambiamento e progresso per le comunità, offrendo speranza e opportunità a chiunque desideri apprendere e crescere.
                    </p>
                </div>
                <div class="input-donazioni">
                    <input type="number" class="input-testo" placeholder="Inserisci l'importo" autocomplete="off" required>
                </div>
                <div class="bottone">
                    <button class="button-standard" id="bottone">Dona</button>
                </div>
            </div>
        </div>


    </section>

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('donazioni.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>