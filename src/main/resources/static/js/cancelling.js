function cancelReservation(projection_id){
    var id=sessionStorage.getItem("id");

    var formData = JSON.stringify({
        "user_id": id,
        "projection_id": projection_id,
    });
    $.ajax({
        url: '/cancel_reservation',
        dataType: 'json',
        type: 'delete',
        contentType: 'application/json',
        data: formData,
        success: function(){
            window.location.replace("/account/"+id+"/reservations");
        },
        error: function(){
            window.location.replace("/account/"+id+"/reservations");
        }
    });
    
}