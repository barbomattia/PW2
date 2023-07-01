<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="intestazione.jsp" />


<link rel="stylesheet" type="text/css" href="css/attivita.css">
<link rel="stylesheet" type="text/css" href="css/struttura.css">

<main>
    <div class="cover">
        <h1> ATTIVITA' </h1>
        <h3> Istituto Tecnico Tum4World</h3>
    </div>

    <section>
        <div class="row-singola">
            <h1>Attivita'</h1>
            <p>
                descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione
                descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione
                descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione
                descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione
                descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione
                descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione descrizione
            </p>
        </div>

        <div id="rigaAttivita">
            <a href="scuola.jsp" class="noSottolineatura">
                <div class="card" style="background-image: url('Images/Attivita/Scuola.jpg')">
                    <div class="cardInfo">
                        <h3 class="cardInfoText"> SCUOLA </h3>
                        <p class="cardInfoText">
                            DESCRIZIONE SCUOLA/DESCIZIONE SCUOLA/DESCRIZIONE SCUOLA/DESCIZIONE SCUOLA/DESCRIZIONE SCUOLA/
                            DESCRIZIONE SCUOLA/DESCIZIONE SCUOLA/DESCRIZIONE SCUOLA/DESCIZIONE SCUOLA/DESCRIZIONE SCUOLA/
                        </p>
                    </div>
                </div>
            </a>

            <a href="${pageContext.request.contextPath}/GestoreDonazioniNavetta" methods="GET" class="noSottolineatura">
                <div class="card" style="background-image: url('Images/Attivita/School-Bus.jpg')">
                    <div class="cardInfo">
                        <h3 class="cardInfoText"> BUS </h3>
                        <p class="cardInfoText">
                            DESCRIZIONE BUS/DESCIZIONE BUS/DESCRIZIONE BUS/DESCIZIONE BUS/DESCRIZIONE BUS/DESCIZIONE BUS/
                            DESCRIZIONE BUS/DESCIZIONE BUS/DESCRIZIONE BUS/DESCIZIONE BUS/DESCRIZIONE BUS/DESCIZIONE BUS/
                        </p>
                    </div>
                </div>
            </a>

            <a href="mensa.jsp" class="noSottolineatura">
                <div class="card" style="background-image: url('Images/Attivita/Mensa.jpg')">
                    <div class="cardInfo">
                        <h3 class="cardInfoText"> MENSA </h3>
                        <p class="cardInfoText">
                            DESCRIZIONE MENSA/DESCIZIONE MENSA/DESCRIZIONE MENSA/DESCIZIONE MENSA/DESCRIZIONE MENSA/DESCIZIONE MENSA/
                            DESCRIZIONE MENSA/DESCIZIONE MENSA/DESCRIZIONE MENSA/DESCIZIONE MENSA/DESCRIZIONE MENSA/DESCIZIONE MENSA/
                        </p>
                    </div>
                </div>
            </a>


            <script type="text/javascript" src="javascript/attivita.js"></script>
        </div>
    </section>



</main>

<jsp:include page="footer.jsp"/>