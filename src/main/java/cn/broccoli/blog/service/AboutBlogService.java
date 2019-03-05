package cn.broccoli.blog.service;


import cn.broccoli.blog.beans.ResultBean;
import cn.broccoli.blog.po.AboutBlog;
import cn.broccoli.blog.po.BlogMessage;


public interface AboutBlogService {
	BlogMessage selectByPrimaryKey(String name);
}
