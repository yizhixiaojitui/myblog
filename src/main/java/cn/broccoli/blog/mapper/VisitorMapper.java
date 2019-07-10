package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.Visitor;

public interface VisitorMapper {

    int deleteByPrimaryKey(Integer vId);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    Visitor selectByPrimaryKey(Integer vId);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKey(Visitor record);
}