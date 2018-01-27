var login = document.getElementById("exampleInputPassword1").value;
var password = document.getElementById("exampleInputPassword1").value;

function prepareLoginData() {
    console.log(password);
}

function createLoginObject() {
    var LoginObject = {};
    LoginObject.login = login;
    LoginObject.password = password;
    return LoginObject;
}

function sendLoginData() {
    var loginJSON = createLoginObject();
    console.log(loginJSON);
}

document.getElementById("submitLoginData").addEventListener("click", sendLoginData);