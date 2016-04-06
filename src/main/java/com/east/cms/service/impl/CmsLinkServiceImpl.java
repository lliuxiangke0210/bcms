package com.east.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.CmsLinkMapper;
import com.east.cms.model.CmsLink;
import com.east.cms.service.CmsLinkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("cmsLinkService")
public class CmsLinkServiceImpl implements CmsLinkService {

	@Resource
	private CmsLinkMapper cmsLinkDao;

	@Override
	public void add(CmsLink cl) {
		cmsLinkDao.addSelect(cl);

	}

	@Override
	public void delete(int id) {
		cmsLinkDao.delete(id);

	}

	@Override
	public void update(CmsLink cl) {
		cmsLinkDao.update(cl);

	}

	@Override
	public CmsLink load(int id) {
		return cmsLinkDao.load(id);
	}

	@Override
	public PageInfo<CmsLink> findByType(String type) {
		PageHelper.startPage(1, 10);
		List<CmsLink> cmsLinks = cmsLinkDao.findByType(type);
		// 用PageInfo对结果进行包装
		@SuppressWarnings({ "rawtypes" })
		PageInfo page = new PageInfo(cmsLinks);
		return page;
	}

	@Override
	public List<CmsLink> listByType(String type) {
		return cmsLinkDao.listByType(type);
	}

	@Override
	public List<String> listAllType() {
		return cmsLinkDao.listAllType();
	}

	@Override
	public Map<String, Integer> getMinAndMaxPos() {
		return cmsLinkDao.getMinAndMaxPos();
	}

	@Override
	public void updatePos(int id, int oldPos, int newPos) {
		cmsLinkDao.updatePos(id, oldPos, newPos);

	}

}
