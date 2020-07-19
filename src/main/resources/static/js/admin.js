function registerManager() {
    let email = document.getElementById("email1").value;
    let name = document.getElementById('name').value;
    let lastname = document.getElementById('lastname').value;
    let phone = document.getElementById('phone_number').value;
    let password = document.getElementById('password1').value;
    let password1 = document.getElementById('password2').value;
    let username = document.getElementById('username').value;
    let date=document.getElementById('date').value;
    let cinema=document.getElementById('cinema').value;
    let id=sessionStorage.getItem("id");
    if(password1==password){
        var formData = JSON.stringify({
            "email": email,
            "name": name,
            "phone_number":phone,
            "lastname":lastname,
            "password":password,
            "username":username,
            "date":date,
            "role":1,
            "activity":true,
            "cinema_id":cinema
        });
        $.ajax({
            url: '/register-manager',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: formData,
            success: function(data){
                window.location.replace("/account/"+id+"/managers");
            },
            error: function( jqXhr, textStatus, errorThrown ){
                window.location.replace("/account/"+id+"/managers");
            }
        });
    }else{
        alert("Passwords do not match!");
    }
}
function managers(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/managers");
}
function createManager(){
    var id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/register_man");
}
function deleteManager(manager_id){
    let id=sessionStorage.getItem("id");
    $.ajax({
        url: '/remove_manager/'+manager_id,
        dataType: 'json',
        type: 'delete',
        contentType: 'application/json',
        success: function(){
            window.location.replace("/account/"+id+"/managers");
        },
        error: function(){
            window.location.replace("/account/"+id+"/managers");
        }
    });
}