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

}
