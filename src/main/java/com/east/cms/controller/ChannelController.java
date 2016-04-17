package com.east.cms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.east.cms.auth.AuthClass;
import com.east.cms.model.Channel;
import com.east.cms.model.ChannelTree;
import com.east.cms.pojo.AjaxObj;
import com.east.cms.pojo.ChannelType;
import com.east.cms.pojo.TreeDto;
import com.east.cms.service.ChannelService;
import com.east.cms.service.IndexService;
import com.east.cms.utils.JsonUtil;

@RequestMapping("/admin/channel")
@Controller
@AuthClass
public class ChannelController {
	@Autowired
	private ChannelService channelService;
	@Autowired
	private IndexService indexService;

	@RequestMapping("/channels")
	public String list(Model model) {
		model.addAttribute("treeDatas", JsonUtil.getInstance().obj2json(channelService.generateTree()));
		return "channel/list";
	}

	@RequestMapping("/channels/{pid}")
	public String listChild(@PathVariable Integer pid, @Param Integer refresh, Model model) {
		Channel pc = null;
		if (refresh == null) {
			model.addAttribute("refresh", 0);
		} else {
			model.addAttribute("refresh", 1);
		}
		if (pid == null || pid <= 0) {
			pc = new Channel();
			pc.setChannelName(Channel.ROOT_NAME);
			pc.setId(Channel.ROOT_ID);
		} else
			pc = channelService.load(pid);
		model.addAttribute("pc", pc);
		model.addAttribute("channels", channelService.listByParent(pid));
		return "channel/list_child";
	}

	@RequestMapping("/treeAll")
	public @ResponseBody List<ChannelTree> tree() {
		return channelService.generateTree();
	}

	@RequestMapping(value = "/treeAs", method = RequestMethod.POST)
	public @ResponseBody List<TreeDto> tree(@Param Integer pid) {
		List<TreeDto> tds = new ArrayList<TreeDto>();
		if (pid == null || pid <= 0) {
			tds.add(new TreeDto(0, "网站根栏目", 1));
			return tds;
		}
		List<ChannelTree> cts = channelService.generateTreeByParent(pid);
		for (ChannelTree ct : cts) {
			tds.add(new TreeDto(ct.getId(), ct.getChannelName(), 1));
		}
		return tds;
	}

	private void initAdd(Model model, Integer pid) {
		if (pid == null)
			pid = 0;
		Channel pc = null;
		if (pid == 0) {
			pc = new Channel();
			pc.setId(Channel.ROOT_ID);
			pc.setChannelName(Channel.ROOT_NAME);
		} else {
			pc = channelService.load(pid);
		}
		model.addAttribute("pc", pc);
		List<String> types = Arrays.asList(ChannelType.NAV_CHANNEL, ChannelType.TOPIC_CONTENT, ChannelType.TOPIC_IMG,
				ChannelType.TOPIC_LIST);
		model.addAttribute("types", types);
	}

	@RequestMapping(value = "/add/{pid}", method = RequestMethod.GET)
	public String add(@PathVariable Integer pid, Model model) {
		initAdd(model, pid);
		model.addAttribute(new Channel());
		return "channel/add";
	}

	@RequestMapping(value = "/add/{pid}", method = RequestMethod.POST)
	public String add(@PathVariable Integer pid, Channel channel, BindingResult br, Model model) {
		if (br.hasErrors()) {
			initAdd(model, pid);
			return "channel/add";
		}
		channelService.add(channel, pid);
		indexService.generateTop();
		return "redirect:/admin/channel/channels/" + pid + "?refresh=1";
	}

	@RequestMapping("/delete/{pid}/{id}")
	public String delete(@PathVariable Integer pid, @PathVariable Integer id, Model model) {
		channelService.delete(id);
		indexService.generateTop();
		return "redirect:/admin/channel/channels/" + pid + "?refresh=1";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		Channel c = channelService.load(id);
		model.addAttribute("channel", c);
		Channel pc = null;
		if (c.getParentId() == null) {
			pc = new Channel();
			pc.setId(Channel.ROOT_ID);
			pc.setChannelName(Channel.ROOT_NAME);
		} else {
			pc = channelService.load(c.getParentId());
		}
		model.addAttribute("pc", pc);
		// model.addAttribute("types",
		// EnumUtils.enumProp2NameMap(ChannelType.class, "name"));
		List<String> types = Arrays.asList(ChannelType.NAV_CHANNEL, ChannelType.TOPIC_CONTENT, ChannelType.TOPIC_IMG,
				ChannelType.TOPIC_LIST);
		model.addAttribute("types", types);
		return "channel/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable Integer id, Channel channel, BindingResult br, Model model) {
		if (br.hasErrors()) {
			// model.addAttribute("types",
			// EnumUtils.enumProp2NameMap(ChannelType.class, "name"));
			List<String> types = Arrays.asList(ChannelType.NAV_CHANNEL, ChannelType.TOPIC_CONTENT,
					ChannelType.TOPIC_IMG, ChannelType.TOPIC_LIST);
			model.addAttribute("types", types);
			return "channel/update";
		}
		Channel tc = channelService.load(id);
		int pid = 0;
		if (tc.getParentId() != null)
			pid = tc.getParentId();
		tc.setIsCustomLink(channel.getIsCustomLink());
		tc.setCustomLinkUrl(channel.getCustomLinkUrl());
		tc.setIsIndex(channel.getIsIndex());
		tc.setIsTopNav(channel.getIsTopNav());
		tc.setChannelName(channel.getChannelName());
		tc.setIsRecommend(channel.getIsRecommend());
		tc.setChannelStatus(channel.getChannelStatus());
		tc.setChannelType(channel.getChannelType());
		tc.setNavOrder(channel.getNavOrder());
		channelService.update(tc);
		indexService.generateTop();
		return "redirect:/admin/channel/channels/" + pid + "?refresh=1";
	}

	@RequestMapping("/channels/updateSort")
	public @ResponseBody AjaxObj updateSort(@Param Integer[] ids) {
		try {
			channelService.updateSort(ids);
			indexService.generateTop();
		} catch (Exception e) {
			return new AjaxObj(0, e.getMessage());
		}
		return new AjaxObj(1);
	}
}
