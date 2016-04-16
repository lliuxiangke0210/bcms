package com.east.cms.service.impl;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import com.east.cms.service.AttachmentService;
import com.east.cms.service.CmsLinkService;
import com.east.cms.service.DwrService;
import com.east.cms.service.GroupService;
import com.east.cms.service.IndexPicService;

@RemoteProxy(name = "dwrService")
public class DwrServiceImpl implements DwrService {

	@Autowired
	private GroupService groupService;
	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private IndexPicService indexPicService;
	@Autowired
	private CmsLinkService cmsLinkService;

	@Override
	@RemoteMethod
	public void addGroupChannel(int gid, int cid) {
		groupService.addGroupChannel(gid, cid);

	}

	@Override
	@RemoteMethod
	public void deleteGroupChannel(int gid, int cid) {
		groupService.deleteGroupChannel(gid, cid);

	}

	@Override
	@RemoteMethod
	public void updateIndexPic(int aid) {
		System.out.println("dwrservice:" + aid);
		attachmentService.updateIndexPic(aid);

	}

	@Override
	@RemoteMethod
	public void updateAttachInfo(int aid) {
		attachmentService.updateAttachInfo(aid);

	}

	@Override
	@RemoteMethod
	public void deleteAttach(int id) {
		attachmentService.delete(id);

	}

	@Override
	@RemoteMethod
	public void updatePicPos(int id, int oldPos, int newPos) {
		indexPicService.updatePos(id, oldPos, newPos);

	}

	@Override
	@RemoteMethod
	public void updateLinkPos(int id, int oldPos, int newPos) {
		cmsLinkService.updatePos(id, oldPos, newPos);

	}

}
