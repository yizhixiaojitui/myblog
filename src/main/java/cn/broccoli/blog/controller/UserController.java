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
import cn.broccoli.blog.utils.JWTUtil;
import cn.broccoli.blog.utils.LoginHelper;
import cn.broccoli.blog.utils.RandomValidateCode;
import cn.broccoli.blog.utils.UserHelper;
import plm.common.beans.ResultBean;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	JWTUtil jwtUtil;
	
	/**登录验证
	 * @param request
	 * @param response
	 * @param login
	 * @return
	 */
	///account/login
	/**  
	* @Title: Login  
	* @Description: TODO 登录接口  
	* @param @param request
	* @param @param response
	* @param @param login
	* @param @return    参数  
	* @return ResultBean<Map<String,String>>    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/account/login/signup",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Map<String, String>> Login(HttpServletRequest request,HttpServletResponse response,LoginHelper login) {
		
		return new ResultBean<Map<String,String>>(userService.LoginSignup(request, response,login));
	}
	/**  
	* @Title: validateCodeImage  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param name
	* @param @return    参数  
	* @return String    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/account/get",method = RequestMethod.GET)  
	@ResponseBody
	public String validateCodeImage(String name) {
		
		return userService.countByName(name);
	}
	/**  
	* @Title: updatePassword  
	* @Description: TODO 修改密码 
	* @param @param request
	* @param @param oldPassword
	* @param @param password
	* @param @return    参数  
	* @return ResultBean<Integer>    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/admin/update/password",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Integer> updatePassword(HttpServletRequest request,String oldPassword,String password) {
	
		return new ResultBean<Integer>(userService.modifyUserPassword(jwtUtil.getUserId(request), oldPassword, password));
	}
	/**  
	* @Title: getUser  
	* @Description: TODO 获取用户详细信息  
	* @param @param request
	* @param @return    参数  
	* @return ResultBean<UserHelper>    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/admin/get/userinfo",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<UserHelper> getUser(HttpServletRequest request) {
		
		return new ResultBean<UserHelper>(userService.findUserInfoById(jwtUtil.getUserId(request)));
	}
	/**  
	* @Title: updateUser  
	* @Description: TODO 修改用户信息
	* @param @param request
	* @param @param userHelper
	* @param @return    参数  
	* @return ResultBean<Integer>    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/admin/update/userinfo",method = RequestMethod.POST)  
	@ResponseBody
	public ResultBean<Integer> updateUser(HttpServletRequest request,UserHelper userHelper) {
		System.out.println(userHelper.toString());
		return new ResultBean<Integer>(userService.modifyUserInfo( userHelper,jwtUtil.getUserId(request)));
	}
}
