package cn.broccoli.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.broccoli.blog.po.ArticleList;
import cn.broccoli.blog.po.FriendlyLink;
import cn.broccoli.blog.service.FriendlyLinkService;
import cn.broccoli.blog.service.SysAuthorityService;
import cn.broccoli.blog.utils.Menu;
import plm.common.beans.PageResultBean;
import plm.common.beans.ResultBean;

@Controller
public class FriendlyLinkController {
	@Autowired
	private SysAuthorityService sysAuthorityService;
	@Autowired
	FriendlyLinkService friendlyLinkService;
	@RequestMapping(value = "/home/friendlyLink",method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<List<FriendlyLink>> findFriendlyLinkAll(){
		return new ResultBean<List<FriendlyLink>>(friendlyLinkService.findFriendlyLinkAll());
	}
	@RequestMapping(value = "/home/api/friendlyLink",method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<List<Menu>> testAPI(){
		return new ResultBean<List<Menu>>(sysAuthorityService.getAllMenuList());
	}
	@RequestMapping(value = "/api/friendlyLink/getlist", method = RequestMethod.GET)
	@ResponseBody
	public PageResultBean<List<FriendlyLink>> findAllArticleList(int page,Integer limit,String linkId,String linkName) {
		return new PageResultBean<List<FriendlyLink>>(friendlyLinkService.findFriendlyLinkCount( linkId, linkName), friendlyLinkService.findFriendlyLinkPage(page, limit, linkId, linkName));
	}
	@RequestMapping(value = "/api/friendlyLink/save",method = RequestMethod.POST)
	@ResponseBody
	public ResultBean<Boolean> saveFriendlyLink(@RequestBody FriendlyLink friendlyLink){
		return new ResultBean<Boolean>(friendlyLinkService.saveFriendlyLink(friendlyLink));
	}
	@RequestMapping(value = "/api/friendlyLink/delete",method = RequestMethod.DELETE)
	@ResponseBody
	public ResultBean<Boolean> removeFriendlyLink(@RequestBody List<FriendlyLink> list){
		return new ResultBean<Boolean>(friendlyLinkService.removeFriendlyLink(list));
	}
	
}
