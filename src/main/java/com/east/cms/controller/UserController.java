package com.east.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.dao.UserDao;
import com.east.com.service.UserServcie;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserServcie userServcie;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView delete(ModelAndView model) {
		System.out.println("hello");
		userServcie.delete(2);
		model.setViewName("redirect:/admin/user/users");
		return model;
	}
}