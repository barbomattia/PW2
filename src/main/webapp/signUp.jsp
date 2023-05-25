<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="intestazione.jsp" />

<link rel="stylesheet" type="text/css" href="css/signUp.css">

<main id="signUp-Body">

    <div class="signupElement">
        <h1 class="signupElement" id="title"> Registrati qua</h1>
        <form class="signupElement">
            <input style="margin: 5px" class="signupElement" type="text" placeholder="Nome">

            <input style="margin: 5px" class="signupElement" type="text" placeholder="Cognome">

            <br><br>

            <input class="signupElement" type="date">
            <p><sup>*</sup>devi essere maggiorenne</p>


            <input class="signupElement" type="email" placeholder="youremail@domain">

            <br><br>

            <input class="signupElement" type="text" id="phoneNumber" placeholder="phone number">

            <br><br>

            <label for="affiliazione">tipo di affiliazione:</label>
            <select class="signupElement" id="affiliazione" name="affiliazione">
                <option value="aderente"> Aderente</option>
                <option value="simpatizzante"> Simpatizzante</option>
            </select>

            <br><br>

            <input class="signupElement" type="text" placeholder="username">

            <br><br>

            <input class="signupElement" type="password" placeholder="password">

            <p id="infoPassword"><sup>*</sup> La password deve essere lunga 8 caratteri, deve contenere almeno un carattere numerico, un carattere
                maiuscolo e un carattere tra $, ! e ?</p>

            <input class="signupElement" type="password" placeholder="conferma password">

            <br><br>
            <button style="margin: 5px" type="submit">Registrati</button>
            <input style="margin: 5px" type="reset">

            <br><br>
        </form>
    </div>
</main>

<jsp:include page="footer.jsp" />
