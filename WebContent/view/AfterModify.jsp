<%@page import="com.mindtree.service.DeleteService"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.mindtree.model.dao.CheckUserType"%>
<%@page import="java.io.PrintWriter" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	 <link rel="stylesheet" type="text/css" href="style.css">
	 <title>Modify</title>
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
		<%	
			String userName = session.getAttribute("username").toString();
			if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
				%>
				<h1>Your Product have been successfully Updated!</h1>
				<% 
			}
			else{
				%>
				<h1>Your Product have been successfully Sent for Approval!</h1>
				<%
			}
		%>
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