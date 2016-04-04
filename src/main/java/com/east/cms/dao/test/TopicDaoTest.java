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

import com.east.cms.dao.TopicMapper;
import com.east.cms.model.Topic;

@Service("topicDaoTest")
public class TopicDaoTest {

	@Resource
	private TopicMapper topicMapper;

	public void findAll() {

		List<Topic> topics = topicMapper.findAll(3, 2, "hello", 1);
		System.out.println(topics);

	}

	public void searchTopicByKeyword() {

		List<Topic> topics = topicMapper.searchTopicByKeyword("lxk");
		System.out.println(topics);

	}

	public void searchTopic() {

		List<Topic> topics = topicMapper.searchTopic("hello");
		System.out.println(topics);

	}

	public void findRecommendTopic() {

		List<Topic> topics = topicMapper.findRecommendTopic(1);
		System.out.println(topics);

	}

	public void listTopicByChannelAndNumber() {

		List<Topic> topics = topicMapper.listTopicByChannelAndNumber(1, 2);
		System.out.println(topics);

	}

}