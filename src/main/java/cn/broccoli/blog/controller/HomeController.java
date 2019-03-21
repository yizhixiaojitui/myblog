package cn.broccoli.blog.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import cn.broccoli.blog.service.ArticleService;
import cn.broccoli.blog.utils.RandomValidateCode;
import plm.common.beans.ResultBean;
import plm.common.exceptions.UnloginException;


@Controller
public class HomeController {
	@Autowired
	private ArticleService articleService;
	
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)  	
	public ModelAndView Login() {
		return new ModelAndView("user/login.jsp");
	}
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
	//验证码
	@RequestMapping(value = "/captcha",method = RequestMethod.GET)  	
	public void vcode(HttpServletRequest request, HttpServletResponse response) {
		
		RandomValidateCode randomValidateCode = new RandomValidateCode();
		randomValidateCode.getRandcode(request, response);//输出图片方法
	}
	
	
}
