package data;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
  @Autowired
  private UserDAO userDAO;
  @Autowired
  private userloginDAO userloginDAO;
  public void addUserForLogin(String username,String password,String email) {
	  userloginDAO.addUser(username, password, email);
  }
  public List<users> getListUserLogin() {
	  return userloginDAO.getListUser();
  }
  public boolean checkUserExist(String username,String password) {
	  return userloginDAO.checkUserExist(username, password);
  }
  public boolean checkUsernameExist(String username) {
	  return userloginDAO.checkUsernameExist(username);
  }
  public void deleteUserLogin(String username) {
userloginDAO.deleteUser(username);
  }
public void createUser(String username,String password) {
	userDAO.createUser(username,password);
}
public void changeUserPassword(String username,String password) {
	userDAO.changeUserPassword(username, password);;
}
public void deleteUser(String username) {
	userDAO.deleteUser(username);
}
public List<UserTable> getListUser() {
	return userDAO.getListUser();
}
public List<UserSysPriv> getLisRoletUser(){
	return userDAO.getLisRoletUser();
}
public List<String> getListPrivUserByUsername(String username){
	return userDAO.getListPrivUserByUsername(username);
}
public List<String> getListRoletUserByUsername(String username){
	return userDAO.getListRoletUserByUsername(username);
}

public List<Role> getListRole(){
	return userDAO.getListRole();
}
public List<String> getListRoleExceptRole(String rolename){
	return userDAO.getListRoleExceptRole(rolename);
}
public void addNewPrivilege(String privilege,String username) {
	userDAO.addNewPrivilege(privilege, username);
}
public void addRoleToRole(String rolename,String rolenametobeadded) {
	userDAO.addRoleToRole(rolenametobeadded, rolename);
}
public void revokePrivilege(String privilege,String username) {
	userDAO.RevokePrivilege(privilege, username);
}
public void CreateRole(String rolename) {
	userDAO.CreateRole(rolename);
}
public void DropRole(String rolename) {
	userDAO.DropRole(rolename);
}
public List<RolePrivileged> getListRolePrivileged() {
	return userDAO.getListRolePrivileged();
}
public void AddprivilegeToRole(String privilege,String rolename) {
	userDAO.AddprivilegeToRole(privilege, rolename);
}
public List<UsersAndTheirRole> getListUserAndTheirRole(){
	return userDAO.getListUserAndTheirRole();
}
public void AddRoleToUser(String rolename,String username) {
userDAO.AddRoleToUser(username, rolename);
}
public List<String> listPrivilegeCanSet(){
	return userDAO.listPrivilegeCanSet();
}
public List<String> getListRoleFromSelectedRole(String rolename){
	return userDAO.getListRoleFromSelectedRole(rolename);
}
public void revokeRoleFromRole(String rolename,String rolenametoberevoked) {
	userDAO.revokeRoleFromRole(rolename, rolenametoberevoked);
}
public void setQuotaUser(String username,String quotaset) {
	userDAO.setQuotaUser(username, quotaset);
}
public List<String> getListRoletUserByRole(String rolename){
	return userDAO.getListRoletUserByRole(rolename);
}
public void revokeRoleFromUser(String rolename,String username) {
	userDAO.revokeRoleFromUser(username, rolename);
}
public void revokePrivFromRole(String rolename,String privilege) {
userDAO.revokePrivFromRole(rolename, privilege);
}
public List<RoleToRole> getListRoleToRole() {
	return userDAO.getListRoleToRole();
}
public List<quota> listQuota(){
	return userDAO.listQuota();
}
}