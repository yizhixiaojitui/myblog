package cn.broccoli.blog.service;


import cn.broccoli.blog.utils.BlogMessage;


public interface AboutBlogService {
	BlogMessage selectByPrimaryKey(String name);
}
