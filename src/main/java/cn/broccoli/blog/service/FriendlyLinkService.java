package cn.broccoli.blog.service;

import java.util.List;

import cn.broccoli.blog.po.FriendlyLink;

public interface FriendlyLinkService {

	List<FriendlyLink> findFriendlyLinkAll();
	
	List<FriendlyLink> findFriendlyLinkPage(Integer page,Integer limit,String linkId,String linkName);
	
	int findFriendlyLinkCount(String linkId,String linkName);
	
	boolean saveFriendlyLink(FriendlyLink friendlyLink);
	
	boolean removeFriendlyLink(List<FriendlyLink> list);
}
