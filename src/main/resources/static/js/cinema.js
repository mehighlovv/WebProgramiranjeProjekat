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
function edit(cinema_id){
    window.location.replace("/cinema/"+cinema_id);
}
function editCinema(cinema_id){

    let name=document.getElementById("name").value;
    let address=document.getElementById("address").value;
    let phone_number=document.getElementById("phone_number").value;
    let email=document.getElementById("email").value;
    var formData = JSON.stringify({
        "id":cinema_id,
        "name": name,
        "address": address,
        "email":email,
        "phone_number":phone_number,
        "schedule":null,
        "managers":null,
        "rooms":null
    });
    $.ajax({
        url: '/edit_cinema',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Something's wrong!");
			}
			else {
				window.location.replace("/cinemas");
			}
		  }
    });
    
}