<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="intestazione.jsp" />

<link rel="stylesheet" type="text/css" href="css/rowStruttura.css">

<main id="mainBody">

    <div class="cover" style="background-image: url('Images/Attivita/Mensa.jpg')">
        <h1 style="color: darkolivegreen"> MENSA </h1>
        <h3 style="color: black"> Istituto Tecnino Tum4World</h3>
    </div>

    <div class="spaziatura"></div>
    <div class="spaziatura"></div>

    <div class="row" setMargin="true">
        <div class="col-50">
            <h1>MENSA</h1>
            <p>
                Il servizio mensa fornisce agli studenti del nostro istituto ogni giorno il pranzo.
            </p>
            <p>
                Questo servizio è fondamentale infatti oltre a toglie dalle spalle delle famiglie un pasto giornaliero
                ; assicura un pasto ricco ed equilibrato a tutti i scolari.
            </p>
            <p>
                Da qualche hanno la mesa ha attivato una iniziativa con un forno locale che permette di fornire ai ragazzi
                pane fresco di giornata.
            </p>
        </div>

        <div class="col-50 pl-2">
            <div class="cover" style="background-image: url('Images/Attivita/pane.jpg')"></div>
        </div>
    </div>

    <div class="spaziatura"></div>

</main>

<jsp:include page="footer.jsp"/>
