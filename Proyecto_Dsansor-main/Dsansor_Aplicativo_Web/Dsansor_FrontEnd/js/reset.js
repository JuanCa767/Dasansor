//var password_old = document.getElementById("oldpw");
var password = document.getElementById("newpw"); 
var confirm_password = document.getElementById("confirmpw");
 

function validatePassword(){
    /*if(password_old.value == password.value){
        confirm_password.setCustomValidity("Las contraseñas ingresadas son iguales");    
    }else{

    }*/
   
    if(password.value != confirm_password.value) {
        //Colorear confirm en rojo o usar:
        confirm_password.setCustomValidity("Las contraseñas no coinciden");
    } 
    else {
        confirm_password.setCustomValidity('La contrasaña ha sido cambiada');
    }
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;