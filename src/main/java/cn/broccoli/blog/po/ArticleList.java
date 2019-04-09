package cn.broccoli.blog.po;

import java.util.Date;

public class ArticleList {
	private Short articleId;
	private String articleName;
	private Date articleTime;
	private Integer articleClick;
	private String sortArticleName;
	private String userNikename;
	private Integer articleType;
	private Byte articleUp;
	private Byte articleSupport;
	private Byte articleStatus;
	private Byte moduleType;

	public Byte getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(Byte articleStatus) {
		this.articleStatus = articleStatus;
	}

	public String getUserNikename() {
		return userNikename;
	}

	public void setUserNikename(String userNikename) {
		this.userNikename = userNikename;
	}

	private String articleLabel;
	private String articleDescription;

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

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

	public Byte getModuleType() {
		return moduleType;
	}

	public void setModuleType(Byte moduleType) {
		this.moduleType = moduleType;
	}

	@Override
	public String toString() {
		return "ArticleList [articleId=" + articleId + ", articleName=" + articleName + ", articleTime=" + articleTime
				+ ", articleClick=" + articleClick + ", sortArticleName=" + sortArticleName + ", userNikename="
				+ userNikename + ", articleType=" + articleType + ", articleUp=" + articleUp + ", articleSupport="
				+ articleSupport + ", articleStatus=" + articleStatus + ", moduleType=" + moduleType + ", articleLabel="
				+ articleLabel + ", articleDescription=" + articleDescription + "]";
	}

	

}
