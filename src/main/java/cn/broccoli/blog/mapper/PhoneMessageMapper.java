package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.PhoneMessage;

public interface PhoneMessageMapper {

    int deleteByPrimaryKey(Integer phoneId);

    int insert(PhoneMessage record);

    int insertSelective(PhoneMessage record);

    PhoneMessage selectByPrimaryKey(Integer phoneId);

    int updateByPrimaryKeySelective(PhoneMessage record);

    int updateByPrimaryKey(PhoneMessage record);
}