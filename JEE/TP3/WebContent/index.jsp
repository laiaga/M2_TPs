<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uber title of death</title>
</head>
<body>

	<p>
	<% DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date(); 
	out.print(dateFormat.format(date));%>
	</p>
	
	<jsp:useBean id="product" scope="session" class="monapp.Product" >
    	<p>Nouveau produit !</p>
	</jsp:useBean>
	<jsp:setProperty
    name="product"
    property="*" />
	<p>Nom:  <%= product.getName()  %></p>
	<p>Prix: <%= product.getPrice() %></p>
	<p>Desc: <%= product.getDesc()  %></p>

</body>
</html>