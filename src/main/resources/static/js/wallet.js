var menu_btn = document.querySelector("#menu-btn")
var sidebar = document.querySelector("#sidebar")
var container = document.querySelector(".my-container")
menu_btn.addEventListener("click", () => {
    sidebar.classList.toggle("active-nav")
    container.classList.toggle("active-cont")
})

function startValue() {

    setTimeout(() => {

        document.getElementById('payCard1').checked = false;
        document.getElementById('payCard2').checked = false;

        document.getElementsByClassName('payOpt')[0].style.display = 'block';
        document.getElementsByClassName('payOpt')[1].style.display = 'block';

        document.getElementById('creditCard').style.display = 'none';
        document.getElementById('blikk').style.display = 'none';

    }, 500)
}

//Credit card
function selectPayMet(id) {

    document.getElementById(id).checked = true;

    if (id.localeCompare('payCard2') == 0) {
        setTimeout(() => {
            document.getElementsByClassName('payOpt')[0].style.display = 'none';
            document.getElementsByClassName('payOpt')[1].style.display = 'none';

            document.getElementById('creditCard').style.display = 'block';
        }, 500);
    }
    if(id.localeCompare('payCard1') == 0){
        setTimeout(() => {
            document.getElementsByClassName('payOpt')[0].style.display = 'none';
            document.getElementsByClassName('payOpt')[1].style.display = 'none';

            document.getElementById('blikk').style.display = 'block';
        }, 500);
    }

}

function onlyNumberKey(evt, id) {

    var ASCIICode = (evt.which) ? evt.which : evt.keyCode
    if (ASCIICode > 32 && (ASCIICode < 48 || ASCIICode > 57) && ASCIICode != 46) {

        validateBuy();
        return false;
    } else {

        if (id.localeCompare('cardNumber') == 0) {
            if (document.getElementById(id).value.length < 19) {
                document.getElementById(id).style.borderColor = 'red';
            } else {
                document.getElementById(id).style.borderColor = 'blue';
            }

            if (document.getElementById(id).value.length == 4 || document.getElementById(id).value.length == 9 || document.getElementById(id).value.length == 14) {

                document.getElementById(id).value += "-";

            }
        }
        if (id.localeCompare('cardDate') == 0) {
            if (document.getElementById(id).value.length < 7) {
                document.getElementById(id).style.borderColor = 'red';
            } else {
                document.getElementById(id).style.borderColor = 'blue';
            }
            if (document.getElementById(id).value.length == 2) {

                document.getElementById(id).value += "/";

            }

        }
        if (id.localeCompare('cvvNumber') == 0) {

            if (document.getElementById(id).value.length < 3) {
                document.getElementById(id).style.borderColor = 'red';
            } else {
                document.getElementById(id).style.borderColor = 'blue';
            }

        }
        if (id.localeCompare('blikNumber') == 0) {

            if (document.getElementById(id).value.length < 11) {
                document.getElementById(id).style.borderColor = 'red';
            } else {
                document.getElementById(id).style.borderColor = 'blue';
            }
            if (document.getElementById(id).value.length == 1 ||
                document.getElementById(id).value.length == 3 ||
                document.getElementById(id).value.length == 5 ||
                document.getElementById(id).value.length == 7 ||
                document.getElementById(id).value.length == 9) {

                document.getElementById(id).value += "-";

            }

        }

        blikNumber
        validateBuy();
        return true;

    }

}

function validateBuy(){
    var input = document.getElementById('amountInputb').value;
    const button = document.getElementById('submitButtonb');

    if(input > 0 & document.getElementById('cryptoBuyb').value != document.getElementById('cryptoPayb').value){
        button.disabled = false;
    }else {
        button.disabled = true;
    }
}
setInterval(validateBuy,250);

function validateSell(){
    var input = document.getElementById('amountInputSell').value;
    const button = document.getElementById('submitButtonSell');

    if(input > 0){
        button.disabled = false;
    }else {
        button.disabled = true;
    }
}
setInterval(validateSell, 250);

function sendMax(max){
    var e =document.getElementById('toSell');
    document.getElementById('amountInputSell').value = e.options[e.selectedIndex].id;
}

function sendMaxBuy(max){
    const xhr = new XMLHttpRequest();

    xhr.onload = function (){

        const serverResponse = document.getElementById("amountInputb").value = this.responseText ;
    };
    var pay = document.getElementById('cryptoPayb');
    var buy = document.getElementById('cryptoBuyb');
    xhr.open("POST","howMuch.php");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send('pay=' + pay.options[pay.selectedIndex].value + '&buy=' + buy.options[buy.selectedIndex].value);
}

function walletVal(){
    const xhr = new XMLHttpRequest();

    xhr.onload = function (){
        const serverResponse1 = document.getElementById("here");
        serverResponse1.innerHTML = this.responseText
    };
    xhr.open("POST","");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send('pay=1');
}
//walletVal();

function walletTotalVal(){
    const xhr = new XMLHttpRequest();

    xhr.onload = function (){
        const serverResponse1 = document.getElementById("there");
        serverResponse1.innerHTML = this.responseText
    };
    xhr.open("POST","");
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send('pay=2');
}
//walletTotalVal();

function clearInput(){
    document.getElementById('amountInputb').value = '';
    document.getElementById('amountInputSell').value = '';
}
