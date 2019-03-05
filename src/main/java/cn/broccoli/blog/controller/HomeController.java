package cn.broccoli.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import cn.broccoli.blog.service.ArticleService;


@Controller
public class HomeController {
	@Autowired
	private ArticleService articleService;
	
	

	@RequestMapping(value = "/admin",method = RequestMethod.GET)  	
	public ModelAndView admin() {
		return new ModelAndView("index.jsp");
	}
	//进入主页
	@RequestMapping(value = "/blog/{name}",method = RequestMethod.GET)  	
	public ModelAndView blog(@PathVariable String name) {
		return new ModelAndView("blog/index.jsp");
	}
	@RequestMapping(value = "/blog/{name}/article/details/{id}",method = RequestMethod.GET)
	public ModelAndView articleDetail(@PathVariable String name,@PathVariable Integer id) {
		return new ModelAndView("blog/detail.jsp","article",articleService.findArticleDetails(id));
	}

	
}
