package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.Photos;

public interface PhotosMapper {

    int deleteByPrimaryKey(Integer photoId);

    int insert(Photos record);

    int insertSelective(Photos record);

    Photos selectByPrimaryKey(Integer photoId);

    int updateByPrimaryKeySelective(Photos record);

    int updateByPrimaryKey(Photos record);
}