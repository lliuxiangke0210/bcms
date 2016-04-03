package com.east.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.east.cms.model.Topic;
import com.github.pagehelper.PageInfo;

public interface TopicMapper {
	/**
	 * 根据栏目和标题和状态进行文章的检索 select new
	 * Topic(t.id,t.title,t.keyword,t.status,t.recommend,t.publishDate,t.author,
	 * t.cname)
	 * 
	 * @param cid
	 * @param title
	 * @return
	 */
	public PageInfo<Topic> find(Integer cid, String title, Integer status);

	/**
	 * 根据用户，栏目和标题和状态进行检索
	 * 
	 * @param uid
	 * @param cid
	 * @param title
	 * @return
	 */
	public PageInfo<Topic> find(@Param("userId") Integer userId, @Param("channelId") Integer channelId,
			@Param("title") String title, @Param("status") Integer status);

	/**
	 * 根据关键字进行文章的检索，仅仅只是检索关键字类似的
	 * 
	 * @param keyword
	 * @return
	 */
	public PageInfo<Topic> searchTopicByKeyword(@Param("keyword") String keyword);

	/**
	 * 通过某个条件来检索，该条件会在标题，内容和摘要中检索
	 * 
	 * @param con
	 * @return
	 */
	public PageInfo<Topic> searchTopic(@Param("con") String con);

	/**
	 * 检索某个栏目的推荐文章，如果cid为空，表示检索全部的文章
	 * 
	 * @param ci
	 * @return
	 */
	public PageInfo<Topic> findRecommendTopic(@Param("channelId") Integer channelId);

	/**
	 * 根据栏目和文章的数量获取该栏目中的文章
	 * 
	 * @param cid
	 * @param num
	 * @return
	 */
	public List<Topic> listTopicByChannelAndNumber(@Param("channelId") int channelId, @Param("num") int num);

	public List<Topic> listTopicsByChannel(@Param("channelId") int channelId);

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
	public Topic loadLastedTopicByColumn(@Param("channelId") int channelId);
}