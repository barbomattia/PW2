var myBottonCards = document.getElementsByClassName("bottoneCard");

var DESCRIZIONECHIMICA = "Grazie al completamento del nuovo laboratorio di chimica quest'anno partira questo nuovo corso" +
    "Il corso è un corso quinquennale che conferisce agli studenti una profonda conoscenza sulla chimica generale"
function popUpTesto(e){

    /* Navigo nel documento per raggiungere la posizione in cui voglio aggiungere un nodo */
    let navDom = e.target.ownerDocument.childNodes[0].childNodes[2].childNodes[7]

    /* Scelgo quale testo mostrare in base a che bottone premo*/
    let indicatoreTesto = e.target.getAttribute("testo")

    let testoDescrizione;
    if(indicatoreTesto === "chimica"){
        testoDescrizione= DESCRIZIONECHIMICA;
    }
    else if(indicatoreTesto === "meccanica"){
        testoDescrizione="DESCRIZIONE MECCANICA";
    }
    else if(indicatoreTesto === "informatica"){
        testoDescrizione="DESCRIZIONE INFORMATICA";
    }
    else if(indicatoreTesto === "alberghiero"){
        testoDescrizione="DESCRIZIONE ALBERGIERO";
    }

    /* controlla se ci sono già delle finestre corso a schermo */
    if(document.getElementsByClassName("descrizioneCorso").length != 0){
        finestraPrec = document.getElementsByClassName("descrizioneCorso")[0];
        navDom.removeChild(finestraPrec)
    }

    let finestra = document.createElement("div");
    let descrizione = document.createTextNode(testoDescrizione)
    finestra.appendChild(descrizione);


    /* definisco la classe per definire il CSS della finestra*/
    if(indicatoreTesto === "chimica"){
        finestra.setAttribute("class","descrizioneCorso margin30 sfondoGiallo")
    }
    else if(indicatoreTesto === "meccanica"){
        finestra.setAttribute("class","descrizioneCorso margin30 sfondoRed")
    }
    else if(indicatoreTesto === "informatica"){
        finestra.setAttribute("class","descrizioneCorso margin30 sfondoBlu")
    }
    else if(indicatoreTesto === "alberghiero"){
        finestra.setAttribute("class","descrizioneCorso margin30 sfondoVerde")
    }

    navDom.appendChild(finestra);

}

for (let myBottonCard of myBottonCards) {
    var testo = myBottonCard.getAttribute("testo")
    myBottonCard.addEventListener("click", popUpTesto,true)
}
