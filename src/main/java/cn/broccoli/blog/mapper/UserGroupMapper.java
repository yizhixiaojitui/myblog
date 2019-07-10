package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.UserGroup;

public interface UserGroupMapper {

    int deleteByPrimaryKey(Byte gId);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(Byte gId);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}