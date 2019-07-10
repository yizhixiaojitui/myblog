package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.PowerList;

public interface PowerListMapper {

    int deleteByPrimaryKey(Integer pId);

    int insert(PowerList record);

    int insertSelective(PowerList record);

    PowerList selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(PowerList record);

    int updateByPrimaryKey(PowerList record);
}