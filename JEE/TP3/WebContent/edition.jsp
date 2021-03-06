<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- controle, iterations, tests, variables -->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- traitement XML -->
	<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
	<!-- formattage des donnees -->
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<!-- SQL/JDBC -->
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edition d'une personne</title>
</head>
<body>

<c:out value="Entrez les informations concernant la personne à créer : "/>

<form method="post" action="traitement.php">
    <p>
        <label>Identifiant</label> : <input type="text" name="id" />
    </p>
    <p>
        <label>Nom</label> : <input type="text" name="nom" />
    </p>
    <p>
        <label>Prénom</label> : <input type="text" name="prenom" />
    </p>
    <p>
        <label>Date de naissance</label> : <input type="date" name="date_naissance" />
    </p>
    <p>
        <label>E-mail</label> : <input type="email" name="email" />
    </p>
</form>

</body>
</html>