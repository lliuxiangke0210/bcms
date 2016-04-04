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

import com.east.cms.dao.AttachmentMapper;
import com.east.cms.model.Attachment;
import com.east.cms.model.AttachmentTopic;

@Service("attachmentDaoTest")
public class AttachmentDaoTest {

	@Resource
	private AttachmentMapper attachmentMapper;

	public void listByTopic() {

		List<AttachmentTopic> attachmentTopics = attachmentMapper.listByTopic(1);
		System.out.println(attachmentTopics);

	}

	public void findNoUseAttachment() {

		List<Attachment> attachment = attachmentMapper.findNoUseAttachment();
		System.out.println(attachment);

	}

	public void findNoUseAttachmentNum() {
		Integer num = attachmentMapper.findNoUseAttachmentNum();
		System.out.println(num);
	}

	public void listIndexPic() {
		List<AttachmentTopic> lists = attachmentMapper.listIndexPic(1);
		System.out.println(lists);
	}

	public void findChannelPic() {
		List<AttachmentTopic> lists = attachmentMapper.findChannelPic(1);
		System.out.println(lists);
	}

	public void listAllIndexPic() {
		List<AttachmentTopic> lists = attachmentMapper.listAllIndexPic();
		System.out.println(lists);
	}

	public void listAttachByTopic() {
		List<AttachmentTopic> lists = attachmentMapper.listAttachByTopic(1);
		System.out.println(lists);
	}

}