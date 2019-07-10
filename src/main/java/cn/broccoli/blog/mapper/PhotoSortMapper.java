package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.PhotoSort;

public interface PhotoSortMapper {
  
    int deleteByPrimaryKey(Integer sortImgId);

    int insert(PhotoSort record);

    int insertSelective(PhotoSort record);
   
    PhotoSort selectByPrimaryKey(Integer sortImgId);
   
    int updateByPrimaryKeySelective(PhotoSort record);

    int updateByPrimaryKey(PhotoSort record);
}