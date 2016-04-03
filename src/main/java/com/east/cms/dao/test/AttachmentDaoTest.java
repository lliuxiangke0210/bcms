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
import com.east.cms.model.AttachmentTopic;

@Service("attachmentDaoTest")
public class AttachmentDaoTest {

	@Resource
	private AttachmentMapper attachmentMapper;

	public void listByTopic() {

		List<AttachmentTopic> attachmentTopics = attachmentMapper.listByTopic(1);
		System.out.println(attachmentTopics);

	}

}