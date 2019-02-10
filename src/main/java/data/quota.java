package data;

import java.math.BigDecimal;

public class quota {
String tablespaceName;
String username;
BigDecimal bytes;
BigDecimal maxBytes;
BigDecimal blocks;
BigDecimal maxBlocks;
String dropped;
public quota() {
	// TODO Auto-generated constructor stub
}
public String getTablespaceName() {
	return tablespaceName;
}
public void setTablespaceName(String tablespaceName) {
	this.tablespaceName = tablespaceName;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public BigDecimal getBytes() {
	return bytes;
}
public void setBytes(BigDecimal bytes) {
	this.bytes = bytes;
}
public BigDecimal getMaxBytes() {
	return maxBytes;
}
public void setMaxBytes(BigDecimal maxBytes) {
	this.maxBytes = maxBytes;
}
public BigDecimal getBlocks() {
	return blocks;
}
public void setBlocks(BigDecimal blocks) {
	this.blocks = blocks;
}
public BigDecimal getMaxBlocks() {
	return maxBlocks;
}
public void setMaxBlocks(BigDecimal maxBlocks) {
	this.maxBlocks = maxBlocks;
}
public String getDropped() {
	return dropped;
}
public void setDropped(String dropped) {
	this.dropped = dropped;
}

}
