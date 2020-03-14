package cn.broccoli.blog.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.broccoli.blog.dto.SysAdminUserDTO;
import cn.broccoli.blog.po.SysUserRole;
import cn.broccoli.blog.po.User;
import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.JWTUtil;
import cn.broccoli.blog.utils.LoginHelper;
import cn.broccoli.blog.utils.UserHelper;
import cn.broccoli.blog.utils.UserList;
import plm.common.beans.PageResultBean;
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
	public ResultBean<Map<String, String>> UserLogin(HttpServletRequest request,HttpServletResponse response,LoginHelper login) {
		
		return new ResultBean<Map<String,String>>(userService.LoginSignup(request, response, login));
		//return new ResultBean<Map<String,String>>(userService.LoginSignup(request, response,login));
	}
	@RequestMapping(value = "/account/logout",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<Boolean> UserLogout(HttpServletResponse response) {
		
		return new ResultBean<Boolean>(userService.userLogout(response));
	}
	/**  
	* @Title: validateCodeImage  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param name
	* @param @return    参数  
	* @return String    返回类型  
	* @throws  
	*/
	@RequestMapping(value = "/admin/getuserinfo",method = RequestMethod.GET)  
	@ResponseBody
	public String validateCodeImage(String name) {
		User user=(User) SecurityUtils.getSubject().getPrincipal();
		return user.getUserName();
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
	
		return new ResultBean<Integer>(userService.modifyUserPassword(((User) SecurityUtils.getSubject().getPrincipal()).getUserId(), oldPassword, password));
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
		
		return new ResultBean<UserHelper>(userService.findUserInfoById(((User) SecurityUtils.getSubject().getPrincipal()).getUserId()));
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
		return new ResultBean<Integer>(userService.modifyUserInfo( userHelper,((User) SecurityUtils.getSubject().getPrincipal()).getUserId()));
	}
	@RequestMapping(value = "/api/user/users/list",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<List<UserList>> findUsers(HttpServletRequest request,int page,int limit,Integer userId,String userNikename,String userEmail,String userSex) {
		return new ResultBean<List<UserList>>(userService.findUsersList(page,limit,userId,userNikename,userEmail,userSex));
	}
	@RequestMapping(value = "/api/user/users/add",method = RequestMethod.POST)  
	@ResponseBody
	public ResultBean<Integer> addUser(HttpServletRequest request,@RequestBody User user){
		return new ResultBean<Integer>(userService.addUser(request, user));
	}
	@RequestMapping(value = "/api/user/users/lock",method = RequestMethod.POST)  
	@ResponseBody
	public ResultBean<Integer> updateUserLock(HttpServletRequest request,Integer userid,Integer userLock){
		return new ResultBean<Integer>(userService.modifyUserLock(userid, userLock));
	}
	@RequestMapping(value = "/api/user/administrator/list",method = RequestMethod.GET)  
	@ResponseBody
	public PageResultBean<List<SysAdminUserDTO>> findAdminUsers(int page, int limit, Integer userId, String userName, Long roleId) {
		return new PageResultBean<List<SysAdminUserDTO>>(userService.findAdminUsersCount(userId,userName,roleId),userService.findAdminUsers(page, limit, userId, userName, roleId));
	}
	@RequestMapping(value = "/api/user/administrator/role/update",method = RequestMethod.PUT)  
	@ResponseBody
	public ResultBean<Integer> updateUserRole(HttpServletRequest request,Integer id,Integer roleId){
		
		return new ResultBean<Integer>(userService.modifyAdminUserRoleByuserIdOrRoleId(id, roleId.longValue()));
	}
	@RequestMapping(value = "/api/user/administrator/role/add",method = RequestMethod.POST)  
	@ResponseBody
	public ResultBean<Integer> addUserRole(@RequestBody SysUserRole sysUserRole){
		System.out.println(">>>>>>>>>>>>>"+sysUserRole);
		return new ResultBean<Integer>(userService.addAdminUserRole(sysUserRole.getUserId(), sysUserRole.getRoleId()));
	}
	@RequestMapping(value = "/api/user/administrator/role/delete",method = RequestMethod.DELETE)  
	@ResponseBody
	public ResultBean<Integer> deleteUserRole(@RequestBody List<SysAdminUserDTO> sysAdminUserDTO){
		System.out.println("????????????>>>>"+sysAdminUserDTO);
		return new ResultBean<Integer>(userService.removeAdminUserRoleByuserIdOrRoleId(sysAdminUserDTO));
	}
}
