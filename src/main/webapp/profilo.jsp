<jsp:include page="intestazione.jsp" />
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->

<link rel="stylesheet" type="text/css" href="css/struttura.css">
<link rel="stylesheet" type="text/css" href="css/profilo.css">

<main>


    <section>
      <jsp:include page="simpOrAd.jsp" />
      <div class="box">
          <div class="user">
              <span class="attributo">nome:</span>
              <span class="valore">Giovanni</span>
          </div>
          <div class="user">
              <span class="attributo">cognome:</span>
              <span class="valore">30</span>
          </div>
          <div class="user">
              <span class="attributo">email:</span>
              <span class="valore">giovanni@example.com</span>
          </div>
          <div class="user">
              <span class="attributo">telefono:</span>
              <span class="valore">333333333333</span>
          </div>
          <div class="user">
              <span class="attributo">data di nascita:</span>
              <span class="valore">03/07/02</span>
          </div>
          <div class="user">
              <span class="attributo">ruolo:</span>
              <span class="valore">aderente</span>
          </div>
      </div>
  </section>


</main>

<jsp:include page="footer.jsp"/>

