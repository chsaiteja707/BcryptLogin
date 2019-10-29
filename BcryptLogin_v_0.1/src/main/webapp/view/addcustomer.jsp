<%@ include file = "header_secured.jsp" %>
<div class="ui raised very padded text container segment">
	<h1>Add User</h1>
	<form:form action="/pages/postadd" modelAttribute="customer" class="ui form" method="POST">
		<form:hidden path="id"/>
		
		<div class="field">
			<label>Firstname</label>
			<form:input path="fname"></form:input>
		</div>
		<div class="field">
			<label>Lastname</label>
			<form:input path="lname"></form:input>
		</div>
		<div class="field">
			<label>Email</label>
			<form:input path="email"></form:input>
		</div>
		<input class="ui button" type="submit" value="Add to List">
	</form:form>
</div>
<%@ include file = "footer.jsp" %>
