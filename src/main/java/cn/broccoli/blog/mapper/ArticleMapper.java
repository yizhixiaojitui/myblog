package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.Article;
import cn.broccoli.blog.po.ArticleDetails;
import cn.broccoli.blog.po.ArticleList;
import cn.broccoli.blog.utils.TagsList;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    
    ArticleDetails selectByPrimaryKey(@Param("id")Integer id);
    
    List<ArticleList> selectByBlogger(@Param("username")String username,@Param("page") int page);
    
    int selectArticleCount(@Param("userid")Integer userid,@Param("articleId")String articleId,@Param("articleName")String articleName,@Param("articleStatus")String articleStatus);
    
    int insertArticle(Article article);
    
    List<ArticleList> selectArticleByUserid(@Param("userid")Integer userid,@Param("page") int page,@Param("limit") int limit,@Param("articleId")String articleId,@Param("articleName")String articleName,@Param("articleStatus")String articleStatus);
    
    boolean deleteArticleById(List<ArticleList> ids);
    
    int selectByTagsID(List<TagsList> ids);
}