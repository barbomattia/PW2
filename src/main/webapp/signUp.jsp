<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="intestazione.jsp" />

<link rel="stylesheet" type="text/css" href="css/signUp.css">

<main id="signUp-Body">

    <div class="signupElement">
        <form action="${pageContext.request.contextPath}/signUp" method="POST">
        <h1 class="signupElement" id="title"> Registrati qua</h1>
            <input style="margin: 5px" class="signupElement" type="text" placeholder="Nome" name="name" required/>

            <input style="margin: 5px" class="signupElement" type="text" placeholder="Cognome" name="surname" required>

            <br><br>

            <input class="signupElement" type="date" name="date" required>
            <p><sup>*</sup>Devi essere maggiorenne</p>


            <input class="signupElement" type="email" placeholder="youremail@domain" name="mail" required>

            <br><br>

            <input class="signupElement" type="integer" id="phoneNumber" placeholder="Numero di telefono" name="phone_number" required>

            <br><br>

            <label for="affiliazione">Tipo di affiliazione:</label>
            <select class="signupElement" id="affiliazione" name="role">
                <option value="aderente"> Aderente</option>
                <option value="simpatizzante"> Simpatizzante</option>
            </select>

            <br><br>

            <input class="signupElement" type="text" placeholder="Username" name="username" required>

            <br><br>

            <input class="signupElement" type="password" placeholder="Password" name="password" required>

            <input class="signupElement" type="password" placeholder="Conferma password" required>

            <br><br>

            <p id="infoPassword"><sup>*</sup> La password deve essere lunga 8 caratteri, deve contenere almeno un carattere numerico, un carattere
                maiuscolo e un carattere tra $, ! e ?</p>

            <br><br>
            <button style="margin: 5px" type="submit">Registrati</button>
            <input style="margin: 5px" type="reset">

            <br><br>
            <br><br>
            <br><br>
            <br><br>
        </form>
    </div>
</main>

<jsp:include page="footer.jsp" />
