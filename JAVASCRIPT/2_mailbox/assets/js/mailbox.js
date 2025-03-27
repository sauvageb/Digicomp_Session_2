const btnToggle = document.querySelector("button");

btnToggle.addEventListener("click", function (){
    let imgMailbox = document.querySelector("img");

    if(btnToggle.textContent === "Poster une lettre"){
        btnToggle.textContent = "Vider le courrier";
        imgMailbox.src = "assets/img/mailbox_full.png";
    }else {
        btnToggle.textContent = "Poster une lettre";
        imgMailbox.src = "assets/img/mailbox_empty.png";
    }
});

