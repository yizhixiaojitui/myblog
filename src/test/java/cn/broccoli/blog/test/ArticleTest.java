package cn.broccoli.blog.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.broccoli.blog.mapper.ArticleMapper;
import cn.broccoli.blog.mapper.ArticleToTagMapper;
import cn.broccoli.blog.mapper.TagMapper;
import cn.broccoli.blog.po.Article;
import cn.broccoli.blog.po.Tag;
import cn.broccoli.blog.service.ArticleService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring-mybatis.xml" })
public class ArticleTest {

	@Autowired
	ArticleService articleService;
	@Autowired
	private TagMapper tagMapper;
	@Autowired
	private ArticleToTagMapper articleToTagMapper;
	@Autowired
	private ArticleMapper articleMapper;
	public static void beforeRead(){
		System.out.println("准备测试环境成功。。。");
	}
	//spring 配置文件  注解扫描包路径问题。。
	//测试文章添加
	@Test
	public void addArticleTest() {
		/*
		 * Article article=new Article(); article.setArticleName("添加文章测试");
		 * article.setArticleDescription("嘻嘻 测试文章第一篇");
		 * article.setArticleLabel("分享日常,精彩生活,多姿多彩,"); article.setArticleTime(new
		 * Date()); article.setArticleIp("127.0.0.1"); article.setUserId(10001);
		 * article.setArticleContent("sadasadadadadad"); article.setSortArticleId(8);
		 * article.setArticleClick(0); String []
		 * taglist=article.getArticleLabel().split(",");
		 * articleMapper.insertArticle(article);
		 */
		//分割标签字符 添加标签
		List<Tag> tags=new ArrayList<Tag>();
		//Map<String, Object> map = new HashMap<String, Object>();
		//初始化tag
		String []  taglist="分享日常1,精彩生活2,多姿多彩3,".split(",");
		for (int i = 0; i < taglist.length; i++) {
			if(taglist[i]!="") {
				//去掉字符前后空格
				tags.add(new Tag(taglist[i].trim()));
			}
		}
		tagMapper.insertByTagList(tags);
		for (Tag tag : tags) {
			System.out.println("标签id"+tag.getId());
		}
		//map.put("articleId", article.getArticleId());
		//map.put("list", tags);
		
		//articleToTagMapper.insertByArticleIdOrTagId(map);
		
	}
	
}
