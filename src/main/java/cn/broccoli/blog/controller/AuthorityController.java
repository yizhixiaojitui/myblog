package cn.broccoli.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.broccoli.blog.service.SysAuthorityService;
import cn.broccoli.blog.service.SysRoleAuthorityService;
import cn.broccoli.blog.utils.Menu;
import plm.common.beans.ResultBean;

@Controller
public class AuthorityController {

	@Autowired
	private SysAuthorityService sysAuthorityService;
	@Autowired
	private SysRoleAuthorityService sysRoleAuthorityService;
	
	/**
	 * 查询全部的权限列表
	 * @return
	 */
	@RequestMapping(value = "/api/authority/list",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<List<Menu>> getAuthorityList() {
		return new ResultBean<List<Menu>>(sysAuthorityService.getAllMenuList());
	}
	/**
	 * 根据角色id查询已授权的权限列表
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/api/authority/checked/list",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<List<Long>> getAuthorityChecked(Long roleId) {
		return new ResultBean<List<Long>>(sysRoleAuthorityService.findAuthIdByRoleId(roleId));
	}
}
