let popupMD = document.getElementById("idPopupMostraDati");
let popupVA = document.getElementById("idPopupIscrizioneAttivita");
let popuEA = document.getElementById("idPopupEliminaAccount");
let popupD = document.getElementById("idPopupDonazione");
function mostraDati(){ popupMD.classList.add("open-popup"); }

function chiudiMostraDati(){ popupMD.classList.remove("open-popup"); }

function selezionaAttivita(){ popupVA.classList.add("open-popup"); }

function chiudiSelezionaAttivita(){ popupVA.classList.remove("open-popup"); }

function mostraEliminaAccount(){ popuEA.classList.add("open-popup"); }

function chiudiMostraEliminaAccount(){ popuEA.classList.remove("open-popup"); }

function mostraEffettuaDonazione(ruolo){
    if(ruolo === "aderente"){
        popupD.classList.add("open-popup");
    }
    else {
        alert("Per utilizzare questa funzione, devi essere un Aderente")
    }
}

function chiudiEffettuaDonazione(){ popupD.classList.remove("open-popup"); }
