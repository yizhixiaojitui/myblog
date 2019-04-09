package cn.broccoli.blog.po;

import java.util.Date;

public class Article {
    private Short articleId;

    private String articleName;

    private Date articleTime;

    private String articleIp;

    private Integer articleClick;

    private Integer sortArticleId;

    private Integer userId;

    private Byte typeId;

    private Integer articleType;

    private Byte articleUp;

    private Byte articleSupport;

    private String articleLabel;

    private String articleContent;
    
    private Byte articleStatus;

    private String articleDescription;
    
    private Byte moduleType;
    public Byte getModuleType() {
		return moduleType;
	}

	public void setModuleType(Byte moduleType) {
		this.moduleType = moduleType;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}
	
 

	public Byte getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(Byte articleStatus) {
		this.articleStatus = articleStatus;
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
        this.articleName = articleName == null ? null : articleName.trim();
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleIp() {
        return articleIp;
    }

    public void setArticleIp(String articleIp) {
        this.articleIp = articleIp == null ? null : articleIp.trim();
    }

    public Integer getArticleClick() {
        return articleClick;
    }

    public void setArticleClick(Integer articleClick) {
        this.articleClick = articleClick;
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
        this.articleLabel = articleLabel == null ? null : articleLabel.trim();
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleName=" + articleName + ", articleTime=" + articleTime
				+ ", articleIp=" + articleIp + ", articleClick=" + articleClick + ", sortArticleId=" + sortArticleId
				+ ", userId=" + userId + ", typeId=" + typeId + ", articleType=" + articleType + ", articleUp="
				+ articleUp + ", articleSupport=" + articleSupport + ", articleLabel=" + articleLabel
				+ ", articleContent=" + articleContent + ", articleStatus=" + articleStatus + ", articleDescription="
				+ articleDescription + ", moduleType=" + moduleType + "]";
	}



	
    
}