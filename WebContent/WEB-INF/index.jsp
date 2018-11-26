<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/agency.min.css" type="text/css" />
<link rel="stylesheet" href="./css/proxi.css">
<title>Accueil</title>
</head>
<body>
	<div>
		<table>
			<caption>Liste des clients </caption>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Email</th>
					<th>Adresse</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="client" items ="${clients}"> 
						
				<tr>	
					<td>${client.id}</td>
					<td>${client.lastname}</td>
					<td>${client.firstname}</td>
					<td>${client.email}</td>
					<td>${client.address}</td>
				</tr>
			</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Email</th>
					<th>Adresse</th>
				</tr>
			</tfoot>
		</table>
	</div>
	<div>
		<form method="post" action="">
			<label for="client">Selectionner un client</label>
			<select name="client" id="client">
				<c:forEach var="client" items ="${clients}"> 
					<option value="1">Client n°${client.id}</option>
				</c:forEach>	
			</select>
		</form>
		<p><a href="edit.html">Modifier les infos du client</a>
		<a href="account.html">Liste des comptes du client</a>
		<a href="edit.html">Faire un virement compte à compte</a></p>
	</div>
</body>
</html>