package cn.broccoli.blog.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.broccoli.blog.mapper.UserMapper;
import cn.broccoli.blog.po.User;
import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.JWTUtil;
import cn.broccoli.blog.utils.LoginHelper;
import cn.broccoli.blog.utils.UserHelper;
import plm.common.exceptions.CheckException;
import plm.common.exceptions.UnloginException;
import plm.common.utils.SaleUtil;
@Service("UserService")
public class UserServiceImpl implements UserService{
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	
	/**
	* <p>Title: selectIdByName</p>  
	* <p>Description: 根据用户名返回用户id</p>  
	* @param name
	* @return  
	* @see cn.broccoli.blog.service.UserService#selectIdByName(java.lang.String)  
	*/ 
	@Override
	public int selectIdByName(String name) {
		int id=userMapper.countByName(name);
		logger.info(name+"的用户id为:"+id);
		return id;
	}

	@Override
	public String countByName(String name) {
		return SaleUtil.PassWordToMD5(name);
	}

	/**
	* <p>Title: LoginSignup</p>  
	* <p>Description: 用户登录方法</p>  
	* @param request
	* @param response
	* @param login
	* @return  
	 * @see cn.broccoli.blog.service.UserService#LoginSignup(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, cn.broccoli.blog.utils.LoginHelper)  
	*/ 
	@Override
	public Map<String, String> LoginSignup(HttpServletRequest request,HttpServletResponse response,LoginHelper login) {
		Map<String, String> result=new HashMap<String, String>();
		HttpSession httpSession=request.getSession();
		String randomcode=httpSession.getAttribute("randomcode_key").toString();
		if(!randomcode.equalsIgnoreCase(login.getVercode())) {
			System.out.println("验证码错误！！！");
			throw new UnloginException("验证码错误");
		}
		String password=SaleUtil.PassWordToMD5(login.getPassword());
		System.out.println("UserLogin =>password:"+password);
		UsernamePasswordToken userNamePassWordToken= new UsernamePasswordToken(login.getUsername(),password);
		try {
		SecurityUtils.getSubject().login(userNamePassWordToken);
	    } catch (UnknownAccountException uae) {
	    	throw new UnloginException("用户名不存在:" + userNamePassWordToken.getPrincipal());
		} catch (IncorrectCredentialsException ice) {
			throw new UnloginException("用户名/密码不正确!");
		} catch (LockedAccountException lae) {
			throw new UnloginException("用户名 " + userNamePassWordToken.getPrincipal() + " 被锁定 !");
		}
		Session session=SecurityUtils.getSubject().getSession();
		String accessToken=(String) session.getAttribute("access_token");
		System.out.println("========"+accessToken);
		Cookie cookie = new Cookie("access_token",accessToken);
		cookie.setPath("/");
		response.addCookie(cookie);
		result.put("access_token", accessToken);
		return result;
	}

	
	/**
	* <p>Title: findUserById</p>  
	* <p>Description: 根据用户id查询返回用户实体</p>  
	* @param userId
	* @return  User
	* @see cn.broccoli.blog.service.UserService#findUserById(java.lang.Integer)  
	*/ 
	@Override
	public User findUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);
	}

	/**
	* <p>Title: modifyUserPassword</p>  
	* <p>Description: 修改用户密码</p>  
	* @param userid
	* @param oldPassword
	* @param password
	* @return  
	* @see cn.broccoli.blog.service.UserService#modifyUserPassword(java.lang.Integer, java.lang.String, java.lang.String)  
	*/ 
	@Override
	public int modifyUserPassword(Integer userid, String oldPassword, String password) {
		User user=userMapper.selectByPrimaryKey(userid);
		if(!SaleUtil.PassWordToMD5(oldPassword).equals(user.getUserPwd())) {
			throw new UnloginException("当前密码输入错误");
		}
		
		return userMapper.updatePassword(userid, SaleUtil.PassWordToMD5(password));
	}

	/**
	* <p>Title: findUserInfoById</p>  
	* <p>Description: 根据ID查询用户详细信息</p>  
	* @param userId
	* @return  
	* @see cn.broccoli.blog.service.UserService#findUserInfoById(java.lang.Integer)  
	*/ 
	@Override
	public UserHelper findUserInfoById(Integer userId) {

		
		return userMapper.selectUserInfoById(userId);
	}

	/**
	* <p>Title: modifyUserInfo</p>  
	* <p>Description: 修改用户资料</p>  
	* @param userHelper
	* @param userid
	* @return  
	* @see cn.broccoli.blog.service.UserService#modifyUserInfo(cn.broccoli.blog.utils.UserHelper, java.lang.Integer)  
	*/ 
	@Override
	public int modifyUserInfo( UserHelper userHelper,Integer userid) {
		// TODO Auto-generated method stub
		userHelper.setUserId(userid);
		return userMapper.updateUserInfo(userHelper);
	}

	/**
	* <p>Title: userLogout</p>  
	* <p>Description:用户注销登录 </p>  
	* @return  
	* @see cn.broccoli.blog.service.UserService#userLogout()  
	*/ 
	@Override
	public boolean userLogout(HttpServletResponse response) {
		// TODO Auto-generated method stub
		Cookie cookie = new Cookie("access_token",null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		logger.info("");
		return true;
	}

	/**
	* <p>Title: findUserByUsername</p>  
	* <p>Description: </p>  
	* @param name
	* @return  
	* @see cn.broccoli.blog.service.UserService#findUserByUsername(java.lang.String)  
	*/ 
	@Override
	public User findUserByUsername(String name) {

		
		return userMapper.selectByUserName(name);
	}
	
	

}
