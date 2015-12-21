<%@page import="beans.UnidadDTO"%>
<%@page import="beans.MateriaPrimaDTO"%>
<%@page import="controlador.BusinessDelegate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar un semielaborado</title>
</head>
<body>
<script type="text/javascript" src="scripts.js"></script>
<form action="AltaSE" method="post" onsubmit="return validarForm()">
   	Materia Prima: <select id="mp" name="mp" multiple="multiple">
	<%for(MateriaPrimaDTO mp : BusinessDelegate.getInstancia().listarMPs()){%>
   		<option value="<%=mp.getCodigo()%>"><%=mp.getDescripcion()%></option>
	<%}%>
	</select><br>
	Unidad: <select name="unidad">
	<%for(UnidadDTO u : BusinessDelegate.getInstancia().listarUNs()){%>
   		<option value="<%=Integer.toString(u.getCodigo())%>"><%=u.getDescripcion()%></option>
	<%}%>
	</select><br>
	Costo de producción: <input id="costoProd" name="costoProd" type="text"/><br>
	Descripción: <input id="desc" name="desc" type="text"/><br>
	<input type="submit" value="Crear SE"><br>	
</form>
<a href="index.html">Volver</a>
</body>
</html>