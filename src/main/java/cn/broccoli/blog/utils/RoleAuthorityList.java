package cn.broccoli.blog.utils;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;

public class RoleAuthorityList {

	private Long id;
	
	private String title;
	@TableField(exist = false)
	private List<RoleAuthorityList> children;
	@TableField(exist = false)
	//是否选中
	private boolean checked;
	@TableField(exist = false)
	//是否展开
	private String spread;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<RoleAuthorityList> getChildren() {
		return children;
	}
	public void setChildren(List<RoleAuthorityList> children) {
		this.children = children;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getSpread() {
		return spread;
	}
	public void setSpread(String spread) {
		this.spread = spread;
	}
	
	
	
}
