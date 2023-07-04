
var frasi = [];             // array delle frasi
var cits = [];              // array delle citazioni

var nodoFrase = document.getElementById("frase")
var nodeCit = document.getElementById("cit")


function getFrasi(){            // Richiesta al Server delle frasi ( più precismanete alla servlet GestoreFrasi

    // Preparo la richiesta
    var xhttp = new XMLHttpRequest();   //Creo la richiesta
    xhttp.responseType = "json";        //specifico che voglio una risposta in JSON
    xhttp.open("GET","/PW2_war_exploded/GestoreFrasi", true );

    //Invio richiesta
    xhttp.send();

    //Callback
    xhttp.onreadystatechange = function (){
        //Contlollo lo stato della risposta
        let done=4, ok=200;
        if(xhttp.readyState === done && xhttp.status===ok){

            // prendo il contenuto della risposta e lo salvo nei relativi array
            frasi=this.response.frasi;
            cits=this.response.cit;

            //console.log(this.response)
            //console.log(frasi)
            //console.log(cits)

            initFrase();
        }
    }


}

function initFrase(){                                           //funzione per iniziallizzare la fascia

    console.log(frasi)
    console.log(cits)

    var index = Math.floor(Math.random()*frasi.length);
    var nextFrase = frasi[index];
    var nextCit = cits[index]

    nodoFrase.innerText = nextFrase;
    nodeCit.innerText = nextCit;

}

function aggiornaFrase(){

    var frasePresente = nodoFrase.innerText; // prendo la frase presente
    //console.log(frasePresente)
    do{
        var index = Math.floor(Math.random()*frasi.length);         // ritorna un intero casuale
        var nextFrase = frasi[index];                                  // estraggo la prossima frase dall'array delle frasi
        var nextCit = cits[index];                                     // estraggo la prossima citazione dall'array delle citazioni
        //console.log(nextFrase)
    }while(nextFrase==frasePresente)                                   // se la frase sucessiva è uguale a quella presente rifaccio l'estrazione finchè non sono diverse

    nodoFrase.innerText = nextFrase;                                   // aggiorno il testo del nodo Frase
    nodeCit.innerText = nextCit;                                       // aggiorno il testo del nodo Cit
    //console.log("CAMBIO")
}



function main(){
    getFrasi()
    setInterval(aggiornaFrase,20000)
}

main()


