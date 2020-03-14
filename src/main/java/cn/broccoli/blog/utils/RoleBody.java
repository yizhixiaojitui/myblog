package cn.broccoli.blog.utils;

import java.io.Serializable;
import java.util.List;

public class RoleBody implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String roleName;
	
	private String desciption;
	
	private String menu;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	
}
