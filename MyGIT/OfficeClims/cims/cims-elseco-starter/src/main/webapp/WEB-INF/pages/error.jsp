<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Something went wrong</h2>
	</br>
	<h3>Request method 'GET' not supported. Please verify your Request.</h3>
	</br>
	<c:if test="${not empty msg}">
		<h4>${msg}</h4>
	</c:if>
	
</body>
</html>
