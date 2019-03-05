package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.Shuoshuo;
import cn.broccoli.blog.po.ShuoshuoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShuoshuoMapper {
    int countByExample(ShuoshuoExample example);

    int deleteByExample(ShuoshuoExample example);

    int deleteByPrimaryKey(Integer shuoId);

    int insert(Shuoshuo record);

    int insertSelective(Shuoshuo record);

    List<Shuoshuo> selectByExample(ShuoshuoExample example);

    Shuoshuo selectByPrimaryKey(Integer shuoId);

    int updateByExampleSelective(@Param("record") Shuoshuo record, @Param("example") ShuoshuoExample example);

    int updateByExample(@Param("record") Shuoshuo record, @Param("example") ShuoshuoExample example);

    int updateByPrimaryKeySelective(Shuoshuo record);

    int updateByPrimaryKey(Shuoshuo record);
}