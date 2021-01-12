package web.models;


public class UserModel {
	
	private Long id;
	private String email = "";
	private String firstName = "";
	private String lastName = "";
	private String phone = "";
	private String role = "";
	private Boolean active = false;
	
	private Boolean error = false;
	private String errorMsg = "";
	
	public UserModel() {
		
	}
	
	public UserModel(Long id, String email, String firstName, String lastName, String phone, String role,
			Boolean active) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.role = role;
		this.active = active;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
