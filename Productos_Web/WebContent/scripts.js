function validarForm() {
	var flagError = false;
	var costo = document.getElementsByName("costoProd")[0].value;
	if(!costo){
		alert("Ingrese un costo de producción.");
		flagError = true;
	}else{
		if(isNaN(parseFloat(costo))){
			alert("Ingrese un costo de producción numérico.");
			costo="";
			flagError = true;
		}
	}

	var desc = document.getElementsByName("desc")[0].value;
	if(!desc){
		alert("Ingrese una descripción.");
		flagError = true;
	}

	var selMP = document.getElementsByName("mp")[0];
	var count = 0;
	for(var i = 0; i < selMP.options.length; i++){
		if(selMP.options[i].selected){
			count++;
			i = selMP.options.length;
		}
	}
	if(count < 1){
		alert("Seleccione al menos una Materia Prima.");
		flagError = true;
	}

	if(flagError==true){
		return false;
	}
}