function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("Movies");
  switching = true;
  dir = "asc";
  var thead=document.getElementById("th"+n);
  thead.classList.add('fa-sort-asc');
  while (switching) {
    switching = false;
    rows = table.rows;
    for (i = 1; i < (rows.length - 1); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      switchcount ++;
    } else {
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        thead.classList.remove('fa-sort-asc');
        thead.classList.add('fa-sort-desc');
        switching = true;
      }
    }
  }
 	for (i = 1; i <6 ; i++)
 	{
 		var trows=document.getElementById("th"+i);
 		if(i!=n)
 		{
 			if(trows.classList.contains('fa-sort-asc')){
 				trows.classList.remove('fa-sort-asc');
 			} else if(trows.classList.contains('fa-sort-desc')){
 			trows.classList.remove('fa-sort-desc');
 			}
 		}
 	}
}


function filterData(moviesDTO)
{
	var moviename=document.getElementById("moviename").value;
	var genre=document.getElementById("genre").value;
	var time=document.getElementById("time").value;
	var rating=document.getElementById("rating").value;
	var description=document.getElementById("description").value;
	var price=document.getElementById("price").value;
	var filter=[];
	var movies=moviesDTO.movies;
	for(let i=0;i<movies.length;i++)
	{
		document.getElementById(movies[i].id).style.display="";
	}
	if(moviename!="")
		filter["name"]=moviename;
		
	if(genre!="Genre")
		filter["genre"]=genre;
		

	if(rating!="")
		filter["rating"]=rating;
		
		
	if(description!="")
		filter["description"]=description;
		
		
	if(price!="")
		filter["price"]=price;
		
		
	if(time!="")
		filter["time"]=time;;
	for (const [key, value] of Object.entries(filter)) {
		filterOne(movies,key,value);
	}
}

function filterOne(movies,key,value)
{
	for(let i=0;i<movies.length;i++)
	{
		finalFilter(movies[i],key,value);
	}
}

function finalFilter(movie,key,value)
{
	if(document.getElementById(movie.id).style.display=="none")
	{
		return;
	}
	let flag=false;
	if(key=="price"){
		for(let i=0;i<movie.projections.length;i++){
			if(parseInt(value)>=movie.projections[i].price)
				flag=true;
		}
	}
	else if(key=="time"){
		let help=value.split(":");
		for(let i=0;i<movie.projections.length;i++)
		{
			let arr=movie.projections[i].time.split(":");
			if(parseInt(help[0])>=parseInt(arr[0]))
			{
				if(parseInt(help[1])>=parseInt(arr[1]))
					flag=true;	
			}	
		}
	}
	else if(key=="rating"){
		if(parseFloat(value)<=parseFloat(movie.rating))
			flag=true;
	}else if(key=="name"){
		if(movie.name.toLowerCase().indexOf(value.toLowerCase())>-1)
			flag=true;
	}else if(key=="description"){
		if(movie.description.toLowerCase().indexOf(value.toLowerCase())>-1)
			flag=true;
	}else if(key=="genre"){
		if(value!="Genre")
		{
			if(movie.genre==value)
				flag=true;
		}
		else
			flag=true;
	}
	
	if(flag){
		document.getElementById(movie.id).style.display="";
	}
	else{
		document.getElementById(movie.id).style.display="none";
	}
	
	
}

function getMovie(id) {
    $.ajax({
        url: '/movie/'+id,
        type: 'get',
        contentType: 'application/json',
        success: function(){
            window.location.replace("/movie/"+id);
        },
        error: function(){
            	alert("Server error");
            	return;
        }
    });
}
function reserve(projection_id){

	var id=sessionStorage.getItem("id");

    var formData = JSON.stringify({
        "user_id": id,
        "projection_id": projection_id,
    });
    $.ajax({
        url: '/reserve_ticket',
        dataType: 'json',
        type: 'post',
        contentType: 'application/json',
        data: formData,
		complete: function (xhr, status) {
			if (status === 'error') {
				alert("You either already reserved a ticket for this projection or it isn't currently playing in any room!");
			}
			else {
				window.location.replace("/account/"+id+"/reservations");
			}
		  }
    });
    
}
