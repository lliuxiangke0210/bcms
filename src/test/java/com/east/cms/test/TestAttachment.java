package com.east.cms.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.east.cms.model.Attachment;
import com.east.cms.pojo.SystemContext;
import com.east.cms.service.AttachmentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestAttachment {

	@Autowired
	private AttachmentService attachmentService;

	@Test
	public void testAddAttachment() throws IOException {
		SystemContext.setRealPath("D:\\teach_source\\class2\\j2EE\\cms_2013\\cms-web\\src\\main\\webapp");
		Attachment attach = new Attachment();
		attach.setIsAttach(0);
		attach.setIsImg(1);
		attach.setIsIndexPic(0);
		attach.setNewName("aaaaa.jpg");
		attach.setOldName("abc.jpg");
		attach.setSize(Long.valueOf(111111));
		attach.setSuffix("jpg");
		// InputStream is = new FileInputStream("e:/br/01.jpg");
		// attachmentService.add(attach, is);
		// System.out.println(attach.getId());
	}
}
