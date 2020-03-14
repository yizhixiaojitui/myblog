package cn.broccoli.blog.service;

import java.util.List;

import cn.broccoli.blog.po.SysRoleAuthority;

public interface SysRoleAuthorityService {

	List<String> findAuthorityByUserid(Integer userid);
	
	List<Long> findAuthIdByRoleId(Long roleId);
}
