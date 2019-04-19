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
	@Override
	public List<FriendlyLink> findFriendlyLinkAll() {
		// TODO Auto-generated method stub
		return friendlyLinkMapper.selectAll();
	}
	/* (non-Javadoc)
	 * @see cn.broccoli.blog.service.FriendlyLinkService#findFriendlyLinkPage(int, java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	@Override
	public List<FriendlyLink> findFriendlyLinkPage(Integer page, Integer limit, String linkId, String linkName) {
		// TODO Auto-generated method stub
		page=(page-1)*limit;
		return friendlyLinkMapper.selectLinkByPage(page, limit, linkId, linkName);
	}
	/* (non-Javadoc)
	 * @see cn.broccoli.blog.service.FriendlyLinkService#findFriendlyLinkCount()
	 */
	@Override
	public int findFriendlyLinkCount(String linkId,String linkName) {
		// TODO Auto-generated method stub
		return friendlyLinkMapper.selectCount( linkId, linkName);
	}
	/* (non-Javadoc)
	 * @see cn.broccoli.blog.service.FriendlyLinkService#saveFriendlyLink(cn.broccoli.blog.po.FriendlyLink)
	 */
	@Override
	public boolean saveFriendlyLink(FriendlyLink friendlyLink) {
		// TODO Auto-generated method stub
		//检查是否已添加
		return friendlyLinkMapper.insert(friendlyLink);
	}
	/* (non-Javadoc)
	 * @see cn.broccoli.blog.service.FriendlyLinkService#removeFriendlyLink(java.util.List)
	 */
	@Override
	public boolean removeFriendlyLink(List<FriendlyLink> list) {
		// TODO Auto-generated method stub
		//严格来说应该判断是否存在
		return friendlyLinkMapper.deleteFriendlyLink(list);
	}

}
