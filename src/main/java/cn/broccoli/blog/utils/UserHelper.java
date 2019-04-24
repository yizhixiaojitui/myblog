package cn.broccoli.blog.utils;

import java.util.Date;

public class UserHelper {
	private Integer userId;

	private String userName;

    private String userNikename;
    
    private String userPhone;

    private String userSex;
    
    private String userEmail;
    
    private Date userBirthday;

    private String userDescription;

    private String userImageUrl;
    
    private Integer userPower;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNikename() {
		return userNikename;
	}

	public void setUserNikename(String userNikename) {
		this.userNikename = userNikename;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	public String getUserImageUrl() {
		return userImageUrl;
	}

	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}

	public Integer getUserPower() {
		return userPower;
	}

	public void setUserPower(Integer userPower) {
		this.userPower = userPower;
	}

	@Override
	public String toString() {
		return "UserHelper [userName=" + userName + ", userNikename=" + userNikename + ", userPhone=" + userPhone
				+ ", userSex=" + userSex + ", userEmail=" + userEmail + ", userBirthday=" + userBirthday
				+ ", userDescription=" + userDescription + ", userImageUrl=" + userImageUrl + ", userPower=" + userPower
				+ "]";
	}
    

}
