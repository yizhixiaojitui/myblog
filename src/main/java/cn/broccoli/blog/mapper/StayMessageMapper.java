package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.StayMessage;

public interface StayMessageMapper {

    int deleteByPrimaryKey(Short stayId);

    int insert(StayMessage record);

    int insertSelective(StayMessage record);
    
    StayMessage selectByPrimaryKey(Short stayId);

    int updateByPrimaryKeySelective(StayMessage record);

    int updateByPrimaryKey(StayMessage record);
}