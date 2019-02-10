package data;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class newspaper {
	BigDecimal  id;
String title;
String mainimage;
String content;
String author;
String newspaperType;
Timestamp releaseDate;
public newspaper() {
	// TODO Auto-generated constructor stub
}

public Timestamp getReleaseDate() {
	return releaseDate;
}

public void setReleaseDate(Timestamp releaseDate) {
	this.releaseDate = releaseDate;
}

public BigDecimal  getId() {
	return id;
}
public void setId(BigDecimal  id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getMainimage() {
	return mainimage;
}
public void setMainimage(String mainimage) {
	this.mainimage = mainimage;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getNewspaperType() {
	return newspaperType;
}
public void setNewspaperType(String newspaperType) {
	this.newspaperType = newspaperType;
}

}
