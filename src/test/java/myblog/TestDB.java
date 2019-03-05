package myblog;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.broccoli.blog.mapper.UserMapper;
import cn.broccoli.blog.po.User;

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
	
}
