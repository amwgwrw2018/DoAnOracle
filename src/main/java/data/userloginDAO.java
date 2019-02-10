package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class userloginDAO {

	@Autowired
	  private JdbcTemplate jdbcTemplate;
	public void addUser(String username,String password,String email) {
		int value = jdbcTemplate.update("insert into USERTABLE values(?,?,?)",username,password,email);
	}
	public List<users> getListUser(){
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from USERTABLE");
List<users> list=new ArrayList<users>();
for (Map row : rows) {
	users u=new users();
	u.setUsername((String)row.get("USERNAME"));
	u.setPassword((String)row.get("PASSWORD"));
	u.setEmail((String)row.get("EMAIL"));
	list.add(u);
}
return list;
	}
	public boolean checkUserExist(String username,String password) {
		
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select USERNAME,PASSWORD from USERTABLE where USERNAME='"+username+"' AND PASSWORD='"+password+"'");
		  int count=0;
			for (Map row : rows) {
				count++;
				
				
			}
		if(count>0) {
			return true;
		}else {
			return false;
		}
	}
	public boolean checkUsernameExist(String username) {
		
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select USERNAME,PASSWORD from USERTABLE where USERNAME='"+username+"'");
		  int count=0;
			for (Map row : rows) {
				count++;
				
				
			}
		if(count>0) {
			return true;
		}else {
			return false;
		}
	}
	public void deleteUser(String username) {
		 int value = jdbcTemplate.update("delete from USERTABLE where USERNAME='"+username+"'"); 
	}
}
