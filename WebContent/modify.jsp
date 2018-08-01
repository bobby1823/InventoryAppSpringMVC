<%@page import="java.util.ArrayList"%>
<%@page import="com.mindtree.service.DBManager"%>
<%@page import="com.mindtree.service.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<form action="Modify" method="post">
	<br>
	<br>
	<%
		Item item = DBManager.getItem(Integer.parseInt(request.getParameter("storeId")),
				Integer.parseInt(request.getParameter("productId")));
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("productId", request.getParameter("productId"));
				httpSession.setAttribute("storeId", request.getParameter("storeId"));
				httpSession.setAttribute("deptId", request.getParameter("storeId"));
	%>
	<table style="border: 1px solid #000000;" border="1" align="center">
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Product Id</span></strong></td>
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Store Id</span></strong></td>
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Dept Id</span></strong></td>
		</tr>
		<tr style="background-color: #fefef5;">
			<td style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<%=item.getProductId()%></span></strong></td>
			<td style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<%=item.getStoreId()%></span></strong></td>
			<td style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<%=item.getDeptId()%></span></strong></td>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Product Name</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="text" name="productName"
						value="<%=item.getProductName()%>"></span></strong></td>
		<tr>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Vendor</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="text" name="vendor"
						value="<%=item.getVendor()%>"></span></strong></td>
		</tr>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">MRP</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="text" name="mrp"
						value="<%=item.getMrp()%>"></span></strong></td>
		</tr>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Batch Number</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="text" name="batchNumber"
						value="<%=item.getBatchNum()%>"></span></strong></td>
		</tr>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Batch Date</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="date" name="batchDate"
						value="<%=item.getBatchDate()%>"></span></strong></td>
		</tr>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Quantity</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="number" min="0" name="quantity"
						value="<%=item.getQuantity()%>"></span></strong></td>
		</tr>
		<tr style="background-color: #315FA5;">
			<td colspan="3"
				style="text-align: center; background-color: #315FA5;"><strong><span
					style="color: #EFEFEE;">&nbsp;<input type="submit"
						value="Update Data"></span></strong></td>
		</tr>
	</table>
	</form>
</body>
</html>