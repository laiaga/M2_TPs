<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.*"%>
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
<title>Uber title of death</title>
</head>
<body>
	<p>
		<%
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			out.print(dateFormat.format(date));
		%>
	</p>

	<jsp:useBean id="product2" scope="request" class="monapp.Product">
		<p>Nouveau produit !</p>
	</jsp:useBean>
	<jsp:setProperty name="product2" property="*" />
	<p>
		Nom:
		<%=product2.getName()%></p>
	<p>
		Prix:
		<%=product2.getPrice()%></p>
	<p>
		Desc:
		<%=product2.getDesc()%></p>

</body>
</html>