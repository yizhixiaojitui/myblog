package cn.broccoli.blog.po;

import java.io.Serializable;

public class FriendlyLink implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Short linkId;

    private String linkName;

    private String linkUrl;

    private Byte showOrder;

    public Short getLinkId() {
        return linkId;
    }

    public void setLinkId(Short linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public Byte getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Byte showOrder) {
        this.showOrder = showOrder;
    }

	@Override
	public String toString() {
		return "FriendlyLink [linkId=" + linkId + ", linkName=" + linkName + ", linkUrl=" + linkUrl + ", showOrder="
				+ showOrder + "]";
	}
}