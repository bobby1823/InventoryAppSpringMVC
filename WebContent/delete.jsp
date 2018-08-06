<%@page import="com.mindtree.service.DeleteService"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.mindtree.model.dao.CheckUserType"%>
<%@page import="java.io.PrintWriter" %>
<%@page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Product</title>
</head>
<body>
		<%
			response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
		    response.setHeader("Pragma","no-cache"); //HTTP 1.0
		    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
		%>
		<%
			HttpSession sessionObject = request.getSession();
			String userName = sessionObject.getAttribute("username").toString();
			int deleteProductId = Integer.parseInt(String.valueOf(request.getParameter("productId")));
			//Delete Service is getting called.
			DeleteService deleteService = new DeleteService();
			deleteService.deleteProduct(userName, deleteProductId);
			response.sendRedirect("AfterDelete.jsp");
		
		%>
</body>
</html>