package com.east.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.dao.UserDao;
import com.east.cms.dao.test.RoleDaoTest;
import com.east.cms.dao.test.UserDaoTest;
import com.east.com.service.UserServcie;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserServcie userServcie;
	@Autowired
	private UserDaoTest userDaoTest;
	@Autowired
	private RoleDaoTest roleDaoTest;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView delete(ModelAndView model) {
		System.out.println("hello");
		// userDaoTest.loadByUsername();
		// roleDaoTest.listRole();
		// userDaoTest.listUserRoles();
		// userDaoTest.listUserRoleIds();
		// userDaoTest.listUserGroups();
		// userDaoTest.listUserGroupIds();
		// userDaoTest.loadUserRole();
		userDaoTest.loadUserGroup();
		model.setViewName("/index");
		return model;
	}
}