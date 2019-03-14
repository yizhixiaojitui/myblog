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
	@RequestMapping(value = "admin/article/drafts",method = RequestMethod.GET)  	
	public ModelAndView articleDrafts() {
		return new ModelAndView("article/drafts.jsp");
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
		return "article";
	}
	
	
}
