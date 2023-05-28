<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="intestazione.jsp" />

<main id="BodySimpatizzante" onload="recuperaInformazioni()">

    <script type="text/javascript" src="javascript/simpatizzante.js"></script>

    <h1>Colombooooooo</h1>

    <h1 id="messaggioAutenticazione"></h1>


    <a href="${pageContext.request.contextPath}/logout">Effettua il logout</a>
    <!-- non c'è ancora logout.jsp -->

</main>

<jsp:include page="footer.jsp" />

