package cn.broccoli.blog.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
		HttpSession session=request.getSession();
		String randomcode=session.getAttribute("randomcode_key").toString();
		if(!randomcode.equalsIgnoreCase(login.getVercode())) {
			System.out.println("验证码错误！！！");
			throw new UnloginException("验证码错误");
		}
		//密码MD5加密比对
		login.setPassword(SaleUtil.PassWordToMD5(login.getPassword()));
		User user=userMapper.selectByUserName(login.getUsername());
		if(user==null) {
			throw new UnloginException("用户名不存在或密码错误！");
		}
		if(user.getUserPwd().equals(login.getPassword())) {
			String token=JWTUtil.generToken(user.getUserId().toString(),null, null);
			System.out.println("========"+token);
			Cookie cookie = new Cookie("access_token",token);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			result.put("access_token", token);
		}else {
		throw new UnloginException("用户名或密码错误！");
			
		}
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

	@Override
	public UserHelper findUserInfoById(Integer userId) {

		
		return userMapper.selectUserInfoById(userId);
	}

	@Override
	public int modifyUserInfo( UserHelper userHelper,Integer userid) {
		// TODO Auto-generated method stub
		userHelper.setUserId(userid);
		return userMapper.updateUserInfo(userHelper);
	}
	
	

}
