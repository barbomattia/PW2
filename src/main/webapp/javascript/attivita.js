var myCards = document.getElementsByClassName("card");

for (let i = 0; i < myCards.length; i++) {
    el = myCards[i]
    console.log(el)
    el.onmouseenter = function(e){
        console.log("dentro")
        console.log(e.target.childNodes[1].childNodes[1])
        e.target.childNodes[1].setAttribute("class","cardInfoSel")
    }
    el.onmouseleave = function(e){
        console.log("fuori")
        e.target.childNodes[1].setAttribute("class","cardInfo")
    }
}
