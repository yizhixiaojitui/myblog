package cn.broccoli.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.LoginHelper;
import plm.common.beans.ResultBean;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/login/signup",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Map<String, String>> Login(HttpServletRequest request,LoginHelper login) {
		
		return new ResultBean<Map<String,String>>(userService.LoginSignup(request, login));
	}
}
