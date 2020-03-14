package cn.broccoli.blog.po;

import java.io.Serializable;

public class ModuleType implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer typeId;

    private String userName;

    private Integer userId;

    private String typeIcon;

    private Byte showOrder;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTypeIcon() {
        return typeIcon;
    }

    public void setTypeIcon(String typeIcon) {
        this.typeIcon = typeIcon == null ? null : typeIcon.trim();
    }

    public Byte getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Byte showOrder) {
        this.showOrder = showOrder;
    }
}