/**
 * 
 */
package plm.common.utils;

/**
 * @package plm.common.utils
 * @author yizhixiaojitui 密码加 盐 工具类
 * @Date 2019年4月23日
 */
public class SaleUtil {

	private static String salt="yizhixiaojitui";
	// 为密码加“盐”
	public String addSalt(String password) {
		
		return salt + "_" + password + "_" + salt;
	}
	
	
	public static String PassWordToMD5(String password) {
		password=salt + "_" + password + "_" + salt;
		return MD5Util.stringToMD5(password, 2);
	}
	

	// 随机生成“盐”
	/**
	 * @param length 随机盐长度
	 * @return
	 */
	public  String getSalt(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			// 生成48-122之间的随机整数
			int n = (int) (Math.random() * (122 - 48) + 48);
			// 将整数强转成字符追加到字符串中
			sb.append((char) n);
		}
		return sb.toString();
	}
}
