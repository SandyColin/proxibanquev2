<%@ page isErrorPage="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>error page</title>
</head>
<body>
 <h1 style="color:red; size:x-large;text-align:center">Une erreur est survenue.<br></h1>
 <h1 style="color:red; size:x-large;text-align:center"> Veuillez contacter le responsable technique de l'application<br></h1>
 <c:url var="indexUrl" value="/"/>
 <h3 style="text-align:center"><a href="${indexUrl}"> Revenir au menu principal</h3></p>
</body>
</html>