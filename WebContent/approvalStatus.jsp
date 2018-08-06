<%@page import="java.util.ArrayList"%>
<%@page import="com.mindtree.service.DBManager"%>
<%@page import="com.mindtree.service.Item"%>
<%@page import="com.mindtree.model.dao.*"%>
<%@page import="com.mindtree.model.dao.impl.*"%>
<%@page import="com.mindtree.beans.InventoryUpdateTable" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Your Approval Status</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />

<script>
			 
	function approve(storeId, productId, deptId, operationType, productName, vendor, mrp, batchNum, batchDate, quantity, status) {
		var txt;
		txt = confirm("Do you really want to Approve")
		if (txt.toString() == "true") {
			window.location = "approve.jsp?storeId=" + storeId + "&productId="
					+ productId + "&deptId=" +deptId+ "&operationType=" + operationType + "&productName=" +productName+ "&vendor="+vendor+ "&mrp="+mrp+
					"&batchNumber="+batchNum+ "&batchDate="+batchDate+ "&quantity="+quantity+ "&status="+status;
		}
	}

	function deny(storeId, productId, deptId, operationType, productName, vendor, mrp, batchNum, batchDate, quantity, status) {
		var txt;
		txt = confirm("Do you really want to Deny the item request")
		if (txt.toString() == "true") {
			window.location = "deny.jsp?storeId=" + storeId + "&productId="
					+ productId + "&deptId=" +deptId+ "&operationType=" + operationType + "&productName=" +productName+ "&vendor="+vendor+ "&mrp="+mrp+
					"&batchNum="+batchNum+ "&batchDate="+batchDate+ "&quantity="+quantity+ "&status="+status;
		}
	}
</script>
</head>
<body style="background-color: lightblue;">
	<div id="menu">
		<ul>
			<li><a href="deptHome.jsp">Home</a>&nbsp;&nbsp;</li>
			<li><a href="addItem.jsp">Add</a>&nbsp;&nbsp;</li>
			<li><a href="approvalStatus.jsp">Approval Status</a>&nbsp;&nbsp;</li>
			<li><a href="logout.jsp">Logout</a>&nbsp;&nbsp;</li>
		</ul>
	</div>
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
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Request Type</span></strong></td>
				<td style="text-align: center;"><strong><span
						style="color: #ffffff;">Status</span></strong></td>
				<%
					String userName = session.getAttribute("username").toString();
					if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
				 %>
				<td colspan="2" style="text-align: center;"><strong><span
						style="color: #ffffff;">Approve/Deny</span></strong></td>
				<%
					}
				 %>
			</tr>

			<%
				ShowInventoryDao showInventory = new ShowInventoryDaoImpl();
				ArrayList<InventoryUpdateTable> items = showInventory.showInventoryData();
				int i = 1;
				if(items != null) {
					for (InventoryUpdateTable item : items) {
			%>
			<tr style="background-color: #fefef5;">
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp; <%=i%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getProductId()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getStoreInfo().getStoreId()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getDeptInfo() %></span></strong></td>
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
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getOperationType()%></span></strong></td>
				<td style="text-align: center; background-color: #EFEFEE;"><strong><span
						style="color: #000000;">&nbsp;<%=item.getStatus()%></span></strong></td>
				<%					
					if(CheckUserType.checkUserType(userName).equalsIgnoreCase("Store Manager")) {
				%>
				<td style="text-align: center; background-color: #4CAF50;"><strong><span
						style="color: #000000;">&nbsp;<a href="javascript:approve(<%=item.getStoreInfo().getStoreId()%>,<%=item.getProductId()%>,<%=item.getDeptInfo()%>,<%="'"+item.getOperationType()+"'"%>,<%="'"+item.getProductName()+"'"%>,<%="'"+item.getVendor()+"'"%>,<%=item.getMrp()%>,<%="'"+item.getBatchNum()+"'"%>,<%="'"+item.getBatchDate()+"'"%>,<%=item.getQuantity()%>,<%="'"+item.getStatus()+"'"%>);"><img
								src="${pageContext.request.contextPath}/resources/images/approveIcon.png" title="Approve"></a></span></strong></td>
				<td style="text-align: center; background-color: #b90a2d;"><strong><span
						style="color: #000000;">&nbsp;<a href="javascript:deny(<%=item.getStoreInfo().getStoreId()%>,<%=item.getProductId()%>,<%=item.getDeptInfo()%>,<%="'"+item.getOperationType()+"'"%>,<%="'"+item.getProductName()+"'"%>,<%="'"+item.getVendor()+"'"%>,<%=item.getMrp()%>,<%="'"+item.getBatchNum()+"'"%>,<%="'"+item.getBatchDate()+"'"%>,<%=item.getQuantity()%>,<%="'"+item.getStatus()+"'"%>);"><img
								src="${pageContext.request.contextPath}/resources/images/denyIcon.png" title="Deny"></a></span></strong></td>
				<%
					}
				%>
			</tr>
			<%
				i++;
				}
			}
			%>
		</table>
	</div>
</body>
</html>