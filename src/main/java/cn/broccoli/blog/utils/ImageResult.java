package cn.broccoli.blog.utils;

import java.io.Serializable;

public class ImageResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String src;
	
	private String title;
	
	private String msg;

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
