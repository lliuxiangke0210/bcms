package com.east.cms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.auth.AuthMethod;
import com.east.cms.pojo.CmsSessionContext;

@Controller
// @AuthClass("login")
public class AdminController {

	@RequestMapping("/admin")
	@AuthMethod
	public ModelAndView index(ModelAndView model) {
		model.setViewName("admin/index");
		return model;
	}

	@AuthMethod
	@RequestMapping("/admin/logout")
	public ModelAndView logout(HttpSession session, ModelAndView model) {
		CmsSessionContext.removeSession(session);
		session.invalidate();
		model.setViewName("redirect:/login");
		return model;
	}
}
