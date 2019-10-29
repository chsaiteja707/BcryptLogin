<%@ include file = "header_secured.jsp" %>
<div class="ui raised very padded text container segment">
	<table class="ui celled padded table">
			<thead class="heading">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Delete</th>
					<th>Update</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="temp" items="${customers}">
				
					<!-- construct an delete link with customer id -->
					<c:url var="deleteLink" value="/pages/delete">
						<c:param name="customerId" value="${temp.id}"/>
					</c:url>
					
					<!-- construct an update link with customer id -->
					<c:url var="updateLink" value="/pages/update">
						<c:param name="customerId" value="${temp.id}"/>
					</c:url>
				<tr>
					<td>${temp.fname}</td>
					<td>${temp.lname}</td>
					<td>${temp.email}</td>
					<td><a href="${deleteLink}"><i class="trash alternate outline icon"></i></a></td>
					<td><a href="${updateLink}"><i class="edit icon"></i></a></td>
				</tr>
				</c:forEach>
			</tbody>
			
	</table>
</div>
	
<%@ include file = "footer.jsp" %>+