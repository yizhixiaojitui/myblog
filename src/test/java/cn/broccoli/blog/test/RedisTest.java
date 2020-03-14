package cn.broccoli.blog.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.broccoli.blog.redis.RedisCache;
import cn.broccoli.blog.redis.RedisCacheTransfer;
import cn.broccoli.blog.redis.RedisUtil;
import cn.broccoli.blog.service.SysAuthorityService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring-mybatis.xml" })
public class RedisTest {

	@Autowired
	RedisUtil redisUtil;
	@Autowired
	SysAuthorityService sysAuthorityService;
	@Test
	public void redisPutTest() {
		//redisUtil.set("txy22","aaaa");
		
		System.out.println(redisUtil.get("txy22"));
	}
	@Test
	public void mybatisRedisTest() {
		//redisUtil.set("txy22","aaaa");
		long startTime=System.currentTimeMillis();	
		sysAuthorityService.getMenuByUserId(10001);
		long run1=System.currentTimeMillis();	
		System.out.println("第一次查询耗时："+(run1-startTime)+"ms");
		sysAuthorityService.getMenuByUserId(10001);
		long run2=System.currentTimeMillis();	
		System.out.println("第一次查询耗时："+(run2-run1)+"ms");
	
	}
	@Test
	public void mybatisRedisPutClearTest() {
		//redisUtil.set("txy22","aaaa");
		//System.out.println(redisUtil.get("txy22"));
	}
}
