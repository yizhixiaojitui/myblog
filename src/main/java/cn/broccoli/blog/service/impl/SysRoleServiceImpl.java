package cn.broccoli.blog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.broccoli.blog.dto.SysRoleDTO;
import cn.broccoli.blog.dto.SysRoleSelectDTO;
import cn.broccoli.blog.mapper.SysRoleAuthorityMapper;
import cn.broccoli.blog.mapper.SysRoleMapper;
import cn.broccoli.blog.po.SysRole;
import cn.broccoli.blog.po.SysRoleAuthority;
import cn.broccoli.blog.service.SysRoleService;
import cn.broccoli.blog.utils.Menu;
import cn.broccoli.blog.utils.RoleBody;
@Service("SysRoleService")
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	SysRoleMapper sysRoleMapper;
	@Autowired
	SysRoleAuthorityMapper sysRoleAuthorityMapper;
	
	@Override
	//根据用户名查询所属权限名称
	public List<String> findRoleNameByUserId(Integer userid) {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectRoleNameByUserName(userid);
	}
	@Override
	public boolean addRole(RoleBody roleBody) {
		// TODO Auto-generated method stub
		SysRole sysRole=new SysRole();
		sysRole.setRoleName(roleBody.getRoleName());
		sysRole.setDescription(roleBody.getDesciption());
		sysRole.setCreateTime(new Date());
		sysRole.setStatus(0);
		sysRoleMapper.insert(sysRole);
		
		List<Menu> menuList=(List<Menu>) JSON.parseArray(roleBody.getMenu(),Menu.class);
		List<SysRoleAuthority> sysRoleAuthorityList=new ArrayList<SysRoleAuthority>();
		for (Menu menu1 : menuList) {
			sysRoleAuthorityList.add(new SysRoleAuthority(menu1.getId(), sysRole.getId()));
			if(null!=menu1.getChildren()) {
				for (Menu menu2 : menu1.getChildren()) {
					sysRoleAuthorityList.add(new SysRoleAuthority(menu2.getId(), sysRole.getId()));
					if(null!=menu2.getChildren()) {
						for (Menu menu3 : menu2.getChildren()) {
							sysRoleAuthorityList.add(new SysRoleAuthority(menu3.getId(), sysRole.getId()));
						}
					}
				}
			}
		}
		
		return sysRoleAuthorityMapper.insertByRoleIdOrAuthid(sysRoleAuthorityList);
	}
	@Override
	public List<SysRoleSelectDTO> findSysRoleList() {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectRoleList();
	}
	@Override
	public List<SysRole> findSysRoleListById(Long role,int page,Integer limit) {
		page=(page-1)*limit;
		return sysRoleMapper.selectRoleListByRoleId(role,page,limit);
	}
	@Override
	public SysRole findSysRoleById() {

		SysRole sysRole = new SysRole();
		sysRole.setId(1L);
		sysRole.setCreateTime(new Date());
		sysRole.setDescription("SSSSSSSSSSSSS");
		sysRole.setRoleName("aaaaaa");
		sysRole.setStatus(1);
		sysRole.setUpdateTime(new Date());
		return sysRole;
	}
	@Override
	public boolean modifyRole(SysRoleDTO sysRoleDTO) {
		SysRole sysRole = new SysRole();
		sysRole.setId(sysRoleDTO.getId());
		sysRole.setDescription(sysRoleDTO.getDescription());
		sysRole.setRoleName(sysRoleDTO.getRoleName());
		sysRole.setUpdateTime(new Date());
		sysRoleMapper.updateByPrimaryKey(sysRole);
		//删除角色ID全部的权限
		sysRoleAuthorityMapper.deleteByRoleId(sysRoleDTO.getId());
		
		long[] authIdArray = (long[]) ConvertUtils.convert(sysRoleDTO.getAuthId().split(","),long.class);
	
			
		
		
		//创建角色权限list
		List<SysRoleAuthority> sysRoleAuthorityList=new ArrayList<SysRoleAuthority>();
		for (int i = 0; i < authIdArray.length; i++) {
			sysRoleAuthorityList.add(new SysRoleAuthority(authIdArray[i],sysRoleDTO.getId()));
		}
		//重新添加权限
		
		return sysRoleAuthorityMapper.insertByRoleIdOrAuthid(sysRoleAuthorityList);
	}
	@Override
	public boolean modifyRoleStatusByRoleId(Long id, int status) {
		// TODO Auto-generated method stub
		return sysRoleMapper.updateRoleStatusByRoleId(id, status);
	}
	@Override
	public boolean removeRoleByRoleId(List<SysRole> sysRole) {
		// TODO Auto-generated method stub
		return sysRoleMapper.deleteRoleByRoleIds(sysRole);
	}
	@Override
	public List<SysRoleSelectDTO> findSysRoleNormalList() {
		// TODO Auto-generated method stub
		return sysRoleMapper.selectRoleNormalList();
	}

}
