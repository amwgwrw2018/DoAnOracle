package pageController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import data.NewspaperService;
import data.Role;
import data.UserDAO;
import data.UserService;
import data.UserSysPriv;
import data.UserTable;
import data.newspaper;
import data.users;
@Controller
public class pageController {
	 
    @Autowired
    private NewspaperService newspapersvc;
    @Autowired
    private UserService userser;
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public ModelAndView  listUser() {
    	ModelAndView model = new ModelAndView();
 
    ArrayList<newspaper> lisnsp=(ArrayList<newspaper>) newspapersvc.getListnewSpaper();
    model.addObject("lisnsp", lisnsp);
    newspaper newest=newspapersvc.getNewestNewspaper();
    model.addObject("newestnsp", newest);
    ArrayList<newspaper> newestTwo=(ArrayList<newspaper>)newspapersvc.getNewestNewspaperList(2);
    model.addObject("newestTwo", newestTwo);
    ArrayList<newspaper> newestThree=(ArrayList<newspaper>)newspapersvc.getNewestNewspaperList(3);
    model.addObject("newestThree", newestThree);
    ArrayList<newspaper> newestFive=(ArrayList<newspaper>)newspapersvc.getNewestNewspaperList(5);
    model.addObject("newestFive", newestFive);
    ArrayList<newspaper> newestSix=(ArrayList<newspaper>)newspapersvc.getNewestNewspaperList(6);
    model.addObject("newestSix", newestSix);
    ArrayList<newspaper> newestFour=(ArrayList<newspaper>)newspapersvc.getNewestNewspaperList(4);
    model.addObject("newestFour", newestFour);
        model.setViewName("homepage");
       


    	return model;
    }
    @RequestMapping(value = { "/signUpForm" }, method = RequestMethod.GET)
    public ModelAndView  signUpForm() {

    	ModelAndView model = new ModelAndView();
 
  
        model.setViewName("signUp");
       


    	return model;
    } 
    
    @RequestMapping(value = { "/loginForm" }, method = RequestMethod.GET)
    public ModelAndView  loginForm() {

    	ModelAndView model = new ModelAndView();
 
  
        model.setViewName("login");
       


    	return model;
    } 
    
    @RequestMapping(value = { "/signUp" }, method = RequestMethod.POST)
    public ModelAndView  signUp(HttpServletRequest request,@RequestParam("username") String username,
    		@RequestParam("password") String password,
    		@RequestParam("email") String email) {
    	System.out.println(username);
    	System.out.println(password);
    	System.out.println(email);
    	userser.addUserForLogin(username, password, email);
    	
    	//request.getSession().setAttribute("currentUser", username);
    	ModelAndView model = new ModelAndView();
 
  
        model.setViewName("login");
       
        

    	return model;
    }
    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public ModelAndView  login(HttpServletRequest request,@RequestParam("username") String username,
    		@RequestParam("password") String password) {
    	System.out.println(username);
    	System.out.println(password);
    	ModelAndView model = new ModelAndView();
 if(userser.checkUserExist(username, password)) {
	 request.getSession().setAttribute("currentUser",username);
 	


	 return new ModelAndView("redirect:/page/");
 
 }else {
	 return new ModelAndView("redirect:/page/");
	
 }
 
    	
       


  
    }
    
    @RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
    public ModelAndView  logout(HttpServletRequest request) {
    	
    	request.getSession().removeAttribute("currentUser");
    	
    	return new ModelAndView("redirect:/page/");
    }
    @RequestMapping(value = { "/singlePage/{id}" },produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    public ModelAndView  listUser(@PathVariable("id")String id) throws IOException {
    	ModelAndView model = new ModelAndView();
    	newspaper nsp=(newspaper) newspapersvc.getListNewSpaper(id);
    	String newspaperContent= newspapersvc.getnewspaperContent(id);
    	
// 
//    ArrayList<newspaper> lisnsp=(ArrayList<newspaper>) newspapersvc.getListnewSpaper();
//    model.addObject("lisnsp", lisnsp);
    	 ArrayList<newspaper> newestThree=(ArrayList<newspaper>)newspapersvc.getNewestNewspaperList(3);
    	    model.addObject("newestThree", newestThree);
    	 model.addObject("nsp", nsp);
    	 model.addObject("newspaperContent", newspaperContent);
        model.setViewName("single-post");
       


    	return model;
    }
    
    @RequestMapping(value = { "/catagories/{catagories}" },produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
    public ModelAndView  postByCatagories(@PathVariable("catagories")String catagories) throws IOException {
    	ModelAndView model = new ModelAndView();
    	ArrayList<newspaper> nspList=(ArrayList<newspaper>) newspapersvc.getNewSpaperByCatagories(catagories);
    	
    	
// 
//    ArrayList<newspaper> lisnsp=(ArrayList<newspaper>) newspapersvc.getListnewSpaper();
//    model.addObject("lisnsp", lisnsp);
    	 model.addObject("nspList", nspList);
  
        model.setViewName("catagories-post");
       


    	return model;
    }
    @RequestMapping(value = { "/adminPage" }, method = RequestMethod.GET)
    public ModelAndView  adminPage() {

    	ModelAndView model = new ModelAndView();
    	  ArrayList<newspaper> lisnsp=(ArrayList<newspaper>) newspapersvc.getListnewSpaper();
    	    model.addObject("lisnsp", lisnsp);
  
        model.setViewName("data-table");
       


    	return model;
    } 
    @RequestMapping(value = { "/adminPageUser" }, method = RequestMethod.GET)
    public ModelAndView  adminPageUser() {

    	ModelAndView model = new ModelAndView();
    	  ArrayList<users> lisnsp=(ArrayList<users>) userser.getListUserLogin();
    	    model.addObject("lisnsp", lisnsp);
  
        model.setViewName("data-table-user");
       


    	return model;
    } 
@RequestMapping(value = { "/deletensp" }, method = RequestMethod.POST)
public ModelAndView  deletensp(@RequestParam("nspID")String nspID) {

newspapersvc.deleteNewspaper(nspID);

	ModelAndView model = new ModelAndView("redirect:/page/adminPage");
   
    

	return model;
} 
@RequestMapping(value = { "/deleteuserlogin" }, method = RequestMethod.POST)
public ModelAndView  deleteuserlogin(@RequestParam("username")String username) {

userser.deleteUserLogin(username);

	ModelAndView model = new ModelAndView("redirect:/page/adminPageUser");
   
    

	return model;
}
@RequestMapping(value = { "/addUserForLogin" }, method = RequestMethod.POST)
public ModelAndView  addUserForLogin(@RequestParam("username")String username,
		@RequestParam("password")String password,
		@RequestParam("email")String email) {

userser.addUserForLogin(username, password, email);

	ModelAndView model = new ModelAndView("redirect:/page/adminPageUser");
   
    

	return model;
}
}