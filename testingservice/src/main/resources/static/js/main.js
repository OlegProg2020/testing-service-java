function checkPassword() {
    let password = document.getElementById("password");
    let confirm = document.getElementById("confirm");
    if(password. password.value !== confirm.value) {
        confirm.value = "";
        alert("Passwords don't match");
    }
}