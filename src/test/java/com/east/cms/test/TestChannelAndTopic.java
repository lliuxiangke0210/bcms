package com.east.cms.test;

import java.util.List;

import org.apache.shiro.session.mgt.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.east.cms.model.Channel;
import com.east.cms.pojo.ChannelType;
import com.east.cms.service.ChannelService;
import com.east.cms.service.TopicService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestChannelAndTopic {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private TopicService topicService;

	@Test
	public void testTopNav() {
		List<Channel> cs = channelService.listTopNavChannel();
		for (Channel c : cs) {
			System.out.println(
					c.getId() + "," + c.getChannelName() + "," + c.getIsCustomLink() + "," + c.getCustomLinkUrl());
		}
	}

	@Test
	public void testIndexChannel() {
		List<Channel> cs = channelService.listAllIndexChannel(ChannelType.TOPIC_LIST);
		for (Channel c : cs) {
			System.out.println(c.getId() + "," + c.getChannelName());
		}
	}

	@Test
	public void testIsUpdateIndex() {
		System.out.println(topicService.isUpdateIndex(7));
	}

	@Test
	public void testLoadLastTopic() {
		System.out.println(topicService.loadLastedTopicByColumn(7).getSummary());
	}

	@Test
	public void testLoadFirstChannel() {
		System.out.println(channelService.loadFirstChannelByNav(1).getChannelName());
	}

	@Test
	public void testListChannelByType() {
		for (Channel c : channelService.listChannelByType(ChannelType.NAV_CHANNEL)) {
			System.out.println(c.getChannelName() + "," + c.getId());
		}
	}

}
