<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <title>Tum4World</title>
    <link rel="icon" href="Images/Logo.ico">
    <link rel="stylesheet" type="text/css" href="./css/intestazione.css">
    <link rel="stylesheet" type="text/css" href="./css/cookiePopUp.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Tangerine:wght@700&display=swap" rel="stylesheet">
</head>

<body id="body">

    <div id="cookiePopUp" pop-up="false">
        <div id="cookieTitle" >
            <img src="Images/Cookie_icon.png" alt="Cookie Image">
            <h1>Cookie</h1>
        </div>

        <p>Questo sito usa i cookie per fornire una fruibilità migliore del sito</p>

        <div id="cookieBottoni">
            <button  class="buttonCookie buttonNormal" id="accept">Accetto </button>
            <button  class="buttonCookie buttonNormal">Declino </button>
        </div>

        <script src="javascript/cookiePopUp.js"></script>
    </div>


    <div id="mainIntestazione">

        <div id="divIntestazione">
            <h1>Tum4World</h1>
        </div>

        <div id="rigaFrasi">
            <div id="corpoFrase">
                <h1 id="frase"></h1>
                <h1 id="cit"></h1>
            </div>
            <script src="javascript/gestoreFrasi.js"></script>
        </div>

        <nav id="navIntestazione">

            <div id="icona-menu">
                <img src="Images/Logo.png">
            </div>

            <ul id="menu" menu_open="false">
                <li> <a href="home.jsp"> Home page</a> </li>
                <li> <a href="chiSiamo.jsp"> Chi siamo</a> </li>
                <li> <a href="attivita.jsp"> Attività</a> </li>
                <li> <a href="contatti.jsp"> Contatti</a> </li>
                <li> <a href="signUp.jsp"> Sign-in</a> </li>
                <li> <a href="login.jsp"> Log-in</a> </li>
                <!-- <li> <a class="profilo" href="simpOrAd.jsp" onclick="toggleMenu()"> profilo</a> -->
            </ul>

            <div class="sub-menu-wrap" id="subMenu">
                <div class="sub-menu">
                    <div class="user-info">
                        <img src="Images/user.png">
                        <h3>nome utente</h3>
                    </div>
                    <hr>
                    <a href="profilo.jsp" class="sub-menu-link">
                        <img src="Images/settings.png">
                        <p>Profilo</p>
                        <img src="Images/angle-small-right.png" class="freccia">
                    </a>
                    <a href="donazioni.jsp" class="sub-menu-link">
                        <img src="Images/heart.png">
                        <p>Donazioni</p>
                        <img src="Images/angle-small-right.png" class="freccia">
                    </a>
                    <a href="iscrizioni.jsp" class="sub-menu-link">
                        <img src="Images/star.png">
                        <p>Iscriviti</p>
                        <img src="Images/angle-small-right.png" class="freccia">
                    </a>
                    <a href="#" class="sub-menu-link">
                        <img src="Images/sign-out-alt.png">
                        <p>Logout</p>
                        <img src="Images/angle-small-right.png" class="freccia">
                    </a>
                    <a href="#" class="sub-menu-link">
                        <img src="Images/trash.png">
                        <p>Elimina account</p>
                        <img src="Images/angle-small-right.png" class="freccia">
                    </a>
                </div>
            </div>

            <div class="icon_hamburger">
                <div class="el1"></div>
                <div class="el2"></div>
            </div>
            <script type="text/javascript" src="javascript/intestazione.js"></script>

        </nav>
    </div>

