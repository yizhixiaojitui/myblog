package cn.broccoli.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.LoginHelper;
import cn.broccoli.blog.utils.RandomValidateCode;
import plm.common.beans.ResultBean;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	/**登录验证
	 * @param request
	 * @param response
	 * @param login
	 * @return
	 */
	///account/login
	@RequestMapping(value = "/account/login/signup",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Map<String, String>> Login(HttpServletRequest request,HttpServletResponse response,LoginHelper login) {
		
		return new ResultBean<Map<String,String>>(userService.LoginSignup(request, response,login));
	}
	@RequestMapping(value = "/account/get",method = RequestMethod.GET)  
	@ResponseBody
	public String validateCodeImage(String name) {
		
		return userService.countByName(name);
	}
	@RequestMapping(value = "/account/update/password",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Boolean> updatePassword(HttpServletRequest request,HttpServletResponse response,LoginHelper login) {
		
		return new ResultBean<Boolean>();
	}
}
