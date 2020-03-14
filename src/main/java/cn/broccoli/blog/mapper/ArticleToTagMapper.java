package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.ArticleToTag;
import cn.broccoli.blog.utils.TagResultMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ArticleToTagMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(@Param("articleId")Short articleId,@Param("tagId")Integer tagId);

    int insertSelective(ArticleToTag record);


    ArticleToTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleToTag record);

    int updateByPrimaryKey(ArticleToTag record);
    
    int deleteByIds(List<TagResultMap> taglist);
    
    int insertByArticleIdOrTagId(@Param("map")Map<String, Object> map);
}