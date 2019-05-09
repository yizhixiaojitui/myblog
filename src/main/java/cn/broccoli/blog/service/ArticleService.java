package cn.broccoli.blog.service;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.broccoli.blog.po.Article;
import cn.broccoli.blog.po.ArticleDetails;
import cn.broccoli.blog.po.ArticleList;
import cn.broccoli.blog.utils.ArticleInfo;
import cn.broccoli.blog.utils.TagsList;

public interface ArticleService {
	 ArticleDetails findArticleDetails(Integer id);
	
	 List<ArticleList> getAll(String username,int pageIndex);
	 
	 List<ArticleList> findArticleList(String username,int page);
	 
	 List<Map<Integer, String>> findArticleSortList(Integer userid);
	 
	 Boolean addArticleSort(Integer userid,String articlesort);
	 
	 int findArticleLimitCount(Integer userid,String articleId,String articleName,String articleStatus);
	 
	 int findArticleCount(Integer userid);
	 
	 int saveArticle(Article article,HttpServletRequest request);
	 
	 List<ArticleList> findAllArticleList(Integer userid,int page,int limit,String articleId,String articleName,String articleStatus);
	 
	 boolean removeArticleByIds(List<ArticleList> list);
	 
	 boolean test();
	 
	 List<TagsList> findTagsList(Integer userid,int page,int limit,String sortArticleId,String sortArticleName);
	 
	 int findTagsCount(Integer userid,String sortArticleId,String sortArticleName);
	 
	 boolean removeTags(List<TagsList> ids);
	 
	 ArticleInfo findArticleInfo(Integer userid,Integer articleid);
	 
	 int modifyArticle(ArticleInfo articleinfo,Integer userid);
	 
	 int modifyTags(TagsList tl);
}
