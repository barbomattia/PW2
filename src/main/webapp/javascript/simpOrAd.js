function effettuaDonazione(){

    id = localStorage.getItem("id");
    username = localStorage.getItem("username");
    importo = document.getElementById("idImportoDonazione").value;
    message = document.getElementById("idMessaggioDonazione").value;

    var xhr = new XMLHttpRequest();
    var url = "/PW2_war_exploded/DonazioniUtenti";

    // Imposta il callback per gestire la risposta
    xhr.onload = function () {
        if (xhr.status === 200) {
            // La richiesta è stata completata con successo
            console.log(xhr.responseText);
            alert(xhr.getResponseHeader("message"));
        }
        else {
            // Si è verificato un errore nella richiesta
            console.error(xhr.status);
            alert(xhr.getResponseHeader("message"));
        }
        chiudiEffettuaDonazione();
    }

    // Imposta il metodo e l'URL di destinazione
    xhr.open("POST", url, true);

    // Imposta l'header Content-Type per indicare che si invia un form
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    // Crea i dati da inviare come stringa nel formato chiave=valore
    var data = "id=" + id + "&username=" + username + "&importoDonazione=" + importo + "&messaggioDonazione=" + message;

    // Invia la richiesta
    xhr.send(data);
}

function iscriviti(){}

