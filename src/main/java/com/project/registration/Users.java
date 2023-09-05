package com.project.registration;

public class Users {
    private String uname;
    private String email;
   
    
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public Users() {
		super();
		
	}
	public Users(String uname, String email) {
		super();
		this.uname = uname;
		this.email = email;
		
	}
}
