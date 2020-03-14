package cn.broccoli.blog.po;

import java.io.Serializable;

public class AboutBlog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer blogId;

	private String blogKeyword;

	private String blogDescription;

	private String blogName;

	private String blogTitle;

	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getBlogKeyword() {
		return blogKeyword;
	}

	public void setBlogKeyword(String blogKeyword) {
		this.blogKeyword = blogKeyword == null ? null : blogKeyword.trim();
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription == null ? null : blogDescription.trim();
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName == null ? null : blogName.trim();
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle == null ? null : blogTitle.trim();
	}
}