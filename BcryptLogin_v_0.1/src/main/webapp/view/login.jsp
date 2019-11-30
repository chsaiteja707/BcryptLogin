<%@ include file = "header_unsecured.jsp" %>
<div class="ui raised very padded text container segment">
<h1>Login Page</h1>
<form:form action="/authenticateTheUser" modelAttribute="crmUser" class="ui form" method="POST">
	<c:if test="${param.error != null}">
		<div class="ui negative message">
		  
			  <div class="header">
	
			    Invalid Credentials
			  </div>
		  <p>Please enter valid credentials</p>
		 </div>
	</c:if>
	<div class="field">
			<label>Username</label>
			<form:input path="username" name="username"></form:input>
		</div>
		<div class="field">
			<label>Password</label>
			<form:input path="password" name="password"></form:input>
		</div>
		<input class="ui button" type="submit" value="Login">
</form:form>
</div>
<%@ include file = "footer.jsp" %>
