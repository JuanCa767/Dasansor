


function enviar(){
    document.forma.action= "formulario.html";
    document.forma.submit();
}

function verificarClave(){
    if(document.getElementById('user').value=="juan" && document.getElementById('password').value == "juan123"){
        enviar();
        //alert("entro aqui");
    }
    else{
        alert("Clave errada");
    }

}