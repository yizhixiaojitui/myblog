package cn.broccoli.blog.service;


import cn.broccoli.blog.po.BlogMessage;


public interface AboutBlogService {
	BlogMessage selectByPrimaryKey(String name);
}
