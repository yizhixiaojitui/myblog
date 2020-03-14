package cn.broccoli.blog.po;

import java.io.Serializable;

public class SysRoleAuthority implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Long menuId;

    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public SysRoleAuthority() {
    	super();
    }
    public SysRoleAuthority(Long menuId,Long roleId) {
    	super();
    	this.menuId=menuId;
    	this.roleId=roleId;
    }
}