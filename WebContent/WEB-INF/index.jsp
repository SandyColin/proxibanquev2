<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>

	<table>
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Email</th>
			<th>Adresse</th>
		</tr>

	<c:forEach var="client" items ="${clients}"> 
				
		<tr>		
			<td>${lastname.client}</td>
			<td>${firstname.client}</td>
			<td>${email.client}</td>
			<td>${address.client}</td>
		</tr>
	</c:forEach>
	</table>

	<form method="post" action="">
		<label for="client">Selectionner un client</label>
		<select name="client" id="client">
			<option value="1">Client n°1</option>
			<option value="2">Client n°2</option>
			<option value="3">Client n°3</option>
			<option value="4">Client n°4</option>
			<option value="5">Client n°5</option>
			
		
		
		</select>
	</form>
	<p><a href="edit.html">Modifier les infos du client</a>
	<a href="account.html">Liste des comptes du client</a>
	<a href="edit.html">Faire un virement compte à compte</a></p>
</body>
</html>