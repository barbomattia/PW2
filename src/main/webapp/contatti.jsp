<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="intestazione.jsp" />

<link rel="stylesheet" type="text/css" href="css/contatti.css">
<link rel="stylesheet" type="text/css" href="css/struttura.css">

<main>
    <div class="cover">
        <h1> CONTATTI </h1>
        <h3> Istituto Tecnico Tum4World</h3>
    </div>

    <section>
        <h1 class="titolo">Contatti</h1>
        <p>Contattaci come preferisci</p>

        <div class="rowContatti">
            <div class="colContatti">
                <h3>Email</h3>
                <p>email: tum4world@nessunonoluogonoesiste.com </p>
            </div>
            <div class="colContatti">
                <h3>Telefono</h3>
                <p>contatto telefonico: +39 366 294 8933</p>
            </div>
            <div class="colContatti">
                <h3>Tum4world</h3>
                <p>Compila un piccolo modulo e verrai ricontattato da Tum4World: <a href="formcontatti.jsp">contattaci</a></p>
            </div>
        </div>
    </section>

</main>

<jsp:include page="footer.jsp"/>