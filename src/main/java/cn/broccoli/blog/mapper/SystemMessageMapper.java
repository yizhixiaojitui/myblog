package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.SystemMessage;


public interface SystemMessageMapper {
  
    int deleteByPrimaryKey(Integer systemId);

    int insert(SystemMessage record);

    int insertSelective(SystemMessage record);

    SystemMessage selectByPrimaryKey(Integer systemId);

    int updateByPrimaryKeySelective(SystemMessage record);

    int updateByPrimaryKey(SystemMessage record);
}