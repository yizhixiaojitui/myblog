package cn.broccoli.blog.service;

import java.util.List;

import cn.broccoli.blog.dto.SysRoleDTO;
import cn.broccoli.blog.dto.SysRoleSelectDTO;
import cn.broccoli.blog.po.SysRole;
import cn.broccoli.blog.utils.RoleBody;

public interface SysRoleService {

	//根据用户id查询用户拥有的角色信息
	List<String> findRoleNameByUserId(Integer userid);
	//新增角色
	boolean addRole(RoleBody roleBody);
	//查询角色列表
	List<SysRoleSelectDTO> findSysRoleList();
	//查询角色列表
	List<SysRoleSelectDTO> findSysRoleNormalList();
	//根据搜索条件查询角色列表
	List<SysRole> findSysRoleListById(Long role,int page,Integer limit);
	
	SysRole findSysRoleById();
	//修改角色与权限
	boolean modifyRole(SysRoleDTO sysRoleDTO);
	//修改角色状态
	boolean modifyRoleStatusByRoleId(Long id,int status);
	//删除角色
	boolean removeRoleByRoleId(List<SysRole> sysRole);
}
