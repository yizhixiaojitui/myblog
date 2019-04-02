package cn.broccoli.blog.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.broccoli.blog.mapper.ArticleMapper;
import cn.broccoli.blog.mapper.ArticleSortMapper;
import cn.broccoli.blog.mapper.UserMapper;
import cn.broccoli.blog.po.Article;
import cn.broccoli.blog.po.ArticleDetails;
import cn.broccoli.blog.po.ArticleList;
import cn.broccoli.blog.po.ArticleSort;
import cn.broccoli.blog.service.ArticleService;
import plm.common.exceptions.UnloginException;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService{
	private static Logger logger = Logger.getLogger(ArticleServiceImpl.class);
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ArticleSortMapper articleSortMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<ArticleList> getAll(String username, int pageIndex) {
		
		return articleMapper.selectByBlogger(username, pageIndex);
	}

	@Override
	public List<ArticleList> findArticleList(String username, int page) {
		
		int pageIndex=(page-1)*10;
		List<ArticleList> result=articleMapper.selectByBlogger(username, pageIndex);
		return result;
	}

	@Override
	public ArticleDetails findArticleDetails(Integer id) {
		ArticleDetails ad=articleMapper.selectByPrimaryKey(id);
		System.out.println("findArticleDetails"+ad);
		return ad;
	}

	@Override
	public List<Map<Integer, String>> findArticleSortList(String username) {
		return  articleSortMapper.selectByUserId(userMapper.selectIdByName(username));
	}

	@Override
	public Boolean addArticleSort(String name, String articlesort) {
		ArticleSort articleSort=new ArticleSort();
		articleSort.setSortArticleName(articlesort);
		articleSort.setUserId(userMapper.selectIdByName(name));
		boolean result=articleSortMapper.insert(articleSort);
		return result;
	}

	@Override
	public int findArticleCount(String name) {
		int userid=userMapper.selectIdByName(name);
		return articleMapper.selectArticleCount(userid);
	}

	@Override
	public int saveArticle(Article article) {
		article.setArticleTime(new Date());
		article.setUserId(10001);
		article.setArticleIp("127.0.0.1");
		article.setArticleClick(0);
		logger.info("==========="+article.toString());
		int i=articleMapper.insertArticle(article);
		logger.info("code:"+article.getArticleStatus());
		return i;
		
	}

	@Override
	public List<ArticleList> findAllArticleList(int page, int limit,String articleId,String articleName,String articleStatus) {
		int pageIndex=(page-1)*limit;
		System.out.println(articleId);
		return  articleMapper.selectArticleByUserid(10001, pageIndex, limit,articleId,articleName,articleStatus);
	}

	/* (non-Javadoc)
	 * @see cn.broccoli.blog.service.ArticleService#removeArticle(java.util.List)
	 */
	@Override
	public boolean removeArticleByIds(List<ArticleList> list) {
		
		return articleMapper.deleteArticleById(list);
	}

	/* (non-Javadoc)
	 * @see cn.broccoli.blog.service.ArticleService#test()
	 */
	@Override
	public boolean test() {
		int i=1;
		if(i==1) {
		throw new UnloginException();
		}
		return false;
	}

}
