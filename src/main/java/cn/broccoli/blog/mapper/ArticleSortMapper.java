package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.ArticleSort;
import cn.broccoli.blog.po.ArticleSortExample;
import cn.broccoli.blog.utils.TagsList;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ArticleSortMapper {
    int countByExample(ArticleSortExample example);

    int deleteByExample(ArticleSortExample example);

    int deleteByPrimaryKey(Integer sortArticleId);

    boolean insert(ArticleSort record);

    int insertSelective(ArticleSort record);

    List<ArticleSort> selectByExample(ArticleSortExample example);

    ArticleSort selectByPrimaryKey(Integer sortArticleId);

    int updateByExampleSelective(@Param("record") ArticleSort record, @Param("example") ArticleSortExample example);

    int updateByExample(@Param("record") ArticleSort record, @Param("example") ArticleSortExample example);

    int updateByPrimaryKeySelective(ArticleSort record);

    int updateByPrimaryKey(ArticleSort record);
    
    List<Map<Integer, String>> selectByUserId(@Param("userid")int userId);
    
    List<TagsList> selectTagsBylimit(@Param("userid")Integer userid,@Param("page") int page,
    		@Param("limit") int limit,@Param("sortArticleId")String sortArticleId,@Param("sortArticleName") String sortArticleName);
    
    int selectTagBylimitCount(@Param("userid")Integer userid,@Param("sortArticleId")String sortArticleId,@Param("sortArticleName") String sortArticleName);

    boolean deleteTagsById(List<TagsList> ids);

    int updateById(TagsList tl);

    ArticleSort selectByName(@Param("userid") Integer userid,@Param("name")String name);

}