package cn.broccoli.blog.po;

import java.io.Serializable;
import java.util.Date;

public class StayMessage implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Short stayId;

    private Integer userId;

    private Integer stayUserId;

    private String messageContent;

    private String stayUserIp;

    private Date messageStayTime;

    private String place;

    public Short getStayId() {
        return stayId;
    }

    public void setStayId(Short stayId) {
        this.stayId = stayId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStayUserId() {
        return stayUserId;
    }

    public void setStayUserId(Integer stayUserId) {
        this.stayUserId = stayUserId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public String getStayUserIp() {
        return stayUserIp;
    }

    public void setStayUserIp(String stayUserIp) {
        this.stayUserIp = stayUserIp == null ? null : stayUserIp.trim();
    }

    public Date getMessageStayTime() {
        return messageStayTime;
    }

    public void setMessageStayTime(Date messageStayTime) {
        this.messageStayTime = messageStayTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }
}