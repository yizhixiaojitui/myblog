package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.StayMessage;
import cn.broccoli.blog.po.StayMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StayMessageMapper {
    int countByExample(StayMessageExample example);

    int deleteByExample(StayMessageExample example);

    int deleteByPrimaryKey(Short stayId);

    int insert(StayMessage record);

    int insertSelective(StayMessage record);

    List<StayMessage> selectByExample(StayMessageExample example);

    StayMessage selectByPrimaryKey(Short stayId);

    int updateByExampleSelective(@Param("record") StayMessage record, @Param("example") StayMessageExample example);

    int updateByExample(@Param("record") StayMessage record, @Param("example") StayMessageExample example);

    int updateByPrimaryKeySelective(StayMessage record);

    int updateByPrimaryKey(StayMessage record);
}