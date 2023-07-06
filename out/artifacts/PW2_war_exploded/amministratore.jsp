<jsp:include page="intestazione.jsp" />

<main id="mainAmministratore">

  <link rel="stylesheet" type="text/css" href="css/amministratore.css">

  <h1 class="classAmministratore">Area ${role}, utente ${username} - id = ${id}</h1>

  <div class="classAmministratore">
    <button type="submit" class="btn" onclick="elencaUtenti('registrati')">Elenca tutti gli utenti registrati</button>
    <div class="popup" id="idPopup_registrati">
      <h2>Elenco utenti registrati: </h2>
      <table>
        <thead>
        <tr>
          <th>ID</th><th>USERNAME</th><th>ROLE</th><th>NAME</th><th>SURNAME</th><th>BIRTH</th><th>MAIL</th><th>PHONE_NUMBER</th><th>SUM DONATION</th>
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

  <h2>Numero di Visite</h2>
  <div id="nVisite"></div>
  <h2>Istogramma visite</h2>
  <div id="idIstogrammaVisite"></div>
  <h2>Grafico donazioni</h2>
  <div id="idGraficoDonazioni"></div>



  <br>
  <br>
  <!--
  <div id="graficoNumeroVisite" style="width: 100%; height: 350px;">

  </div>

  <script>
    document.addEventListener('DOMContentLoaded', function () {
      console.log("ci siamo")
      const chart = Highcharts.chart('graficoNumeroVisite', {
        chart: {
          type: 'spline'
        },
        title: {
          text: 'Elenco visitatori'
        },
        xAxis: {
          //categories: ['Utenti', 'Simpatizzanti', 'Aderenti']
          text: 'Tempo'
        },
        yAxis: {
          title: {
            text: 'Utenti'
          }
        },
        series: [{
          name: 'Simpatizzanti',
          data: [1, 0, 4]
        }, {
          name: 'Aderenti',
          data: [5, 7, 3]
        }]
      });
    });
  </script>
-->
  <br>

  <div class="classSimpOrAd">
    <a href="${pageContext.request.contextPath}/logout">Effettua il logout</a>
  </div>
  <br>
  <br>
  <br>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://code.highcharts.com/highcharts.js"></script>
  <script src="./javascript/amministratore.js" onload="caricaGrafi()"></script>

  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
</main>


<jsp:include page="footer.jsp" />

