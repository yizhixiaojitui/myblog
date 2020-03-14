package cn.broccoli.blog.utils;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;

public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String title;

    private String description;

    private String url;

    private String menuCode;

    private String parentMenucode;

    private String icon;
    @TableField(exist = false)
	//是否选中
	private boolean checked ;
	@TableField(exist = false)
	//是否展开
	private boolean spread=true;
    
    @TableField(exist = false)
    private List<Menu> children;
    
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

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public String getParentMenucode() {
        return parentMenucode;
    }

    public void setParentMenucode(String parentMenucode) {
        this.parentMenucode = parentMenucode == null ? null : parentMenucode.trim();
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean getSpread() {
		return spread;
	}

	public void setSpread(boolean spread) {
		this.spread = spread;
	}

    
}
