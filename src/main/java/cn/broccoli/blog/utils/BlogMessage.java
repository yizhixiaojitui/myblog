package cn.broccoli.blog.utils;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.TableField;

import cn.broccoli.blog.po.FriendlyLink;
import cn.broccoli.blog.po.Tag;

public class BlogMessage {
	 private Integer blogId;

	    private String blogKeyword;

	    private String blogDescription;

	    private String blogName;

	    private String blogTitle;

	    //private String userName;

		private String userSex;
	    
	    private String userNikename;
	    
	    private String userImageUrl;
	    
	    private String userDescription;
	    
	    private int pageView;
	    
	    private int articleNum;
	    @TableField(exist = false)
	    private List<Tag> tags;
	    @TableField(exist = false)
	    private List<FriendlyLink> friendlyLinks;
	    @TableField(exist = false)
	    private List<ArticleHot> articleHots;
	    /**  
	    * @Fields field:field:{todo}(推荐)  
	    */
	    @TableField(exist = false)
	    private List<ArticleTop> articleTop;
	    
	    public String getUserSex() {
			return userSex;
		}

		public void setUserSex(String userSex) {
			this.userSex = userSex;
		}

		public String getUserNikename() {
			return userNikename;
		}

		public void setUserNikename(String userNikename) {
			this.userNikename = userNikename;
		}

		public String getUserImageUrl() {
			return userImageUrl;
		}

		public void setUserImageUrl(String userImageUrl) {
			this.userImageUrl = userImageUrl;
		}

		public String getUserDescription() {
			return userDescription;
		}

		public void setUserDescription(String userDescription) {
			this.userDescription = userDescription;
		}

		public int getPageView() {
			return pageView;
		}

		public void setPageView(int pageView) {
			this.pageView = pageView;
		}

		public int getArticleNum() {
			return articleNum;
		}

		public void setArticleNum(int articleNum) {
			this.articleNum = articleNum;
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

		public List<Tag> getTags() {
			return tags;
		}

		public void setTags(List<Tag> tags) {
			this.tags = tags;
		}

		public List<FriendlyLink> getFriendlyLinks() {
			return friendlyLinks;
		}

		public void setFriendlyLinks(List<FriendlyLink> friendlyLinks) {
			this.friendlyLinks = friendlyLinks;
		}

		public List<ArticleHot> getArticleHots() {
			return articleHots;
		}

		public void setArticleHots(List<ArticleHot> articleHots) {
			this.articleHots = articleHots;
		}

		public List<ArticleTop> getArticleTop() {
			return articleTop;
		}

		public void setArticleTop(List<ArticleTop> articleTop) {
			this.articleTop = articleTop;
		}
		
		public BlogMessage() {
			super();
		}
	    public BlogMessage(List<Tag> tags,List<FriendlyLink> friendlyLinks,List<ArticleHot> articleHots,List<ArticleTop> articleTop) {
	    	super();
	    	this.tags=tags;
	    	this.friendlyLinks=friendlyLinks;
	    	this.articleHots=articleHots;
	    	this.articleTop=articleTop;
	    	
	    }
}
