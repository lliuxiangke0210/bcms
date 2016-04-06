package com.east.cms.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.east.cms.model.Attachment;
import com.east.cms.model.AttachmentTopic;
import com.github.pagehelper.PageInfo;

public interface AttachmentService {

	public void add(Attachment a, InputStream is) throws IOException;

	public void delete(int id);

	public AttachmentTopic load(int id);

	/**
	 * 获取没有被引用的附件
	 * 
	 * @return
	 */
	public PageInfo<Attachment> findNoUseAttachment();

	/**
	 * 清空没有被引用的附件
	 */
	public void clearNoUseAttachment();

	/**
	 * 获取某个文章的附件
	 * 
	 * @param tid
	 * @return
	 */
	public List<AttachmentTopic> listByTopic(int tid);

	/**
	 * 根据一个数量获取首页图片的附件信息
	 * 
	 * @param num
	 * @return
	 */
	public List<AttachmentTopic> listIndexPic(int num);

	/**
	 * 获取某个栏目中的附件图片信息
	 * 
	 * @param cid
	 * @return
	 */
	public PageInfo<AttachmentTopic> findChannelPic(int cid);

	/**
	 * 获取某篇文章的属于附件类型的附件对象
	 * 
	 * @param tid
	 * @return
	 */
	public List<AttachmentTopic> listAttachByTopic(int tid);

	public void updateIndexPic(int aid);

	public void updateAttachInfo(int aid);

	public PageInfo<AttachmentTopic> listAllPic();

	public long findNoUseAttachmentNum();

}
