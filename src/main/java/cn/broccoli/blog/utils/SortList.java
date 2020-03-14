package cn.broccoli.blog.utils;

import java.io.Serializable;

public class SortList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer sortArticleId;

	private String userNikename;

    private String sortArticleName;

	public Integer getSortArticleId() {
		return sortArticleId;
	}

	public void setSortArticleId(Integer sortArticleId) {
		this.sortArticleId = sortArticleId;
	}

	public String getUserNikename() {
		return userNikename;
	}

	public void setUserNikename(String userNikename) {
		this.userNikename = userNikename;
	}

	public String getSortArticleName() {
		return sortArticleName;
	}

	public void setSortArticleName(String sortArticleName) {
		this.sortArticleName = sortArticleName;
	}

	@Override
	public String toString() {
		return "TagsList [sortArticleId=" + sortArticleId + ", userNikename=" + userNikename + ", sortArticleName="
				+ sortArticleName + "]";
	}
    
    
}
