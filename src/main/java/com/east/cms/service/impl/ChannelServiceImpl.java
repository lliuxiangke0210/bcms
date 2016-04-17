package com.east.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.ChannelMapper;
import com.east.cms.model.Channel;
import com.east.cms.model.ChannelTree;
import com.east.cms.model.Topic;
import com.east.cms.pojo.ChannelType;
import com.east.cms.pojo.CmsException;
import com.east.cms.service.ChannelService;
import com.east.cms.service.TopicService;

@Service("channelService")
public class ChannelServiceImpl implements ChannelService {
	@Resource
	private ChannelMapper channelDao;
	@Resource
	private TopicService topicService;

	public static void initTreeNode(List<ChannelTree> cts) {
		cts.add(0, new ChannelTree(Channel.ROOT_ID, Channel.ROOT_NAME, -1));
		for (ChannelTree ct : cts) {
			if (ct.getParentId() == null)
				ct.setParentId(0);
		}
	}

	@Override
	public void add(Channel channel, Integer pid) {
		Integer orders = channelDao.getMaxOrderByParent(pid);// oo
		if (pid != null && pid > 0) {
			Channel pc = channelDao.load(pid);
			if (pc == null)
				throw new CmsException("要添加栏目的父类对象不正确!");
			channel.setParentId(pc.getId());
		}
		channel.setOrders(orders + 1);
		channelDao.add(channel);
	}

	@Override
	public void update(Channel channel) {
		channelDao.update(channel);
	}

	@Override
	public void delete(int id) {// oo
		// 1、需要判断是否存在子栏目
		List<Channel> cs = channelDao.listByParent(id);
		if (cs != null && cs.size() > 0)
			throw new CmsException("要删除的栏目还有子栏目，无法删除");
		// 2、需要判断是否存在文章
		List<Topic> ts = topicService.listTopicByChannel(id);
		if (ts.size() > 0) {
			throw new CmsException("该栏目还有相应的文章信息，不能删除");
		}
		// 3、需要删除和组的关联关系
		channelDao.deleteChannelGroups(id);// oo
		channelDao.delete(id);

	}

	@Override
	public void clearTopic(int id) {
		List<Topic> tops = topicService.listTopicByChannel(id);
		for (Topic t : tops) {
			topicService.delete(t.getId());
		}
	}

	@Override
	public Channel load(int id) {
		return channelDao.load(id);
	}

	@Override
	public List<Channel> listByParent(Integer pid) {// oo
		return channelDao.listByParent(pid);
	}

	@Override
	public List<ChannelTree> generateTree() {// oo
		List<ChannelTree> channelTrees = channelDao.generateTree();
		initTreeNode(channelTrees);
		return channelTrees;
	}

	@Override
	public List<ChannelTree> generateTreeByParent(Integer pid) {// oo

		return channelDao.generateTreeByParent(pid);
	}

	@Override
	public List<Channel> listPublishChannel() {// oo
		return channelDao.listPublishChannel(ChannelType.NAV_CHANNEL);
	}

	@Override
	public List<Channel> listTopNavChannel() {// oo
		return channelDao.listTopNavChannel();
	}

	@Override
	public void updateSort(Integer[] ids) {// oo
		channelDao.updateSort(ids);

	}

	@Override
	public List<Channel> listAllIndexChannel(String channelType) {// oo
		return channelDao.listAllIndexChannel(channelType);
	}

	@Override
	public Channel loadFirstChannelByNav(int cid) {// oo
		return channelDao.loadFirstChannelByNav(cid);
	}

	@Override
	public List<Channel> listUseChannelByParent(Integer cid) {// oo
		return channelDao.listUseChannelByParent(cid);
	}

	@Override
	public List<Channel> listChannelByType(String channelType) {// oo
		return channelDao.listChannelByType(channelType);
	}

}
