function login() {
    // get the form data
    // there are many ways to get this data using jQuery (you can use the class or id also)
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;
    var formData = JSON.stringify({
        "email": email,
        "password": password
    });
    console.log(formData);
    $.ajax({
        url: '/login',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){

            sessionStorage.setItem("id", data["id"]);
            sessionStorage.setItem("role",data["role"]);

            window.location.replace("/account/"+data["id"]);
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 404) {
                alert("Email not found!");
                return;
            } else if (jqXhr.status == 400) {
                alert("Wrong password");
                return;
            } else if (jqXhr.status == 406) {
            	alert("Server error");
            	return;
            }
            // default handling
            alert("error")
        }
    });
}
function register() {
    let email = document.getElementById('email').value;
    let name = document.getElementById('name').value;
    let lastname = document.getElementById('lastname').value;
    let phone = document.getElementById('phone_number').value;
    let password = document.getElementById('password').value;
    let password1 = document.getElementById('password1').value;
    let username = document.getElementById('username').value;
    let date=document.getElementById('date').value;
    
    if(password1!=password){
    	alert("Password do not match!");
    	return;
    }
    else{
    var formData = JSON.stringify({
        "email": email,
        "name": name,
        "phone_number":phone,
        "lastname":lastname,
        "password":password,
        "username":username,
        "date":date,
        "role":1,
        "activity":false
    });
    console.log(formData);
    $.ajax({
        url: '/register-user',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(data){
        	console.log("success");
        	sessionStorage.setItem("id", data["id"]);
            sessionStorage.setItem("role",data["role"]);
            window.location.replace("/account/"+data["id"]);
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
                }
        }
    });
    }
}
function logOut() {
	sessionStorage.clear();
	window.location.replace("/");
}