colContForm = document.getElementById("colContForm");
pop_up = document.getElementById("finesta-Ricontattami");
form = document.getElementById("formRicontattami");
finestra_conferma = document.getElementById("finestra-invioConfermato");


/* SHOW POP-UP */
colContForm.addEventListener("click", showFormRicontattami);

function showFormRicontattami(){
    pop_up.setAttribute("pop-up","true")
    window.scrollTo(window.innerWidth/2,window.innerHeight/2)           //scrolla la pagina in centro alla finestra
    window.onscroll = function() {
        window.scrollTo(window.innerWidth/2, window.innerHeight/2);     //sovrascrivo la funzione di scroll per sbloccare lo scroll
    };
}

function closeFormRicontattami(){
    pop_up.setAttribute("pop-up","false")
    window.onscroll = function() {}                                          // riattivo lo scroll
}





//INVIO MAIL: abbiamo deciso che tutta l'operazione di invio email sara implementata nel front-end.

function inviaMail(){

    let nome_cognome = form.nome_cognome.value;
    let mail = form.mail.value;
    let motivo = form.motivo.value;
    let argomentazione = form.argomentazione.value;

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
    }

    form.reset();
    closeFormRicontattami()

}

function controllaCampi(nome_cognome,mail){

    let check = true

    if(!controlloNomeCognome(nome_cognome)){
        //console.log("Il campo nome e cognome inserito ha un formato non valido");
        document.getElementById("nome_cognome").setAttribute("class","inputerror")
        document.getElementById("lable_nome_cognome").setAttribute("class","lableerror")
        //window.alert("Errore: nome e cognome inserito con un formato invalido");
        check=false
        event.preventDefault();
    }
    if(!controlloMail(mail)){
        //console.log("La mail inserita ha un formato non valido");
        document.getElementById("lable_contatti-mail").setAttribute("class","lableerror")
        document.getElementById("contatti-mail").setAttribute("class","inputerror")
        //window.alert("Errore: mail inserita con un formato invalido");
        check=false
        event.preventDefault();
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

//RESET COLORE VERDE INPUT ERRATI
function over_reset(){
    document.getElementById("lable_contatti-mail").setAttribute("class","lable")
    document.getElementById("contatti-mail").setAttribute("class","input")

    document.getElementById("nome_cognome").setAttribute("class","input")
    document.getElementById("lable_nome_cognome").setAttribute("class","lable")

    form.reset();
}

