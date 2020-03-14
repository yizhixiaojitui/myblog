/**  
* @Title: TagResultMap.java  
* @Package cn.broccoli.blog.utils  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Administrator  
* @date 2019年5月30日  
* @version V1.0  
*/
package cn.broccoli.blog.utils;

import java.io.Serializable;

/**  
* @ClassName: TagResultMap  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author Administrator  
* @date 2019年5月30日  
*    
*/
public class TagResultMap implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	 private Integer tagId;

	 private Integer articleId;
	    
	 private String tagName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "TagResultMap [id=" + id + ", tagId=" + tagId + ", articleId=" + articleId + ", tagName=" + tagName
				+ ", getId()=" + getId() + ", getTagId()=" + getTagId() + ", getArticleId()=" + getArticleId()
				+ ", getTagName()=" + getTagName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	 
	 
}
