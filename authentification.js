
/*Fonction pour vérifier que tous les champs sont remplis lors de l'authentification.*/
function verification(){
	var verifnom = document.getElementById('id_user').value;
	var verifpwd = document.getElementById('id_pwd').value;
	
	if (verifnom == "" || verifpwd == ""){
	alert('Veuillez remplir tous les champs');
	
		if (verifnom == ""){
			document.getElementById('id_user').focus();
			return false;
		}
		
		else if (verifpwd == ""){
			document.getElementById('id_pwd').focus();
			return false;
		}
	
		else if (verifpwd == "" && verifnom == ""){
			document.getElementById('id_user').focus();
			return false;
		}
		else 
		{
			alert('Erreur dans les conditions');
		}
	}
};

/*Fonctions pour afficher le menu about us*/
function about(){
	document.getElementById('id_about').style.display='block';
	return 0;
}

function noabout(){
	document.getElementById('id_about').style.display='none';
	return 0;
}

/*Fonctions pour afficher le menu constact*/
function contact(){
	document.getElementById('id_contact').style.display='block';
	return 0;
}

function nocontact(){
	document.getElementById('id_contact').style.display='none';
	return 0;
}


/*Fonctions pour afficher l'alert mot de passe oublier*/
function collapse(){
	alert("Veuillez consulter le fichier readme fourni avec l'application.");
}