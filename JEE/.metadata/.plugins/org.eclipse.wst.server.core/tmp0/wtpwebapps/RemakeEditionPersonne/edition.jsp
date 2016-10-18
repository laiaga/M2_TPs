<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="person" scope="session" class="model.Person" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification des détails d'une personne</title>
</head>
<body>

	<form action="EditionServlet" method="get">
		<p>
			<strong>Nom :</strong><input type="text" name="name" />
		</p>
		<p>
			<strong>Prénom :</strong> <input type="text" name="surname" />
		</p>
		<p>
			<strong>Date de naissance :</strong> <input type="text"
				name="birthdate" />
		</p>
		<p>
			<strong>Email :</strong> <input type="text" name="email" />
		</p>
		<p>
			<input type="submit" value="submit">
		</p>
	</form>

</body>
</html>