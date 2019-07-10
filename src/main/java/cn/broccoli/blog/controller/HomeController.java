package cn.broccoli.blog.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.broccoli.blog.po.ArticleDetails;
import cn.broccoli.blog.utils.BlogMessage;
import cn.broccoli.blog.po.User;
import cn.broccoli.blog.service.AboutBlogService;
import cn.broccoli.blog.service.ArticleService;
import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.JWTUtil;
import cn.broccoli.blog.utils.RandomValidateCode;
import plm.common.beans.ResultBean;
import plm.common.exceptions.UnloginException;


@Controller
public class HomeController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private AboutBlogService aboutBlogService;
	@Autowired
	private UserService userService;
	@Autowired
	JWTUtil jwtUtil;
	/**登录页面
	 * @return
	 */
	@RequestMapping(value = "/account/login",method = RequestMethod.GET)  	
	public String loginView() {
		return "user/login";
	}
	@RequestMapping(value = "/index",method = RequestMethod.GET)  	
	public String home(HttpServletRequest request,ModelMap model) {
		return "/index";
	}
	/**后台主页
	 * @return
	 */
	@RequestMapping(value = "/admin",method = RequestMethod.GET)  	
	public String adminView(HttpServletRequest request,ModelMap model) {
		Integer userid=jwtUtil.getUserId(request);
		User user=userService.findUserById(userid);
		model.put("userinfo", user);
		return "/home/index";
	}
	//进入主页
	@RequestMapping(value = "/{name}",method = RequestMethod.GET)  	
	public String blogView(@PathVariable String name,ModelMap model) {
		model.put("blogMes",aboutBlogService.selectByPrimaryKey(name));
		return "blog/index";
	}
	//获取主页信息
	@RequestMapping(value = "/home/getbloginfo",method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<BlogMessage> findBlogMessage(String u) {
		
		return new ResultBean<BlogMessage>(aboutBlogService.selectByPrimaryKey(u));
	}
	@RequestMapping(value = "/{name}/article/details/{id}",method = RequestMethod.GET)
	public String articleDetail(@PathVariable String name,@PathVariable Integer id,ModelMap model) {
		ArticleDetails ad=articleService.findArticleDetails(id);
		//查询文章信息 如果为空 跳转404 否则渲染返回view
		if(ad==null) {
			return "/404";
		}
		model.put("blogMes",aboutBlogService.selectByPrimaryKey(name));
		model.put("article",ad);
		return "blog/detail";
	}
	
	@RequestMapping(value = "/{name}/about",method = RequestMethod.GET)  	
	public String about(@PathVariable String name,ModelMap model) {
		model.put("blogMes",aboutBlogService.selectByPrimaryKey(name));
		return "blog/about";
	}
	@RequestMapping(value = "/{name}/line",method = RequestMethod.GET)  	
	public String timeline(@PathVariable String name,ModelMap model) {
		model.put("blogMes",aboutBlogService.selectByPrimaryKey(name));
		return "blog/timeline";
	}
	@RequestMapping(value = "/{name}/tags",method = RequestMethod.GET)  	
	public String tags(@PathVariable String name,ModelMap model) {
		model.put("blogMes",aboutBlogService.selectByPrimaryKey(name));
		return "blog/tags";
	}
	/**验证码生成接口
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/captcha",method = RequestMethod.GET)  	
	public void validateCodeImage(HttpServletRequest request, HttpServletResponse response) {
		RandomValidateCode randomValidateCode = new RandomValidateCode();
		//输出图片方法
		randomValidateCode.getRandcode(request, response);
	}
	
	
}
