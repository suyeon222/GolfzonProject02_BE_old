<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello host!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div>
	<iframe src="http://localhost:8100/user/"></iframe>
</div>
</body>
</html>
