

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	 <link rel="stylesheet" type="text/css" href="style.css">
	 <title>logout Page</title>
</head>
<body style="background-color: lightblue;">
	 <%		
		 session.removeAttribute("username");
		 session.removeAttribute("password");
		 session.invalidate();
	 %>
	<center>
		 <h1>You have successfully logged out</h1>
		<h3 style="font-weight: normal;" title="Logout">
			To login again <a href="login.jsp"><i>click here</i></a>.
		</h3>
	</center>
</body>
</html>