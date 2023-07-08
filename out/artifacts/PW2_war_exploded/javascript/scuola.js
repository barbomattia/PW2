var myBottonCards = document.getElementsByClassName("bottoneCard");
var section = document.getElementsByTagName("section")[0];

// Aggiungo il listener del click
for (let myBottonCard of myBottonCards) {
    myBottonCard.addEventListener("click", popUpTesto,true)
}

function popUpTesto(e){

    /* Scelgo quale testo mostrare in base a che bottone premo*/
    indicatoreTesto = e.target.getAttribute("testo")        //prendo dall'attributo testo del bottone cliccato l'indicatore di quale testo mostrare
    testoDescrizione = setDescrizione(indicatoreTesto)                  //funziona che ritorna effettivamente il testo in base all'indicatore di testo passato

    // definisco la nuova finestra di descrizione del corso
    finestra = document.createElement("div")            // crea il div contenente la nuova finestra, creo un tag div
    descrizione = document.createTextNode(testoDescrizione)     // definisco il testo da inserire nel nuovo div
    finestra.appendChild(descrizione);                              // inserisco il testo nel div


    /* controlla se ci sono già delle finestre corso a schermo */
    if(section.getElementsByClassName("descrizioneCorso").length != 0){        //controllo che l'arrey ritornato da getClassName non sia vuoto
        finestraPrec = document.getElementsByClassName("descrizioneCorso")[0];  //prendo il primo elemento ( e teoricamente unico ) elemento di classe descrizioneCorso
        section.removeChild(finestraPrec)                                                  //rimozione elemento precedente
    }



    /* definisco la classe del div per definire il CSS della finestra*/
    if(indicatoreTesto === "chimica"){
        finestra.setAttribute("class","descrizioneCorso  sfondoGiallo")
    }
    else if(indicatoreTesto === "meccanica"){
        finestra.setAttribute("class","descrizioneCorso  sfondoRed")
    }
    else if(indicatoreTesto === "informatica"){
        finestra.setAttribute("class","descrizioneCorso  sfondoBlu")
    }
    else if(indicatoreTesto === "alberghiero"){
        finestra.setAttribute("class","descrizioneCorso  sfondoVerde")
    }


    // aggiungo la finestra cosi definita nel main scuola, essa sara aggiunta in coda
    section.appendChild(finestra);
}

function setDescrizione(testo){

    let text;

    if(testo === 'informatica'){
        text = "Il corso di informatica prevede un ciclo di 5 anni; che verrà concluso dall'esame di stato. Questo corso " +
            "fornisce ai ragazzi ottime basi sul mondo informatico, competenza molto spendibile sul mercato del lavoro";
    }

    else if(testo === 'alberghiero'){
        text = "Il corso albergiero prevede un ciclo di 3 anni, estendibile a 4 con una specializzazione come cuoco. " +
            "Il corso è specializzato nel servizio in sala. L'albergiero permette molti sbocchi lavorativi anche all'estero"
    }

    else if(testo === 'chimica'){
        text = "Il corso di chimica prevede un ciclo di 5 anni, che verrà concluso dall'esame di stato. Questo corso, piu" +
            "terico rispetto agli altri, fornisce delle ottime basi per un eventuale proseguzione universitaria nell'ambito chimico"
    }

    else if(testo === 'meccanica'){
        text = "Il corso di meccanica prevede un ciclo di 3 anni. Questo corso ha una grande componente di pratica che permette ai" +
            " ragazzi frequentanti di sviluppare delle ottime skill pratiche subito spendibili nel mondo lavorativo"
    }

    return text;
}
