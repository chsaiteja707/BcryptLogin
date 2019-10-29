<%@ include file = "header_unsecured.jsp" %>
<div class="ui raised very padded text container segment">
<h1>Login Page</h1>
<form:form action="/authenticateTheUser" class="ui form" method="POST">
	<c:if test="${param.error != null}">
		<div class="ui negative message">
		  <i class="close icon"></i>
			  <div class="header">
	
			    Invalid Credentials
			  </div>
		  <p>Please enter valid credentials</p>
		 </div>
	</c:if>
	<div class="field">
	<label>Username</label>
		<input type="text" name="username" />
	</div>
	<div class="field">
	<label>Password</label>
		<input type="password" name="password" />
	</div>
	<input class="ui button" type="submit" value="Login" />
</form:form>
</div>
<%@ include file = "footer.jsp" %>
