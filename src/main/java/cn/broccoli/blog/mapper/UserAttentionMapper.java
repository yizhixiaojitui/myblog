package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.UserAttention;

public interface UserAttentionMapper {
    
    int deleteByPrimaryKey(Short aId);

    int insert(UserAttention record);

    int insertSelective(UserAttention record);

    UserAttention selectByPrimaryKey(Short aId);

    int updateByPrimaryKeySelective(UserAttention record);

    int updateByPrimaryKey(UserAttention record);
}