package com.east.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.AttachmentMapper;
import com.east.cms.dao.ChannelMapper;
import com.east.cms.dao.TopicMapper;
import com.east.cms.dao.UserMapper;
import com.east.cms.model.AttachmentTopic;
import com.east.cms.model.Channel;
import com.east.cms.model.Topic;
import com.east.cms.model.User;
import com.east.cms.pojo.CmsException;
import com.east.cms.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("TopicService")
public class TopicServiceImpl implements TopicService {

	@Resource
	private TopicMapper topicDao;
	@Resource
	private AttachmentMapper attachmentDao;
	@Resource
	private ChannelMapper channelDao;
	@Resource
	private UserMapper userDao;

	private void addTopicAtts(Topic topic, Integer[] aids) {
		if (aids != null) {
			for (Integer aid : aids) {
				AttachmentTopic a = attachmentDao.load(aid);
				if (a == null)
					continue;
				a.setTopicId(topic.getId());
			}
		}
	}

	@Override
	public void add(Topic topic, int cid, int uid, Integer[] aids) {
		Channel c = channelDao.load(cid);
		User u = userDao.load(uid);
		if (c == null || u == null)
			throw new CmsException("要添加的文章必须有用户和栏目");
		topic.setAuthor(u.getNickname());
		topic.setCname(c.getChannelName());
		topic.setCreateDate(new Date());
		topic.setChannelId(c.getId());
		topic.setUserId(u.getId());
		topicDao.add(topic);
		addTopicAtts(topic, aids);
	}

	@Override
	public void add(Topic topic, int cid, int uid) {
		add(topic, cid, uid, null);

	}

	@Override
	public void delete(int id) {
		List<AttachmentTopic> atts = attachmentDao.listByTopic(id);
		attachmentDao.deleteByTopic(id);
		topicDao.delete(id);
		// 删除硬盘上面的文件
		for (AttachmentTopic a : atts) {
			AttachmentServiceImpl.deleteAttachFiles(a);
		}

	}

	@Override
	public void update(Topic topic, int cid, Integer[] aids) {
		Channel c = channelDao.load(cid);
		if (c == null)
			throw new CmsException("要更新的文章必须有用户和栏目");
		topic.setCname(c.getChannelName());
		topic.setChannelId(c.getId());
		topicDao.update(topic);
		addTopicAtts(topic, aids);

	}

	@Override
	public void update(Topic topic, int cid) {
		update(topic, cid, null);

	}

	@Override
	public void updateStatus(int tid) {
		Topic t = topicDao.load(tid);
		if (t.getStatus() == 0)
			t.setStatus(1);
		else
			t.setStatus(0);
		topicDao.update(t);

	}

	@Override
	public Topic load(int id) {
		return topicDao.load(id);
	}

	@Override
	public PageInfo<Topic> find(Integer cid, String title, Integer status) {// oo
		PageHelper.startPage(1, 10);
		List<Topic> topics = topicDao.find(cid, title, status);
		// 用PageInfo对结果进行包装
		PageInfo<Topic> page = new PageInfo<Topic>(topics);
		return page;

	}

	@Override
	public PageInfo<Topic> find(Integer uid, Integer cid, String title, Integer status) {// oo
		PageHelper.startPage(1, 10);
		List<Topic> topics = topicDao.findAll(uid, cid, title, status);
		// 用PageInfo对结果进行包装
		PageInfo<Topic> page = new PageInfo<Topic>(topics);
		return page;

	}

	@Override
	public PageInfo<Topic> searchTopicByKeyword(String keyword) {// oo
		PageHelper.startPage(1, 10);
		List<Topic> topics = topicDao.searchTopicByKeyword(keyword);
		// 用PageInfo对结果进行包装
		PageInfo<Topic> page = new PageInfo<Topic>(topics);
		return page;
	}

	@Override
	public PageInfo<Topic> searchTopic(String con) {// oo
		PageHelper.startPage(1, 10);
		List<Topic> topics = topicDao.searchTopic(con);
		// 用PageInfo对结果进行包装
		PageInfo<Topic> page = new PageInfo<Topic>(topics);
		return page;
	}

	@Override
	public PageInfo<Topic> findRecommendTopic(Integer ci) {// oo
		PageHelper.startPage(1, 10);
		List<Topic> topics = topicDao.findRecommendTopic(ci);
		// 用PageInfo对结果进行包装
		PageInfo<Topic> page = new PageInfo<Topic>(topics);
		return page;
	}

	@Override
	public List<Topic> listTopicByChannelAndNumber(int cid, int num) {// oo
		return topicDao.listTopicByChannelAndNumber(cid, num);
	}

	@Override
	public List<Topic> listTopicByChannel(int cid) {// oo
		return topicDao.listTopicsByChannel(cid);
	}

	@Override
	public boolean isUpdateIndex(int cid) {
		int count = topicDao.isUpdateIndex(cid);
		if (count <= 0)
			return false;
		return true;
	}

	@Override
	public Topic loadLastedTopicByColumn(int cid) {// oo
		return topicDao.loadLastedTopicByColumn(cid);
	}

}
