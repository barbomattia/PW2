colContForm = document.getElementById("colContForm");
pop_up = document.getElementById("finesta-Ricontattami");
form = document.getElementById("formRicontattami");
finestra_conferma = document.getElementById("finestra-invioConfermato");

testo_errore = document.createElement("p")
testo_errore.style.color = "red"


/* SHOW POP-UP */
colContForm.addEventListener("click", showFormRicontattami);

function showFormRicontattami(){
    pop_up.setAttribute("pop-up","true")
    auto_fill()                                                               //imposto automaticamente gli input in base ai cookies
    window.scrollTo(window.innerWidth/2,window.innerHeight/2)           //scrolla la pagina in centro alla finestra
    window.onscroll = function() {
        window.scrollTo(window.innerWidth/2, window.innerHeight/2);     //sovrascrivo la funzione di scroll per sbloccare lo scroll
    };
}

function closeFormRicontattami(){
    pop_up.setAttribute("pop-up","false")
    window.onscroll = function() {}                                          // riattivo lo scroll
}


//AUTO FILL: compila automaticamente i campi nome ed email se trova i corrsipettivi cookies
function auto_fill(){

    if (document.cookie != ""){                                 //controllo che ci siano dei cookies

        //Dato che i cookie sono salvati come una sringa definisco un array di cookie separando la stringa al ;
        cookies = document.cookie.split(";");

        // Passo tutti i cookie alla ricerca di "nome_cognome" e "mail"
        for (var i = 0; i < cookies.length; i++) {
            cookie = cookies[i].trim().split("=");      // divido nome e valore del cookie togliedo eventuali spazi
            if (cookie[0] == 'nome_cognome') {
                form.nome_cognome.value = cookie[1];
            }
            if (cookie[0] == 'mail') {
                form.mail.value = cookie[1];
            }
        }
    }

}



//INVIO MAIL: abbiamo deciso che tutta l'operazione di invio email sara implementata nel front-end.

function inviaMail(){

    let nome_cognome = form.nome_cognome.value;
    let mail = form.mail.value;
    let motivo = form.motivo.value;
    let argomentazione = form.argomentazione.value;

    reset_style()

    let check = controllaCampi(nome_cognome,mail);

    if(check){
        Email.send({
            Host : "smtp.elasticemail.com",
            Username : nome_cognome,
            Password : "password",
            To : 'tum4world@nessunonoluogonoesiste.com',
            From : mail,
            Subject : motivo,
            Body : argomentazione
        }).then(
            //setTimeout(()=>{console.log("email inviata")}, 20000)  //Riga usata per testare il funzionamento asincrono
            window.location.assign("invioConfermato.jsp")
        );

        form.reset();
        closeFormRicontattami()

    }else{
        console.log("ERRORE INVIO")
        //event.preventDefault();
    }


}

function controllaCampi(nome_cognome,mail){

    let check = true

    if(!controlloNomeCognome(nome_cognome)){
        //console.log("Il campo nome e cognome inserito ha un formato non valido");
        document.getElementById("nome_cognome").setAttribute("class","inputerror")
        document.getElementById("lable_nome_cognome").setAttribute("class","lableerror")
        //window.alert("Errore: nome e cognome inserito con un formato invalido");
        testo_errore.innerText = "Errore nome cognome"
        form.appendChild(testo_errore)


        check=false
    }
    if(!controlloMail(mail)){
        //console.log("La mail inserita ha un formato non valido");
        document.getElementById("lable_contatti-mail").setAttribute("class","lableerror")
        document.getElementById("contatti-mail").setAttribute("class","inputerror")
        //window.alert("Errore: mail inserita con un formato invalido");
        testo_errore.innerText = "Errore mail"
        form.appendChild(testo_errore)

        check=false
    }

    return check;

}

function controlloNomeCognome(nome_cognome){
    const patternNomeCognome = /^[A-Za-z\s]*$/      //String composta da soli caratteri e spazi
    return patternNomeCognome.test(nome_cognome);
}
function controlloMail(mail){
    const patternMail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return patternMail.test(mail);
}


// WRAP FUNZIONE DI RESET
function over_reset(){
    reset_style()
    form.reset();
}

//RESET COLORE INPUT ERRATI e RIMOZIONE SCRITTA ERRORE
function reset_style(){
    document.getElementById("lable_contatti-mail").setAttribute("class","lable")
    document.getElementById("contatti-mail").setAttribute("class","input")

    document.getElementById("nome_cognome").setAttribute("class","input")
    document.getElementById("lable_nome_cognome").setAttribute("class","lable")

    console.log(form.children)

    if(form.contains(testo_errore)){
        console.log(form.children)
        form.removeChild(testo_errore)
    }

}
