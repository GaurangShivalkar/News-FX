<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in page</title>
<style><%@include file="../css/style.css"%></style>
</head>


<body>

	<div class="login-box">
  		<h1>Register Form</h1>
  			<form method="post" action="register" class="register">
  				<div class="user-box">
	     			<input type="text" name="username" id="username"/>
	    			<label>User name</label>   				
	    		</div>
	    		
	    		<div class="user-box">	
	     			<input type="email" name="email" id="email"/>
	    			<label>Email</label>  				
	    		</div>
	    		<div class="user-box">
	     			<input type="password" name="password" id="password"/>
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
					Already have an account ? <a href="login.jsp" id="login-form">Login</a>
				</div>
  			</form>
 		</div>
 		
</body>
</html>