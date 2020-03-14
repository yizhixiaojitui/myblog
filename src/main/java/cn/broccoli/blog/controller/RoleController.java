package cn.broccoli.blog.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.broccoli.blog.dto.SysRoleDTO;
import cn.broccoli.blog.dto.SysRoleSelectDTO;
import cn.broccoli.blog.po.SysRole;
import cn.broccoli.blog.service.SysRoleService;
import cn.broccoli.blog.utils.RoleBody;
import plm.common.beans.ResultBean;

@Controller
public class RoleController {

	@Autowired
	SysRoleService sysRoleService;
	
	@RequestMapping(value = "/api/administrators/role/add",method = RequestMethod.POST)  
	@ResponseBody
	public ResultBean<Boolean> savaRole(@RequestBody RoleBody roleBody) {
		
		return new ResultBean<Boolean>(sysRoleService.addRole(roleBody));
	}
	@RequestMapping(value = "/api/administrators/role/list",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<List<SysRole>> findRoleList(Long role,int page,Integer limit) {
		
		return new ResultBean<List<SysRole>>(sysRoleService.findSysRoleListById(role,page,limit));
	}
	
	@RequestMapping(value = "/api/administrators/role/roletype/list",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<List<SysRoleSelectDTO>> findRoleTypeList() {
		
		return new ResultBean<List<SysRoleSelectDTO>>(sysRoleService.findSysRoleList());
	}
	@RequestMapping(value = "/api/administrators/role/get",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<SysRole> findRoleById() {
		
		return new ResultBean<SysRole>(sysRoleService.findSysRoleById());
	}
	@RequestMapping(value = "/api/administrators/role/update",method = RequestMethod.PUT)  
	@ResponseBody
	public ResultBean<Boolean> updateRole(@RequestBody SysRoleDTO sysRoleDTO) {
		
		return new ResultBean<Boolean>(sysRoleService.modifyRole(sysRoleDTO));
	}
	@RequestMapping(value = "/api/administrators/role/lock",method = RequestMethod.POST)  
	@ResponseBody
	public ResultBean<Boolean> updateRoleStatus(Long id,Integer status) {
		
		return new ResultBean<Boolean>(sysRoleService.modifyRoleStatusByRoleId(id, status));
	}
	@RequestMapping(value = "/api/administrators/role/delete",method = RequestMethod.DELETE)  
	@ResponseBody
	public ResultBean<Boolean> deleteRole(@RequestBody List<SysRole> ids) {
		
		return new ResultBean<Boolean>(sysRoleService.removeRoleByRoleId(ids));
	}
	
	@RequestMapping(value = "/api/administrators/admin/add/roletype/list",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<List<SysRoleSelectDTO>> findNormalRoleTypeList() {
		
		return new ResultBean<List<SysRoleSelectDTO>>(sysRoleService.findSysRoleNormalList());
	}
	
}
