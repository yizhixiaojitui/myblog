package cn.broccoli.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.broccoli.blog.mapper.SysRoleAuthorityMapper;
import cn.broccoli.blog.service.SysRoleAuthorityService;
@Service("SysRoleAuthorityService")
public class SysRoleAuthorityServiceImpl implements SysRoleAuthorityService{

	@Autowired
	private SysRoleAuthorityMapper sysRoleAuthorityMapper;
	@Override
	//根据用户id查询权限列表
	public List<String> findAuthorityByUserid(Integer userid) {
		// TODO Auto-generated method stub
		return sysRoleAuthorityMapper.selectByUserId(userid);
	}
	@Override
	public List<Long> findAuthIdByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return sysRoleAuthorityMapper.selectAuthIdByRoleId(roleId);
	}

}
