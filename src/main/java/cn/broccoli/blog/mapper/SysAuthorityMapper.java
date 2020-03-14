package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.SysAuthority;
import cn.broccoli.blog.po.SysAuthorityExample;
import cn.broccoli.blog.utils.Menu;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAuthorityMapper {
    int countByExample(SysAuthorityExample example);

    int deleteByExample(SysAuthorityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysAuthority record);

    int insertSelective(SysAuthority record);

    List<SysAuthority> selectByExample(SysAuthorityExample example);

    SysAuthority selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysAuthority record, @Param("example") SysAuthorityExample example);

    int updateByExample(@Param("record") SysAuthority record, @Param("example") SysAuthorityExample example);

    int updateByPrimaryKeySelective(SysAuthority record);

    int updateByPrimaryKey(SysAuthority record);
    
    List<Menu> getAll();
    
    List<Menu> selectMenuByUserId(@Param("userid") Integer userid);
}