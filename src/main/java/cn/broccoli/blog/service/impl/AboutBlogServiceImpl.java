package cn.broccoli.blog.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.broccoli.blog.mapper.AboutBlogMapper;
import cn.broccoli.blog.mapper.ArticleMapper;
import cn.broccoli.blog.mapper.FriendlyLinkMapper;
import cn.broccoli.blog.mapper.TagMapper;
import cn.broccoli.blog.mapper.UserMapper;
import cn.broccoli.blog.utils.BlogMessage;
import cn.broccoli.blog.service.AboutBlogService;
@Service("AboutBlogService")
public class AboutBlogServiceImpl implements AboutBlogService{
	private static Logger logger = Logger.getLogger(AboutBlogServiceImpl.class);
	@Autowired
	private AboutBlogMapper aboutBlogMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private FriendlyLinkMapper friendlyLinkMapper;
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private TagMapper tagMapper;
	/**
	* <p>Title: selectByPrimaryKey</p>  
	* <p>Description: 根据用户名查询主页信息</p>  
	* @param name
	* @return  
	* @see cn.broccoli.blog.service.AboutBlogService#selectByPrimaryKey(java.lang.String)  
	*/ 
	@Override
	public BlogMessage selectByPrimaryKey(String name) {
		Integer id=userMapper.selectIdByName(name);
		BlogMessage blogMessage=aboutBlogMapper.selectBlogMessage(id);
		blogMessage.setFriendlyLinks(friendlyLinkMapper.selectAll());
		blogMessage.setArticleHots(articleMapper.selectArticleHot(id));
		blogMessage.setArticleTop(articleMapper.selectArticleTop(id));
		blogMessage.setTags(tagMapper.selectTagAll());
		return  blogMessage;
	}
	

}
