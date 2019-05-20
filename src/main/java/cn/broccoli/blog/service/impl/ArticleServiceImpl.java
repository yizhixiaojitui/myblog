package cn.broccoli.blog.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.broccoli.blog.mapper.ArticleMapper;
import cn.broccoli.blog.mapper.ArticleSortMapper;
import cn.broccoli.blog.mapper.ArticleToTagMapper;
import cn.broccoli.blog.mapper.TagMapper;
import cn.broccoli.blog.mapper.UserMapper;
import cn.broccoli.blog.po.Article;
import cn.broccoli.blog.po.ArticleDetails;
import cn.broccoli.blog.po.ArticleList;
import cn.broccoli.blog.po.ArticleSort;
import cn.broccoli.blog.po.ArticleToTag;
import cn.broccoli.blog.po.Tag;
import cn.broccoli.blog.service.ArticleService;
import cn.broccoli.blog.utils.ArticleInfo;
import cn.broccoli.blog.utils.ArticleTop;
import cn.broccoli.blog.utils.CusAccessObjectUtil;
import cn.broccoli.blog.utils.JWTUtil;
import cn.broccoli.blog.utils.SortList;
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
	private TagMapper tagMapper;
	@Autowired
	private ArticleToTagMapper articleToTagMapper;
	@Autowired
	JWTUtil jwtUtil;

	/**
	* <p>Title: getAll</p>  
	* <p>Description: 主页获取文章分页列表</p>  
	* @param username
	* @param pageIndex
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#getAll(java.lang.String, int)  
	*/ 
	@Override
	public List<ArticleList> getAll(String username, int pageIndex) {
		
		return articleMapper.selectByBlogger(username, pageIndex);
	}

	/**
	* <p>Title: findArticleList</p>  
	* <p>Description: 查询后台文章列表</p>  
	* @param username
	* @param page
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#findArticleList(java.lang.String, int)  
	*/ 
	@Override
	public List<ArticleList> findArticleList(String username, int page) {
		
		int pageIndex=(page-1)*10;
		List<ArticleList> result=articleMapper.selectByBlogger(username, pageIndex);
		return result;
	}

	/**
	* <p>Title: findArticleDetails</p>  
	* <p>Description: </p>  
	* @param id
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#findArticleDetails(java.lang.Integer)  
	*/ 
	@Override
	public ArticleDetails findArticleDetails(Integer id) {
		ArticleDetails ad=articleMapper.selectByPrimaryKey(id);
		if(ad==null) {
			
		}
		System.out.println("findArticleDetails"+ad);
		return ad;
	}

	/**
	* <p>Title: findArticleSortList</p>  
	* <p>Description: 查询文章分类列表回填下拉框</p>  
	* @param userid
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#findArticleSortList(java.lang.Integer)  
	*/ 
	@Override
	public List<Map<Integer, String>> findArticleSortList(Integer userid) {
		return  articleSortMapper.selectByUserId(userid);
	}

	/**
	* <p>Title: addArticleSort</p>  
	* <p>Description: 新增文章分类</p>  
	* @param userid
	* @param articlesort
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#addArticleSort(java.lang.Integer, java.lang.String)  
	*/ 
	@Override
	public Boolean addArticleSort(Integer userid, String articlesort) {
		//判断分类是否存在
		if(articleSortMapper.selectByName(userid, articlesort)!=null) {
			throw new CheckException("分类已存在！请检查");
		}
		ArticleSort articleSort=new ArticleSort();
		articleSort.setSortArticleName(articlesort);
		articleSort.setUserId(userid);
		boolean result=articleSortMapper.insert(articleSort);
		return result;
	}

	/**
	* <p>Title: findArticleLimitCount</p>  
	* <p>Description: 后台管理获取文章分页</p>  
	* @param userid
	* @param articleId
	* @param articleName
	* @param articleStatus
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#findArticleLimitCount(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)  
	*/ 
	@Override
	public int findArticleLimitCount(Integer userid,String articleId,String articleName,String articleStatus) {
		return articleMapper.selectArticleCount(userid, articleId, articleName, articleStatus);
	}


	/**
	* <p>Title: saveArticle</p>  
	* <p>Description: 新增保存文章</p>  
	* @param article
	* @param request
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#saveArticle(cn.broccoli.blog.po.Article, javax.servlet.http.HttpServletRequest)  
	*/ 
	@Override
	public int saveArticle(Article article,HttpServletRequest request) {

		//存储过程比较好 这样效率很低
		String [] taglist=article.getArticleLabel().split(",");
		List<Integer> tagId=new ArrayList<Integer>();
		
		Tag tag=new Tag();
		ArticleToTag articleToTag=new ArticleToTag();
		//获取真实ip地址
		String ip=CusAccessObjectUtil.getIpAddress(request);
		article.setArticleTime(new Date());
		article.setUserId(jwtUtil.getUserId(request));
		article.setArticleIp(ip);
		article.setArticleClick(0);
		logger.info("==========="+article.toString());
		int count=articleMapper.insertArticle(article);
		logger.info("======文章ID====="+count);
		//分割标签字符 添加标签
		for (int i = 0; i < taglist.length; i++) {
			if(taglist[i]!="") {
				System.out.println("tagName:"+taglist[i]);
				tag.setTagName(taglist[i]);
				Integer tid=tagMapper.insert(tag);
				System.out.println("tagId"+tid);
				tagId.add(tid);
			}
		}
		articleToTag.setArticleId(count);
		for (Iterator iterator = tagId.iterator(); iterator.hasNext();) {
			logger.info("======tagID====="+(Integer)iterator.next());
			articleToTag.setTagId((Integer)iterator.next());
			articleToTagMapper.insert(articleToTag);
		}
		return article.getArticleId();
		
	}

	/**
	* <p>Title: findAllArticleList</p>  
	* <p>Description: 获取文章列表</p>  
	* @param userid
	* @param page
	* @param limit
	* @param articleId
	* @param articleName
	* @param articleStatus
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#findAllArticleList(java.lang.Integer, int, int, java.lang.String, java.lang.String, java.lang.String)  
	*/ 
	@Override
	public List<ArticleList> findAllArticleList(Integer userid,int page, int limit,String articleId,String articleName,String articleStatus) {
		page=(page-1)*limit;
		return  articleMapper.selectArticleByUserid(userid, page, limit,articleId,articleName,articleStatus);
	}

	/**
	* <p>Title: removeArticleByIds</p>  
	* <p>Description: 根据文章ID删除文章</p>  
	* @param list
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#removeArticleByIds(java.util.List)  
	*/ 
	@Override
	public boolean removeArticleByIds(List<ArticleList> list) {
		
		return articleMapper.deleteArticleById(list);
	}

	@Override
	public List<ArticleTop> test() {
		return articleMapper.selectArticleTop(10001);
	}

	/**
	* <p>Title: findTagsList</p>  
	* <p>Description: 获取文章分类列表</p>  
	* @param userid
	* @param page
	* @param limit
	* @param sortArticleId
	* @param sortArticleName
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#findTagsList(java.lang.Integer, int, int, java.lang.String, java.lang.String)  
	*/ 
	@Override
	public List<SortList> findTagsList(Integer userid, int page, int limit, String sortArticleId, String sortArticleName) {
		page=(page-1)*limit;
		return articleSortMapper.selectTagsBylimit(userid, page, limit, sortArticleId, sortArticleName);
	}

	/**
	* <p>Title: findArticleCount</p>  
	* <p>Description: 获取文章总行数</p>  
	* @param userid
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#findArticleCount(java.lang.Integer)  
	*/ 
	@Override
	public int findArticleCount(Integer userid) {
		// TODO Auto-generated method stub
		return articleMapper.selectArticleCount(userid, null, null, null);
	}

	
	/**
	* <p>Title: findTagsCount</p>  
	* <p>Description: </p>  
	* @param userid
	* @param sortArticleId
	* @param sortArticleName
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#findTagsCount(java.lang.Integer, java.lang.String, java.lang.String)  
	*/ 
	@Override
	public int findTagsCount(Integer userid, String sortArticleId, String sortArticleName) {
		return articleSortMapper.selectTagBylimitCount(userid, sortArticleId, sortArticleName);
	}

	/**
	* <p>Title: removeTags</p>  
	* <p>Description: 删除文章分类</p>  
	* @param ids
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#removeTags(java.util.List)  
	*/ 
	@Override
	public boolean removeTags(List<SortList> ids) {
		// TODO Auto-generated method stub
		//删除分类检查是否有文章引用了这个分类
		int code=articleMapper.selectByTagsID(ids);
		if(code!=0) {
			throw new CheckException("有文章使用了id请检查后在删除！");
		}else {
		return articleSortMapper.deleteTagsById(ids);
		}
	}

	/**
	* <p>Title: findArticleInfo</p>  
	* <p>Description: 查询文章信息回填表单</p>  
	* @param userid
	* @param articleid
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#findArticleInfo(java.lang.Integer, java.lang.Integer)  
	*/ 
	@Override
	public ArticleInfo findArticleInfo(Integer userid, Integer articleid) {
		// TODO Auto-generated method stub
		ArticleInfo articleinfo=articleMapper.selectArticle(userid, articleid);
		System.out.println(articleinfo);
		return articleinfo;
	}

	/**
	* <p>Title: modifyArticle</p>  
	* <p>Description: 修改文章</p>  
	* @param articleinfo
	* @param userid
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#modifyArticle(cn.broccoli.blog.utils.ArticleInfo, java.lang.Integer)  
	*/ 
	@Override
	public int modifyArticle(ArticleInfo articleinfo,Integer userid) {
		articleinfo.setUserId(userid);
		
		return articleMapper.updateArticle(articleinfo);
	}

	/**
	* <p>Title: modifyTags</p>  
	* <p>Description:修改文章分类 </p>  
	* @param tl
	* @return  
	* @see cn.broccoli.blog.service.ArticleService#modifyTags(cn.broccoli.blog.utils.SortList)  
	*/ 
	@Override
	public int modifyTags(SortList tl) {
		// TODO Auto-generated method stub
		return articleSortMapper.updateById(tl);
	}

}
