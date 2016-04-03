package com.east.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.dao.test.AttachmentDaoTest;
import com.east.cms.dao.test.ChannelDaoTest;
import com.east.cms.dao.test.RoleDaoTest;
import com.east.cms.dao.test.UserDaoTest;
import com.east.com.service.UserServcie;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServcie userServcie;

	@Autowired
	private UserDaoTest userDaoTest;
	@Autowired
	private RoleDaoTest roleDaoTest;
	@Autowired
	private ChannelDaoTest channelDaoTest;
	@Autowired
	private AttachmentDaoTest attachmentDaoTest;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView delete(ModelAndView model) {
		// userDaoTest.loadByUsername();
		// roleDaoTest.listRole();
		// userDaoTest.listUserRoles();
		// userDaoTest.listUserRoleIds();
		// userDaoTest.listUserGroups();
		// userDaoTest.listUserGroupIds();
		// userDaoTest.loadUserRole();
		// userDaoTest.loadUserGroup();
		// userDaoTest.loadByUsername();
		// userDaoTest.listRoleUsers();
		// userDaoTest.listRoleUsersByType();
		// userDaoTest.listGroupUsers();
		// userDaoTest.addUserRole();
		// userDaoTest.addUserGroup();
		// userDaoTest.deleteUserRoles();
		// roleDaoTest.listRole();
		// roleDaoTest.deleteRoleUsers();
		// channelDaoTest.listByParent();
		// channelDaoTest.getMaxOrderByParent();
		// channelDaoTest.updateSort();
		// channelDaoTest.listPublishChannel();
		// channelDaoTest.listAllIndexChannel();
		// channelDaoTest.listTopNavChannel();
		attachmentDaoTest.listByTopic();
		model.setViewName("/index");
		return model;
	}
}