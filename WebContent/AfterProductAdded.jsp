
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	 <link rel="stylesheet" type="text/css" href="style.css">
	 <title>Product Added</title>
</head>
<body style="background-color: lightblue;">
	 <%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
	    response.setHeader("Pragma","no-cache"); //HTTP 1.0
	    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
	%>
	<%
		if(session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<center>
		 <h1>Your Product have been successfully added!</h1>
		<h3 style="font-weight: normal;" title="">
			<a href="deptHome.jsp" title="Home Page Link">Soon you will redirected to Home Page 
						<%
							Thread.sleep(5000);
						   // response.sendRedirect("/LoginDemo/deptHome.jsp");
						%>										
						</a>.
		</h3>
	</center>
</body>
</html>