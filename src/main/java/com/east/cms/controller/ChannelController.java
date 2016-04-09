package com.east.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.service.ChannelService;

@RequestMapping("/admin/channel")
@Controller
// @AuthClass
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	@RequestMapping(value = "/service1", method = RequestMethod.GET)
	public ModelAndView userService1Test(ModelAndView model) {

		model.setViewName("/index");
		return model;
	}
}