package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.UserAttention;
import cn.broccoli.blog.po.UserAttentionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAttentionMapper {
    int countByExample(UserAttentionExample example);

    int deleteByExample(UserAttentionExample example);

    int deleteByPrimaryKey(Short aId);

    int insert(UserAttention record);

    int insertSelective(UserAttention record);

    List<UserAttention> selectByExample(UserAttentionExample example);

    UserAttention selectByPrimaryKey(Short aId);

    int updateByExampleSelective(@Param("record") UserAttention record, @Param("example") UserAttentionExample example);

    int updateByExample(@Param("record") UserAttention record, @Param("example") UserAttentionExample example);

    int updateByPrimaryKeySelective(UserAttention record);

    int updateByPrimaryKey(UserAttention record);
}