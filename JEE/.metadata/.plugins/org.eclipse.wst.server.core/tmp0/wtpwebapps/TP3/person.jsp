<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Descriptif d'une personne</title>
</head>
<body>

	<jsp:useBean id="person" scope="session" class="person.bean.Person" ></jsp:useBean>

	
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nom</td>
			<td>Prénom</td>
			<td>Date de naissance</td>
			<td>Email</td>
		</tr>
		<tr>
			<td><jsp:getProperty property="id" name="person"/></td>
			<td><jsp:getProperty property="name" name="person"/></td>
			<td><jsp:getProperty property="surname" name="person"/></td>
			<td><jsp:getProperty property="birthdate" name="person"/></td>
			<td><jsp:getProperty property="email" name="person"/></td>
		</tr>
	</table>
	
</body>
</html>