<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">
			<legend>Modification du client</legend>
			<div class="form-row">
				
				<div class="col">
				    <label for="id">Identifiant</label>
					<input type="hidden" class="form-control" value="${client.id}"name="id" id="id" required />
				</div>
				<div class="col">
				    <label for ="firstname">Nom:</label>
					<input type="text" class="form-control" value="${client.firstname}"
						name="firstname" id="firstname" required/>
				</div>
				<div class="col">
				    <label for="Prénom">Prénom</label>
					<input type="text" class="form-control" value="${client.lastname}"
						name="lastname" id="lastname" required/>
				</div>
				<div class="col">
				    <label for="email">email</label>
					<input type="email" class="form-control" value="${client.email}"
						name="email" id="email" required/>
				</div>
				<div class="col">
				    <label for="address">Adresse</label>
					<input type="text" class="form-control" value="${client.address}"
						name="address" id="address" required/>
				</div>
				<div class="col">
					<button type="submit" class="btn btn-primary" required>Modifier</button>
				</div>
			</div>
	


</form>



</body>
</html>