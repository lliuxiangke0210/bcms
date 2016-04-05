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
	public void add(Groupz group) {
		groupDao.add(group);
	}

	@Override
	public void delete(int id) {
		List<User> users = userDao.listGroupUsers(id);
		if (users != null && users.size() > 0)
			throw new CmsException("删除的组中还有用户，不能删除");
		groupDao.delete(id);
	}

	@Override
	public Groupz load(int id) {
		return groupDao.load(id);
	}

	@Override
	public void update(Groupz group) {
		groupDao.update(group);
	}

	@Override
	public List<Groupz> listGroup() {
		return groupDao.listGroup();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<Groupz> findGroup() {
		PageHelper.startPage(1, 10);
		List<Groupz> groupzs = groupDao.findGroup();
		// 用PageInfo对结果进行包装
		@SuppressWarnings({ "rawtypes" })
		PageInfo page = new PageInfo(groupzs);
		return page;
	}

	@Override
	public void deleteGroupUsers(int gid) {
		groupDao.deleteGroupUsers(gid);

	}

	@Override
	public void addGroupChannel(int gid, int cid) {
		Groupz g = groupDao.load(gid);
		Channel c = channelDao.load(cid);
		if (c == null || g == null)
			throw new CmsException("要添加的组频道关联对象不存在");
		groupDao.addGroupChannel(g, c);

	}

	@Override
	public GroupChannel loadGroupChannel(int gid, int cid) {
		return groupDao.loadGroupChannelById(gid, cid);
	}

	@Override
	public void clearGroupChannel(int gid) {
		groupDao.clearGroupChannel(gid);

	}

	@Override
	public void deleteGroupChannel(int gid, int cid) {
		groupDao.deleteGroupChannel(gid, cid);

	}

	@Override
	public List<Integer> listGroupChannelIds(int gid) {
		return groupDao.listGroupChannelIds(gid);
	}

	@Override
	public List<ChannelTree> generateGroupChannelTree(int gid) {
		return groupDao.generateGroupChannelTree(gid);
	}

	@Override
	public List<ChannelTree> generateUserChannelTree(int uid) {
		return groupDao.generateUserChannelTree(uid);
	}

}
