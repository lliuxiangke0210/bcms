package com.east.cms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.east.cms.model.AttachmentTopic;
import com.east.cms.model.Channel;
import com.east.cms.model.Topic;
import com.east.cms.pojo.ChannelType;
import com.east.cms.pojo.SystemContext;
import com.east.cms.service.AttachmentService;
import com.east.cms.service.ChannelService;
import com.east.cms.service.KeywordService;
import com.east.cms.service.TopicService;
import com.east.cms.utils.BaseInfoUtil;
import com.github.pagehelper.PageInfo;

@Controller
public class IndexController {
	@Autowired
	private ChannelService channelService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private KeywordService keywordService;

	@RequestMapping({ "/", "/index" })
	public String index(Model model) {
		model.addAttribute("baseInfo", BaseInfoUtil.getInstacne().read());
		return "index/index";
	}

	@RequestMapping("/channel/{cid}")
	public String showChannel(@PathVariable int cid, Model model, HttpServletResponse resp, HttpServletRequest req)
			throws IOException {
		Channel c = channelService.load(cid);
		System.out.println(c.getChannelType());
		Channel pc = null;
		if (c.getChannelType() == ChannelType.NAV_CHANNEL) {
			pc = c;
			// 如果是导航栏目，需要获取该栏目中的第一个栏目
			c = channelService.loadFirstChannelByNav(c.getId());
		} else {
			pc = channelService.load(c.getParentId());
		}
		// System.out.println(c.getType()==ChannelType.TOPIC_LIST);
		// System.out.println(c.getType());
		if (c.getChannelType() == ChannelType.TOPIC_CONTENT) {
			resp.sendRedirect(req.getContextPath() + "/topic/" + topicService.loadLastedTopicByColumn(cid).getId());
		} else if (c.getChannelType() == ChannelType.TOPIC_IMG) {
			SystemContext.setPageSize(16);
			SystemContext.setSort("a.topic.publishDate");
			SystemContext.setOrder("desc");
			PageInfo<AttachmentTopic> atts = attachmentService.findChannelPic(cid);
			model.addAttribute("datas", atts);
		} else if (c.getChannelType() == ChannelType.TOPIC_LIST) {
			SystemContext.setSort("t.publishDate");
			SystemContext.setOrder("desc");
			// System.out.println(c.getType());
			model.addAttribute("datas", topicService.find(c.getId(), null, 1));
		}
		SystemContext.removeSort();
		SystemContext.removeOrder();
		model.addAttribute("pc", pc);
		model.addAttribute("cs", channelService.listUseChannelByParent(pc.getId()));
		model.addAttribute("channel", c);
		if (c.getChannelType() == ChannelType.TOPIC_LIST) {
			return "index/channel";
		} else {
			return "index/channel_pic";
		}
	}

	@RequestMapping("/topic/{tid}")
	public String showTopic(@PathVariable int tid, Model model) {
		model.addAttribute("topic", topicService.load(tid));
		List<AttachmentTopic> atts = attachmentService.listAttachByTopic(tid);
		if (atts.size() > 0) {
			model.addAttribute("hasAtts", true);
			model.addAttribute("atts", atts);
		} else {
			model.addAttribute("hasAtts", false);
		}
		return "index/topic";
	}

	@RequestMapping("/search/{con}")
	public String search(@PathVariable String con, Model model) {
		SystemContext.setOrder("asc");
		SystemContext.setSort("c.orders");
		model.addAttribute("cs", channelService.listChannelByType(ChannelType.NAV_CHANNEL));
		SystemContext.setOrder("desc");
		SystemContext.setSort("t.publishDate");
		PageInfo<Topic> topics = topicService.searchTopic(con);
		emp(topics, con);
		model.addAttribute("datas", topics);
		model.addAttribute("con", con);
		return "index/search";
	}

	@RequestMapping("/keyword/{con}")
	public String keyword(@PathVariable String con, Model model) {
		model.addAttribute("kws", keywordService.getMaxTimesKeyword(9));
		SystemContext.setOrder("desc");
		SystemContext.setSort("t.publishDate");
		PageInfo<Topic> topics = topicService.searchTopicByKeyword(con);
		emp(topics, con);
		model.addAttribute("datas", topics);
		model.addAttribute("con", con);
		return "index/keyword";
	}

	private void emp(PageInfo<Topic> topics, String con) {
		for (Topic t : topics.getList()) {
			if (t.getTitle().contains(con)) {
				String tt = t.getTitle().replaceAll(con, "<span class='emp'>" + con + "</span>");
				t.setTitle(tt);
			}
		}
	}
}
