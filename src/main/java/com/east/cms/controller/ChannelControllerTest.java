package com.east.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.service.ChannelService;

@Controller
@RequestMapping("/channel")
public class ChannelControllerTest {

	@Autowired
	private ChannelService channelServcie;

	@RequestMapping(value = "/service1", method = RequestMethod.GET)
	public ModelAndView userService1Test(ModelAndView model) {

		model.setViewName("/index");
		return model;
	}
}