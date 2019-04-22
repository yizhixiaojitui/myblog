package cn.broccoli.blog.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import cn.broccoli.blog.utils.CusAccessObjectUtil;
import cn.broccoli.blog.utils.JWTUtil;
import cn.broccoli.blog.utils.TagsList;
import plm.common.exceptions.CheckException;
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
	@Autowired
	JWTUtil jwtUtil;

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
		if(ad==null) {
			
		}
		System.out.println("findArticleDetails"+ad);
		return ad;
	}

	@Override
	public List<Map<Integer, String>> findArticleSortList(Integer userid) {
		return  articleSortMapper.selectByUserId(userid);
	}

	@Override
	public Boolean addArticleSort(Integer userid, String articlesort) {
		
		if(articleSortMapper.selectByName(userid, articlesort)!=null) throw new CheckException("分类已存在！请检查");
		ArticleSort articleSort=new ArticleSort();
		articleSort.setSortArticleName(articlesort);
		articleSort.setUserId(userid);
		boolean result=articleSortMapper.insert(articleSort);
		return result;
	}

	@Override
	public int findArticleLimitCount(Integer userid,String articleId,String articleName,String articleStatus) {
		return articleMapper.selectArticleCount(userid, articleId, articleName, articleStatus);
	}


	@Override
	public int saveArticle(Article article,HttpServletRequest request) {
		//获取真实ip地址
		String ip=CusAccessObjectUtil.getIpAddress(request);
		article.setArticleTime(new Date());
		article.setUserId(jwtUtil.getUserId(request));
		article.setArticleIp(ip);
		article.setArticleClick(0);
		logger.info("==========="+article.toString());
		int code=articleMapper.insertArticle(article);
		logger.info("code:"+article.getArticleStatus());
		return code;
		
	}

	@Override
	public List<ArticleList> findAllArticleList(Integer userid,int page, int limit,String articleId,String articleName,String articleStatus) {
		page=(page-1)*limit;
		return  articleMapper.selectArticleByUserid(userid, page, limit,articleId,articleName,articleStatus);
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

	/* (non-Javadoc)
	 * @see cn.broccoli.blog.service.ArticleService#findTagsList(java.lang.Integer, int, int, java.lang.String, java.lang.String)
	 */
	@Override
	public List<TagsList> findTagsList(Integer userid, int page, int limit, String sortArticleId, String sortArticleName) {
		page=(page-1)*limit;
		return articleSortMapper.selectTagsBylimit(userid, page, limit, sortArticleId, sortArticleName);
	}

	/* (non-Javadoc)
	 * @see cn.broccoli.blog.service.ArticleService#findArticleCount(java.lang.Integer)
	 */
	@Override
	public int findArticleCount(Integer userid) {
		// TODO Auto-generated method stub
		return articleMapper.selectArticleCount(userid, null, null, null);
	}

	/* (non-Javadoc)
	 * @see cn.broccoli.blog.service.ArticleService#findTagsCount(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public int findTagsCount(Integer userid, String sortArticleId, String sortArticleName) {
		return articleSortMapper.selectTagBylimitCount(userid, sortArticleId, sortArticleName);
	}

	/* (non-Javadoc)
	 * @see cn.broccoli.blog.service.ArticleService#removeFriendlyLink(java.util.List)
	 */
	@Override
	public boolean removeTags(List<TagsList> ids) {
		// TODO Auto-generated method stub
		//删除分类得检查是否有文章引用了这个分类
		int code=articleMapper.selectByTagsID(ids);
		if(code!=0) {
			throw new CheckException("有文章使用了id请检查后在删除！");
		}else {
		return articleSortMapper.deleteTagsById(ids);
		}
	}

}
