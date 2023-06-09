


var frasi = ["Fare volontariato fa bene all’anima e al cuore","Là dove c’è un volontario, c’è umanità e speranza", "Quello che per altri è perdita di tempo per me è vita", "Tutti hanno la responsabilità di essere volontari da qualche parte"]
var cits = ["(Roy Disney)","(Rinaldo Sidoli)","(Rinaldo Sidoli)","(Jennifer Garner)"]

var nodoFrase = document.getElementById("frase")
var nodeCit = document.getElementById("cit")


function getFrasi(){            // Richiesta al Server delle frasi ( più precismanete alla servlet GestoreFrasi

    var xhttp = new XMLHttpRequest();   //Creo la richiesta
    xhttp.responseType = "json";        //specifico che voglio una risposta in JSON
    xhttp.open("GET","/PW2_war_exploded/GestoreFrasi", true );
    xhttp.send();


}

function initFrase(){
    var index = Math.floor(Math.random()*frasi.length);
    var nextFrase = frasi[index];
    var nextCit = cits[index]

    nodoFrase.innerText = nextFrase;
    nodeCit.innerText = nextCit;

}

function aggiornaFrase(){

    var frasePresente = nodoFrase.innerText; // prenod la frase presente
    //console.log(frasePresente)
    do{
        var index = Math.floor(Math.random()*frasi.length);
        var nextFrase = frasi[index];
        var nextCit = cits[index]
        //console.log(nextFrase)
    }while(nextFrase==frasePresente)

    nodoFrase.innerText = nextFrase;
    nodeCit.innerText = nextCit;
    //console.log("CAMBIO")
}




getFrasi()
initFrase()
setInterval(aggiornaFrase,5000)

