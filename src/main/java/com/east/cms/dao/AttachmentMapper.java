package com.east.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.east.cms.model.Attachment;
import com.east.cms.model.AttachmentTopic;

public interface AttachmentMapper {

	/**
	 * 获取没有被引用的附件 pageInfo
	 * 
	 * @return
	 */
	public List<Attachment> findNoUseAttachment();// oo

	public Integer findNoUseAttachmentNum();// oo

	/**
	 * 清空没有被引用的附件
	 */
	public void clearNoUseAttachment();// oo

	/**
	 * 删除某个文章的所有附件
	 * 
	 * @param tid
	 */
	public void deleteByTopic(@Param("topicId") int topicId);// oo

	/**
	 * 获取某个文章的附件
	 * 
	 * @param tid
	 * @return
	 */
	public List<AttachmentTopic> listByTopic(@Param("topicId") int topicId);// oo

	/**
	 * 根据一个数量获取首页图片的附件信息
	 * 
	 * @param num
	 * @return
	 */
	public List<AttachmentTopic> listIndexPic(@Param("num") int num);// oo

	/**
	 * 获取某个栏目中的附件图片信息 PageInfo
	 * 
	 * @param cid
	 * @return
	 */
	public List<AttachmentTopic> findChannelPic(@Param("channelId") int channelId);// oo

	/**
	 * 获取所有的新闻图片信息 PageInfo
	 * 
	 * @return
	 */
	public List<AttachmentTopic> listAllIndexPic();// oo

	/**
	 * 获取某篇文章的属于附件类型的附件对象
	 * 
	 * @param tid
	 * @return
	 */
	public List<AttachmentTopic> listAttachByTopic(@Param("topicId") int topicId);// oo

}