<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="person" scope="session" class="model.Person" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage des détails d'une personne</title>
</head>
<body>

	<table border="1">
		<tr>
			<td><strong>Id : </strong></td>
			<td><c:out value="${person.id}" /></td>
		</tr>
		<tr>
			<td><strong>Nom : </strong></td>
			<td><c:out value="${person.name}" /></td>
		</tr>
		<tr>
			<td><strong>Prénom : </strong></td>
			<td><c:out value="${person.surname}" /></td>
		</tr>
		<tr>
			<td><strong>Date de naissance : </strong></td>
			<td><c:out value="${person.birthdate}" /></td>
		</tr>
		<tr>
			<td><strong>Email : </strong></td>
			<td><c:out value="${person.email}" /></td>
		</tr>
	</table>

</body>
</html>