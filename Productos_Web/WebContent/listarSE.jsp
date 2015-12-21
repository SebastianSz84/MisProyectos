<%@page import="controlador.Sistema"%>
<%@page import="entities.SemiElaborado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar MP por Semielaborado</title>
</head>
<body>
<form action="ListaMPporSE" method="get">
	SemiElaborado: <select id="semiElab" name="semiElab">
	<%for(SemiElaborado se : Sistema.getInstancia().listarSE()){%>
	  		<option value="<%=Integer.toString(se.getNumero())%>"><%=se.getDescripcion()%></option>
	<%}%>
	</select><br>
	<input type="submit" value="Listar MPs"/>
</form>
</body>
</html>