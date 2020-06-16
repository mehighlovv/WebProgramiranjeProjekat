function initCinema () {
    let id = sessionStorage.getItem("id");
    let role = sessionStorage.getItem("role");
    let offline=document.getElementById("offline");
    let online=document.getElementById("online");
    let admin = document.getElementsByClassName("admin");
    if (id == null) {
    	for (let i = 0; i < admin.length; i++) {
    		admin[i].style.display = "none";
    	}
        offline.style.display="block";
        online.style.display="none";
    } else {
    	if (role == "ADMIN") {
    		for (let i = 0; i < admin.length; i++) {
    			admin[i].style.display = "block";
    		}
    	} else {
    		for (let i = 0; i < admin.length; i++) {
    			admin[i].style.display = "none";
    		}
    	}
        online.style.display="block";
        offline.style.display="none";
    }
}

function init () {
    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementById("online");
    if (id == null) {
        offline.style.display="block";
        online.style.display="none";
    } else {
        online.style.display="block";
        offline.style.display="none";
    }
}
