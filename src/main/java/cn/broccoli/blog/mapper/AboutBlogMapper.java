package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.AboutBlog;
import cn.broccoli.blog.utils.BlogMessage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AboutBlogMapper {

    int deleteByPrimaryKey(Integer blogId);

    int insert(AboutBlog record);

    int insertSelective(AboutBlog record);
    
    BlogMessage selectBlogMessage(@Param("id")Integer id);

    int updateByPrimaryKeySelective(AboutBlog record);

    int updateByPrimaryKey(AboutBlog record);
    
    int insertBlog(AboutBlog record);
}