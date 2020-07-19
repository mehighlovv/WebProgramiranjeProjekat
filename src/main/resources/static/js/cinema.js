function addCinema() {
    let email = document.getElementById('emailc').value;
    let name = document.getElementById('name').value;
    let phone = document.getElementById('phone').value;
    let address = document.getElementById('address').value;
    var formData = JSON.stringify({
        "email": email,
        "name": name,
        "phone_number":phone,
        "address":address
    });
    console.log(formData);
    $.ajax({
        url: '/add-cinema',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
        success: function(){
        	console.log("success");
            window.location.replace("/cinemas");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
                }
        }
    });
}
function deleteCinema(id) {

    $.ajax({
        url: '/cinemas/'+id,
        type: 'delete',
        success: function(){
        	console.log("success");
            window.location.replace("/cinemas");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 409) {
                alert("Something went wrong!");
                return;
                }
        }
    });
}