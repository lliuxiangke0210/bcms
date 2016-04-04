/**
 * 
 */
/**
 * @author lxk
 *
 */
package com.east.cms.dao.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.CmsLinkMapper;
import com.east.cms.model.CmsLink;

@Service("cmsLinkDaoTest")
public class CmsLinkDaoTest {

	@Resource
	private CmsLinkMapper cmsLinkMapper;

	public void findByType() {

		List<CmsLink> cmsLinks = cmsLinkMapper.findByType(null);
		System.out.println(cmsLinks);

	}

	public void listByType() {

		List<CmsLink> cmsLinks = cmsLinkMapper.listByType("1");
		System.out.println(cmsLinks);

	}

	public void listAllType() {

		List<String> types = cmsLinkMapper.listAllType();
		System.out.println(types);

	}

	public void getMinAndMaxPos() {

		Map<String, Integer> maps = cmsLinkMapper.getMinAndMaxPos();
		System.out.println(maps);

	}

	public void addSelect() {
		CmsLink cmsLink = new CmsLink();
		cmsLink.setNewWin("6");
		cmsLink.setTitle("hello world");
		cmsLink.setType("sd");
		cmsLink.setUrl("www.google.com");
		cmsLink.setUrlClass("gasd");
		cmsLink.setUrlId("7");
		CmsLink testcms = cmsLinkMapper.addSelect(cmsLink);
		System.out.println(testcms.getPos());

	}

}