package cn.broccoli.blog.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.broccoli.blog.mapper.SysAuthorityMapper;
import cn.broccoli.blog.mapper.SysRoleMapper;
import cn.broccoli.blog.mapper.UserMapper;
import cn.broccoli.blog.po.User;
import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.service.impl.UserServiceImpl;
import cn.broccoli.blog.utils.Menu;
import cn.broccoli.blog.utils.MenuTree;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring-mybatis.xml" })
public class MenuTreeTest {

	@Autowired
	SysAuthorityMapper sysAuthorityMapper;
	@Autowired
	SysRoleMapper sysRoleMapper;
	@BeforeClass
	public static void beforeRead(){
		System.out.println("准备测试环境成功。。。");
	}
	//spring 配置文件  注解扫描包路径问题。。
	//测试菜单权限树的生成
	@Test
	public void menuTreeToJsonTest() {
		MenuTree menuTree=new MenuTree(sysAuthorityMapper.getAll());
		List<Menu> list=menuTree.builTree();
		String jsonOutput= JSON.toJSONString(list);
		System.out.println("MENUTREE"+jsonOutput);
		
		
	}
}
