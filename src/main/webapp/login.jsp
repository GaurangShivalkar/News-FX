<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login page</title>

<style><%@include file="../css/style.css"%></style>
</head>
<body>

<div class="login-box">
  <h2>Login</h2>
	<form  method="post" action="login" class="login">
		<!--<div class="signin">  -->
			<div class="user-box">
				<input type="email" id="email" name="email" required />
				<label>Email</label>
			</div>
			
			<div class="user-box">
				<input type="password" id="password" name="password"  required />
				 <label>Password</label>
			</div>
			
			<p>
				<span></span>
				<span></span>
				<span></span>
				<span></span>
				<input type="submit" value="Submit" />
			</p>
			
			<div class="account-exist">
				Create a new account? <a href="sign.jsp" id="register-form">Register</a>
			</div>
		<!-- </div> -->
	</form>

    
 
</div>
	
</body>
</html>