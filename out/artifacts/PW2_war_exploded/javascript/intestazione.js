hamburger = document.querySelector('.icon_hamburger');
menu = document.getElementById("menu")
el1 = document.querySelector('.el1')
el2 = document.querySelector('.el2')
subMenu = document.getElementById("subMenu");

hamburger.addEventListener("click", function (){
    let open = menu.getAttribute("menu_open")
    if(open=="true"){
        menu.setAttribute("menu_open","false")
    }else{
        menu.setAttribute("menu_open","true")
    }
} )

document.onload = addListenerLogout();
function addListenerLogout(){
    let log_out = document.getElementById("LO")
    if(log_out!=null){
        log_out.addEventListener("click",logout)
    }
}

function logout(){

    var xhttp = new XMLHttpRequest();   //Creo la richiesta
    xhttp.open("GET","/PW2_war_exploded/logout", true );
    xhttp.send();

}
