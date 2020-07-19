function rateMovie(movie_id,watched_movie_id){
    let rating=parseInt(document.getElementById("rated").value);
    var formData = JSON.stringify({
        "movie_id": movie_id,
        "watched_movie_id": watched_movie_id,
        "rating":rating
    });
    var id=sessionStorage.getItem("id");
    $.ajax({
        url: '/rate',
        dataType: 'json',
        type: 'put',
        contentType: 'application/json',
        data: formData,
        complete: function (xhr, status) {
			if (status === 'error') {
				console.log(error);
				alert("Rating failed!");
			}
			else {
                window.location.replace("/account/"+id+"/watched_movies");			
            }
		  }
    });
    
}
function showRated(user){
    showAll(user);
    for(let i=0;i<user.watched_movies.length;i++){
        if(user.watched_movies[i].rating!=0)
            document.getElementById(user.watched_movies[i].id).style.display="";
        else
            document.getElementById(user.watched_movies[i].id).style.display="none";
    }
}
function showUnrated(user){
    showAll(user);
    for(let i=0;i<user.watched_movies.length;i++){
        if(user.watched_movies[i].rating==0)
            document.getElementById(user.watched_movies[i].id).style.display="";
        else
            document.getElementById(user.watched_movies[i].id).style.display="none";
    }
}
function showAll(user){
    for(let i=0;i<user.watched_movies.length;i++){
        document.getElementById(user.watched_movies[i].id).style.display="";
    }
}
