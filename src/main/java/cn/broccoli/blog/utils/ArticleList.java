package cn.broccoli.blog.utils;

import java.util.Date;

public class ArticleList {
	private Short articleId;
	private String articleName;
	private Date articleTime;
    private Integer articleClick;
    private String sortArticleName;
    private Integer articleType;
    private Byte articleUp;
    private Byte articleSupport;
    private String articleLabel;
    private String articleContent;
    
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
	public String getSortArticleName() {
		return sortArticleName;
	}
	public void setSortArticleName(String sortArticleName) {
		this.sortArticleName = sortArticleName;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
}
