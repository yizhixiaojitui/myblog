package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.UserRank;

public interface UserRankMapper {

    int deleteByPrimaryKey(Integer rankId);

    int insert(UserRank record);

    int insertSelective(UserRank record);

    UserRank selectByPrimaryKey(Integer rankId);

    int updateByPrimaryKeySelective(UserRank record);

    int updateByPrimaryKey(UserRank record);
}