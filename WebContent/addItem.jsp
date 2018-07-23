<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Item</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="menu">
<ul>
<li><a href="deptHome.jsp">Home</a>&nbsp;&nbsp;</li>
<li><a href="addItem.jsp">Add</a>&nbsp;&nbsp;</li>
<li><a href="approvalStatus.jsp">Approval Status</a>&nbsp;&nbsp;</li>
<li><a href="logout.jsp">Logout</a>&nbsp;&nbsp;</li>
</ul>
</div>

<form action="AddProduct" method="post">
	<br>
	<br>
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
					style="color: #000000;">&nbsp;<input type="number" min="0" name="productId"></span></strong></td>
			<td style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="number" min="0" name = "storeId"></span></strong></td>
			<td style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="number" min="0" name = "deptId"></span></strong></td>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Product Name</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="text" name = "productName"></span></strong></td>
		<tr>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Vendor</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="text" name = "vendor"></span></strong></td>
		</tr>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">MRP</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="text" name = "mrp"></span></strong></td>
		</tr>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Batch Number</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="number" min="0" name = "batchNumber"></span></strong></td>
		</tr>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Batch Date</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="date" name = "batchDate"></span></strong></td>
		</tr>
		<tr style="background-color: #315FA5;">
			<td style="text-align: center;"><strong><span
					style="color: #ffffff;">Quantity</span></strong></td>
			<td colspan="2"
				style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="number" min="0" name = "quantity"></span></strong></td>
		</tr>
		<tr style="background-color: #315FA5;">
			<td colspan="3"
				style="text-align: center; background-color: #315FA5;"><strong><span
					style="color: #000000;">&nbsp;<input type="submit"
						value="Add Item"></span></strong></td>
		</tr>
	</table>
	</form>
</body>
</html>