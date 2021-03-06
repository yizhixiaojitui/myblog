package plm.common.beans;

import java.io.Serializable;


/**  
* @ClassName: PageResultBean  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author Administrator  
* @date 2019年7月10日  
*  
* @param <T>  
*/
public class PageResultBean<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int NO_LOGIN = -1;

	public static final int SUCCESS = 0;

	public static final int CHECK_FAIL = 1;

	public static final int NO_PERMISSION = 2;

	public static final int UNKNOWN_EXCEPTION = -99;
	
	//当前页
    private int pageIndex;
	//每页行数
	private int pageSize = 10;
	//总行数
	private int count;
	//总页数
	private int pageCount;
	
	/**
	 * 返回的信息(主要出错的时候使用)
	 */
	private String msg = "success";

	

	/**
	 * 接口返回码, 0表示成功, 其他看对应的定义
	 * 晓风轻推荐的做法是: 
	 * 0   : 成功
	 * >0 : 表示已知的异常(例如提示错误等, 需要调用地方单独处理) 
	 * <0 : 表示未知的异常(不需要单独处理, 调用方统一处理)
	 */
	private int code = SUCCESS;

	/**
	 * 返回的数据
	 */
	private T data;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		
		return (this.count%this.pageSize==0)?(this.count/this.pageSize):(this.count/this.pageSize+1);
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public PageResultBean() {
		super();
	}

	public PageResultBean(T data) {
		super();
		this.data = data;
	}
	public PageResultBean(int count,T data) {
		super();
		this.count=count;
		this.data = data;
	}
	public PageResultBean(Throwable e) {
		super();
		this.msg = e.toString();
		this.code = UNKNOWN_EXCEPTION;
	}
}
