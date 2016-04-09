package com.east.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.dao.test.AttachmentDaoTest;
import com.east.cms.dao.test.ChannelDaoTest;
import com.east.cms.dao.test.CmsLinkDaoTest;
import com.east.cms.dao.test.GroupDaoTest;
import com.east.cms.dao.test.RoleDaoTest;
import com.east.cms.dao.test.TopicDaoTest;
import com.east.cms.dao.test.UserDaoTest;
import com.east.cms.service.GroupService;
import com.east.cms.service.UserService;

@Controller
@RequestMapping("/group")
public class GroupControllerTest {

	@Autowired
	private UserService userServcie;

	@Autowired
	private UserDaoTest userDaoTest;
	@Autowired
	private RoleDaoTest roleDaoTest;
	@Autowired
	private ChannelDaoTest channelDaoTest;
	@Autowired
	private AttachmentDaoTest attachmentDaoTest;
	@Autowired
	private CmsLinkDaoTest cmsLinkDaoTest;
	@Autowired
	private TopicDaoTest topicDaoTest;
	@Autowired
	private GroupDaoTest groupDaoTest;
	@Autowired
	private GroupService groupService;
	/*
	 * @Autowired private UserServiceTest userServiceTest;
	 */
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/service1", method = RequestMethod.GET)
	public ModelAndView groupService1(ModelAndView model) {

		userServcie.delete(7);
		model.setViewName("/index");
		return model;
	}

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
		// attachmentDaoTest.listByTopic();
		// attachmentDaoTest.findNoUseAttachment();
		// attachmentDaoTest.findNoUseAttachmentNum();
		// attachmentDaoTest.listIndexPic();
		// attachmentDaoTest.findChannelPic();
		// attachmentDaoTest.listAllIndexPic();
		// attachmentDaoTest.listAttachByTopic();
		// cmsLinkDaoTest.findByType();
		// cmsLinkDaoTest.listByType();
		// cmsLinkDaoTest.listAllType();
		// cmsLinkDaoTest.getMinAndMaxPos();
		// cmsLinkDaoTest.addSelect();
		// topicDaoTest.findAll();
		// topicDaoTest.searchTopicByKeyword();
		// topicDaoTest.searchTopic();
		// topicDaoTest.findRecommendTopic();
		// topicDaoTest.listTopicByChannelAndNumber();
		// groupDaoTest.listGroup();
		// groupDaoTest.deleteGroupUsers();
		// groupDaoTest.loadGroupChannelById();
		// groupDaoTest.listGroupChannelIds();
		// groupDaoTest.generateGroupChannelTree();
		// groupDaoTest.generateUserChannelTree();
		groupDaoTest.add();
		model.setViewName("/index");
		return model;
	}

}