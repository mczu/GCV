function createLoginObject() {
    var login = document.getElementById("exampleInputLogin").value;
    var password = document.getElementById("exampleInputPassword1").value;

    var LoginObject = {};
    LoginObject.login = login;
    LoginObject.password = password;
    console.log(LoginObject);
    return LoginObject;
}

var url = 'http://localhost:8080/login';

var newData = JSON.stringify(createLoginObject());

var request = new Request(url, {
    method: 'POST',
    body: newData,
    headers: new Headers({
        'Content-Type': 'application/json'
    })
});

function sendLoginData() {
    console.log(newData);
    fetch(request)
        .then(function (data) {
            // Handle response we get from the API
            console.log(data);
        });
}

document.getElementById("submitLoginData").addEventListener("click", sendLoginData);