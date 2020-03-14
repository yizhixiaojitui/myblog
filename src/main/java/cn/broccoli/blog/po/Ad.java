package cn.broccoli.blog.po;

import java.io.Serializable;
import java.util.Date;

public class Ad implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Short adId;

    private Short positionId;

    private Byte mediaType;

    private String adName;

    private String adLink;

    private Date startTime;

    private Date endTime;

    private String linkMan;

    private String linkEmail;

    private String linkPhone;

    private Integer clickCount;

    private Byte enabled;

    private String adCode;

    public Short getAdId() {
        return adId;
    }

    public void setAdId(Short adId) {
        this.adId = adId;
    }

    public Short getPositionId() {
        return positionId;
    }

    public void setPositionId(Short positionId) {
        this.positionId = positionId;
    }

    public Byte getMediaType() {
        return mediaType;
    }

    public void setMediaType(Byte mediaType) {
        this.mediaType = mediaType;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName == null ? null : adName.trim();
    }

    public String getAdLink() {
        return adLink;
    }

    public void setAdLink(String adLink) {
        this.adLink = adLink == null ? null : adLink.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail == null ? null : linkEmail.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode == null ? null : adCode.trim();
    }
}