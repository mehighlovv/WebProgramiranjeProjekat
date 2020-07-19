function addRoom(cinema_id){

	var id=sessionStorage.getItem("id");
    let capacity=document.getElementById("capacity").value;
    let mark=document.getElementById("mark").value;
    var formData = JSON.stringify({
        "mark": mark,
        "capacity": capacity,
        "cinema_id":cinema_id
    });
    $.ajax({
        url: '/add_room',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Something's wrong!");
			}
			else {
				window.location.replace("/account/"+id+"/cinema");
			}
		  }
    });
    
}
function deleteRoom(room_id,cinema_id){

	var id=sessionStorage.getItem("id");
    $.ajax({
        url: '/delete_room/'+cinema_id+'/room/'+room_id,
        dataType: 'json',
        type: 'delete',
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Something's wrong!");
			}
			else {
				window.location.replace("/account/"+id+"/cinema");
			}
		  }
    });
    
}
function editRoom(room_id){

	var id=sessionStorage.getItem("id");
    let capacity=document.getElementById("capacity").value;
    let mark=document.getElementById("mark").value;
    var formData = JSON.stringify({
        "id":room_id,
        "mark": mark,
        "capacity": capacity,
    });
    $.ajax({
        url: '/edit_room',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("Something's wrong!");
			}
			else {
				window.location.replace("/account/"+id+"/cinema");
			}
		  }
    });
    
}
function edit(room_id){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/cinema/room/"+room_id);
}
function cinema(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/cinema");
}
function schedule(){
    let id=sessionStorage.getItem("id");
    window.location.replace("/account/"+id+"/schedule");
}
