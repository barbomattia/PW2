let popupMD = document.getElementById("idPopupMostraDati");
let popupVA = document.getElementById("idPopupIscrizioneAttivita");
let popuEA = document.getElementById("idPopupEliminaAccount");
function mostraDati(){
    popupMD.classList.add("open-popup");
}

function chiudiMostraDati(){
    popupMD.classList.remove("open-popup");
}

function selezionaAttivita(){
    popupVA.classList.add("open-popup");
}

function chiudiSelezionaAttivita(){
    popupVA.classList.remove("open-popup");
}

function mostraEliminaAccount(){
    popuEA.classList.add("open-popup");
}

function chiudiMostraEliminaAccount(){
    popuEA.classList.remove("open-popup");
}

function OLDvisualizzaDati(id, username){

    console.log("dentro visualizzaDati.js, id = " + id + ", username = " + username);
    document.getElementById("formVisualizzaDati").action = "visualizzaDatiPersonali";
    //document.getElementById("formVisualizzaDati").action = "#";
    document.getElementById("formVisualizzaDati").method = "GET";
    document.getElementById("formVisualizzaDati").setAttribute("id", id);
    document.getElementById("formVisualizzaDati").setAttribute("username", username);
    document.getElementById("formVisualizzaDati").submit();

    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'visualizzaDatiPersonali', true);
    xhr.onreadystatechange = function() {
        console.log("Dentro la funzione")
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            console.log("Superato l'if")
            var response = xhr.responseText;
            var data = JSON.parse(response);

            // Ciclo per ogni chiave presente nell'oggetto JSON
            for (var key in data) {
                if (data.hasOwnProperty(key)) {
                    var value = data[key];
                    // Utilizza la chiave e il valore come desiderato
                    console.log(key + ': ' + value);
                }
            }

            // Utilizzo di Object.keys() e Array.forEach() per ciclare sui dati
            Object.keys(data).forEach(function(key) {
                var value = data[key];
                // Utilizza la chiave e il valore come desiderato
                console.log(key + ': ' + value);
            });
        }
    };
    xhr.send();
}

function visualizzaDati(id, username){
    console.log("Dentro la funzione visualizzaDati");

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        console.log("Fuori dall'if")
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("Dentro l'if")
            var response = JSON.parse(xhr.responseText);
            console.log(xhr.responseText);
            console.log(JSON.parse(xhr.responseText));
            console.log("Invoco la funzione stampaDati")
            console.log("Response = " + response);
            stampaDati(response);
        }
    };

    xhr.open("GET", "visualizzaDatiPersonali?id=" + id, true);
    xhr.send();
}
function stampaDati_v2(data) {
    var outputDiv = document.getElementById("output");
    outputDiv.innerHTML = "";

    for (var i = 0; i < data.length; i++) {
        var item = document.createElement("p");
        item.textContent = data[i].campo1 + " - " + data[i].campo2; // Modificare campo1 e campo2 con i nomi dei campi desiderati
        outputDiv.appendChild(item);
    }
}
function agag(){
    let newWin = window.open("about:blank", "hello", "width=200,height=200");

    newWin.document.write(
        "<script>window.opener.document.body.innerHTML = 'Test'<\/script>"
    );

    if(document.getElementById("h1").getAttribute("style") == "visibility:hidden"){
        document.getElementById("h1").setAttribute("style", "visibility:visible");
    }
    else{
        document.getElementById("h1").setAttribute("style", "visibility:hidden");
    }

}

function stampaDati(data) {
    console.log("Dentro stampaDati");
    console.log("data = " + data);
    for (var i = 0; i < data.length; i++) {

        var item = data[i].campo1 + " - " + data[i].campo2; // Modificare campo1 e campo2 con i nomi dei campi desiderati
        console.log(item);
    }
}
