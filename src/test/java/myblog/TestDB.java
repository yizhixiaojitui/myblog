package myblog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.broccoli.blog.mapper.UserMapper;
import cn.broccoli.blog.po.User;
import cn.broccoli.blog.utils.UserHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestDB {
	 private static Logger logger = Logger.getLogger(TestDB.class);
	 @Resource
	    private UserMapper userMapper = null;
	 @Test
	    public void test1() {
		 User user = userMapper.selectByPrimaryKey(10001);
	        logger.info("select product = " + user.toString());
	    }
	
	 @Test
	    public void testUpdate() throws IOException {
		 String username = "865636176@qq.com";
			String preLoginUrl = "https://login.sina.com.cn/sso/prelogin.php?";
			String base64Username = Base64.getEncoder().encodeToString(username.getBytes());
			String params = "entry=weibo&su=" + base64Username
					+ "MTIzNDU2&rsakt=mod&checkpin=1&client=ssologin.js(v1.4.19)&_=";
			String url = preLoginUrl + params + System.currentTimeMillis();

			URL u=new URL(url);
			HttpURLConnection connection= (HttpURLConnection) u.openConnection();
			connection.setRequestMethod("GET");
	        logger.info("=====update = "+connection.getResponseCode() );
	        logger.info("body=="+getBodyFromConnection(connection));
	    }
	 private String getBodyFromConnection(HttpURLConnection connection) throws IOException {
	        int responseCode = connection.getResponseCode();

	        if (responseCode == 200) {
	            InputStream inputStream = connection.getInputStream();
	            return readInputStream(inputStream);
	        } else {
	            InputStream errorStream = connection.getErrorStream();
	            return readInputStream(errorStream);
	        }
	    }

	    private String readInputStream(InputStream is) throws IOException {
	        String str;
	        StringBuilder stringBuilder = new StringBuilder();
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
	        while ((str = bufferedReader.readLine()) != null) {
	            stringBuilder.append(str);
	        }
	        return stringBuilder.toString();
	    }
}
