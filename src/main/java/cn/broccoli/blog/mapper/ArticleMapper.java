package cn.broccoli.blog.mapper;

import cn.broccoli.blog.po.Article;
import cn.broccoli.blog.po.ArticleDetails;
import cn.broccoli.blog.po.ArticleList;
import cn.broccoli.blog.utils.ArticleInfo;
import cn.broccoli.blog.utils.ArticleTop;
import cn.broccoli.blog.utils.ArticleHot;
import cn.broccoli.blog.utils.SortList;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    //根据文章id 查询文章详细信息  主页文章详细页用
    ArticleDetails selectByPrimaryKey(@Param("id")Integer id);
    //根据用户名 当前页信息查询主页文章列表
    List<ArticleList> selectByBlogger(@Param("username")String username,@Param("page") int page);
    //查询文章数量
    int selectArticleCount(@Param("userid")Integer userid,@Param("articleId")String articleId,@Param("articleName")String articleName,@Param("articleStatus")String articleStatus);
    
    int insertArticle(Article article);
    //根据用户名 分页信息 分页查询文章列表
    List<ArticleList> selectArticleByUserid(@Param("userid")Integer userid,@Param("page") int page,@Param("limit") int limit,@Param("articleId")String articleId,@Param("articleName")String articleName,@Param("articleStatus")String articleStatus);
    //根据文章id list删除文章
    boolean deleteArticleById(List<ArticleList> ids);
    //根据分类id查询文章数量
    int selectByTagsID(List<SortList> ids);
    //根据用户信息和文章id查询文章信息
    ArticleInfo selectArticle(@Param("userid")Integer userid,@Param("articleid")Integer articleid);
    //修改文章  --加个用户信息
    int updateArticle(ArticleInfo articleinfo);
    //查询主页阅读榜单
    List<ArticleHot> selectArticleHot(Integer userid);
    //查询主页推荐榜单
    List<ArticleTop> selectArticleTop(Integer userid);
    //根据用户和标签查询文章列表
    List<ArticleList> selectArticleByTagName(@Param("userName")String userName,@Param("tagName")String tagName );
    //根据用户和模块查询文章列表
    List<ArticleList> selectArticleByModule(@Param("userName")String userName,@Param("module")int module );
}