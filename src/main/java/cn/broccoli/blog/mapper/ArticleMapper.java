package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.Article;
import cn.broccoli.blog.po.ArticleDetails;
import cn.broccoli.blog.po.ArticleList;
import cn.broccoli.blog.utils.ArticleInfo;
import cn.broccoli.blog.utils.ArticleTop;
import cn.broccoli.blog.utils.ArticleHot;
import cn.broccoli.blog.utils.SortList;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    
    ArticleDetails selectByPrimaryKey(@Param("id")Integer id);
    
    List<ArticleList> selectByBlogger(@Param("username")String username,@Param("page") int page);
    
    int selectArticleCount(@Param("userid")Integer userid,@Param("articleId")String articleId,@Param("articleName")String articleName,@Param("articleStatus")String articleStatus);
    
    int insertArticle(Article article);
    
    List<ArticleList> selectArticleByUserid(@Param("userid")Integer userid,@Param("page") int page,@Param("limit") int limit,@Param("articleId")String articleId,@Param("articleName")String articleName,@Param("articleStatus")String articleStatus);
    
    boolean deleteArticleById(List<ArticleList> ids);
    
    int selectByTagsID(List<SortList> ids);
    
    ArticleInfo selectArticle(@Param("userid")Integer userid,@Param("articleid")Integer articleid);
    
    int updateArticle(ArticleInfo articleinfo);
    
    List<ArticleHot> selectArticleHot(Integer userid);
    
    List<ArticleTop> selectArticleTop(Integer userid);
}