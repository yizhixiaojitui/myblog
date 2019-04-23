package plm.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public static String stringToMD5(String str,int times){
		try {
			//获得消息摘要实例
			MessageDigest md = MessageDigest.getInstance("MD5");
				
			//获得消息摘要
			for(int i=1;i<=times;i++){
				//使用目标的字节数组更新消息摘要
				md.update(str.getBytes());	
				byte[] digest=md.digest();		
				str=ByteUtil.bytesToHexString(digest);
			}		
			return str;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}

