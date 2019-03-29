package cn.broccoli.blog.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.broccoli.blog.utils.LoginHelper;

public interface UserService {
	int selectIdByName(String name);

	String countByName(String name);
	

	Map<String, String> LoginSignup(HttpServletRequest request,LoginHelper login);
}
