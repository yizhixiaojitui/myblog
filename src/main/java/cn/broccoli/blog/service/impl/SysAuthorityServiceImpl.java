package cn.broccoli.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.broccoli.blog.mapper.SysAuthorityMapper;
import cn.broccoli.blog.service.SysAuthorityService;
import cn.broccoli.blog.utils.Menu;
import cn.broccoli.blog.utils.MenuTree;
@Service("SysAuthorityService")
public class SysAuthorityServiceImpl implements SysAuthorityService{
	@Autowired
	private SysAuthorityMapper sysAuthorityMapper;
	@Override
	public List<Menu> getAllMenuList() {
		// TODO Auto-generated method stub
		MenuTree menuTree=new MenuTree(sysAuthorityMapper.getAll());
		List<Menu> list=menuTree.builTree();
		return list;
	}
	@Override
	public List<Menu> getMenuByUserId(Integer userid) {
		
		MenuTree menuTree=new MenuTree(sysAuthorityMapper.selectMenuByUserId(userid));
		List<Menu> list=menuTree.builTree();
		System.out.println(JSON.toJSONString(list));
		return list;
	}

}
