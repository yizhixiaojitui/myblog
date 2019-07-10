package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.Ad;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdMapper {
    int deleteByPrimaryKey(Short adId);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Short adId);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKeyWithBLOBs(Ad record);

    int updateByPrimaryKey(Ad record);
}