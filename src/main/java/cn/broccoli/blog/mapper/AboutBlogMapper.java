package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.AboutBlog;
import cn.broccoli.blog.po.AboutBlogExample;
import cn.broccoli.blog.po.BlogMessage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AboutBlogMapper {
    int countByExample(AboutBlogExample example);

    int deleteByExample(AboutBlogExample example);

    int deleteByPrimaryKey(Integer blogId);

    int insert(AboutBlog record);

    int insertSelective(AboutBlog record);

    List<AboutBlog> selectByExample(AboutBlogExample example);

    BlogMessage selectBlogMessage(@Param("id")Integer id);

    int updateByExampleSelective(@Param("record") AboutBlog record, @Param("example") AboutBlogExample example);

    int updateByExample(@Param("record") AboutBlog record, @Param("example") AboutBlogExample example);

    int updateByPrimaryKeySelective(AboutBlog record);

    int updateByPrimaryKey(AboutBlog record);
}