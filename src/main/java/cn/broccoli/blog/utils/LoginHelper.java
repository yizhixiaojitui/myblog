/**
 * 
 */
package cn.broccoli.blog.utils;

import java.io.Serializable;

/**
 * @package cn.broccoli.blog.utils
 * @author yizhixiaojitui
 *
 * @Date 2019年3月26日
 */
public class LoginHelper implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	private String vercode;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", vercode=" + vercode + "]";
	}

	

	
}
