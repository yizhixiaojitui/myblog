package cn.broccoli.blog.utils;

public class BlogMessage {
	 private Integer blogId;

	    private String blogKeyword;

	    private String blogDescription;

	    private String blogName;

	    private String blogTitle;

	    private String userName;

		private String userSex;
	    
	    private String userNikename;
	    
	    private String userImageUrl;
	    
	    private String userDescription;
	    
	    private int pageView;
	    
	    private int articleNum;
	    
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
	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName == null ? null : userName.trim();
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
