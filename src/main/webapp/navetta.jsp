<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="intestazione.jsp" />

<% float percDon = (float)request.getAttribute("percDonazioni"); %>

<main>
    <link rel="stylesheet" type="text/css" href="css/struttura.css">
    <link rel="stylesheet" type="text/css" href="css/navetta.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Smokum&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Chokokutai&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@900&display=swap" rel="stylesheet">
</main>

<main>

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
              <% if(percDon < 100.0) { %>
              attualmente come associazioe stiamo cercando i fondi per completare questo progetto.
              <% } else{ %>
              ma grazie alle vostre donazioni siamo riusciti a raggiungere i soldi necessari per comprare la terza navetta.
              Attualmente il nostro team sta lavorando per effettuare l'acquisto.
              <% } %>
          </p>
          <p>
              Con i ragazzi che usufruiscono di questo servizio abbiamo deciso di dare dei nomi alle 2 navette: "Thunder" e "McQueen"
          </p>
          <p>
              <% if(percDon < 100.0) { %>
              Se volete contribuire al completamto del parco vetture cliccate sul bottone DONA, Il costo totale della nuova navetta è
              di 100.000$.
              Dalla barra a destra potete vedere la percentuale del fondo raggiunto, rappresentata dalla barra gialla.
              <% } else{ %>
              Anche se l'obbiettivo dei 100.000$ sono stati raggiunti lasciamo attivo il link per la donazione, eventuali fondi
              aggiuntivi saranno usati per la manutenzione dei mezzi.
              <% } %>
          </p>
          <button class="button-standard" type="button" onclick="showFormDona()"> Dona </button>
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

              <div class="bus-row-static" acquired="false">
                  <div class="barra-completamento" style="width: <%=percDon%>% "></div>
                  <div class="barra-completamento-info">
                      <img src="Images/Attivita/iconaBus.png" class="iconaBus" alt="Icona Bus"/>
                      <div class="percentuale"><%=percDon%>%</div>
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
          <form id="formReale" action="/PW2_war_exploded/GestoreDonazioniNavetta" method="post">
              <p setMargin="true">La tua donazione sarà destinata all'acuisto della terza navetta</p>
              <label for="importo">Importo Donazione</label>
              <input type="number" placeholder="0" name="importo" id="importo" required>
              <button type="submit"> DONA </button>
          </form>
      </div>
  </div>

</main>

<jsp:include page="footer.jsp"/>

