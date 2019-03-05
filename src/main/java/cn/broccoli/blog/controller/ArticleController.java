package cn.broccoli.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import plm.common.beans.ResultBean;
import plm.common.beans.PageResultBean;
import cn.broccoli.blog.po.Article;
import cn.broccoli.blog.po.ArticleList;
import cn.broccoli.blog.service.ArticleService;

/**
 * @package cn.broccoli.blog.controller
 * @author yizhixiaojitui
 *
 * @Date 2019年3月1日
 */
@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	// 分页查询用户的文章
	/**
	 * @param name
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/blog/{name}/article", method = RequestMethod.GET)
	@ResponseBody
	public PageResultBean<List<ArticleList>> findArticleList(@PathVariable String name, int page) {
		PageResultBean<List<ArticleList>> result=new PageResultBean<List<ArticleList>>(articleService.findArticleList(name, page));
		result.setPageIndex(page);
		result.setCount(articleService.findArticleCount(name));
		return result;
	}
	//这个临时用户指定的自己的名称  以后从token中获取
	/**查询文章分类
	 * @return
	 */
	@RequestMapping(value = "/api/article/sort/getlist", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<List<Map<Integer, String>>> findSortArticleList() {

		return new ResultBean<List<Map<Integer, String>>>(articleService.findArticleSortList("yizhixiaojitui"));
	}
	
	//这个临时用户指定的自己的名称  以后从token中获取
	/**增加文章分类
	 * @param articleSort
	 * @return
	 */
	@RequestMapping(value = "/api/article/sort/addsort", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<Boolean> addSortArticle(String articleSort) {

		return new ResultBean<Boolean>(articleService.addArticleSort("yizhixiaojitui", articleSort));
	}
	@RequestMapping(value = "/api/article/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Integer> saveArticle(@RequestBody Article article) {
		System.out.println(article.toString());
        System.out.println("saveArticle");
        return new ResultBean<Integer>(articleService.saveArticle(article));
	}
	
	@RequestMapping(value = "/api/article/getAllArticle", method = RequestMethod.GET)
	@ResponseBody
	public PageResultBean<List<ArticleList>> findAllArticleList( int page,Integer limit) {
		List<ArticleList> list=articleService.findAllArticleList(page,limit);
		
		PageResultBean<List<ArticleList>> result=new PageResultBean<List<ArticleList>>(list);
		result.setCount(articleService.findArticleCount("yizhixiaojitui"));
		return result;
	}
	@RequestMapping(value = "/api/article/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public ResultBean<Boolean> removeArticle(@RequestBody List<ArticleList> list) {
		
		return new ResultBean<Boolean>(articleService.removeArticleByIds(list));

	}
}
