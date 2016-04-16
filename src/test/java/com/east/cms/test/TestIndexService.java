package com.east.cms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.east.cms.pojo.SystemContext;
import com.east.cms.service.IndexService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestIndexService {

	private IndexService indexService;
	private String rp = "D:\\teach_source\\class2\\j2EE\\cms_2013\\cms-web\\src\\main\\webapp";

	@Test
	public void testGenerateTop() {
		SystemContext.setRealPath(rp);
		indexService.generateTop();
	}

	@Test
	public void testGenerateBody() {
		SystemContext.setRealPath(rp);
		indexService.generateBody();
	}
}
