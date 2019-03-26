package cn.broccoli.blog.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.broccoli.blog.mapper.UserMapper;
import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.LoginHelper;
import plm.common.exceptions.CheckException;
import plm.common.exceptions.UnloginException;
@Service("UserService")
public class UserServiceImpl implements UserService{
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserMapper userMapper;

	@Override
	public int selectIdByName(String name) {
		int id=userMapper.countByName(name);
		logger.info(name+"的用户id为:"+id);
		return id;
	}

	@Override
	public String countByName(String name) {
		if(userMapper.countByName(name)==0) {
			return "template/tips/error.html";
		}
		return "blog/index.jsp";
	}

	/* (non-Javadoc)
	 * @see cn.broccoli.blog.service.UserService#LoginSignup()
	 */
	@Override
	public Map<String, String> LoginSignup(HttpServletRequest request,LoginHelper login) {
		Map<String, String> result=new HashMap<String, String>();
		HttpSession session=request.getSession();
		result.put("access_token", "abcdefg");
		String randomcode=session.getAttribute("randomcode_key").toString();
		if(!randomcode.equals(login.getVercode())) {
			System.out.println("验证码错误！！！");
			throw new UnloginException("验证码错误");
		}
		
		return result;
	}

}
