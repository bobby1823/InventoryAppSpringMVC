<%@page import="java.util.List"%>
<%@page import="com.mindtree.service.DBManager"%>
<%@page import="com.mindtree.model.dao.impl.*"%>
<%@page import="com.mindtree.service.Item"%>
<%@page import="com.mindtree.beans.ProductTable" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage inventory</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css"  rel="stylesheet" type="text/css" />
</head>
<script>
	function showAlert(storeId, productId, deptId) {
		var txt;
		txt = confirm("Do you really want to delete")
		if (txt.toString() == "true") {
			window.location = "delete.jsp?storeId=" + storeId + "&productId="
					+ productId + "&deptId=" +deptId;
		}
	}

	function modifyItem(storeId, productId, deptId) {
		var request = new XMLHttpRequest();
		request.onreadystatechange = function() {
			var response = request.responseText;
			document.getElementById("editData").innerHTML = response;
			window.location = "#editData";
		}
		request.open("get", "modify.jsp?storeId=" + storeId + "&productId="
				+ productId + "&deptId=" +deptId, true);
		request.send(null);
	}
</script>
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
	
	<div id="menu">
		<ul>
			<li><a href="deptHome.jsp">Home</a>&nbsp;&nbsp;</li>
			<li><a href="addItem.jsp">Add</a>&nbsp;&nbsp;</li>
			<li><a href="approvalStatus.jsp">Approval Status</a>&nbsp;&nbsp;</li>
			<li><a href="logout.jsp">Logout</a>&nbsp;&nbsp;</li>
		</ul>
	</div>
	<br>
	<br>
	<div class="productsTable">
		<table style="border: 1px solid #000000;" border="1" align="center">
			<tr style="background-color: #315FA5;">
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">&nbsp;S.No.</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Product Id</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Store Id</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Dept Id</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Product Name</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Vendor</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">MRP</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Batch Number</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Batch Date</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Quantity</span></strong></td>
				<td colspan="2" style="text-align: center;"><strong><span
						style="color: #ffffff;">Modify/Delete</span></strong></td>
			</tr>

			<%
				ShowInventoryDaoImpl product = new ShowInventoryDaoImpl();
				List<ProductTable> items = product.showProductData();
				int i = 1;
				for (ProductTable item : items) {
			%>
			<tr style="background-color: #fefef5;">
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp; <%=i%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getProductId()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getStoreInfo().getStoreId()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getDeptInfo()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getProductName()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getVendor()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getMrp()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getBatchNum()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getBatchDate()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getQuantity()%></span></strong></td>
				<td style="text-align: center; background-color: #EEA43B;"><strong><span
						style="color: #000000;">&nbsp;<a
							href="javascript:modifyItem(<%=item.getStoreInfo().getStoreId()%>,<%=item.getProductId()%>,<%=item.getDeptInfo()%>);"><img
								src="${pageContext.request.contextPath}/resources/images/editIcon.png" title="Edit Product"></img></a></span></strong></td>
				<td style="text-align: center; background-color: #b90a2d;"><strong><span
						style="color: #000000;">&nbsp;<a
							href="javascript:showAlert(<%=item.getStoreInfo().getStoreId()%>,<%=item.getProductId()%>,<%=item.getDeptInfo()%>);"><img
								src="${pageContext.request.contextPath}/resources/images/deleteIcon.png" title="Delete Product"></img></a></span></strong></td>
			</tr>
			<%
				i++;
				}
			%>
		</table>
		<div id="editData"></div>
	</div>
	<script type="text/javascript">
	function validateForm() {
		// validation for null values
		var productName = document.forms["editForm"]["productName"].value;
		var vendor = document.forms["editForm"]["vendor"].value;
		var mrp = document.forms["editForm"]["mrp"].value;
		var batchNumber = document.forms["editForm"]["batchNumber"].value;
		var batchDate = document.forms["editForm"]["batchDate"].value;
		var quantity = document.forms["editForm"]["quantity"].value;
		var errorMessage="";
		if(productName==""){
			errorMessage=errorMessage+"Product Name must be filled\n";
		}
		if(vendor==""){
			errorMessage=errorMessage+"Vendor Name must be filled\n";
		}
		if(mrp==""){
			errorMessage=errorMessage+"MRP must be filled\n";
		}
		if(batchNumber==""){
			errorMessage=errorMessage+"Batch Number must be filled\n";
		}
		if(batchDate==""){
			errorMessage=errorMessage+"Batch Date must be filled\n";
		}
		if(quantity==""){
			errorMessage=errorMessage+"Quantity must be filled\n";
		}
		if(errorMessage!=""){
			alert(errorMessage);
			return false;
		}
		var namePattern = /^[a-zA-Z]+(\s[a-zA-Z]+)*$/;
		if(!namePattern.test(productName)){
			alert("Product name should contain only alphabets. Accepted space between words.");
			return false;
		}
		if(!namePattern.test(vendor)){
			alert("Vendor name should contain only alphabets or spaces. Accepted space between words.");
			return false;
		}
		var costPattern = /^\d+(\.\d{1,2}){0,1}$/;
		if(!costPattern.test(mrp)){
			alert("Please provide valid cost for the product. Accepted 2 digits after decimal.");
			return false;
		}
	}
</script>
</body>
</html>