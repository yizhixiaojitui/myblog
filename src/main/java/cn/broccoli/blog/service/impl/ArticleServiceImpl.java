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
import org.springframework.transaction.annotation.Transactional;

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
import cn.broccoli.blog.utils.TagResultMap;
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
		//字符串分割标签名称
		List<Integer> tagId=new ArrayList<Integer>();
		//初始化标签id list
		Tag tag=new Tag();
		//初始化tag
		//获取真实ip地址
		String ip=CusAccessObjectUtil.getIpAddress(request);
		article.setArticleTime(new Date());
		article.setUserId(jwtUtil.getUserId(request));
		article.setArticleIp(ip);
		article.setArticleClick(0);
		int count=articleMapper.insertArticle(article);
		logger.info("插入文章返回ID："+count);
		//分割标签字符 添加标签
		for (int i = 0; i < taglist.length; i++) {
			if(taglist[i]!="") {
				//去掉字符前后空格
				tag.setTagName(taglist[i].trim());
				Integer code=tagMapper.insert(tag);
				tagId.add(tag.getId());
				logger.info("插入标签返回code："+code+" 插入标签id："+tag.getId()+"插入的标签名称："+taglist[i]);
			}
		}
		for (int i=0;i<tagId.size();i++) {
			articleToTagMapper.insert(article.getArticleId(),tagId.get(i));
			logger.info("插入文章标签关联表 文章id："+article.getArticleId()+" 标签id"+tagId.get(i));
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
		//删除标签文章关联表  修改tagnum数量
		for (ArticleList articleList : list) {
			List<TagResultMap> taglist=tagMapper.selectByArticleId(articleList.getArticleId().intValue());
			//文章已去掉的tag  修改tag表文章数量-1
			tagMapper.updateArticleNumById(taglist);
			//删除文章tag关联表已去掉的tag
			articleToTagMapper.deleteByIds(taglist);
		}
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
		//先去查询tag article表 查询tagid   根据tagid查询 tag name id  list 与表单传过来的遍历对比 存在的删除list 得到文章修改已删除的tag 和未添加的tag
		//存在的减1 不存在的添加
		//如果一样 删除掉 里面就剩
		//查询文章已添加的tag
		List<TagResultMap> taglist=tagMapper.selectByArticleId(articleinfo.getArticleId().intValue());
		//获取拆分前台传递过来的tag 获得数组
		String [] arrayTags=articleinfo.getArticleLabel().split(",");
		//初始化去重list
		List<String> changeTags = new ArrayList<String>();
		//数组去重
		for (int i=0; i<arrayTags.length; i++) {
			 if(!changeTags.contains(arrayTags[i].trim())) {
				    //赋值给去重list
				 changeTags.add(arrayTags[i].trim());
	            }
        }
		//初始化未添加的tags list
		List<String> tags = new ArrayList<String>(changeTags);
		//
		List<TagResultMap> removeTags=new ArrayList<TagResultMap>(taglist); 
		//倒序循环对比已添加的tag与前台传来的tag list
		for (String string : changeTags){ 
			for (TagResultMap tagResultMap : taglist) {
				if(tagResultMap.getTagName().equals(string)) {
					//删除文章已添加的tag 剩下的就是文章修改 去掉的tag 
					removeTags.remove(tagResultMap);
					//得到要未添加的标签
					tags.remove(string);
				}
			}
		}
		Tag tag=new Tag();
		//循环添加tag   tag文章关联表
		for (String str:tags) {
			if(str!=""||str!=null) {
				tag.setTagName(str);
				Integer code=tagMapper.insert(tag);
				articleToTagMapper.insert(articleinfo.getArticleId(),tag.getId());
				logger.info("article update=>插入标签返回code："+code+" 插入标签id："+tag.getId()+"插入的标签名称："+str);
			}
		}
		//判断list是否为空 
		if(removeTags!=null&&removeTags.size()>0) {
			//文章已去掉的tag  修改tag表文章数量
			tagMapper.updateArticleNumById(removeTags);
			//删除文章tag关联表已去掉的tag
			articleToTagMapper.deleteByIds(removeTags);
		}
		
		
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
