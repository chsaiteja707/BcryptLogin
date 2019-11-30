package com.project.PlaneLogin.user;


public class CrmUser {
	private String username;
	private String password;
	
	public CrmUser() {
		
	}

	public CrmUser(String username,String password) {
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/* if validation to be performed by spring remove the existing attributes and include the below

	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String username;
	
	
	

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String password;
	
	public CrmUser() {
		
	}

	public CrmUser(@NotNull(message = "is required") @Size(min = 1, message = "is required") String username,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String password) {
		super();
		this.username = username;
		this.password = password;
	}
	*/

	
}
