package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class newspaperDAO {

	@Autowired
	  private JdbcTemplate jdbcTemplate;
	public void deleteNewspaper(String nspID) {
		 int value = jdbcTemplate.update("Delete from NEWSPAPER where NEWSPAPER.id="+nspID);
	}
	 public List<newspaper> getListNewSpaper() {
		  List<newspaper> newspaperList = new ArrayList<newspaper>();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select NEWSPAPER.id,NEWSPAPER.RELEASEDATE,NEWSPAPER.title,NEWSPAPER.mainimage,NEWSPAPER.content,NEWSPAPER.author,NEWSPAPERTYPE.newspapertype from newspaper inner join NEWSPAPERTYPE on newspaper.newspapertype=NEWSPAPERTYPE.id");
			for (Map row : rows) {
				newspaper newspaper = new newspaper();
			newspaper.setId((BigDecimal )row.get("ID"));
			newspaper.setTitle((String)row.get("TITLE"));
			newspaper.setMainimage((String)row.get("MAINIMAGE"));
			newspaper.setContent((String)row.get("CONTENT"));
			newspaper.setAuthor((String)row.get("AUTHOR"));
			newspaper.setNewspaperType((String)row.get("NEWSPAPERTYPE"));
			newspaper.setReleaseDate((Timestamp)row.get("RELEASEDATE"));
			newspaperList.add(newspaper);
			}
		return newspaperList;
	 }
			 public List<newspaper> getNewestNewspaperList(int numberOfNewspaper) {
				  List<newspaper> newspaperList = new ArrayList<newspaper>();
				  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from (select NEWSPAPER.id,NEWSPAPER.RELEASEDATE,NEWSPAPER.title,NEWSPAPER.mainimage,NEWSPAPER.content,NEWSPAPER.author,NEWSPAPERTYPE.newspapertype from newspaper inner join NEWSPAPERTYPE on newspaper.newspapertype=NEWSPAPERTYPE.id order by  NEWSPAPER.releasedate desc) where rownum<="+numberOfNewspaper);
		
				  List<newspaper> list=new ArrayList<newspaper>();
				  for (Map row : rows) {
					  newspaper newspaper = new newspaper();
					newspaper.setId((BigDecimal )row.get("ID"));
					newspaper.setTitle((String)row.get("TITLE"));
					newspaper.setMainimage((String)row.get("MAINIMAGE"));
					newspaper.setContent((String)row.get("CONTENT"));
					newspaper.setAuthor((String)row.get("AUTHOR"));
					newspaper.setNewspaperType((String)row.get("NEWSPAPERTYPE"));
					newspaper.setReleaseDate((Timestamp)row.get("RELEASEDATE"));
					list.add(newspaper);
					}
				return list;
			 }
			 public newspaper getNewestNewspaper() {
				  List<newspaper> newspaperList = new ArrayList<newspaper>();
				  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from (select NEWSPAPER.id,NEWSPAPER.RELEASEDATE,NEWSPAPER.title,NEWSPAPER.mainimage,NEWSPAPER.content,NEWSPAPER.author,NEWSPAPERTYPE.newspapertype from newspaper inner join NEWSPAPERTYPE on newspaper.newspapertype=NEWSPAPERTYPE.id order by  NEWSPAPER.releasedate desc) where rownum<=1");
				  newspaper newspaper = new newspaper();
				  for (Map row : rows) {
						
					newspaper.setId((BigDecimal )row.get("ID"));
					newspaper.setTitle((String)row.get("TITLE"));
					newspaper.setMainimage((String)row.get("MAINIMAGE"));
					newspaper.setContent((String)row.get("CONTENT"));
					newspaper.setAuthor((String)row.get("AUTHOR"));
					newspaper.setNewspaperType((String)row.get("NEWSPAPERTYPE"));
					newspaper.setReleaseDate((Timestamp)row.get("RELEASEDATE"));
					
					}
				return newspaper;
			 }
	 public newspaper getNewSpaperById(String id) {
		 newspaper newspaperList = new newspaper();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select NEWSPAPER.id,NEWSPAPER.RELEASEDATE,NEWSPAPER.title,NEWSPAPER.mainimage,NEWSPAPER.content,NEWSPAPER.author,NEWSPAPERTYPE.newspapertype from newspaper\r\n" + 
		  		"inner join NEWSPAPERTYPE on newspaper.newspapertype=NEWSPAPERTYPE.id where NEWSPAPER.id="+id);
		  newspaper newspaper = new newspaper();
			for (Map row : rows) {
				
			newspaper.setId((BigDecimal )row.get("ID"));
			newspaper.setTitle((String)row.get("TITLE"));
			newspaper.setMainimage((String)row.get("MAINIMAGE"));
			newspaper.setContent((String)row.get("CONTENT"));
			newspaper.setAuthor((String)row.get("AUTHOR"));
			newspaper.setNewspaperType((String)row.get("NEWSPAPERTYPE"));
			newspaper.setReleaseDate((Timestamp)row.get("RELEASEDATE"));
			
			}
		return newspaper;
	 }
	 
	 public List<newspaper> getNewSpaperByCatagories(String catagories) {
		 newspaper newspaperList = new newspaper();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select NEWSPAPER.id,NEWSPAPER.RELEASEDATE,NEWSPAPER.title,NEWSPAPER.mainimage,NEWSPAPER.content,NEWSPAPER.author,NEWSPAPERTYPE.newspapertype from newspaper inner join NEWSPAPERTYPE on newspaper.newspapertype=NEWSPAPERTYPE.id  where NEWSPAPERTYPE.newspapertype='"+catagories+"'");
		
		  List<newspaper> list=new ArrayList<newspaper>();
			for (Map row : rows) {
				  newspaper newspaper = new newspaper();
			newspaper.setId((BigDecimal )row.get("ID"));
			newspaper.setTitle((String)row.get("TITLE"));
			newspaper.setMainimage((String)row.get("MAINIMAGE"));
			newspaper.setContent((String)row.get("CONTENT"));
			newspaper.setAuthor((String)row.get("AUTHOR"));
			newspaper.setNewspaperType((String)row.get("NEWSPAPERTYPE"));
			newspaper.setReleaseDate((Timestamp)row.get("RELEASEDATE"));
			list.add(newspaper);
			}
		return list;
	 }
	 
	 public String getContentNewspaperById(String id) throws IOException {
		 newspaper newspaperList = new newspaper();
		  List<Map<String, Object>> rows = jdbcTemplate.queryForList("select NEWSPAPER.content from newspaper where NEWSPAPER.id="+id);
		  newspaper newspaper = new newspaper();
		  String filename="";
			for (Map row : rows) {
				filename=(String)row.get("CONTENT");
		
		
		
			}
			String newspaperContent="";
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:\\aDoAnHocKy77777\\newspaperData\\"+filename)),"UTF-8"));
			String data;
			while((data=br.readLine())!=null) {
				newspaperContent+=data+"\n";
			}
		
			br.close();
		
		return newspaperContent;
	 }
}
