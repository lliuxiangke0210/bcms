package com.east.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.model.Role;
import com.east.cms.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleControllerTest {

	@Autowired
	private RoleService roleServcie;

	@RequestMapping(value = "/service1", method = RequestMethod.GET)
	public ModelAndView userService1Test(ModelAndView model) {
		Role role = roleServcie.load(2);
		System.out.println(role);
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/service2", method = RequestMethod.GET)
	public ModelAndView userService2Test(ModelAndView model) {
		Role role = new Role();
		role.setId(2);
		role.setName("hr");
		role.setRoleType("1");
		roleServcie.updateSelective(role);
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/service3", method = RequestMethod.GET)
	public ModelAndView userService3Test(ModelAndView model) {
		Role role = new Role();
		role.setName("hrdd");
		role.setRoleType("1");
		roleServcie.add(role);
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/service4", method = RequestMethod.GET)
	public ModelAndView userService4Test(ModelAndView model) {

		model.setViewName("/index");
		return model;
	}

}