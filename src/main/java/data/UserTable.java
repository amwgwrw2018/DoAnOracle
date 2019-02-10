package data;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class UserTable {
String username;
BigDecimal user_id;
Timestamp created;

public UserTable(String username, BigDecimal user_id, Timestamp created) {

	this.username = username;
	this.user_id = user_id;
	this.created = created;
}

public UserTable() {
	// TODO Auto-generated constructor stub
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public BigDecimal getUser_id() {
	return user_id;
}

public void setUser_id(BigDecimal user_id) {
	this.user_id = user_id;
}

public Timestamp getCreated() {
	return created;
}

public void setCreated(Timestamp created) {
	this.created = created;
}


}
