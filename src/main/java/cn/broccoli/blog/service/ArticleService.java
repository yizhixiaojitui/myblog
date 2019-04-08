package cn.broccoli.blog.service;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.broccoli.blog.po.Article;
import cn.broccoli.blog.po.ArticleDetails;
import cn.broccoli.blog.po.ArticleList;

public interface ArticleService {
	 ArticleDetails findArticleDetails(Integer id);
	
	 List<ArticleList> getAll(String username,int pageIndex);
	 
	 List<ArticleList> findArticleList(String username,int page);
	 
	 List<Map<Integer, String>> findArticleSortList(Integer userid);
	 
	 Boolean addArticleSort(Integer userid,String articlesort);
	 
	 int findArticleCount(Integer userid);
	 
	 int saveArticle(Article article,HttpServletRequest request);
	 
	 List<ArticleList> findAllArticleList(Integer userid,int page,int limit,String articleId,String articleName,String articleStatus);
	 
	 boolean removeArticleByIds(List<ArticleList> list);
	 boolean test();
	 
}
