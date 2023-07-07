function incrementaCounterPagina(nomePagina){
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/PW2_war_exploded/PagineVisitateServlet?nomePagina="+nomePagina, true);
    xhr.send();
}