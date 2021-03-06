package cn.broccoli.blog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
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
import cn.broccoli.blog.po.User;
import cn.broccoli.blog.service.ArticleService;
import cn.broccoli.blog.service.UserService;
import cn.broccoli.blog.utils.ArticleInfo;
import cn.broccoli.blog.utils.ArticleTop;
import cn.broccoli.blog.utils.JWTUtil;
import cn.broccoli.blog.utils.SortList;

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
	@RequestMapping(value = "/home/article", method = RequestMethod.GET)
	@ResponseBody
	public PageResultBean<List<ArticleList>> findArticleList(String u, int page) {
		return new PageResultBean<List<ArticleList>>(articleService.findArticleCount(userService.selectIdByName(u)), articleService.findArticleList(u, page));
	}
	//这个临时用户指定的自己的名称  以后从token中获取
	/**查询文章分类
	 * @return
	 */
	@RequestMapping(value = "/api/article/tags/list", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<List<Map<Integer, String>>> findTagsList(HttpServletRequest request) {

		return new ResultBean<List<Map<Integer, String>>>(articleService.findArticleSortList(((User)SecurityUtils.getSubject().getPrincipal()).getUserId()));
	}
	@RequestMapping(value = "/api/article/tags/getlist", method = RequestMethod.GET)
	@ResponseBody
	public PageResultBean<List<SortList>> findTagsByLimitList(HttpServletRequest request,int page,int limit,String sortArticleId,String sortArticleName) {
		Integer userid=jwtUtil.getUserId(request);
		return new PageResultBean<List<SortList>>(articleService.findTagsCount(((User)SecurityUtils.getSubject().getPrincipal()).getUserId(), sortArticleId, sortArticleName), articleService.findTagsList(((User)SecurityUtils.getSubject().getPrincipal()).getUserId(), page, limit, sortArticleId, sortArticleName));
	}
	@RequestMapping(value = "/api/article/tags/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Integer> updateTag(@RequestBody SortList tl) {

		return new ResultBean<Integer>(articleService.modifyTags(tl));
	}
	//避免重复先要确认数据库是否已添加
	/**增加文章分类
	 * @param articleSort
	 * @return
	 */
	@RequestMapping(value = "/api/article/tags/addtags", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Boolean> addSortArticle(String articleSort,HttpServletRequest request) {

		return new ResultBean<Boolean>(articleService.addArticleSort(((User)SecurityUtils.getSubject().getPrincipal()).getUserId(), articleSort));
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
		
		return new PageResultBean<List<ArticleList>>(articleService.findArticleLimitCount(((User)SecurityUtils.getSubject().getPrincipal()).getUserId(), articleId, articleName, articleStatus), articleService.findAllArticleList(((User)SecurityUtils.getSubject().getPrincipal()).getUserId(),page,limit,articleId,articleName,articleStatus));
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
	@RequestMapping(value = "/home/test",method = RequestMethod.GET)  
	@ResponseBody
	public ResultBean<List<ArticleTop>> vtest(HttpServletRequest request, HttpServletResponse response) {
		
		return new ResultBean<List<ArticleTop>>(articleService.test());
	}
	@RequestMapping(value = "/api/article/tags/delete",method = RequestMethod.DELETE)
	@ResponseBody
	public ResultBean<Boolean> removeTags(@RequestBody List<SortList> list){
		return new ResultBean<Boolean>(articleService.removeTags(list));
	}
	@RequestMapping(value = "/api/article/getinfo",method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<ArticleInfo> getArticleInfo(HttpServletRequest request,Integer id){
		return new ResultBean<ArticleInfo>(articleService.findArticleInfo(((User)SecurityUtils.getSubject().getPrincipal()).getUserId(), id));
	}
	@RequestMapping(value = "/api/article/update",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Integer> updateArticle(HttpServletRequest request,@RequestBody ArticleInfo articleinfo){
		return new ResultBean<Integer>(articleService.modifyArticle(articleinfo, ((User)SecurityUtils.getSubject().getPrincipal()).getUserId()));
	}
	
}
