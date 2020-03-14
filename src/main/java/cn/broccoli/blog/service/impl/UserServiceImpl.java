package cn.broccoli.blog.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.broccoli.blog.dto.SysAdminUserDTO;
import cn.broccoli.blog.mapper.AboutBlogMapper;
import cn.broccoli.blog.mapper.UserMapper;
import cn.broccoli.blog.po.AboutBlog;
import cn.broccoli.blog.po.User;
import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.CusAccessObjectUtil;
import cn.broccoli.blog.utils.LoginHelper;
import cn.broccoli.blog.utils.UserHelper;
import cn.broccoli.blog.utils.UserList;
import plm.common.exceptions.CheckException;
import plm.common.exceptions.UnloginException;
import plm.common.utils.SaleUtil;
@Service("UserService")
public class UserServiceImpl implements UserService{
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AboutBlogMapper aboutBlogMapper;
	/**
	* <p>Title: selectIdByName</p>  
	* <p>Description: 根据用户名返回用户id</p>  
	* @param name
	* @return  
	* @see cn.broccoli.blog.service.UserService#selectIdByName(java.lang.String)  
	*/ 
	@Override
	public int selectIdByName(String name) {
		int id=userMapper.selectIdByName(name);
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
		Object sessionRandomCode=httpSession.getAttribute("randomcode_key");
		if(sessionRandomCode==null) {
			throw new UnloginException("请点击重新获取验证码");
		}
		if(!login.getVercode().equalsIgnoreCase(sessionRandomCode.toString())) {
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
		//最后一次登陆IP跟登录时间
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

	//查询网站所有用户
	@Override
	public List<UserList> findUsersList(int page,int limit,Integer userId,String userNikename,String userEmail,String userSex) {
		//
		page=(page-1)*limit;
		return userMapper.selectUsers(page,limit,userId,userNikename,userEmail,userSex);
	}

	@Override
	public int addUser(HttpServletRequest request,User user) {
		String ip=CusAccessObjectUtil.getIpAddress(request);
		String password=SaleUtil.PassWordToMD5("123456");
		Date time=new Date();
		user.setUserRegisterTime(time);
		user.setUserRegisterIp(ip);
		user.setUserLastLoginIp(ip);
		user.setUserPwd(password);
		Integer userid=userMapper.insertSelective(user);
		//创建博客
		AboutBlog aboutBlog = new AboutBlog();
		aboutBlog.setUserId(userid);
		aboutBlog.setBlogName(user.getUserNikename());
		aboutBlog.setBlogTitle(user.getUserNikename());
		
		return aboutBlogMapper.insertBlog(aboutBlog);
	}

	//锁定用户
	@Override
	public int modifyUserLock(Integer userId, Integer userLock) {
		
		return userMapper.updateUserLockByUserId(userId, userLock);
	}

	@Override
	public List<SysAdminUserDTO> findAdminUsers(int page, int limit, Integer userId, String userNikename, Long roleId) {
		// TODO Auto-generated method stub
		page=(page-1)*limit;
		return userMapper.selectAdminUsers(page, limit, userId, userNikename, roleId);
	}

	@Override
	public int findAdminUsersCount(Integer userId, String userNikename, Long roleId) {
		// TODO Auto-generated method stub
		return userMapper.selectAdminUsersCount(userId, userNikename, roleId);
	}

	@Override
	public int addAdminUserRole(Integer userId, Long roleId) {
		
		User user=userMapper.selectByPrimaryKey(userId);
		if(null==user) {
			throw new CheckException("无此用户id！["+userId+"]");
		}
		int count=userMapper.selectAdminUserRoleByuserIdOrRoleId(userId, roleId);
		if(count!=0) {
			throw new CheckException("已经添加了这个角色，请勿重复添加！");
		}
		return userMapper.insertAdminUserRole(userId, roleId);
	}

	@Override
	public int findAdminUserRoleByuserIdOrRoleId(Integer userId, Long roleId) {
		// TODO Auto-generated method stub
		return userMapper.selectAdminUserRoleByuserIdOrRoleId(userId, roleId);
	}

	@Override
	public int modifyAdminUserRoleByuserIdOrRoleId(Integer userId, Long roleId) {
		// TODO Auto-generated method stub
		return userMapper.updateAdminUserRoleByuserIdOrRoleId(userId, roleId);
	}

	@Override
	public int removeAdminUserRoleByuserIdOrRoleId(List<SysAdminUserDTO> sysAdminUserDTO) {
		// TODO Auto-generated method stub
		
		return userMapper.deleteAdminUserRoleByuserIdOrRoleId(sysAdminUserDTO);
	}
	
	

}
