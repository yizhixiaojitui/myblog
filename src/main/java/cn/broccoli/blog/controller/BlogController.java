package cn.broccoli.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import plm.common.beans.ResultBean;

import cn.broccoli.blog.po.BlogMessage;
import cn.broccoli.blog.service.AboutBlogService;


@Controller
public class BlogController {
	@Autowired
	private AboutBlogService aboutBlogService;
	
	
	
	@RequestMapping(value = "/blog/{name}/getbloginfo",method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<BlogMessage> findBlogMessage(@PathVariable String name) {
		
		return new ResultBean<BlogMessage>(aboutBlogService.selectByPrimaryKey(name));
	}
}
