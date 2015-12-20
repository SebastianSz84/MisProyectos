<%@page import="entities.Unidad"%>
<%@page import="controlador.Sistema"%>
<%@page import="entities.MateriaPrima"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar un semielaborado</title>
</head>
<body>
<form action="AltaSE" method="post" onsubmit="return validarCProd()">
   	Materia Prima: <select name="mp">
	<%for(MateriaPrima mp : Sistema.getInstancia().listarMPs()){%>
   		<option value="<%=mp.getCodigo()%>"><%=mp.getDescripcion()%></option>
	<%}%>
	</select><br>
	Unidad: <select name="unidad">
	<%for(Unidad u : Sistema.getInstancia().listarUNs()){%>
   		<option value="<%=Integer.toString(u.getCodigo())%>"><%=u.getDescripcion()%></option>
	<%}%>
	</select><br>
	<input id="costoProd" type="text"/><br>
	<input type="submit" value="Crear SE"><br>	
</form>
</body>
</html>
<script type="text/javascript">
function validarCProd(){
	var costo = document.getElementById("costoProd").value;
	if(!costo){
		alert("Ingrese un costo de producción.");
		return false;
	}else{
		if(isNaN(parseFloat(costo))){
			alert("Ingrese un costo de producción numérico.");
			costo="";
			return false;
		}
	}
}
</script>