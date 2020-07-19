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
    			admin[i].style.display = "";
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
function initAcc(){

    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    let viewer=document.getElementsByClassName("viewer");
    let admin=document.getElementsByClassName("admin");
    let manager=document.getElementsByClassName("manager");
    if (id == null) {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        for (let i = 0; i < viewer.length; i++) {
            viewer[i].style.display = "none";
        }
        for (let i = 0; i < admin.length; i++) {
            admin[i].style.display = "none";
        }
        for (let i = 0; i < manager.length; i++) {
            manager[i].style.display = "none";
        }
        alert("You have to be logged in to view your profile!");
        window.location.replace("/");
    } else {
        let role=sessionStorage.getItem("role");
        if (role == "VIEWER") {
    		for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "none";
            }
            for (let i = 0; i < manager.length; i++) {
                manager[i].style.display = "none";
            }
    	} else if(role=="ADMIN"){
    		for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "none";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "";
            }
            for (let i = 0; i < manager.length; i++) {
                manager[i].style.display = "none";
            }
        }else{
            for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "none";
            }
            for (let i = 0; i < admin.length; i++) {
                admin[i].style.display = "none";
            }
            for (let i = 0; i < manager.length; i++) {
                manager[i].style.display = "";
            }
        }
        

        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}
function initMovie(){

    let id = sessionStorage.getItem("id");
    let role=sessionStorage.getItem("role");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    if (id == null || role!="VIEWER") {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        alert("You have to be logged in as a viewer to be able to reserve a ticket!");
        window.location.replace("/");
    } else {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}
function initMovies(){

    let id = sessionStorage.getItem("id");
    let offline=document.getElementById("offline");
    let online=document.getElementsByClassName("online");
    let viewer=document.getElementsByClassName("viewer");
    if (id == null) {
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "none";
        }
        offline.style.display="block";
        for (let i = 0; i < viewer.length; i++) {
            viewer[i].style.display = "none";
        }
        
    } else {
        let role=sessionStorage.getItem("role");
        if (role == "VIEWER") {
            for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "";
            }
            
    	} else {
            for (let i = 0; i < viewer.length; i++) {
                viewer[i].style.display = "none";
            }

    	}
        for (let i = 0; i < online.length; i++) {
            online[i].style.display = "";
        }
        offline.style.display="none";
    }
}
