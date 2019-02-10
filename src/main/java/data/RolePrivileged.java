package data;

public class RolePrivileged {
String role;
String privilege;
String adminOption;
public RolePrivileged(String role, String privilege, String adminOption) {
	
	this.role = role;
	this.privilege = privilege;
	this.adminOption = adminOption;
}
public RolePrivileged() {
	// TODO Auto-generated constructor stub
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPrivilege() {
	return privilege;
}
public void setPrivilege(String privilege) {
	this.privilege = privilege;
}
public String getAdminOption() {
	return adminOption;
}
public void setAdminOption(String adminOption) {
	this.adminOption = adminOption;
}

}
