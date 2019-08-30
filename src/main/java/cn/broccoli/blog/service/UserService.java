package cn.broccoli.blog.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.broccoli.blog.po.User;
import cn.broccoli.blog.utils.LoginHelper;
import cn.broccoli.blog.utils.UserHelper;

public interface UserService {
	int selectIdByName(String name);

	String countByName(String name);
	
	User findUserByUsername(String name);
	
	User findUserById(Integer userId);

	boolean userLogout(HttpServletResponse response);
	
	Map<String, String> LoginSignup(HttpServletRequest request,HttpServletResponse response,LoginHelper login);

	int modifyUserPassword(Integer userid,String oldPassword,String password);
	
	UserHelper findUserInfoById(Integer userId);
	
	int modifyUserInfo(UserHelper userHelper,Integer userid);
}
