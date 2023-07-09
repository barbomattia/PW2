<jsp:include page="intestazione.jsp" />
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->

<%  HttpSession session = request.getSession(false); %>
<%  String role="", username=""; if(session!=null){ role=session.getAttribute("role").toString(); username=session.getAttribute("username").toString(); } %>

<main id="mainAmministratore">

  <link rel="stylesheet" type="text/css" href="css/amministratore.css">

  <h1 class="classAmministratore">Area <%=role%>, utente <%=username%></h1>

  <div class="classAmministratore">
    <button type="submit" class="btn" onclick="elencaUtenti('registrati')">Elenca tutti gli utenti registrati</button>
    <div class="popup" id="idPopup_registrati">
      <h2>Elenco utenti registrati: </h2>
      <table>
        <thead>
        <tr>
          <th>ID</th><th>USERNAME</th><th>ROLE</th><th>NAME</th><th>SURNAME</th><th>BIRTH</th><th>MAIL</th><th>PHONE_NUMBER</th><th>SUM DONATION</th><th>LISTA ATTIVITA</th>
        </tr>
        </thead>
        <tbody id="idElenco_registrati">
        </tbody>
      </table>
      <button onclick="chiudiElencaUtenti('registrati')">Chiudi</button>
    </div>
  </div>

  <br>

  <div class="classAmministratore">
    <button type="submit" class="btn" onclick="elencaUtenti('simpatizzante')">Elenca tutti gli utenti simpatizzanti</button>
    <div class="popup" id="idPopup_simpatizzante">
      <h2>Elenco utenti simpatizzanti: </h2>
      <table>
        <thead>
        <tr>
          <th>ID</th><th>USERNAME</th><th>NAME</th><th>SURNAME</th><th>BIRTH</th><th>MAIL</th><th>PHONE_NUMBER</th><th>SUM DONATION</th>
        </tr>
        </thead>
        <tbody id="idElenco_simpatizzante">
        </tbody>
      </table>
      <button onclick="chiudiElencaUtenti('simpatizzante')">Chiudi</button>
    </div>
  </div>

  <br>

  <div class="classAmministratore">
    <button type="submit" class="btn" onclick="elencaUtenti('aderente')">Elenca tutti gli utenti aderenti</button>
    <div class="popup" id="idPopup_aderente">
      <h2>Elenco utenti aderenti: </h2>
      <table>
        <thead>
        <tr>
          <th>ID</th><th>USERNAME</th><th>NAME</th><th>SURNAME</th><th>BIRTH</th><th>MAIL</th><th>PHONE_NUMBER</th><th>SUM DONATION</th>
        </tr>
        </thead>
        <tbody id="idElenco_aderente">
        </tbody>
      </table>
      <button onclick="chiudiElencaUtenti('aderente')">Chiudi</button>
    </div>
  </div>

  <br>
  <br>

  <h2>Istogramma visite</h2>
  <div id="idIstogrammaVisite"></div>
  <br>
  <div class="classAmministratore">
    <button type="button" class="btn" onclick="resetVisite()">Reset dati</button>
  </div>
  <br>
  <h2>Grafico denaro donato</h2>
  <div id="idGraficoDonazioniDenaro"></div>

  <h2>Grafico numero donazioni effettuate</h2>
  <div id="idGraficoDonazioniEffettuate"></div>
  <br>
  <br>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://code.highcharts.com/highcharts.js"></script>
  <script src="./javascript/amministratore.js" onload="caricaGrafi()"></script>

  <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('amministratore.jsp')"></script>
</main>


<jsp:include page="footer.jsp" />

