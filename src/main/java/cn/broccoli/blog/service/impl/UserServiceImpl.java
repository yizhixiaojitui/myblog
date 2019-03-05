package cn.broccoli.blog.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.broccoli.blog.mapper.UserMapper;
import cn.broccoli.blog.service.UserService;
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

}
