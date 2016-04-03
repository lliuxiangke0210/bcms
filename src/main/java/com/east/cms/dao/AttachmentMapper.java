package com.east.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.east.cms.model.Attachment;
import com.east.cms.model.AttachmentTopic;
import com.github.pagehelper.PageInfo;

public interface AttachmentMapper {

	/**
	 * 获取没有被引用的附件
	 * 
	 * @return
	 */
	public PageInfo<Attachment> findNoUseAttachment();

	public long findNoUseAttachmentNum();

	/**
	 * 清空没有被引用的附件
	 */
	public void clearNoUseAttachment();

	/**
	 * 删除某个文章的所有附件
	 * 
	 * @param tid
	 */
	public void deleteByTopic(@Param("topicId") int topicId);

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
	public List<AttachmentTopic> listIndexPic(@Param("num") int num);

	/**
	 * 获取某个栏目中的附件图片信息
	 * 
	 * @param cid
	 * @return
	 */
	public PageInfo<AttachmentTopic> findChannelPic(@Param("channelId") int channelId);

	/**
	 * 获取所有的新闻图片信息
	 * 
	 * @return
	 */
	public PageInfo<AttachmentTopic> listAllIndexPic();

	/**
	 * 获取某篇文章的属于附件类型的附件对象
	 * 
	 * @param tid
	 * @return
	 */
	public List<AttachmentTopic> listAttachByTopic(@Param("topicId") int topicId);

}