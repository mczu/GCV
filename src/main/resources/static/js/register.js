function createRegistrationObject() {
    var login = document.getElementById("registerInputPassword1").value;
    var password = document.getElementById("registerInputPassword1").value;
    var email = document.getElementById("registerInputEmail1").value;

    var RegistrationObject = {};
    RegistrationObject.login = login;
    RegistrationObject.password = password;
    RegistrationObject.email = email;
    console.log(RegistrationObject);
    return RegistrationObject;
}

function sendRegistrationData() {
    var url = '/users';
    var newData = JSON.stringify(createRegistrationObject());
    var request = new Request(url, {
        method: 'POST',
        body: newData,
        headers: new Headers({
            'Content-Type': 'application/json'
        })
    });
    console.log(newData);
    fetch(request)
        .then(function (data) {
            // Handle response we get from the API
            console.log(data.responseText);
            swal("Konto zarejestrowane", "Nastąpi teraz przejście do okna logowania")
                .then(function () {
                    window.location.href = "/logging.html";
                });
        });
}

document.getElementById("submitRegistrationData").addEventListener("click", sendRegistrationData);