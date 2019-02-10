package data;

public class Role {
String role;
String passwordRequired;
String authenticationType;
public Role(String role, String passwordRequired, String authenticationType) {
	
	this.role = role;
	this.passwordRequired = passwordRequired;
	this.authenticationType = authenticationType;
}
public Role() {
	// TODO Auto-generated constructor stub
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPasswordRequired() {
	return passwordRequired;
}
public void setPasswordRequired(String passwordRequired) {
	this.passwordRequired = passwordRequired;
}
public String getAuthenticationType() {
	return authenticationType;
}
public void setAuthenticationType(String authenticationType) {
	this.authenticationType = authenticationType;
}

}
