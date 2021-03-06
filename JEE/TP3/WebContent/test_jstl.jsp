<html>
<body>
	<!-- controle, iterations, tests, variables -->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- traitement XML -->
	<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
	<!-- formattage des donnees -->
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<!-- SQL/JDBC -->
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
	<p>Les parametres:</p>
	<ul>
		<c:forEach var="aParam" items="${param}">
			<li>un parametre : <c:out value="${aParam.key}" /> = <c:out
					value="${aParam.value}" />
			</li>
		</c:forEach>
	</ul>
	<c:choose>
		<c:when test="${param['question'] == 'oui'}">
			<c:out value="OUI"/>
		</c:when>
		<c:otherwise>
			<c:out value="NON"/>
		</c:otherwise>
	</c:choose>
</body>
</html>