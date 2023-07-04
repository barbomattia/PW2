<jsp:include page="intestazione.jsp" />

<main id="mainAmministratore">

  <link rel="stylesheet" type="text/css" href="css/amministratore.css">

  <h1 class="classAmministratore">Area ${role}, utente ${username} - id = ${id}</h1>

  <div class="classAmministratore">
    <button type="submit" class="btn" onclick="elencaUtentiRegistrati()">Elenca tutti gli utenti registrati</button>
    <div class="popup" id="idPopupMostraUtentiRegistrati">
      <h2>Elenco utenti registrati: </h2>
      <button onclick="chiudiElencaUtentiRegistrati()">Chiudi</button>
    </div>
  </div>

  <br>

  <div class="classAmministratore">
    <button type="submit" class="btn" onclick="elencaUtentiSimpatizzanti()">Elenca tutti gli utenti simpatizzanti</button>
    <div class="popup" id="idPopupMostraUtentiSimpatizzanti">
      <h2>Elenco utenti simpatizzanti: </h2>
      <button onclick="chiudiElencaUtentiSimpatizzanti()">Chiudi</button>
    </div>
  </div>

  <br>

  <div class="classAmministratore">
    <button type="submit" class="btn" onclick="elencaUtentiAderenti()">Elenca tutti gli utenti aderenti</button>
    <div class="popup" id="idPopupMostraUtentiAderenti">
      <h2>Elenco utenti aderenti: </h2>
      <button onclick="chiudiElencaUtentiAderenti()">Chiudi</button>
    </div>
  </div>

  <br>
  <br>
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

  <br>

  <div class="classSimpOrAd">
    <a href="${pageContext.request.contextPath}/logout">Effettua il logout</a>
  </div>
  <br>
  <br>
  <br>
  <!--<script src="./javascript/amministratore.js"></script>-->
  <script src="https://code.highcharts.com/highcharts.js"></script>

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

