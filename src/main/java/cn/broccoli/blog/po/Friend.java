package cn.broccoli.blog.po;

import java.io.Serializable;

public class Friend implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Short fId;

    private Integer userId;

    private Integer friendId;

    public Short getfId() {
        return fId;
    }

    public void setfId(Short fId) {
        this.fId = fId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }
}