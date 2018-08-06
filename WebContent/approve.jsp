<%@page import="com.mindtree.service.DeleteService"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.mindtree.model.dao.CheckUserType"%>
<%@page import="java.io.PrintWriter" %>
<%@page import="com.mindtree.service.*" %>
<%@page import="java.util.Date"%>
<%@page import="java.io.IOException"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Video</title>
</head>
<body>
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
	<%
		HttpSession sessionObject = request.getSession();
		String userName = sessionObject.getAttribute("username").toString();
		
		int productId = Integer.valueOf(request.getParameter("productId").toString());
		int storeId = Integer.valueOf(request.getParameter("storeId").toString());
		int deptId = Integer.valueOf(request.getParameter("deptId").toString());
		String productName = (request.getParameter("productName").toString());
		String vendor = request.getParameter("vendor").toString();
		double mrp = Double.parseDouble(request.getParameter("mrp").toString());
		String batchNum = request.getParameter("batchNumber").toString();
		Date batchDate = null;
		try {
			String[] date = request.getParameter("batchDate").split("-");
			String year = date[0];
			String month = date[1];
			String day = date[2];
			batchDate = new SimpleDateFormat("dd/MM/yy").parse(day+"/"+month+"/"+year);
			System.out.println("Date: "+batchNum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int quantity = Integer.valueOf(request.getParameter("quantity").toString());
		
		
		String operationType = request.getParameter("operationType").toString();
		

		
		//Delete Service is getting called.
		if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
				//Approve Service is getting called.
				ApproveService approve = new ApproveService();
				approve.approveItem(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity, operationType);
				System.out.println("Entering into After Delete Page");
				response.sendRedirect("AfterDelete.jsp");
			}
		else {
			System.out.println("Won't enter in any page");
		}
	%>
	
</body>
</html>