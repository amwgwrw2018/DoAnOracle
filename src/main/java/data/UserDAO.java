package data;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAO {
	
	@Autowired
	  private JdbcTemplate jdbcTemplate;
	   
	  public void createUser(String username,String password) {
	   
	 
	        int value = jdbcTemplate.update("call CREATE_USER_DOAN(?,?)",username,password);
		
	    }
	  public void changeUserPassword(String username,String password) {
		  int value = jdbcTemplate.update("call CHANGE_USER_DOAN(?,?)",username,password);
	  }
 public void deleteUser(String username) {
	 int value = jdbcTemplate.update("call DROP_USER_DOAN(?)",username);
	  }
 public void addNewPrivilege(String privilege,String username) {
	 int value = jdbcTemplate.update("call add_user_privilege_doan(?,?)",privilege,username); 
 }
 public void RevokePrivilege(String privilege,String username) {
	 int value = jdbcTemplate.update("call revoke_user_privilege_doan(?,?)",privilege,username); 
 }
 public void CreateRole(String rolename) {
	 int value = jdbcTemplate.update("call create_role_doan(?)",rolename); 
	 
 }
 public void DropRole(String rolename) {
	 int value = jdbcTemplate.update("call drop_role_doan(?)",rolename); 
	 
 }
 public void AddprivilegeToRole(String privilege,String rolename) {
	 int value = jdbcTemplate.update("call add_privilege_to_role_doan(?,?)",rolename,privilege); 
 }
 public void AddRoleToUser(String username,String rolename) {
	 int value = jdbcTemplate.update("call add_role_to_user_doan(?,?)",rolename,username); 
 }
 public void addRoleToRole(String rolenametobeadded,String rolename) {
	 System.out.println("da nhan dc"+rolename+" and "+rolenametobeadded);
	 int value = jdbcTemplate.update("call add_role_to_role_doan(?,?)",rolename,rolenametobeadded); 
	 
 }
 public void revokeRoleFromUser(String username,String rolename) {
	 int value = jdbcTemplate.update("call revoke_role_from_user_doan(?,?)",rolename,username); 
 }
 public void revokePrivFromRole(String rolename,String privilege) {
	 int value = jdbcTemplate.update("call revoke_privilege_role_doan(?,?)",rolename,privilege); 
	 
 }
 public void revokeRoleFromRole(String rolename,String rolenametoberevoked) {
	 int value = jdbcTemplate.update("call revoke_role_from_role_doan(?,?)",rolename,rolenametoberevoked); 
	 
 }
 public void setQuotaUser(String username,String quotaset) {
	 int value = jdbcTemplate.update("call SET_QUOTA_USER(?,?)",username,quotaset); 
	 
 }
 public List<quota> listQuota(){
	  List<quota> quotalist = new ArrayList<quota>();
	  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from DBA_TS_QUOTAS");
		for (Map row : rows) {
		quota q=new quota();
		q.setTablespaceName((String)row.get("TABLESPACE_NAME"));
		q.setUsername((String)row.get("USERNAME"));
		q.setBytes((BigDecimal)row.get("BYTES"));
		q.setMaxBytes((BigDecimal)row.get("MAX_BYTES"));
q.setBlocks((BigDecimal)row.get("BLOCKS"));
q.setMaxBlocks((BigDecimal)row.get("MAX_BLOCKS"));
q.setDropped((String)row.get("DROPPED"));
quotalist.add(q);
		}
	return quotalist; 
 }
 
	  public List<UserTable> getListUser() {
		  List<UserTable> userlist = new ArrayList<UserTable>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select USERNAME,USER_ID,CREATED from all_users");
			for (Map row : rows) {
				UserTable user = new UserTable();
				user.setCreated((Timestamp)row.get("CREATED"));
				user.setUser_id((BigDecimal)row.get("USER_ID"));
				user.setUsername((String)row.get("USERNAME"));
				userlist.add(user);
			}
		return userlist;
	  }
	  public List<UserSysPriv> getLisRoletUser() {
		  List<UserSysPriv> userlist = new ArrayList<UserSysPriv>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select GRANTEE,PRIVILEGE,ADMIN_OPTION from DBA_SYS_PRIVS");
			for (Map row : rows) {
				UserSysPriv user = new UserSysPriv();
				user.setPrivilege((String)row.get("PRIVILEGE"));
				user.setAdminOption((String)row.get("ADMIN_OPTION"));
				user.setUsername((String)row.get("GRANTEE"));
				userlist.add(user);
			}
		return userlist;
	  }
	  
	  public List<String> getListPrivUserByUsername(String username) {
		  System.out.println("nhan dc "+username);
		  List<String> privlist = new ArrayList<String>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select PRIVILEGE from DBA_SYS_PRIVS where GRANTEE='" +username+"'");
		  
			for (Map row : rows) {
				
				
				privlist.add((String)row.get("PRIVILEGE"));
			}
		return privlist;
	  }
	  
	  public List<Role> getListRole(){
		  List<Role> rolelist = new ArrayList<Role>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT ROLE,PASSWORD_REQUIRED,AUTHENTICATION_TYPE FROM DBA_ROLES");
			for (Map row : rows) {
				Role role = new Role();
				role.setRole((String)row.get("ROLE"));
				role.setPasswordRequired((String)row.get("PASSWORD_REQUIRED"));
				role.setAuthenticationType((String)row.get("AUTHENTICATION_TYPE"));
				rolelist.add(role);
			}
			return rolelist;
	  }
	  public List<String> getListRoleExceptRole(String rolename){
		  List<String> rolelist = new ArrayList<String>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select ROLE from DBA_ROLES where ROLE <> '"+rolename+"'");
			for (Map row : rows) {
			
				rolelist.add((String)row.get("ROLE"));
				
			}
			return rolelist;
	  }
	  public List<RolePrivileged> getListRolePrivileged(){
		  List<RolePrivileged> rolelist = new ArrayList<RolePrivileged>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM ROLE_SYS_PRIVS");
			for (Map row : rows) {
				RolePrivileged role = new RolePrivileged();
				role.setRole((String)row.get("ROLE"));
				role.setPrivilege((String)row.get("PRIVILEGE"));
				role.setAdminOption((String)row.get("ADMIN_OPTION"));
				rolelist.add(role);
			}
			return rolelist;
	  }
	  public List<UsersAndTheirRole> getListUserAndTheirRole(){
		  List<UsersAndTheirRole> rolelist = new ArrayList<UsersAndTheirRole>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList(" select * from DBA_ROLE_PRIVS");
			for (Map row : rows) {
				UsersAndTheirRole role = new UsersAndTheirRole();
				role.setGrantee((String)row.get("GRANTEE"));
				role.setGrantedRole((String)row.get("GRANTED_ROLE"));
				role.setAdminOption((String)row.get("ADMIN_OPTION"));
				role.setDefaultRole((String)row.get("DEFAULT_ROLE"));
				rolelist.add(role);
			}
			return rolelist;
		 
	  }
	  public List<RoleToRole> getListRoleToRole(){
		  List<RoleToRole> rolelist = new ArrayList<RoleToRole>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from role_role_privs");
			for (Map row : rows) {
				RoleToRole role = new RoleToRole();
				role.setRole((String)row.get("ROLE"));
				role.setGrantedRole((String)row.get("GRANTED_ROLE"));
				role.setAdminOption((String)row.get("ADMIN_OPTION"));
				
				rolelist.add(role);
			}
			return rolelist;
		 
	  }
	  public List<String> listPrivilegeCanSet(){
		  List<String> list=new ArrayList<String>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from SESSION_PRIVS");
		  for (Map row : rows) {
			  list.add((String)row.get("PRIVILEGE"));
		  }
		  return list;
	  }
	  public List<String> getListRoletUserByUsername(String username) {
		  System.out.println("nhan dc "+username);
		  List<String> rolelist = new ArrayList<String>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select GRANTED_ROLE from DBA_ROLE_PRIVS where Grantee='"+username+"'");
		  
			for (Map row : rows) {
				
				
				rolelist.add((String)row.get("GRANTED_ROLE"));
			}
		return rolelist;
	  }
	  
	  public List<String> getListRoletUserByRole(String rolename) {
		  System.out.println("nhan dc "+rolename);
		  List<String> privlist = new ArrayList<String>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT PRIVILEGE FROM ROLE_SYS_PRIVS Where ROLE='"+rolename+"'");
		  
			for (Map row : rows) {
				
				
				privlist.add((String)row.get("PRIVILEGE"));
			}
		return privlist;
	  }
	  public List<String> getListRoleFromSelectedRole(String rolename) {
		  System.out.println("nhan dc "+rolename);
		  List<String> rolelist = new ArrayList<String>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select GRANTED_ROLE from role_role_privs where ROLE='"+rolename+ "'");
		  
			for (Map row : rows) {
				
				
				rolelist.add((String)row.get("GRANTED_ROLE"));
			}
		return rolelist;
	  }
	  
}
