package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.Shuoshuo;

public interface ShuoshuoMapper {

    int deleteByPrimaryKey(Integer shuoId);

    int insert(Shuoshuo record);

    int insertSelective(Shuoshuo record);

    Shuoshuo selectByPrimaryKey(Integer shuoId);

    int updateByPrimaryKeySelective(Shuoshuo record);

    int updateByPrimaryKey(Shuoshuo record);
}