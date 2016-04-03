/**
 * 
 */
/**
 * @author lxk
 *
 */
package com.east.cms.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.ChannelMapper;
import com.east.cms.model.Channel;

@Service("channelDaoTest")
public class ChannelDaoTest {

	@Resource
	private ChannelMapper channelMapper;

	public void listByParent() {

		List<Channel> channels = channelMapper.listByParent(0);
		System.out.println(channels);

	}

	public void getMaxOrderByParent() {

		Integer maxOrders = channelMapper.getMaxOrderByParent(4);
		System.out.println(maxOrders);
	}

	public void updateSort() {
		Integer[] ids = { 21, 22, 23 };
		channelMapper.updateSort(ids);
	}

	public void listPublishChannel() {

		List<Channel> channels = channelMapper.listPublishChannel("导航栏目");
		System.out.println(channels);
	}

	public void listAllIndexChannel() {

		List<Channel> channels = channelMapper.listAllIndexChannel("导航栏目");
		System.out.println(channels);
	}

	public void listTopNavChannel() {

		List<Channel> channels = channelMapper.listTopNavChannel();
		System.out.println(channels);
	}

}