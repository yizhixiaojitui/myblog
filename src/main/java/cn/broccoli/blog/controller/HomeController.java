package cn.broccoli.blog.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.broccoli.blog.po.ArticleDetails;
import cn.broccoli.blog.utils.ArticleTop;
import cn.broccoli.blog.utils.BlogMessage;
import cn.broccoli.blog.po.User;
import cn.broccoli.blog.service.AboutBlogService;
import cn.broccoli.blog.service.ArticleService;
import cn.broccoli.blog.service.SysAuthorityService;
import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.JWTUtil;
import cn.broccoli.blog.utils.Menu;
import cn.broccoli.blog.utils.RandomValidateCode;
import plm.common.beans.ResultBean;


@Controller
public class HomeController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private AboutBlogService aboutBlogService;
	@Autowired
	private UserService userService;
	@Autowired
	private SysAuthorityService sysAuthorityService;
	
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
		User user=(User)SecurityUtils.getSubject().getPrincipal();
		List<Menu> menu=sysAuthorityService.getMenuByUserId(user.getUserId());
		model.put("userinfo", user);
		model.put("menuList", menu);
		return "/home/index";
	}
	@RequestMapping(value = "/admin/tree/test",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<List<Menu>> vtest(HttpServletRequest request, HttpServletResponse response) {
		Integer userid=jwtUtil.getUserId(request);	
		return new ResultBean<List<Menu>>(sysAuthorityService.getMenuByUserId(((User)SecurityUtils.getSubject().getPrincipal()).getUserId()));
	}
	//进入主页
	@RequestMapping(value = "/{name}",method = RequestMethod.GET)  	
	public String blogView(@PathVariable String name,ModelMap model) {
		BlogMessage blogMessage=aboutBlogService.selectByPrimaryKey(name);
		System.out.println("blogMessage"+blogMessage);
		if(blogMessage==null) {
			System.out.println("blogView=null");
			return "/template/tips/404";
		}
		model.put("blogMes",blogMessage);
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
	@RequestMapping(value = "/{name}/tags/{tagName}",method = RequestMethod.GET)  	
	public String tags(@PathVariable String name,@PathVariable String tagName,ModelMap model) {
		model.put("blogMes",aboutBlogService.selectByPrimaryKey(name));
		model.put("list",articleService.findTagArticleList(name, tagName));
		model.put("tagName",tagName);
		return "blog/tags";
	}
	
	@RequestMapping(value = "/{name}/module",method = RequestMethod.GET)  	
	public String module(@PathVariable String name,int mid,ModelMap model) {
		String moduleName="";
		switch (mid) {
		case 1:
			moduleName="问题库";
			break;
		case 2:
			moduleName="随笔";
			break;
		case 3:
			moduleName="分享";
			break;
		default:
			return "template/tips/error";
		}
		model.put("moduleName",moduleName);
		model.put("blogMes",aboutBlogService.selectByPrimaryKey(name));
		model.put("list",articleService.findArticleModule(name, mid));
		return "blog/module";
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
