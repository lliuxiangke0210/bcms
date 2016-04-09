package com.east.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.east.cms.model.Topic;

public interface TopicMapper {
	/**
	 * 根据栏目和标题和状态进行文章的检索 select new
	 * Topic(t.id,t.title,t.keyword,t.status,t.recommend,t.publishDate,t.author,
	 * t.cname)
	 * 
	 * PageInfo
	 * 
	 * @param cid
	 * @param title
	 * @return
	 */
	public List<Topic> find(@Param("channelId") Integer channelId, @Param("title") String title,
			@Param("status") Integer status);// oo

	/**
	 * 根据用户，栏目和标题和状态进行检索
	 * 
	 * PageInfo
	 * 
	 * @param uid
	 * @param cid
	 * @param title
	 * @return
	 */
	public List<Topic> findAll(@Param("userId") Integer userId, @Param("channelId") Integer channelId,
			@Param("title") String title, @Param("status") Integer status);// oo

	/**
	 * 根据关键字进行文章的检索，仅仅只是检索关键字类似的
	 * 
	 * PageInfo
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Topic> searchTopicByKeyword(@Param("keyword") String keyword);// oo

	/**
	 * 通过某个条件来检索，该条件会在标题，内容和摘要中检索
	 * 
	 * PageInfo
	 * 
	 * @param con
	 * @return
	 */
	public List<Topic> searchTopic(@Param("con") String con);// oo

	/**
	 * 检索某个栏目的推荐文章，如果cid为空，表示检索全部的文章
	 * 
	 * PageInfo
	 * 
	 * @param ci
	 * @return
	 */
	public List<Topic> findRecommendTopic(@Param("channelId") Integer channelId);// oo

	/**
	 * 根据栏目和文章的数量获取该栏目中的文章
	 * 
	 * @param cid
	 * @param num
	 * @return
	 */
	public List<Topic> listTopicByChannelAndNumber(@Param("channelId") int channelId, @Param("num") int num);// oo

	public List<Topic> listTopicsByChannel(@Param("channelId") int channelId);// oo

	/**
	 * 判断所添加文章的栏目是否需要进行更新
	 * 
	 * @param cid
	 * @return
	 */
	public boolean isUpdateIndex(@Param("channelId") int channelId);

	/**
	 * 获取某个栏目中的最新的可用文章
	 * 
	 * @param cid
	 * @return
	 */
	public Topic loadLastedTopicByColumn(@Param("channelId") int channelId);// oo

	public void delete(@Param("topicId") int topicId);

	public void add(@Param("topic") Topic topic);

	public void update(@Param("topic") Topic topic);

	public Topic load(@Param("topicId") int topicId);

}