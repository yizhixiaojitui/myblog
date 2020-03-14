package cn.broccoli.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminController {


	@RequestMapping(value = "/admin/article/edit",method = RequestMethod.GET)  	
	public String articleEdit() {
		return "/article/edit";
	}
	@RequestMapping(value = "/admin/article/revise",method = RequestMethod.GET)  	
	public String articleRevise() {
		return "/article/revise";
	}
	@RequestMapping(value = "admin/article/trash",method = RequestMethod.GET)  	
	public String articleTrash() {
		return "article/trash";
	}
	@RequestMapping(value = "admin/console",method = RequestMethod.GET)  	
	public String adminConsole() {
		return "home/console";
	}
	@RequestMapping(value = "admin/content/list",method = RequestMethod.GET)  	
	public String articleList() {
		return "article/list";
	}
	@RequestMapping(value = "admin/content/tags/list",method = RequestMethod.GET)  	
	public String articleSortList() {
		return "article/tags";
	}
	@RequestMapping(value = "admin/set/friendlylink/list",method = RequestMethod.GET)  	
	public String adminFriendlyLink() {
		return "set/friendlylink";
	}
	@RequestMapping(value = "admin/set/user/password",method = RequestMethod.GET)  	
	public String adminUpdatePassword() {
		return "set/user/password";
	}
	@RequestMapping(value = "admin/set/user/info",method = RequestMethod.GET)  	
	public String adminUserInfo() {
		return "set/user/info";
	}
	@RequestMapping(value = "admin/set/system/website",method = RequestMethod.GET)  	
	public String adminWebSite() {
		return "set/system/website";
	}
	@RequestMapping(value = "admin/user/administrators/list",method = RequestMethod.GET)  	
	public String administratorsList() {
		return "user/administrators/list";
	}
	@RequestMapping(value = "admin/user/administrators/roles",method = RequestMethod.GET)  	
	public String rolesList() {
		return "user/administrators/role";
	}
	@RequestMapping(value = "admin/user/administrators/adminform",method = RequestMethod.GET)  	
	public String administratorsFrom() {
		return "user/administrators/adminform";
	}
	@RequestMapping(value = "admin/user/administrators/roleform",method = RequestMethod.GET)  	
	public String roleform() {
		return "user/administrators/roleform";
	}
	@RequestMapping(value = "admin/user/administrators/editroleform",method = RequestMethod.GET)  	
	public String editroleform() {
		return "user/administrators/editroleform";
	}
	@RequestMapping(value = "admin/user/users/userform",method = RequestMethod.GET)  	
	public String userForm() {
		return "user/user/userform";
	}
	@RequestMapping(value = "admin/user/users/list",method = RequestMethod.GET)  	
	public String adminUsersList() {
		return "user/user/list";
	}
	@RequestMapping(value = "admin/content/comment",method = RequestMethod.GET)  	
	public String adminCommentList() {
		return "app/content/comment";
	}
	
	
	
}
