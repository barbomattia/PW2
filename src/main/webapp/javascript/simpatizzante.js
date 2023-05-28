let username = "username", password;

/*
*   CREDO VADA FATTA UNA SERVLET ANZICHè UN JAVASCRIPT
*
*
*
* */
function recuperaInformazioni(){
    console.log("dentro recuperaInformazioni")
    if(session.getAttribute("username") == null){
        console.log("username nullo");
        response.sendRedirect("login.jsp");
    }
    else{
        console.log("username non nullo");
        username = session.getAttribute("username");
        document.getElementById("messaggioAutenticazione").innerText = "Benvenuto, " + username;
    }
}