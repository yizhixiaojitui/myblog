package cn.broccoli.blog.service;


import java.util.List;
import java.util.Map;

import cn.broccoli.blog.po.Article;
import cn.broccoli.blog.po.ArticleDetails;
import cn.broccoli.blog.po.ArticleList;

public interface ArticleService {
	 ArticleDetails findArticleDetails(Integer id);
	
	 List<ArticleList> getAll(String username,int pageIndex);
	 
	 List<ArticleList> findArticleList(String username,int page);
	 
	 List<Map<Integer, String>> findArticleSortList(String username);
	 
	 Boolean addArticleSort(String name,String articlesort);
	 
	 int findArticleCount(String name);
	 
	 int saveArticle(Article article);
	 
	 List<ArticleList> findAllArticleList(int page,int limit,String articleId,String articleName,String articleStatus);
	 
	 boolean removeArticleByIds(List<ArticleList> list);
}
