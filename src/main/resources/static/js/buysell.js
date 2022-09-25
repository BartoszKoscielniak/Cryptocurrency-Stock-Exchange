var menu_btn = document.querySelector("#menu-btn")
var sidebar = document.querySelector("#sidebar")
var container = document.querySelector(".my-container")
menu_btn.addEventListener("click", () => {
    sidebar.classList.toggle("active-nav")
    container.classList.toggle("active-cont")
})

function onlyNumberKey(evt) {
    var ASCIICode = (evt.which) ? evt.which : evt.keyCode
    if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57) && ASCIICode != 46) {
        validateBuy();
        return false;
    }else{
        validateBuy();
        return true;
    }
}

function validateBuy(){
    var input = document.getElementById('amountInputBuy').value;
    const button = document.getElementById('submitButton');

    if(input > 0){
        button.disabled = false;
    }else {
        button.disabled = true;
    }
}
setInterval(validateBuy,250);

function validateSell(){
    var input = document.getElementById('amountInputSellxd').value;
    const button = document.getElementById('submitButtonSell');

    if(input > 0){
        button.disabled = false;
    }else {
        button.disabled = true;
    }
}
setInterval(validateSell,250);

function sendMax(max){
    var e =document.getElementById('toSell');
    document.getElementById('amountInputSell').value = e.options[e.selectedIndex].id;
}

$(document).ready(function () {
    $('#buySellTable').DataTable({
        "pagingType": "numbers"
    });
    $('.dataTables_length').addClass('bs-select');
});

function choosedOneRow(id){
    document.getElementById('cryptoToBuy').value = id;
    document.getElementById('cryptoToSell').value = id * 1000;
}

function sendMaxBuy(max){
    const xhr = new XMLHttpRequest();

    xhr.onload = function (){

        const serverResponse = document.getElementById("amountInputBuy").value = this.responseText ;
        const serverResponse1 = document.getElementById("serverResponse");
        serverResponse1.innerHTML = this.responseText;
    };
    var pay = document.getElementById('cryptotoPay');
    var buy = document.getElementById('cryptoToBuy').value;
    xhr.open("POST","howMuch.php");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send('pay=' + pay.options[pay.selectedIndex].value + '&buy=' + buy);
}

function sendMaxSell(max){
    const xhr = new XMLHttpRequest();

    xhr.onload = function (){

        const serverResponse = document.getElementById("amountInputSellxd").value = this.responseText ;
        const serverResponse1 = document.getElementById("serverResponse");
        serverResponse1.innerHTML = this.responseText;
    };

    var buy = document.getElementById('cryptoToSell').value;
    xhr.open("POST","howMuchToSell.php");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send('sell=' + buy);
}

function clearInput(){
    document.getElementById('amountInputBuy').value = '';
    document.getElementById('amountInputSellxd').value = '';
}