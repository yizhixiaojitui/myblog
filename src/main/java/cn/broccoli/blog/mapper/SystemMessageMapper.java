package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.SystemMessage;
import cn.broccoli.blog.po.SystemMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemMessageMapper {
    int countByExample(SystemMessageExample example);

    int deleteByExample(SystemMessageExample example);

    int deleteByPrimaryKey(Integer systemId);

    int insert(SystemMessage record);

    int insertSelective(SystemMessage record);

    List<SystemMessage> selectByExample(SystemMessageExample example);

    SystemMessage selectByPrimaryKey(Integer systemId);

    int updateByExampleSelective(@Param("record") SystemMessage record, @Param("example") SystemMessageExample example);

    int updateByExample(@Param("record") SystemMessage record, @Param("example") SystemMessageExample example);

    int updateByPrimaryKeySelective(SystemMessage record);

    int updateByPrimaryKey(SystemMessage record);
}