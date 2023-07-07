
function elencaUtenti(richiesta){

    //console.log("Richiesta = " + richiesta);

    let popup = document.getElementById("idPopup_"+richiesta);
    popup.classList.add("open-popup");

    //console.log("Invoco la get");

    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/PW2_war_exploded/GetUtentiServlet?categoriaCercata="+richiesta, true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {

            var risposta = xhr.responseText;
            var elenco = JSON.parse(risposta);

            //elemento <tbody> di <table>
            var tbody = document.getElementById("idElenco_"+richiesta);
            tbody.textContent = "";
            elenco.forEach(function(elemento) {
                var tr = document.createElement("tr");

                var td1 = document.createElement("td");
                td1.textContent = elemento.ID;
                tr.appendChild(td1);

                var td2 = document.createElement("td");
                td2.textContent = elemento.USERNAME;
                tr.appendChild(td2);

                if(richiesta === 'registrati'){
                    var tdRole = document.createElement("td");
                    tdRole.textContent = elemento.ROLE;
                    tr.appendChild(tdRole);
                }

                var td3 = document.createElement("td");
                td3.textContent = elemento.NAME;
                tr.appendChild(td3);

                var td4 = document.createElement("td");
                td4.textContent = elemento.SURNAME;
                tr.appendChild(td4);

                var td5 = document.createElement("td");
                td5.textContent = elemento.BIRTH;
                tr.appendChild(td5);

                var td6 = document.createElement("td");
                td6.textContent = elemento.MAIL;
                tr.appendChild(td6);

                var td7 = document.createElement("td");
                td7.textContent = elemento.PHONE_NUMBER;
                tr.appendChild(td7);

                var td8 = document.createElement("td");
                td8.textContent = elemento.SUM_DONATION;
                tr.appendChild(td8);

                tbody.appendChild(tr);
            });
        }
    };
    xhr.send();
}

function chiudiElencaUtenti(richiesta){
    let popup = document.getElementById("idPopup_"+richiesta);
    popup.classList.remove("open-popup");
}

//Questa funzione permette di ottenere i dati delle visite dal server e poi visualizzarli a schermo
function getVisite() {
    var xhr = new XMLHttpRequest();
    xhr.responseType = "json";
    xhr.open("POST", "/PW2_war_exploded/PagineVisitateServlet", true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var nomi = this.response.nomi;
            var numeroDiVisite = this.response.numeroDiVisite;

            console.log("Nomi: " + nomi);
            console.log("Numero di visite: " + numeroDiVisite)

            creaGraficoPagineVisitate(nomi, numeroDiVisite);

        }
    };
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("action=visualizza");
}

//Creazione dell'istogramma
function creaGraficoPagineVisitate(nomi, numeroDiVisite) {

    let totVisite = 0;

    numeroDiVisite.forEach(function (x){
        totVisite+=x;
    });

    Highcharts.chart('idIstogrammaVisite', {
        chart: {
            type: 'column'
        },
        title: {
            text: 'Istogramma visite - totale: ' + totVisite
        },
        xAxis: {
            categories: nomi
        },
        yAxis: {
            title: {
                text: 'Numero di visite'
            }
        },
        series: [{
            name: 'Visite',
            data: numeroDiVisite
        }]
    });
}

function resetVisite(){
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/PW2_war_exploded/PagineVisitateServlet", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("action=reset");
    location.reload();
}







//Ottengo i dati dal server e li visualizzo
function getDonazioni() {

    var xhr = new XMLHttpRequest();
    xhr.responseType = "json";
    xhr.open("GET", "/PW2_war_exploded/GetDonazioniServlet", true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {

            var donazioniDenaroTot = this.response.donazioniDenaroTot;
            var donazioniEffettuateTot = this.response.donazioniEffettuateTot;
            var donatoriTot = this.response.donatoriTot;

            var donazioniDenaroCurrentYear = this.response.donazioniDenaroCurrentYear;
            var donazioniEffettuateCurrentYear = this.response.donazioniEffettuateCurrentYear;
            var donatoriCurrentYear = this.response.donatoriCurrentYear;

            //console.log("Donazioni denaro tot = " + donazioniDenaroTot);
            //console.log("Donazioni denaro cy = " + donazioniDenaroCurrentYear);

            //Crea grafico donazioni mese per mese
            graficoDonazioni(donazioniDenaroTot, donazioniEffettuateTot, donatoriTot, donazioniDenaroCurrentYear, donazioniEffettuateCurrentYear, donatoriCurrentYear);
        }
    };
    xhr.send();
}

//Crea grafico donazioni mese per mese
function graficoDonazioni(donazioniDenaroTot, donazioniEffettuateTot, donatoriTot, donazioniDenaroCurrentYear, donazioniEffettuateCurrentYear, donatoriCurrentYear) {

    Highcharts.chart('idGraficoDonazioniDenaro', {
        chart: {
            type: 'line'
        },
        title: {
            text: 'Denaro donato'
        },
        xAxis: {
            categories: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre']
        },
        yAxis: {
            title: {
                text: 'Denaro'
            }
        },
        series: [{
            name: "Denaro donato a partire dall'apertura del sito",
            data: donazioniDenaroTot
        },{
            name: "Denaro donato nell'anno corrente",
            data: donazioniDenaroCurrentYear
        }
        ]
    });

    Highcharts.chart('idGraficoDonazioniEffettuate', {
        chart: {
            type: 'line'
        },
        title: {
            text: 'Donazioni effettuate'
        },
        xAxis: {
            categories: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre']
        },
        yAxis: {
            title: {
                text: 'Quantità'
            }
        },
        series: [{
            name: "Donazioni effettuate dall'apertura del sito",
            data: donazioniEffettuateTot
        },{
            name: "Donazioni effettuate quest'anno",
            data: donazioniEffettuateCurrentYear
        },{
            name: "Donatori dall'apertura del sito",
            data: donatoriTot
        },{
            name: "Donatori di quest'anno",
            data: donatoriCurrentYear
        }]
    });
}

// Al caricamento della pagina, ottieni i dati delle visite e delle donazioni
function caricaGrafi() {
    getVisite();
    getDonazioni();
}
