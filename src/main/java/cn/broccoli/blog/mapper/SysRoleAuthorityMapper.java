package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.SysRoleAuthority;
import cn.broccoli.blog.po.SysRoleAuthorityExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysRoleAuthorityMapper {
    int countByExample(SysRoleAuthorityExample example);

    int deleteByExample(SysRoleAuthorityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleAuthority record);

    int insertSelective(SysRoleAuthority record);

    List<SysRoleAuthority> selectByExample(SysRoleAuthorityExample example);

    SysRoleAuthority selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoleAuthority record, @Param("example") SysRoleAuthorityExample example);

    int updateByExample(@Param("record") SysRoleAuthority record, @Param("example") SysRoleAuthorityExample example);

    int updateByPrimaryKeySelective(SysRoleAuthority record);

    int updateByPrimaryKey(SysRoleAuthority record);
    //根据用户id查询角色权限列表
    List<String> selectByUserId(@Param("userid") Integer userid);
    //插入角色权限
    boolean insertByRoleIdOrAuthid(@Param("list")List<SysRoleAuthority> list);
    //根据角色id查询角色权限id
    List<Long> selectAuthIdByRoleId(@Param("roleId")Long roleId);
    //根据角色id删除全部角色权限
    boolean deleteByRoleId(@Param("roleId")Long roleId);
    
    
}