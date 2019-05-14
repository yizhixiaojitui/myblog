package cn.broccoli.blog.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.broccoli.blog.mapper.AboutBlogMapper;
import cn.broccoli.blog.mapper.UserMapper;
import cn.broccoli.blog.po.BlogMessage;
import cn.broccoli.blog.service.AboutBlogService;
@Service("AboutBlogService")
public class AboutBlogServiceImpl implements AboutBlogService{
	private static Logger logger = Logger.getLogger(AboutBlogServiceImpl.class);
	@Autowired
	private AboutBlogMapper aboutBlogMapper;
	@Autowired
	private UserMapper userMapper;
	
	/**
	* <p>Title: selectByPrimaryKey</p>  
	* <p>Description: 根据用户名查询主页信息</p>  
	* @param name
	* @return  
	* @see cn.broccoli.blog.service.AboutBlogService#selectByPrimaryKey(java.lang.String)  
	*/ 
	@Override
	public BlogMessage selectByPrimaryKey(String name) {
		
		return  aboutBlogMapper.selectBlogMessage(userMapper.selectIdByName(name));
	}
	

}
