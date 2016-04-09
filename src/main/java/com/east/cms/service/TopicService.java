package com.east.cms.service;

import java.util.List;

import com.east.cms.model.Topic;
import com.github.pagehelper.PageInfo;

public interface TopicService {

	/**
	 * 添加带有附件信息的文章
	 * 
	 * @param topic
	 *            文章对象
	 * @param cid
	 *            文章的栏目
	 * @param uid
	 *            文章的用户
	 * @param aids
	 *            文章的附件id数组
	 */
	public void add(Topic topic, int channelId, int userId, Integer[] aids);

	/**
	 * 添加不带附件信息的文章对象
	 * 
	 * @param topic
	 * @param cid
	 * @param uid
	 */
	public void add(Topic topic, int channelId, int userId);

	/**
	 * 删除文章，先删除文章的附件信息，还得删除附件的文件对象
	 * 
	 * @param id
	 */
	public void delete(int id);

	/**
	 * 更新文章，带附件信息更新
	 * 
	 * @param topic
	 * @param cid
	 * @param aids
	 */
	public void update(Topic topic, int channelId, Integer[] aids);

	/**
	 * 没有带附件信息的文章更新
	 * 
	 * @param topic
	 */
	public void update(Topic topic, int channelId);

	/**
	 * 更新文章的状态
	 * 
	 * @param tid
	 */
	public void updateStatus(int topicId);

	public Topic load(int topicId);

	/**
	 * 根据栏目和标题和状态进行文章的检索
	 * 
	 * @param cid
	 * @param title
	 * @return
	 */
	public PageInfo<Topic> find(Integer channelId, String title, Integer status);

	/**
	 * 根据用户，栏目和标题和状态进行检索
	 * 
	 * @param uid
	 * @param cid
	 * @param title
	 * @return
	 */
	public PageInfo<Topic> find(Integer userId, Integer channelId, String title, Integer status);

	/**
	 * 根据关键字进行文章的检索，仅仅只是检索关键字类似的
	 * 
	 * @param keyword
	 * @return
	 */
	public PageInfo<Topic> searchTopicByKeyword(String keyword);

	/**
	 * 通过某个条件来检索，该条件会在标题，内容和摘要中检索
	 * 
	 * @param con
	 * @return
	 */
	public PageInfo<Topic> searchTopic(String con);

	/**
	 * 检索某个栏目的推荐文章，如果cid为空，表示检索全部的文章
	 * 
	 * @param ci
	 * @return
	 */
	public PageInfo<Topic> findRecommendTopic(Integer ci);

	public List<Topic> listTopicByChannelAndNumber(int channelId, int num);

	public List<Topic> listTopicByChannel(int channelId);

	/**
	 * 判断所添加文章的栏目是否需要进行更新
	 * 
	 * @param cid
	 * @return
	 */
	public boolean isUpdateIndex(int channelId);

	public Topic loadLastedTopicByColumn(int channelId);

}
