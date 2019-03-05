package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.PhotoSort;
import cn.broccoli.blog.po.PhotoSortExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotoSortMapper {
    int countByExample(PhotoSortExample example);

    int deleteByExample(PhotoSortExample example);

    int deleteByPrimaryKey(Integer sortImgId);

    int insert(PhotoSort record);

    int insertSelective(PhotoSort record);

    List<PhotoSort> selectByExample(PhotoSortExample example);

    PhotoSort selectByPrimaryKey(Integer sortImgId);

    int updateByExampleSelective(@Param("record") PhotoSort record, @Param("example") PhotoSortExample example);

    int updateByExample(@Param("record") PhotoSort record, @Param("example") PhotoSortExample example);

    int updateByPrimaryKeySelective(PhotoSort record);

    int updateByPrimaryKey(PhotoSort record);
}