package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import data.Role;
import data.RolePrivileged;
import data.RoleToRole;
import data.UserDAO;
import data.UserService;
import data.UserSysPriv;
import data.UserTable;
import data.UsersAndTheirRole;
import data.quota;
@Controller
public class MainController {
	 
    @Autowired
    private UserService userser;
    @RequestMapping(value = { "/mainPage" }, method = RequestMethod.GET)
    public String  welcomePage(Model model) {
    	//userser.createUser();
    	return "index";
    }
    
    @RequestMapping(value = { "/adminPage" }, method = RequestMethod.GET)
    public String  adminPage(Model model) {
    	//userser.createUser();
    	return "UserManagement";
    }
    
    @RequestMapping(value = { "/createUser" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  createUser(@RequestParam("username") String username,@RequestParam("password") String password) {
    	System.out.println(username);
    	System.out.println(password);
    	userser.createUser(username,password);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    @RequestMapping(value = { "/changeUserPassword" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  changeUserPassword(@RequestParam("username") String username,@RequestParam("newPass") String newPass) {
    	userser.changeUserPassword(username, newPass);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    
    @RequestMapping(value = { "/addNewPrivilege" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  addNewPrivilege(@RequestParam("username") String username,@RequestParam("privilege") String privilege) {
    	userser.addNewPrivilege(privilege, username);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    
    @RequestMapping(value = { "/revokePrivilege" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  revokePrivilege(@RequestParam("username") String username,@RequestParam("privilege") String privilege) {
    	userser.revokePrivilege(privilege, username);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    
    @RequestMapping(value = { "/revokeRoleFromUser" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  revokeRoleFromUser(@RequestParam("username") String username,@RequestParam("rolename") String rolename) {
    	userser.revokeRoleFromUser(rolename, username);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    @RequestMapping(value = { "/revokePrivFromRole" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  revokePrivFromRole(@RequestParam("rolename") String rolename,@RequestParam("privilege") String privilege) {
    	userser.revokePrivFromRole(rolename, privilege);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    
    @RequestMapping(value = { "/revokeRoleFromRole" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  revokeRoleFromRole(@RequestParam("rolename") String rolename,@RequestParam("rolenametoberevoked") String rolenametoberevoked) {
    	userser.revokeRoleFromRole(rolename, rolenametoberevoked);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    
    @RequestMapping(value = { "/createRole" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  createRole(@RequestParam("rolename") String rolename) {
    	userser.CreateRole(rolename);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    @RequestMapping(value = { "/setQuotaUser" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  setQuotaUser(@RequestParam("username") String username,@RequestParam("quotaset") String quotaset) {
    	userser.setQuotaUser(username, quotaset+"M");

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    @RequestMapping(value = { "/dropRole" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  dropRole(@RequestParam("rolename") String rolename) {
    	userser.DropRole(rolename);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    
    @RequestMapping(value = { "/AddPrivilegeToRole" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  dropRole(@RequestParam("rolename") String rolename,@RequestParam("privilegename") String privilegename) {
    	userser.AddprivilegeToRole(privilegename, rolename);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    
    @RequestMapping(value = { "/AddRoleToUser" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  AddRoleToUser(@RequestParam("rolename") String rolename,@RequestParam("username") String username) {
    	userser.AddRoleToUser(rolename, username);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    
    @RequestMapping(value = { "/AddRoleToRole" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  AddRoleToRole(@RequestParam("rolename") String rolename,@RequestParam("rolenametobeadded") String rolenametobeadded) {
    	System.out.println("co role to role");
    	System.out.println(rolename);
    	System.out.println(rolenametobeadded);
    	try {
    		userser.addRoleToRole(rolename, rolenametobeadded);
		} catch (Exception e) {
			System.out.println("co loi xay ra trong khi add role to role");
		}

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
       
        

    	return model;
    }
    @RequestMapping(value = { "/GetUserPrivByUsername" },produces="application/json", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<String> getUserPrivByUsername(@RequestParam("username") String username){
    	System.out.println(userser.getListPrivUserByUsername(username));
    	
    return userser.getListPrivUserByUsername(username);
    }
    
    @RequestMapping(value = { "/GetUserRoleByUsername" },produces="application/json", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<String> GetUserRoleByUsername(@RequestParam("username") String username){
    	System.out.println(userser.getListRoletUserByUsername(username));
    	
    return userser.getListRoletUserByUsername(username);
    }
    @RequestMapping(value = { "/getListRoletUserByRole" },produces="application/json", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<String> getListRoletUserByRole(@RequestParam("rolename") String rolename){
    	System.out.println(userser.getListRoletUserByRole(rolename));
    	
    return userser.getListRoletUserByRole(rolename);
    }
    
    @RequestMapping(value = { "/getListRoleExcept" },produces="application/json", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<String> getListRoleExcept(@RequestParam("rolename") String rolename){
    	System.out.println(userser.getListRoleExceptRole(rolename));
    	
    return userser.getListRoleExceptRole(rolename);
    }
    @RequestMapping(value = { "/getListRoleFromSelectedRole" },produces="application/json", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<String> getListRoleFromSelectedRole(@RequestParam("rolename") String rolename){
    	System.out.println(userser.getListRoleFromSelectedRole(rolename));
    	
    return userser.getListRoleFromSelectedRole(rolename);
    }
    @RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView  deleteUser(@RequestParam("username") String username) {
    	userser.deleteUser(username);

    	ModelAndView model = new ModelAndView("redirect:/User/listUser");
 
  
        
       
        

    	return model;
    }
    @RequestMapping(value = { "/listUser" }, method = RequestMethod.GET)
    public ModelAndView  listUser() {
    	ModelAndView model = new ModelAndView();
    	ArrayList<UserTable> list= (ArrayList<UserTable>) userser.getListUser();
    	model.addObject("listUser", list);
    	ArrayList<UserSysPriv> listPriviUser= (ArrayList<UserSysPriv>) userser.getLisRoletUser();
    	model.addObject("listPriviUser", listPriviUser);
    ArrayList<Role> listRoleUser=(ArrayList<Role>) userser.getListRole();
    model.addObject("listRoleUser", listRoleUser);
    ArrayList<RolePrivileged> listRolePrivileged=(ArrayList<RolePrivileged>) userser.getListRolePrivileged();
    model.addObject("listRolePrivileged", listRolePrivileged);
    ArrayList<UsersAndTheirRole> getUserAndTheirRoleList=(ArrayList<UsersAndTheirRole>) userser.getListUserAndTheirRole();
    model.addObject("UserAndTheirRoleList", getUserAndTheirRoleList);
    ArrayList<String> listPrivilegeCanSet=(ArrayList<String>) userser.listPrivilegeCanSet();
    model.addObject("listPrivilegeCanSet",listPrivilegeCanSet);
    ArrayList<RoleToRole> ListRoleToRole=(ArrayList<RoleToRole>) userser.getListRoleToRole();
    model.addObject("ListRoleToRole",ListRoleToRole);
    ArrayList<quota> listQuota=(ArrayList<quota>) userser.listQuota();
    model.addObject("listQuota",listQuota);
        model.setViewName("index");
       
        

    	return model;
    }


 
}
