package in.co.rays.bean;

import java.util.Date;

public class UserBean {
	
	private int id=0;
	private String firstName = null;
	private String lastName = null;
	private String login_id = null;
	private String password = null;
	private Date dob = null;
	private String address = null;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getLogin_id() {
		return login_id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDob() {
		return dob;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}


}
