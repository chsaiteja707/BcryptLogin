<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- jstl and jsp tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bcrypt Login</title>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
</head>
<body>

	<div class="ui raised very padded text container segment">
	<div class="ui secondary pointing menu" style="border-top: 3px solid rgba(11,232,100,0.15); border-bottom: 3px solid rgba(255,2,2,0.15)">
	  <a class="item" href="/" style="color:#ffa500d9">
	    Home
	  </a>
	  <a class="item" href="/pages/getusers"  style="color:#ffa500d9">
	    Get Customers
	  </a>
	  <div class="right menu" >
	  <a class="item" class="ui inverted green button" href="/login/loginpage"  style="color:#ffa500d9">
	    Login
	  </a>
	  <a class="item" class="ui inverted green button" href="/register/signuppage"  style="color:#ffa500d9">
	    Signup
	  </a>
	  </div>
	</div>
	</div>


