var login = document.getElementById("registerInputPassword1").value;
var password = document.getElementById("registerInputPassword1").value;
var email = document.getElementById("registerInputEmail").value;

function prepareRegistrationData() {
    console.log(password);
}

function createRegistrationObject() {
    var RegistrationObject = {};
    RegistrationObject.login = login;
    RegistrationObject.password = password;
    RegistrationObject.email = email;
    return RegistrationObject;
}

function sendRegistrationData() {
    var loginJSON = createRegistrationObject();
    console.log(loginJSON);
}

document.getElementById("submitLoginData").addEventListener("click", sendRegistrationData);