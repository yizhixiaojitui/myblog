package cn.broccoli.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.broccoli.blog.mapper.FriendlyLinkMapper;
import cn.broccoli.blog.po.FriendlyLink;
import cn.broccoli.blog.service.FriendlyLinkService;
@Service("FriendlyLinkService")
public class FriendlyLinkServiceImpl implements FriendlyLinkService {
	@Autowired
	FriendlyLinkMapper friendlyLinkMapper;
	/**
	* <p>Title: findFriendlyLinkAll</p>  
	* <p>Description: 主页查询获取友情链接</p>  
	* @return  
	* @see cn.broccoli.blog.service.FriendlyLinkService#findFriendlyLinkAll()  
	*/ 
	@Override
	public List<FriendlyLink> findFriendlyLinkAll() {
		// TODO Auto-generated method stub
		return friendlyLinkMapper.selectAll();
	}
	
	/**
	* <p>Title: findFriendlyLinkPage</p>  
	* <p>Description: 分页查询友情链接</p>  
	* @param page
	* @param limit
	* @param linkId
	* @param linkName
	* @return  
	* @see cn.broccoli.blog.service.FriendlyLinkService#findFriendlyLinkPage(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String)  
	*/ 
	@Override
	public List<FriendlyLink> findFriendlyLinkPage(Integer page, Integer limit, String linkId, String linkName) {
		// TODO Auto-generated method stub
		page=(page-1)*limit;
		return friendlyLinkMapper.selectLinkByPage(page, limit, linkId, linkName);
	}

	/**
	* <p>Title: findFriendlyLinkCount</p>  
	* <p>Description: 获取友情链接总行数</p>  
	* @param linkId
	* @param linkName
	* @return  
	* @see cn.broccoli.blog.service.FriendlyLinkService#findFriendlyLinkCount(java.lang.String, java.lang.String)  
	*/ 
	@Override
	public int findFriendlyLinkCount(String linkId,String linkName) {
		// TODO Auto-generated method stub
		return friendlyLinkMapper.selectCount( linkId, linkName);
	}
	
	/**
	* <p>Title: saveFriendlyLink</p>  
	* <p>Description: 添加保存友情链接</p>  
	* @param friendlyLink
	* @return  
	* @see cn.broccoli.blog.service.FriendlyLinkService#saveFriendlyLink(cn.broccoli.blog.po.FriendlyLink)  
	*/ 
	@Override
	public boolean saveFriendlyLink(FriendlyLink friendlyLink) {
		// TODO Auto-generated method stub
		//检查是否已添加
		return friendlyLinkMapper.insert(friendlyLink);
	}
	/**
	* <p>Title: removeFriendlyLink</p>  
	* <p>Description: 删除友情链接</p>  
	* @param list
	* @return  
	* @see cn.broccoli.blog.service.FriendlyLinkService#removeFriendlyLink(java.util.List)  
	*/ 
	@Override
	public boolean removeFriendlyLink(List<FriendlyLink> list) {
		// TODO Auto-generated method stub
		//严格来说应该判断是否存在
		return friendlyLinkMapper.deleteFriendlyLink(list);
	}

}
