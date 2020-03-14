package cn.broccoli.blog.po;

import java.io.Serializable;

public class ArticleSort implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer sortArticleId;

    private Integer userId;

    private String sortArticleName;

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

    public String getSortArticleName() {
        return sortArticleName;
    }

    public void setSortArticleName(String sortArticleName) {
        this.sortArticleName = sortArticleName == null ? null : sortArticleName.trim();
    }
}