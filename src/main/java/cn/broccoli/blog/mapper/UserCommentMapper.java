package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.UserComment;

public interface UserCommentMapper {

    int deleteByPrimaryKey(Integer cId);

    int insert(UserComment record);

    int insertSelective(UserComment record);

    UserComment selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(UserComment record);

    int updateByPrimaryKey(UserComment record);
}