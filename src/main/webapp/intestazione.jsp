<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <title>Tum4World</title>
    <link rel="icon" href="Images/Logo.ico">
    <link rel="stylesheet" type="text/css" href="./css/intestazione.css">
    <link rel="stylesheet" type="text/css" href="./css/cookiePopUp.css">
</head>

<body id="body">

    <main id="cookiePopUp" pop-up="false">
        <div id="cookieTitle" >
            <img src="Images/Cookie_icon.png" alt="Cookie Image">
            <h1>Cookie</h1>
        </div>

        <p>Questo sito usa i cookie per fornire una fruibilità migliore del sito</p>

        <div id="cookieBottoni">
            <button type="button" class="buttonNormal" id="accept">Accetto </button>
            <button type="button" class="buttonNormal">Declino </button>
        </div>

        <script src="javascript/cookiePopUp.js"></script>
    </main>


    <main id="mainIntestazione">
        <div id="divIntestazione">
            <h1>Tum4World</h1>
        </div>
        <nav id="navIntestazione">
            <ul>
                <li> <a href="home.jsp"> Home page</a> </li>
                <li> <a href="chiSiamo.jsp"> Chi siamo</a> </li>
                <li> <a href="attivita.jsp"> Attività</a> </li>
                <li> <a href="contatti.jsp"> Contatti</a> </li>
                <li> <a href="signUp.jsp"> Sign-in</a> </li>
                <li> <a href="login.jsp"> Log-in</a> </li>
            </ul>
        </nav>
        <br>
        <br>
        <br>
        <br>
    </main>
