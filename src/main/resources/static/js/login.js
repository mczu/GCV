function createLoginObject() {
    var login = document.getElementById("exampleInputLogin").value;
    var password = document.getElementById("exampleInputPassword1").value;
    var LoginObject = {};
    LoginObject.login = login;
    LoginObject.password = password;
    console.log(LoginObject);
    return LoginObject;
}

function sendLoginData() {
    var urlLog = '/login';
    var newData = JSON.stringify(createLoginObject());
    var requestLog = new Request(urlLog, {
        method: 'POST',
        body: newData,
        headers: new Headers({
            'Content-Type': 'application/json'
        })
    });
    console.log(createLoginObject());
    console.log(newData);
    fetch(requestLog)
        .then(function (response) {
            // Handle response we get from the API
            console.log(response);
            console.log(response.body);
            console.log(response.text().then(function(text){
                console.log(text);
                localStorage.setItem('userUrl', text);
                if(text !== "BAD_CREDENTIALS"){
                    swal("Logowanie udane!", "Nastąpi teraz przejście do panelu użytkownika")
                        .then(function(){
                            window.location.href = "/register.html";
                        });
                } else {
                    swal("Logowanie nieudane, spróbuj jeszcze raz");
                }
            }));

        })
     /*   .catch(function(error) {
                // If there is any error you will catch them here
        });*/
}
function validateLogging(){
    var login = document.getElementById("exampleInputLogin").value;
    var password = document.getElementById("exampleInputPassword1").value;

    if(login && password !== null){
        sendLoginData();
    } else {
        swal("Wpisz dane logowania");
    }
}

//document.getElementById("submitLoginData").addEventListener("click", sendLoginData);
document.getElementById("submitLoginData").addEventListener("click", validateLogging);