var aFazeres = []
var lista = document.getElementById("divLista")
var botaoAdicionar = document.getElementById("botaoAdicionar")
botaoAdicionar.onclick = adionarNaLista

function adionarNaLista() {
    var aFazer = document.getElementById("geraPassos")

    if (aFazer.value != "") {
        aFazeres.push(aFazer.value)
        carregarLista()
        inputReset()
    } else {
        alert("Campo vazio")
        aFazer.focus()
    }
}

function preLoadLista() {
    var preLoad = document.querySelectorAll("textarea[name=passos]");
    //var preLoad = document.getElementsByName("passos");

    for (var i = 0; i < preLoad.length; i++) {
        aFazeres.push(preLoad[i].value)
    }
}

function removerDaLista(posicao) {
    aFazeres.splice(posicao, 1)
    carregarLista()
}

function carregarLista() {
    lista.innerHTML = "";
    //alert(aFazeres.length);
    for (let i = 0; i < aFazeres.length; i++) {
        let itemLista = document.createElement("li")
        let divText = document.createElement("div")
        let divBtn = document.createElement("div")
        let botaoRemover = document.createElement("input")
        let itemTextArea = document.createElement("textarea")

        
        divText.setAttribute("class", "form-group col-md-10");
        divBtn.setAttribute("class", "form-group col-md-2");
        
        botaoRemover.type = "button"
        botaoRemover.value = "Remover"
        botaoRemover.id = i        
               
        itemTextArea.setAttribute("name", "passos")
        itemTextArea.setAttribute("class", "form-control")
        itemTextArea.setAttribute("rows", "1")    
        
        botaoRemover.setAttribute("onclick", "removerDaLista(" + i + ")")
        botaoRemover.setAttribute("class", "btn btn-sm")
        //botaoRemover.style.marginBottom = "2px"

        itemTextArea.innerHTML = aFazeres[i]
        divText.appendChild(itemTextArea)
        divBtn.appendChild(botaoRemover)
        
        lista.appendChild(divText);
        lista.appendChild(divBtn);
    }
}

function iputCleanAndFocus() {
    let input = document.getElementById("geraPassos")
    input.placeholder = ""
//    input.style.color = "black"
    input.focus();
}

function inputReset() {
    let input = document.getElementById("geraPassos")
    input.value = ""
//    input.setAttribute("placeholder","Adicionar tarefa")
//    input.style.color = "#999"
}