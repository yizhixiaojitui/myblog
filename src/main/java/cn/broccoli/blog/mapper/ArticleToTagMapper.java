package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.ArticleToTag;
import cn.broccoli.blog.po.ArticleToTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleToTagMapper {
    int countByExample(ArticleToTagExample example);

    int deleteByExample(ArticleToTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(@Param("articleId")Short articleId,@Param("tagId")Integer tagId);

    int insertSelective(ArticleToTag record);

    List<ArticleToTag> selectByExample(ArticleToTagExample example);

    ArticleToTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleToTag record, @Param("example") ArticleToTagExample example);

    int updateByExample(@Param("record") ArticleToTag record, @Param("example") ArticleToTagExample example);

    int updateByPrimaryKeySelective(ArticleToTag record);

    int updateByPrimaryKey(ArticleToTag record);
}