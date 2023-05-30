var cookiePopUp= document.getElementById("cookiePopUp");
var bottoni = document.getElementsByTagName("button")

//Mostrare il pop-up quando la finestra viene caricata

window.addEventListener("load",() => {
    //Prima controllo che non sia gia stato richiesto, controllando l'esisenza del cookie
    if(document.cookie.includes("cookieAllow") ){
        cookiePopUp.setAttribute("pop-up","false");
    }else {
        cookiePopUp.setAttribute("pop-up", "true");
    }
})

for (const button of bottoni) {

    // Cambia il CSS quando passi sopra con il mouse
    button.addEventListener("mouseenter", (e) => { e.target.setAttribute("class","buttonHover"); })
    button.addEventListener("mouseleave", (e) => { e.target.setAttribute("class","buttonNormal"); })

    // Al click di uno dei 2 bottoni il banner sparisce
    button.addEventListener("click", (e) => {
        cookiePopUp.setAttribute("pop-up","false");

        //Se il bottone è acept allora setto un cookie di una ora per salvare l'informazione. Possiamo farlo perchè è un cookie di navigazione per cui non è
        // richiesto dalla normativa italiana il consenso.

        if(e.target.id === "accept"){
            document.cookie = "cookieAllow= true;max-age=" + 60 * 60 // il + 60 *60  indica l'eta massima del cookie "cookieAllow" di 3600 secondi
        }else{
            document.cookie = "cookieAllow= false; max-age=" + 60 * 60
        }
    })

}

//questa funzione nonserve, ho sbagliato ad implementarla, ma ci ho messo cosi tanto a definirla che non voglio cancellarla
// dato che i cookie vengono salvate come stringhe devo definire una funzione per ritornare il valore di un singolo cookie dato il suo nome
function getCookie(cookieName) {
    let name = cookieName;
    let cookies = decodeURIComponent(document.cookie);
    let ca = cookies.split(';'); // il metodo split mi permettere di dividere la string ain più stringhe dove compare il ";" carattere che divide i differenti cookies

    //console.log(ca);

    for(let i = 0; i <ca.length; i++) {

        let c = ca[i];                                  // studio la singola stringa cookie
        c = c.replace(/ /g,'')      // toglie eventuali spazi vuoti all'interno della stringa
        //console.log(c)

        var caratteriGiusti = 0;            // numero di caratteri giusti di c

        for(let j = 0; j <( name.length + 1); j++){
            //console.log( c[j] + "->" + name[j] )
            if(c[j] === name[j]){
                caratteriGiusti++;          // conto i caratteri uguali tra il nome del cookie cercato e la stringa analizzata
            }
            if(j==(name.length) && c[j]=="=" ){   //controllo che la stringa finisca con l'uguale se no se due cookie hanno parte iniziale del nome uguale potrebbe dare errore
                caratteriGiusti++;
            }
        }

        //console.log(caratteriGiusti);

        if(caratteriGiusti === ( name.length +1 )){    // controllo se il numeor di caratteri è uguale ad il numero totale
            //console.log("Trovato");

            var value="";                                   // valore da ritornare

            for(let k = name.length +1; k <c.length; k++){     //creo la stringa del valore
               value = value + c[k];
            }

            //console.log(value)
            return value;
        }
    }
   return " "
}