package cn.broccoli.blog.mapper;

import cn.broccoli.blog.dto.SysRoleSelectDTO;
import cn.broccoli.blog.po.SysRole;
import cn.broccoli.blog.po.SysRoleExample;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper {
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);    
    //查询用户名查询所属角色Name
    List<String> selectRoleNameByUserName(@Param("userid")Integer userid);
    //查询全部角色列表
    List<SysRoleSelectDTO> selectRoleList();
    //查询未锁定的角色列表
    List<SysRoleSelectDTO> selectRoleNormalList();
    //根据角色id查询角色列表
    List<SysRole> selectRoleListByRoleId(@Param("id")Long id,@Param("page") int page,@Param("limit") int limit);
    //根据角色id锁定角色
    boolean updateRoleStatusByRoleId(@Param("id")Long id,@Param("status")int status);
    //根据角色id批量删除角色
    boolean deleteRoleByRoleIds(List<SysRole> ids);
}