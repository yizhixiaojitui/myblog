package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.PhoneMessage;
import cn.broccoli.blog.po.PhoneMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhoneMessageMapper {
    int countByExample(PhoneMessageExample example);

    int deleteByExample(PhoneMessageExample example);

    int deleteByPrimaryKey(Integer phoneId);

    int insert(PhoneMessage record);

    int insertSelective(PhoneMessage record);

    List<PhoneMessage> selectByExample(PhoneMessageExample example);

    PhoneMessage selectByPrimaryKey(Integer phoneId);

    int updateByExampleSelective(@Param("record") PhoneMessage record, @Param("example") PhoneMessageExample example);

    int updateByExample(@Param("record") PhoneMessage record, @Param("example") PhoneMessageExample example);

    int updateByPrimaryKeySelective(PhoneMessage record);

    int updateByPrimaryKey(PhoneMessage record);
}