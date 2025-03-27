

const buttonConvert = document.querySelector("#btnConvert");


buttonConvert.addEventListener('click', function (event){
    event.preventDefault();
    const inputTextarea = document.getElementById("input");
    const outputTextarea = document.getElementById("output");
    outputTextarea.value = inputTextarea.value.toUpperCase();
});
