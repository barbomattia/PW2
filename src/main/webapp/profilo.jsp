<jsp:include page="intestazione.jsp" />
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->

<link rel="stylesheet" type="text/css" href="css/struttura.css">
<link rel="stylesheet" type="text/css" href="css/profilo.css">

<main>


    <section>
      <jsp:include page="simpOrAd.jsp" />
      <div class="box">
          <div class="user">
              <span class="attributo">username:</span>
              <span class="valore">${username}</span>
          </div>
          <div class="user">
              <span class="attributo">nome:</span>
              <span class="valore">${role}</span>
          </div>
          <div class="user">
              <span class="attributo">cognome:</span>
              <span class="valore">${surname}</span>
          </div>
          <div class="user">
              <span class="attributo">email:</span>
              <span class="valore">${mail}</span>
          </div>
          <div class="user">
              <span class="attributo">telefono:</span>
              <span class="valore">${phone_number}</span>
          </div>
          <div class="user">
              <span class="attributo">data di nascita:</span>
              <span class="valore">${date_of_birth}</span>
          </div>
          <div class="user">
              <span class="attributo">ruolo:</span>
              <span class="valore">${role}</span>
          </div>
      </div>
  </section>


</main>

<jsp:include page="footer.jsp"/>

