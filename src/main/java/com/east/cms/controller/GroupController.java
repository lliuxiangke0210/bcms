package com.east.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.auth.AuthClass;
import com.east.cms.model.ChannelTree;
import com.east.cms.model.Groupz;
import com.east.cms.service.GroupService;
import com.east.cms.service.UserService;
import com.github.pagehelper.PageInfo;

@RequestMapping("/admin/group")
@Controller
@AuthClass
public class GroupController {

	@Autowired
	private UserService userService;
	@Autowired
	private GroupService groupService;

	@RequestMapping("/groups")
	public ModelAndView list(ModelAndView model) { // oo
		PageInfo<Groupz> pageInfo = groupService.findGroup();
		List<Groupz> datas = pageInfo.getList();
		model.addObject("datas", datas);
		long total = pageInfo.getTotal();
		model.addObject("total", total);
		int pageSize = pageInfo.getPageSize();
		model.addObject("pageSize", pageSize);
		model.setViewName("group/list");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView model) { // oo
		model.addObject("group", new Groupz());
		model.setViewName("group/add");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@Validated Groupz group, BindingResult br, ModelAndView model) {// oo
		if (br.hasErrors()) {
			model.setViewName("group/add");
			return model;
		}
		groupService.add(group);
		model.setViewName("redirect:/admin/group/groups");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable int id, ModelAndView model) {// oo
		model.addObject("group", groupService.load(id));
		model.setViewName("group/update");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST) // oo
	public ModelAndView update(@PathVariable int id, @Validated Groupz group, BindingResult br, ModelAndView model) {
		if (br.hasErrors()) {
			model.setViewName("group/update");
			return model;
		}
		System.out.println(id);
		Groupz ug = groupService.load(id);
		ug.setDescr(group.getDescr());
		ug.setName(group.getName());
		groupService.update(ug);
		model.setViewName("redirect:/admin/group/groups");
		return model;
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable int id, ModelAndView model) {// oo
		groupService.delete(id);
		model.setViewName("redirect:/admin/group/groups");
		return model;
	}

	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable int id, ModelAndView model) {// oo
		model.addObject("group", groupService.load(id));
		model.addObject("us", userService.listGroupUsers(id));
		model.setViewName("group/show");
		return model;
	}

	@RequestMapping("/clearUsers/{id}")
	public ModelAndView clearGroupUsers(@PathVariable int id, ModelAndView model) {// oo
		groupService.deleteGroupUsers(id);
		model.setViewName("redirect:/admin/group/groups");
		return model;
	}

	@RequestMapping("/listChannels/{gid}")
	public ModelAndView listChannels(@PathVariable int gid, ModelAndView model) {// oo
		model.addObject("group", groupService.load(gid));
		model.setViewName("/group/listChannel");
		return model;
	}

	@RequestMapping("/groupTree/{gid}")
	public @ResponseBody List<ChannelTree> groupTree(@PathVariable Integer gid) {
		return groupService.generateGroupChannelTree(gid);
	}

	@RequestMapping("/setChannels/{gid}")
	public ModelAndView setChannels(@PathVariable int gid, ModelAndView model) {
		model.addObject("group", groupService.load(gid));
		model.addObject("cids", groupService.listGroupChannelIds(gid));
		model.setViewName("/group/setChannel");
		return model;
	}

}