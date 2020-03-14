/**
 * 
 */
package cn.broccoli.blog.utils;

import java.io.Serializable;
import java.util.Date;

/**
 * @package cn.broccoli.blog.utils
 * @author yizhixiaojitui
 *
 * @Date 2019年4月25日
 */
public class ArticleInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Short articleId;

    private String articleName;
    
    private Integer sortArticleId;

    private Integer userId;
    
    private String articleContent;
    
    private Byte typeId;

    private Integer articleType;

    private Byte articleUp;

    private Byte articleSupport;

    private String articleLabel;

    private Byte articleStatus;

    private String articleDescription;
    
    private Byte moduleType;

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

	

	public Integer getSortArticleId() {
		return sortArticleId;
	}

	public void setSortArticleId(Integer sortArticleId) {
		this.sortArticleId = sortArticleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Byte getTypeId() {
		return typeId;
	}

	public void setTypeId(Byte typeId) {
		this.typeId = typeId;
	}

	public Integer getArticleType() {
		return articleType;
	}

	public void setArticleType(Integer articleType) {
		this.articleType = articleType;
	}

	public Byte getArticleUp() {
		return articleUp;
	}

	public void setArticleUp(Byte articleUp) {
		this.articleUp = articleUp;
	}

	public Byte getArticleSupport() {
		return articleSupport;
	}

	public void setArticleSupport(Byte articleSupport) {
		this.articleSupport = articleSupport;
	}

	public String getArticleLabel() {
		return articleLabel;
	}

	public void setArticleLabel(String articleLabel) {
		this.articleLabel = articleLabel;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Byte getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(Byte articleStatus) {
		this.articleStatus = articleStatus;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

	public Byte getModuleType() {
		return moduleType;
	}

	public void setModuleType(Byte moduleType) {
		this.moduleType = moduleType;
	}

	@Override
	public String toString() {
		return "ArticleInfo [articleId=" + articleId + ", articleName=" + articleName + ", sortArticleId=" + sortArticleId + ", userId=" + userId + ", typeId=" + typeId + ", articleType="
				+ articleType + ", articleUp=" + articleUp + ", articleSupport=" + articleSupport + ", articleLabel="
				+ articleLabel + ", articleContent=" + articleContent + ", articleStatus=" + articleStatus
				+ ", articleDescription=" + articleDescription + ", moduleType=" + moduleType + "]";
	}
	
}
