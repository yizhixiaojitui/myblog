package cn.broccoli.blog.utils;

import org.springframework.beans.factory.annotation.Autowired;

import cn.broccoli.blog.mapper.UserMapper;

public class LinkParamCheck {
	@Autowired
	private UserMapper userMapper;
	public String blogLinkCheck(String name) {
		int i=1;
		System.out.println("数量"+userMapper.countByName(name));
		String view="";
		if(i==0) {
			view="forward:template/tips/error.html";
		}else {
			view="forward:home/console.html";
		}
		return view;
	}
}
