<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="intestazione.jsp" />

<link rel="stylesheet" type="text/css" href="css/rowStruttura.css">
<link rel="stylesheet" type="text/css" href="css/cardScrolUp.css">

<main id="mainBody">
    <div class="cover" style="background-image: url('Images/Attivita/Scuola.jpg')">
        <h1> SCUOLA </h1>
        <h3> Istituto Tecnino Tum4World</h3>
    </div>

    <div class="spaziatura"></div>
    <div class="spaziatura"></div>

    <div class="row" setMargin="true">
        <div class="col-50">
            <h1>STRUTTURA</h1>
            <p>
                L'istituto Tum4World è il cuore e punto nevralgico della nostra associazione.
            </p>
            <p>
                La struttura originaria risale ai primi anni cinquanta del novecento. Dopo la nostra acquisizione avvenuta nel
                1996 è iniziata una fase di restrutturazione per renderla consona ad un ambiente per ragazzi.
            </p>
            <p>
                Sucessivamenti la scuola ha subito molti ampliamenti per soddisfare la necessità sempre maggiore di aule
                per accogliere il numero crescente di studenti. Inoltre questi aggiornamenti hanno permesso l'attivazione delle
                altre attivita di tum4World: una cucina e sala pranzo per il servizio di mensa, e uno spiazzale per il servizio
                navetta
            </p>
            <p>
                Attualmente l'associazione sta recuperando i fondi necessari per finanziare un nuovo ampliamento che prevede
                la creazione di una aula compiuter necessaria per avviare il nuovo corso di studi di informatica
            </p>
        </div>
        <div class="col-50 pl-2">
             <div class="cover" style="background-image: url('Images/Attivita/Scuola1.jpg')"></div>
        </div>
    </div>

    <div class="spaziatura"></div>

    <div class = row setMargin="true">
        <div class="col-100">
            <h1>CORSI</h1>
            <p>
                Il nostro istituto storicamente mette a disposizione 2 corsi di studio: meccanico e alberghiero,
                da quest'anno, grazie a voi, abbiamo una novità al riguardo. Infatti grazie alle vostre cospique donazioni
                da quest'anno partitrà il nuovo corso di chimica.
            </p>
            <p>
                Ma non è tutto, infatti sono gia iniziati i lavori per la costruzione di una nuova aula computer che permetterà
                l'avvio di un quarto corso aggiungivo quello informatico.
            </p>
        </div>

    </div>

    <div id="rigaCards" style="padding-bottom: 100px">
        <div class="cardSU">
            <p class="new-tag"> NEW </p>
            <div class="imgCard" new="true" style="background-image: url('Images/Attivita/Chimica.jpg')">
                <div class="covering sfondoGiallo"> <h2> CHIMICA </h2> </div>
            </div>
            <div class="tendinaCard" >
                <h3>Corso Chimica</h3>
                <button class="bottoneCard" testo="chimica">READ</button>
            </div>
        </div>

        <div class="cardSU">
            <div class="imgCard" style="background-image: url('Images/Attivita/Meccanica.jpg')">
                <div class="covering sfondoRed"> <h2> MECCANICA </h2></div>
            </div>
            <div class="tendinaCard" >
                <h3>Corso Meccanica</h3>
                <button class="bottoneCard" testo="meccanica">READ</button>
            </div>
        </div>

        <div class="cardSU">
            <div class="imgCard" style="background-image: url('Images/Attivita/Alberghiero.jpg')">
                <div class="covering sfondoVerde"> <h2> ALBERGHIERO </h2> </div>
            </div>
            <div class="tendinaCard" >
                <h3>Corso Alberghiero</h3>
                <button class="bottoneCard" testo="alberghiero">READ</button>
            </div>
        </div>


        <div class="cardSU">
            <p class="next-tag">NEXT</p>
            <div class="imgCard" next="true" style="background-image: url('Images/Attivita/Informatica.jpg')">
                <div class="covering sfondoBlu"> <h2> INFORMATICA </h2> </div>
            </div>
            <div class="tendinaCard" >
                <h3>Corso Informatica</h3>
                <button class="bottoneCard" testo="informatica">READ</button>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="javascript/cardScolUp.js"></script>

</main>

<jsp:include page="footer.jsp"/>