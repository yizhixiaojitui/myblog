/**  
* @Title: TagsArticleList.java  
* @Package cn.broccoli.blog.utils  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Administrator  
* @date 2019年6月28日  
* @version V1.0  
*/
package cn.broccoli.blog.utils;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;

/**  
* @ClassName: TagsArticleList  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author Administrator  
* @date 2019年6月28日  
*    
*/
public class TagsArticleList {

	private Integer tagId;
	
	private String tagName;
	
	private Integer articleNumber;
	
	
	@TableField(exist = false)
	private List<ArticleList> articleList;


	public Integer getTagId() {
		return tagId;
	}


	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}


	public String getTagName() {
		return tagName;
	}


	public void setTagName(String tagName) {
		this.tagName = tagName;
	}


	public Integer getArticleNumber() {
		return articleNumber;
	}


	public void setArticleNumber(Integer articleNumber) {
		this.articleNumber = articleNumber;
	}


	public List<ArticleList> getArticleList() {
		return articleList;
	}


	public void setArticleList(List<ArticleList> articleList) {
		this.articleList = articleList;
	}
	
	
}
