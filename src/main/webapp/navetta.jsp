<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="intestazione.jsp" />

<main>
    <link rel="stylesheet" type="text/css" href="css/rowStruttura.css">
    <link rel="stylesheet" type="text/css" href="css/navetta.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Smokum&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Chokokutai&display=swap" rel="stylesheet">

</main>

<main id="mainBody">

  <div class="cover" style="background-image: url('Images/Attivita/School-Bus.jpg')">
    <h1> NAVETTA </h1>
    <h3> Istituto Tecnino Tum4World</h3>
  </div>

  <div class="spaziatura"></div>
  <div class="spaziatura"></div>

  <div id="row-bus" setMargin="true">
      <div class="col-50-bus">
          <h1>NAVETTA</h1>
          <p>
              Il servizion di navetta è nato dall'esigenza di permettere a tutti i ragazzi,
              anche colore che vivono nei paesini limitrofi a Meru, di frequentare la nostra squola
          </p>
          <p>
              Quando è nata l' idea del servizio navetta come associazione abbiamo stimato che con 3 vetture saremmo
              riusciti a coprire a 360° l' intera area circostante. Ad oggi Tum4World è arrivata a finaziare solo 2 navette,
              Attualmente come associazioe stiamo cercando i fondi per completare questo progetto.
          </p>
          <p>
              Con i ragazzi che usufruiscono di questo servizio abbiamo deciso di dare dei nomi alle 2 navette: "Thunder" e "McQueen"
          </p>
          <p>
              Se volete contribuire al completamto del parco vetture cliccate sul bottone DONA, Il costo totale della nuova navetta è
              di 75.000$.
              Dalla barra a destra potete vedere la percentuale del fondo raggiunto, rappresentata dalla barra gialla.
          </p>
          <button type="button" onclick="showFormDona()"> DONA </button>
      </div>
    <div class="col-50-bus">
        <div class="container-bus-rows">
            <div class="bus-row" acquired="true">
                <div class="elm-scorre">
                    <div class="bus-description">
                        <p><span colore-testo="giallo">Destinazione</span>: Muthara</p>
                        <p><span colore-testo="giallo">Tempo Tragitto</span>: 1h 30m</p>
                        <p><span colore-testo="giallo">Fermate</span>: Schuola - Ruiri Town - Kianjai - Muthara</p>
                    </div>
                    <div class="bus-row-first-el" acquired="true">
                        <h2 class="nomeBusThunder">Thunder</h2>
                        <img src="Images/Attivita/iconaBus.png" class="iconaBus" alt="Icona Bus"/>
                    </div>
                </div>
            </div>

            <div class="bus-row" acquired="true">
                <div class="elm-scorre">
                    <div class="bus-description">
                        <p><span colore-testo="giallo">Destinazione</span>: Katheri</p>
                        <p><span colore-testo="giallo">Tempo Tragitto</span>: 1h</p>
                        <p><span colore-testo="giallo">Fermate</span>: Schuola - Kithaku - Katheri</p>
                    </div>
                    <div class="bus-row-first-el" acquired="true">
                        <h2 class="nomeBusMcQueen">McQueen</h2>
                        <img src="Images/Attivita/iconaBus.png" class="iconaBus" alt="Icona Bus"/>
                    </div>
                </div>
            </div>

            <div class="bus-row" acquired="false">
                <div class="elm-scorre">
                    <div class="bus-description">
                        <p>Work in Progess</p>
                        <p>Dona per far aumentare la barra del budget </p>
                    </div>
                    <div class="bus-row-first-el" acquired="false">
                        <img src="Images/Attivita/iconaBus.png" class="iconaBus" alt="Icona Bus"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>

  <script type="text/javascript" src="javascript/navetta.js"></script>

  <div class="spaziatura"></div>

  <div id="popUp" pop-up="false" >
      <div id="formDonazione">
          <div id="closer" onclick="closeFormDona()">
              <img src="Images/Attivita/iconaX.png" style="width: 30px">
          </div>
          <h2> DONA </h2>
          <form id="formReale" action="src/main/java/com/example/pw2/GestoreDonazioniNavetta.java" method="post">
              <p setMargin="true">La tua donazione sarà destinata all'acuisto della terza navetta</p>
              <label for="importo">Importo Donazione</label>
              <input type="number" placeholder="0" name="importo" required>
              <button type="submit"> DONA </button>
          </form>
      </div>
  </div>

</main>

<jsp:include page="footer.jsp"/>

