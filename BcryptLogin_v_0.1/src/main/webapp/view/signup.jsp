<%@ include file = "header_unsecured.jsp" %>
<div class="ui raised very padded text container segment">
	<h1>Signup Page</h1>
	<form:form action="/register/postsignup" modelAttribute="crmUser" class="ui form" method="POST">
		<c:if test="${registrationError != null}">
			<div>
				${registrationError}
			</div>
		</c:if>
		
		
		<c:if test="${headermsg != null}">
			<div class="ui negative message">
			  <i class="close icon"></i>
				  <div class="header">
				    ${headermsg}
				  </div>
			  <p>${message}</p>
			 </div>
		</c:if>
		
		<div class="field">
			<label>Username</label>
			<form:input path="username"></form:input>
		</div>
		<div class="field">
			<label>Password</label>
			<form:input path="password"></form:input>
		</div>
		<input class="ui button" type="submit" value="Signup">
	</form:form>
</div>
<%@ include file = "footer.jsp" %>
