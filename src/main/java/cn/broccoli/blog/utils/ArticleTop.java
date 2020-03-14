/**  
* @Title: ArticleTop.java  
* @Package cn.broccoli.blog.utils  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Administrator  
* @date 2019年5月20日  
* @version V1.0  
*/
package cn.broccoli.blog.utils;

import java.io.Serializable;

/**  
* @ClassName: ArticleTop  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author Administrator  
* @date 2019年5月20日  
*    
*/
public class ArticleTop implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Short articleId;
	
	private String articleName;

	public Short getArticleId() {
		return articleId;
	}

	public void setArticleId(Short articleId) {
		this.articleId = articleId;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

}
