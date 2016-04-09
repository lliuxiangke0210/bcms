package com.east.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.ChannelMapper;
import com.east.cms.dao.GroupzMapper;
import com.east.cms.dao.RoleMapper;
import com.east.cms.dao.UserMapper;
import com.east.cms.model.Channel;
import com.east.cms.model.ChannelTree;
import com.east.cms.model.GroupChannel;
import com.east.cms.model.Groupz;
import com.east.cms.model.User;
import com.east.cms.pojo.CmsException;
import com.east.cms.service.GroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

	@Resource
	private UserMapper userDao;
	@Resource
	private RoleMapper roleDao;
	@Resource
	private GroupzMapper groupDao;
	@Resource
	private ChannelMapper channelDao;

	@Override
	public void add(Groupz group) {// oo
		groupDao.add(group);
	}

	@Override
	public void delete(int groupId) {// oo
		List<User> users = userDao.listGroupUsers(groupId);
		if (users != null && users.size() > 0)
			throw new CmsException("删除的组中还有用户，不能删除");
		groupDao.delete(groupId);
	}

	@Override
	public Groupz load(int id) {// oo
		return groupDao.load(id);
	}

	@Override
	public void update(Groupz group) {// oo
		groupDao.update(group);
	}

	@Override
	public List<Groupz> listGroup() {// oo
		return groupDao.listGroup();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<Groupz> findGroup() {
		PageHelper.startPage(1, 10);
		List<Groupz> groupzs = groupDao.listGroup();
		// 用PageInfo对结果进行包装
		@SuppressWarnings({ "rawtypes" })
		PageInfo page = new PageInfo(groupzs);
		return page;
	}

	@Override
	public void deleteGroupUsers(int groupId) {// oo
		groupDao.deleteGroupUsers(groupId);

	}

	@Override
	public void addGroupChannel(int groupId, int channelId) {// oo
		Groupz g = groupDao.load(groupId);
		Channel c = channelDao.load(channelId);
		if (c == null || g == null)
			throw new CmsException("要添加的组频道关联对象不存在");
		groupDao.addGroupChannel(g, c);

	}

	@Override
	public GroupChannel loadGroupChannel(int groupId, int channelId) {// oo
		return groupDao.loadGroupChannelById(groupId, channelId);
	}

	@Override
	public void clearGroupChannel(int groupId) {// oo
		groupDao.clearGroupChannel(groupId);

	}

	@Override
	public void deleteGroupChannel(int groupId, int channelId) {// oo
		groupDao.deleteGroupChannel(groupId, channelId);

	}

	@Override
	public List<Integer> listGroupChannelIds(int groupId) {// oo
		return groupDao.listGroupChannelIds(groupId);
	}

	@Override
	public List<ChannelTree> generateGroupChannelTree(int groupId) {// oo
		return groupDao.generateGroupChannelTree(groupId);
	}

	@Override
	public List<ChannelTree> generateUserChannelTree(int userId) {// oo
		return groupDao.generateUserChannelTree(userId);
	}

}
