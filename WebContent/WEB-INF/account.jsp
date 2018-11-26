<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <div class="monindex">
 	 	<form method="post" action="">
			<label>Nom</label><input type="text" value="${client.lastname}"/> 
			<label>Prénom</label><input type="text" value="${client.lastname}"/> 
		</form>
		<table class="listeclients">
			<caption>Liste des comptes </caption>
			<thead>
				<tr>
					<th class="listecompte">Id</th>
					<th class="listecompte">Numéro de compte</th>
					<th class="listecompte">Solde</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="account" items ="${accounts}"> 
						
				<tr>	
					<td class="listecompte">${account.id}</td>
					<td class="listecompte">${account.number}</td>
					<td class="listecompte">${account.balance}</td>
					
				</tr>
			</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th class="listecompte">Id</th>
					<th class="listecompte">Numéro de compte</th>
					<th class="listecompte">Solde</th>
				</tr>
			</tfoot>
		</table>
	</div>
	
		


</body>
</html>