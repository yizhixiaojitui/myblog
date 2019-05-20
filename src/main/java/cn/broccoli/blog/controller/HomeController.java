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
	public ModelAndView loginView() {
		return new ModelAndView("user/login.jsp");
	}
	/**后台主页
	 * @return
	 */
	@RequestMapping(value = "/admin",method = RequestMethod.GET)  	
	public ModelAndView adminView(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		Integer userid=jwtUtil.getUserId(request);
		User user=userService.findUserById(userid);
		view.addObject("userinfo", user);
		view.setViewName("index.jsp");
		return view;
	}
	//进入主页
	@RequestMapping(value = "/{name}",method = RequestMethod.GET)  	
	public ModelAndView blogView(@PathVariable String name) {
		ModelAndView view = new ModelAndView();
		view.addObject("user", name);
		view.setViewName("blog/index.jsp");
		return view;
	}
	//获取主页信息
	@RequestMapping(value = "/home/getbloginfo",method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<BlogMessage> findBlogMessage(String u) {
		
		return new ResultBean<BlogMessage>(aboutBlogService.selectByPrimaryKey(u));
	}
	@RequestMapping(value = "/{name}/article/details/{id}",method = RequestMethod.GET)
	public ModelAndView articleDetail(@PathVariable String name,@PathVariable Integer id) {
		ModelAndView view = new ModelAndView();
		ArticleDetails ad=articleService.findArticleDetails(id);
		//查询文章信息 如果为空 跳转404 否则渲染返回view
		if(ad==null) {
			view.setViewName("/404.jsp");
			return view;
		}
		view.setViewName("blog/detail.jsp");
		view.addObject("article", ad);
		view.addObject("user", name);
		return view;
	}
	
	@RequestMapping(value = "/{name}/about",method = RequestMethod.GET)  	
	public ModelAndView about(@PathVariable String name) {
		ModelAndView view = new ModelAndView();
		view.addObject("user", name);
		view.setViewName("blog/about.jsp");
		return view;
	}
	@RequestMapping(value = "/{name}/line",method = RequestMethod.GET)  	
	public ModelAndView timeline(@PathVariable String name) {
		ModelAndView view = new ModelAndView();
		view.addObject("user", name);
		view.setViewName("blog/timeline.jsp");
		return view;
	}
	/**验证码生成接口
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/captcha",method = RequestMethod.GET)  	
	public void validateCodeImage(HttpServletRequest request, HttpServletResponse response) {
		RandomValidateCode randomValidateCode = new RandomValidateCode();
		randomValidateCode.getRandcode(request, response);//输出图片方法
	}
	
	
}
