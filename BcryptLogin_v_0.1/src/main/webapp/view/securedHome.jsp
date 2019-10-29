<%@ include file = "header_secured.jsp" %>
<div class="ui raised very padded text container segment">
<h1>This is secured Home page</h1>
<p>Only visible after logged in</p>
<c:if test="${filetype != null}">
		<div class="ui positive message">
		  <i class="close icon"></i>
			  <div class="header">
			    file is accepted
			  </div>
		  <p>File is of ${filetype} type</p>
		 </div>
</c:if>
<div>

  <label for="files" class="btn">Select Image</label>
  <input id="files" style="visibility:hidden;" type="file">
</div>

<form:form action="/pages/upload" method="POST" enctype="multipart/form-data">
	<input type="file" name="file" class="ui inverted yellow button"/>
	<input type = "submit" value = "Upload File" class="ui inverted green button"/><br>
</form:form>
</div>
<%@ include file = "footer.jsp" %>