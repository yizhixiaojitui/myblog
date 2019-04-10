package cn.broccoli.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.broccoli.blog.po.FriendlyLink;
import cn.broccoli.blog.service.FriendlyLinkService;
import plm.common.beans.ResultBean;

@Controller
public class FriendlyLinkController {

	@Autowired
	FriendlyLinkService friendlyLinkService;
	@RequestMapping(value = "/friendlyLink",method = RequestMethod.GET)
	@ResponseBody
	public ResultBean<List<FriendlyLink>> findFriendlyLinkAll(){
		return new ResultBean<List<FriendlyLink>>(friendlyLinkService.findFriendlyLinkAll());
	}
	
}
