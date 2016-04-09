package com.east.cms.controller;

import java.util.Date;
import java.util.List;

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
import com.east.cms.model.User;
import com.east.cms.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/admin/user")
public class UserControllerTest {

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
	/*
	 * @Autowired private UserServiceTest userServiceTest;
	 */
	@Autowired
	private UserService userService;

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
		groupDaoTest.listGroup();
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public ModelAndView userServiceTest(ModelAndView model) {
		User user = new User();
		user.setId(10);
		int rid = 2;
		userService.addUserRole(user, rid);
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/service2", method = RequestMethod.GET)
	public ModelAndView userService2Test(ModelAndView model) {// oo
		User user = new User();
		user.setId(10);
		int gid = 8;
		userService.addUserGroup(user, gid);
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/service3", method = RequestMethod.GET)
	public ModelAndView userService3Test(ModelAndView model) {
		User user = new User();
		user.setUsername("abcddefg");
		user.setPassword("1234");
		Integer[] roleIds = { 2, 3, 5 };
		Integer[] groupIds = { 8, 9, 10 };
		userService.add(user, roleIds, groupIds);
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/service4", method = RequestMethod.GET)
	public ModelAndView userService4Test(ModelAndView model) {
		userServcie.delete(220);
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/service5", method = RequestMethod.GET)
	public ModelAndView userService5Test(ModelAndView model) {
		User user = new User();
		user.setId(221);
		user.setCreateDate(new Date());
		user.setEmail("liuxiangke0210@sina.com");
		user.setNickname("cdb");
		user.setPassword("12345");
		user.setPhone("15221618739");
		user.setStatus(2);
		user.setUsername("hello");
		userServcie.update(user);
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/service6", method = RequestMethod.GET)
	public ModelAndView userService6Test(ModelAndView model) {
		PageInfo<User> pageInfo = userServcie.findUser();
		List<User> users = pageInfo.getList();
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println(users);
		System.out.println(pageInfo.getPageSize());
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getStartRow());
		System.out.println(pageInfo.getNavigatepageNums());
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/service7", method = RequestMethod.GET)
	public ModelAndView userService7Test(ModelAndView model) {
		User user = userServcie.load(221);
		System.out.println(user);
		model.setViewName("/index");
		return model;
	}

}