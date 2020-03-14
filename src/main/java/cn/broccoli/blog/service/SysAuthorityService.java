package cn.broccoli.blog.service;

import java.util.List;

import cn.broccoli.blog.utils.Menu;

public interface SysAuthorityService {

	List<Menu> getAllMenuList();
	
	List<Menu> getMenuByUserId(Integer userid);
}
