<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Item</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function validateForm() {
		// validation for null values
		var productId = document.forms["addProductForm"]["productId"].value;
		var storeId = document.forms["addProductForm"]["storeInfo.storeId"].value;
		var deptId = document.forms["addProductForm"]["deptInfo"].value;
		var productName = document.forms["addProductForm"]["productName"].value;
		var vendor = document.forms["addProductForm"]["vendor"].value;
		var mrp = document.forms["addProductForm"]["mrp"].value;
		var batchNumber = document.forms["addProductForm"]["batchNum"].value;
		var batchDate = document.forms["addProductForm"]["batchDate"].value;
		var quantity = document.forms["addProductForm"]["quantity"].value;
		var errorMessage="";
		if(productId==""){
			errorMessage=errorMessage+"Product Id must be filled\n";
		}
		if(storeId==""){
			errorMessage=errorMessage+"Store Id must be filled\n";
		}
		if(deptId==""){
			errorMessage=errorMessage+"Dept Id must be filled\n";
		}
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
<!--  -->
<form action="addProduct" method="post" modelAttribute="product" name="addProductForm" onsubmit="return validateForm()">
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
					style="color: #000000;">&nbsp;<input type="number" min="0" name = "storeInfo.storeId"></span></strong></td>
			<td style="text-align: center; background-color: #EFEFEE;"><strong><span
					style="color: #000000;">&nbsp;<input type="number" min="0" name = "deptInfo"></span></strong></td>
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
					style="color: #000000;">&nbsp;<input type="number" min="0" name = "batchNum"></span></strong></td>
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