// CODICE per l'effetto di SCROLL dei 3 elementi navetta
var busRows = document.getElementsByClassName("bus-row");
function scroll(e){
    elScroll = e.target.getElementsByClassName("elm-scorre")[0];
    elScroll.setAttribute("scroll", "true")
    console.log(elScroll.attributes);
}

function normal(e){
    elScroll = e.target.getElementsByClassName("elm-scorre")[0];
    elScroll.removeAttribute("scroll")
    console.log(elScroll.attributes);
}

for (var busRow of busRows) {
    busRow.addEventListener("mouseenter",scroll)
    busRow.addEventListener("mouseleave",normal)
}

// CODICE per il FORM di DONAZIONE

showFormDona = function(){
    popUp = document.getElementById("popUp");
    popUp.setAttribute("pop-up","true")
}


closeFormDona = function(){
    popUp = document.getElementById("popUp");
    popUp.setAttribute("pop-up","false")
}