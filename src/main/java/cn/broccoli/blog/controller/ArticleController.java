package cn.broccoli.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import cn.broccoli.blog.po.FriendlyLink;
import cn.broccoli.blog.service.ArticleService;
import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.JWTUtil;
import cn.broccoli.blog.utils.TagsList;

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
	@Autowired
	private UserService userService;
	@Autowired
	JWTUtil jwtUtil;
	// 分页查询用户的文章
	/**
	 * @param name
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/blog/{name}/article", method = RequestMethod.GET)
	@ResponseBody
	public PageResultBean<List<ArticleList>> findArticleList(@PathVariable String name, int page) {
		return new PageResultBean<List<ArticleList>>(articleService.findArticleCount(userService.selectIdByName(name)), articleService.findArticleList(name, page));
	}
	//这个临时用户指定的自己的名称  以后从token中获取
	/**查询文章分类
	 * @return
	 */
	@RequestMapping(value = "/api/article/tags/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<List<Map<Integer, String>>> findTagsList(HttpServletRequest request) {

		return new ResultBean<List<Map<Integer, String>>>(articleService.findArticleSortList(jwtUtil.getUserId(request)));
	}
	@RequestMapping(value = "/api/article/tags/getlist", method = RequestMethod.GET)
	@ResponseBody
	public PageResultBean<List<TagsList>> findTagsByLimitList(HttpServletRequest request,int page,int limit,String sortArticleId,String sortArticleName) {
		Integer userid=jwtUtil.getUserId(request);
		return new PageResultBean<List<TagsList>>(articleService.findTagsCount(userid, sortArticleId, sortArticleName), articleService.findTagsList(userid, page, limit, sortArticleId, sortArticleName));
	}
	
	//避免重复先要确认数据库是否已添加
	/**增加文章分类
	 * @param articleSort
	 * @return
	 */
	@RequestMapping(value = "/api/article/tags/addtags", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Boolean> addSortArticle(String articleSort,HttpServletRequest request) {

		return new ResultBean<Boolean>(articleService.addArticleSort(jwtUtil.getUserId(request), articleSort));
	}
	/**文章保存接口
	 * @param article
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/api/article/save", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Integer> saveArticle(@RequestBody Article article,HttpServletRequest request) {
        return new ResultBean<Integer>(articleService.saveArticle(article,request));
	}
	
	/**后台文章列表查询
	 * @param request
	 * @param page
	 * @param limit
	 * @param articleId
	 * @param articleName
	 * @param articleStatus
	 * @return
	 */
	@RequestMapping(value = "/api/article/getAllArticle", method = RequestMethod.GET)
	@ResponseBody
	public PageResultBean<List<ArticleList>> findAllArticleList( HttpServletRequest request,int page,Integer limit,String articleId,String articleName,String articleStatus) {
		Integer userid=jwtUtil.getUserId(request);
		return new PageResultBean<List<ArticleList>>(articleService.findArticleLimitCount(userid, articleId, articleName, articleStatus), articleService.findAllArticleList(userid,page,limit,articleId,articleName,articleStatus));
	}
	/**批量删除文章接口
	 * @param list
	 * @return
	 */
	@RequestMapping(value = "/api/article/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public ResultBean<Boolean> removeArticle(@RequestBody List<ArticleList> list) {
		//删除应该确认是否是自己的
		return new ResultBean<Boolean>(articleService.removeArticleByIds(list));

	}
	@RequestMapping(value = "/test",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<Boolean> vtest(HttpServletRequest request, HttpServletResponse response) {
		
		return new ResultBean<Boolean>(articleService.test());
	}
	@RequestMapping(value = "/api/article/tags/delete",method = RequestMethod.DELETE)
	@ResponseBody
	public ResultBean<Boolean> removeTags(@RequestBody List<TagsList> list){
		return new ResultBean<Boolean>(articleService.removeTags(list));
	}
	
}
