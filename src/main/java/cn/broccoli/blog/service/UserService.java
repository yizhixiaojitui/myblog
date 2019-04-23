package cn.broccoli.blog.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.broccoli.blog.po.User;
import cn.broccoli.blog.utils.LoginHelper;

public interface UserService {
	int selectIdByName(String name);

	String countByName(String name);
	
	User findUserById(Integer userId);

	Map<String, String> LoginSignup(HttpServletRequest request,HttpServletResponse response,LoginHelper login);

	
}
