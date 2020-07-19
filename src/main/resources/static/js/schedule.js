function AddProjection(cinema_id){
    var id=sessionStorage.getItem("id");
    let movie=document.getElementById("movie").value;
    let room=document.getElementById("room").value;
    let date=document.getElementById("date").value;
    let time=document.getElementById("time").value;
    let price=document.getElementById("price").value;
    var formData = JSON.stringify({
        "room_id": room,
        "movie_id": movie,
        "day":date,
        "time":time,
        "price":price,
        "cinema_id":cinema_id
    });
    $.ajax({
        url: '/add_projection',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Something's wrong!");
			}
			else {
				window.location.replace("/account/"+id+"/schedule");
			}
		  }
    });
}