package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.SecretMessage;
import cn.broccoli.blog.po.SecretMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecretMessageMapper {
    int countByExample(SecretMessageExample example);

    int deleteByExample(SecretMessageExample example);

    int deleteByPrimaryKey(Integer secretId);

    int insert(SecretMessage record);

    int insertSelective(SecretMessage record);

    List<SecretMessage> selectByExample(SecretMessageExample example);

    SecretMessage selectByPrimaryKey(Integer secretId);

    int updateByExampleSelective(@Param("record") SecretMessage record, @Param("example") SecretMessageExample example);

    int updateByExample(@Param("record") SecretMessage record, @Param("example") SecretMessageExample example);

    int updateByPrimaryKeySelective(SecretMessage record);

    int updateByPrimaryKey(SecretMessage record);
}