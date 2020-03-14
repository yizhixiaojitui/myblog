package cn.broccoli.blog.utils;

import java.io.Serializable;
import java.util.Date;

public class UserList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String userNikename;
    
    private String userPhone;

    private String userEmail;
    
    private String userSex;
    
    private Date userRegisterTime;
    
    private String userRegisterIp;
    
    private String userImageUrl;
    
    private Byte userLock;
    
    

	public Byte getUserLock() {
		return userLock;
	}

	public void setUserLock(Byte userLock) {
		this.userLock = userLock;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserNikename() {
		return userNikename;
	}

	public void setUserNikename(String userNikename) {
		this.userNikename = userNikename;
	}

	public Date getUserRegisterTime() {
		return userRegisterTime;
	}

	public void setUserRegisterTime(Date userRegisterTime) {
		this.userRegisterTime = userRegisterTime;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserRegisterIp() {
		return userRegisterIp;
	}

	public void setUserRegisterIp(String userRegisterIp) {
		this.userRegisterIp = userRegisterIp;
	}

	public String getUserImageUrl() {
		return userImageUrl;
	}

	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
    
    
}
