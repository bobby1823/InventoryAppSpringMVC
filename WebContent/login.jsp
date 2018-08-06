<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login Page</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css" 
													rel="stylesheet" type="text/css" />

<script type="text/javascript" language="javascript">
		var flag = 0;
		function validateUserName() {
			user = document.getElementsByClassName("form-login")[1].value;
			//alert("User name" +user);
			if (user == "") {
				alert("Inside If condition UserName");
				flag = 1;
				document.getElementById("userName_Error").innerHTML = "Please fill Username";
			}
		}
		
		function validateEmail() {
			user = document.getElementsByClassName("form-login")[0].value;
			//alert("User name" +user);
			if (user == "") {
				alert("Inside If condition Email");
				flag = 1;
				document.getElementById("email_Error").innerHTML = "Please fill Email Address";
			}
			else if(!user.contains("@") && !user.contains(".com")) {
				document.getElementById("email_Error").innerHTML = "Enter a proper Email Address";
			}
		}
		
		function validatePassword() {
			password = document.getElementsByClassName("form-login")[2].value;
			if (password=="") {
				flag = 1;
				document.getElementById("password_Error").innerHTML = "Please fill Password";
			}
		}

		function validateCredentialFields() {
			//flag = 1;
			validateEmail();
			validatePassword();
			validateUserName();
			if(flag === 1) {
				//alert("false");
				return false;
			} else {
				//alert("true");
				return true;
			}
		}
		
	</script>
</head>
<body style="background-color: lightblue;">

	<form action="Login" name = "loginCredentialsForm" modelAttribute="loginDetails" method='post' onsubmit="return validateCredentialFields();">
		<div style="padding: 100px 0 0 250px;">
			<div id="login-box">
				<h2>Login Page</h2>
				Please provide your credential to use this website <br> <br>
				
				<div id="login-box-name" style="margin-top: 20px;">User Id:</div>
				<div id="login-box-field" style="margin-top: 20px;">
					<input name="username" class="form-login" title="Username" value=""
						size="20" maxlength="50" />
						<div id="userName_Error" style="color: red;"></div>
				</div>
				
				<div id="login-box-name">Password:</div>
				<div id="login-box-field">
					<input name="password" type="password" class="form-login"
						title="Password" value="" size="30" maxlength="48" />
						<div id="password_Error" style="color: red;"></div>
						
						<button type="button" id="eye" style="">
							<img
								src="https://cdn0.iconfinder.com/data/icons/feather/96/eye-16.png"
								alt="eye" />
						</button>
				</div>
				
				<div id="login-box-name" style="margin-top: 20px;">Email Id:</div>
				<div id="login-box-field" style="margin-top: 20px;">
					<input name="email" class="form-login" title="Email Id" value=""
						size="20" maxlength="50" />
						<div id="email_Error" style="color: red;"></div>
				</div>
				
				<br /> <span class="login-box-options"> New User? <a
					href="register.jsp" style="margin-left: 30px;">Register Here</a>
				</span> <br /> <br /> <input style="margin-left: 100px;" type="submit"
					value="Login" />
			</div>
		</div>
	</form>
	
	<script type="text/javascript">
		document.getElementById("eye").addEventListener("click", function() {
	        var pwd = document.getElementsByClassName("form-login")[1];
	        if(pwd.getAttribute("type")=="password"){
	            pwd.setAttribute("type","text");
	        } else {
	            pwd.setAttribute("type","password");
	        }
	    });
	</script>
</body>
</html>