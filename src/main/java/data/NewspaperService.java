package data;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NewspaperService {
	@Autowired
	private newspaperDAO newspaperDao;
	public List<newspaper> getListnewSpaper() {
		return newspaperDao.getListNewSpaper();
	}
	public newspaper getListNewSpaper(String id) {
		return newspaperDao.getNewSpaperById(id);
	}
	public String getnewspaperContent(String id) throws IOException {
return newspaperDao.getContentNewspaperById(id);
	}
	public newspaper getNewestNewspaper() {
		return newspaperDao.getNewestNewspaper();
	}
	public List<newspaper> getNewestNewspaperList(int numberOfNewspaper){
		return newspaperDao.getNewestNewspaperList(numberOfNewspaper);
	}
	public List<newspaper> getNewSpaperByCatagories(String catagories){
		return newspaperDao.getNewSpaperByCatagories(catagories);
	}
	public void deleteNewspaper(String nspID) {
		newspaperDao.deleteNewspaper(nspID);
	}
}
