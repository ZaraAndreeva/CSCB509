let loginUrl = "localhost:8080/login";
let email = document.getElementById("email");
let password = document.getElementById("password");
let sendLogin = () => {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", loginUrl, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        email,
        password
    }));
};

