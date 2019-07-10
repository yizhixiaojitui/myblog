package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.Friend;

public interface FriendMapper {

    int deleteByPrimaryKey(Short fId);

    int insert(Friend record);

    int insertSelective(Friend record);

    Friend selectByPrimaryKey(Short fId);

    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);
}