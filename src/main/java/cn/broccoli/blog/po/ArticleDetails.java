package cn.broccoli.blog.po;

import java.io.Serializable;
import java.util.Date;

public class ArticleDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Short articleId;
	
	private String articleName;

    private Date articleTime;

    private Integer articleClick;
    
    private Byte typeId;
    
    private String articleLabel;

    private String articleContent;
    
    private String sortArticleName;
    
    private String userNikename;
    
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

	public Date getArticleTime() {
		return articleTime;
	}

	public void setArticleTime(Date articleTime) {
		this.articleTime = articleTime;
	}

	public Integer getArticleClick() {
		return articleClick;
	}

	public void setArticleClick(Integer articleClick) {
		this.articleClick = articleClick;
	}

	public Byte getTypeId() {
		return typeId;
	}

	public void setTypeId(Byte typeId) {
		this.typeId = typeId;
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

	public String getSortArticleName() {
		return sortArticleName;
	}

	public void setSortArticleName(String sortArticleName) {
		this.sortArticleName = sortArticleName;
	}

	public String getUserNikename() {
		return userNikename;
	}

	public void setUserNikename(String userNikename) {
		this.userNikename = userNikename;
	}

	@Override
	public String toString() {
		return "ArticleDetails [articleId=" + articleId + ", articleName=" + articleName + ", articleTime="
				+ articleTime + ", articleClick=" + articleClick + ", typeId=" + typeId + ", articleLabel="
				+ articleLabel + ", articleContent=" + articleContent + ", sortArticleName=" + sortArticleName
				+ ", userNikename=" + userNikename + ", getArticleId()=" + getArticleId() + ", getArticleName()="
				+ getArticleName() + ", getArticleTime()=" + getArticleTime() + ", getArticleClick()="
				+ getArticleClick() + ", getTypeId()=" + getTypeId() + ", getArticleLabel()=" + getArticleLabel()
				+ ", getArticleContent()=" + getArticleContent() + ", getSortArticleName()=" + getSortArticleName()
				+ ", getUserNikename()=" + getUserNikename() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
