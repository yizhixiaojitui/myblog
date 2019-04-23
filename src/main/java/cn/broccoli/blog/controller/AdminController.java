package cn.broccoli.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AdminController {


	@RequestMapping(value = "/admin/article/edit",method = RequestMethod.GET)  	
	public ModelAndView articleEdit() {
		return new ModelAndView("/article/edit.jsp");
	}
	@RequestMapping(value = "admin/article/trash",method = RequestMethod.GET)  	
	public ModelAndView articleTrash() {
		return new ModelAndView("article/trash.jsp");
	}
	@RequestMapping(value = "admin/console",method = RequestMethod.GET)  	
	public ModelAndView adminConsole() {
		return new ModelAndView("home/console.jsp");
	}
	@RequestMapping(value = "admin/article",method = RequestMethod.GET)  	
	public String adminarticle() {
		return "forward:/index.jsp?id=10001";
	}
	@RequestMapping(value = "admin/content/list",method = RequestMethod.GET)  	
	public ModelAndView articleList() {
		return new ModelAndView("article/list.jsp");
	}
	@RequestMapping(value = "admin/content/tags/list",method = RequestMethod.GET)  	
	public ModelAndView articleSortList() {
		return new ModelAndView("article/tags.jsp");
	}
	@RequestMapping(value = "admin/set/friendlylink/list",method = RequestMethod.GET)  	
	public ModelAndView adminFriendlyLink() {
		return new ModelAndView("set/friendlylink.jsp");
	}
	@RequestMapping(value = "admin/set/user/password",method = RequestMethod.GET)  	
	public ModelAndView adminUpdatePassword() {
		return new ModelAndView("set/user/password.jsp");
	}
	@RequestMapping(value = "admin/set/user/info",method = RequestMethod.GET)  	
	public ModelAndView adminUserInfo() {
		return new ModelAndView("set/user/info.jsp");
	}
	
	
}
