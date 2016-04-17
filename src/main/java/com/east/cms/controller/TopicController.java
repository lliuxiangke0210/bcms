package com.east.cms.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.east.cms.auth.AuthClass;
import com.east.cms.auth.AuthMethod;
import com.east.cms.model.Attachment;
import com.east.cms.model.ChannelTree;
import com.east.cms.model.Topic;
import com.east.cms.model.User;
import com.east.cms.pojo.AjaxObj;
import com.east.cms.pojo.SystemContext;
import com.east.cms.pojo.TopicDto;
import com.east.cms.service.AttachmentService;
import com.east.cms.service.ChannelService;
import com.east.cms.service.IndexService;
import com.east.cms.service.KeywordService;
import com.east.cms.service.TopicService;
import com.east.cms.utils.JsonUtil;
import com.github.pagehelper.PageInfo;

@Controller
@AuthClass("login")
@RequestMapping("/admin/topic")
public class TopicController {
	@Autowired
	private TopicService topicService;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private KeywordService keywordService;
	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private IndexService indexService;

	private final static List<String> imgTypes = Arrays.asList("jpg", "jpeg", "gif", "png");

	private void initList(String con, Integer cid, Model model, HttpSession session, Integer status) {
		SystemContext.setSort("t.publishDate");
		SystemContext.setOrder("desc");
		boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
		if (isAdmin) {
			PageInfo<Topic> pageInfo = topicService.find(cid, con, status);
			List<Topic> topics = pageInfo.getList();
			model.addAttribute("datas", topics);
			model.addAttribute("total", pageInfo.getTotal());
			model.addAttribute("pageSize", pageInfo.getPageSize());
		} else {
			User loginUser = (User) session.getAttribute("loginUser");
			PageInfo<Topic> pageInfo = topicService.find(loginUser.getId(), cid, con, status);
			List<Topic> topics = pageInfo.getList();
			model.addAttribute("datas", topics);
			model.addAttribute("total", pageInfo.getTotal());
			model.addAttribute("pageSize", pageInfo.getPageSize());
		}
		if (con == null)
			con = "";
		SystemContext.removeOrder();
		SystemContext.removeSort();
		model.addAttribute("con", con);
		model.addAttribute("cid", cid);
		model.addAttribute("cs", channelService.listPublishChannel());
	}

	@RequestMapping("/audits")
	@AuthMethod(role = "ROLE_PUBLISH,ROLE_AUDIT") // oo
	public String auditList(@RequestParam(required = false) String con, @RequestParam(required = false) Integer cid,
			Model model, HttpSession session) {
		initList(con, cid, model, session, 1);
		return "topic/list";
	}

	@RequestMapping("/unaudits")
	@AuthMethod(role = "ROLE_PUBLISH,ROLE_AUDIT")
	public String unauditList(@RequestParam(required = false) String con, @RequestParam(required = false) Integer cid,
			Model model, HttpSession session) {
		initList(con, cid, model, session, 0);
		return "topic/list";
	}

	@RequestMapping("/changeStatus/{id}")
	@AuthMethod(role = "ROLE_AUDIT")
	public String changeStatus(@PathVariable int id, Integer status) {
		topicService.updateStatus(id);
		Topic t = topicService.load(id);
		if (topicService.isUpdateIndex(t.getChannelId())) {
			indexService.generateBody();
		}
		if (status == 0) {
			return "redirect:/admin/topic/unaudits";
		} else {
			return "redirect:/admin/topic/audits";
		}
	}

	@RequestMapping("/delete/{id}")
	@AuthMethod(role = "ROLE_PUBLISH")
	public String delete(@PathVariable int id, Integer status) {
		Topic t = topicService.load(id);
		topicService.delete(id);
		if (topicService.isUpdateIndex(t.getChannelId())) {
			indexService.generateBody();
		}
		if (status == 0) {
			return "redirect:/admin/topic/unaudits";
		} else {
			return "redirect:/admin/topic/audits";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@AuthMethod(role = "ROLE_PUBLISH")
	public String add(Model model) {
		Topic t = new Topic();
		t.setPublishDate(new Date());
		TopicDto td = new TopicDto(t);
		model.addAttribute("topicDto", td);
		return "topic/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Validated TopicDto topicDto, BindingResult br, String[] aks, Integer[] aids,
			HttpSession session) {
		if (br.hasErrors()) {
			return "topic/add";
		}
		Topic t = topicDto.getTopic();
		User loginUser = (User) session.getAttribute("loginUser");
		StringBuffer keys = new StringBuffer();
		if (aks != null) {
			for (String k : aks) {
				keys.append(k).append("|");
				keywordService.addOrUpdate(k);
			}
		}
		t.setKeyword(keys.toString());
		topicService.add(t, topicDto.getCid(), loginUser.getId(), aids);
		if (topicDto.getStatus() == 1 && topicService.isUpdateIndex(topicDto.getCid())) {
			indexService.generateBody();
		}
		return "redirect:/jsp/common/addSuc.jsp";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	@AuthMethod(role = "ROLE_PUBLISH")
	public String update(@PathVariable int id, Model model) {
		Topic t = topicService.load(id);
		String keyword = t.getKeyword();
		if (keyword != null && !"".equals(keyword.trim()))
			model.addAttribute("keywords", keyword.split("\\|"));
		model.addAttribute("atts", attachmentService.listByTopic(id));
		TopicDto td = new TopicDto(t, t.getChannelId());
		model.addAttribute("topicDto", td);
		model.addAttribute("cname", channelService.load(t.getChannelId()).getChannelName());
		return "topic/update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable int id, @Validated TopicDto topicDto, BindingResult br, String[] aks,
			Integer[] aids, HttpSession session) {
		if (br.hasErrors()) {
			return "topic/update";
		}
		Topic tt = topicService.load(id);
		Topic t = topicDto.getTopic();
		StringBuffer keys = new StringBuffer();
		if (aks != null) {
			for (String k : aks) {
				keys.append(k).append("|");
				keywordService.addOrUpdate(k);
			}
		}
		tt.setKeyword(keys.toString());
		tt.setChannelPicId(t.getChannelPicId());
		tt.setContent(t.getContent());
		tt.setPublishDate(t.getPublishDate());
		tt.setRecommend(t.getRecommend());
		tt.setStatus(t.getStatus());
		tt.setSummary(t.getSummary());
		tt.setTitle(t.getTitle());
		topicService.update(tt, topicDto.getCid(), aids);
		if (topicService.isUpdateIndex(topicDto.getCid())) {
			indexService.generateBody();
		}
		return "redirect:/jsp/common/addSuc.jsp";
	}

	@RequestMapping("/{id}")
	public String show(@PathVariable int id, Model model) {
		model.addAttribute(topicService.load(id));
		model.addAttribute("atts", attachmentService.listByTopic(id));
		return "topic/show";
	}

	@RequestMapping(value = "/searchKeyword")
	@AuthMethod(role = "ROLE_PUBLISH")
	public @ResponseBody List<String> searchKeyword(String term) {
		return keywordService.listKeywordStringByCon(term);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST) // 返回的是json类型的值，而uploadify只能接受字符串
	public void upload(MultipartFile attach, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain;charset=utf-8");
		AjaxObj ao = null;
		try {
			Attachment att = new Attachment();
			String ext = FilenameUtils.getExtension(attach.getOriginalFilename());
			System.out.println(ext);
			att.setIsAttach(0);
			if (imgTypes.contains(ext))
				att.setIsImg(1);
			else
				att.setIsImg(0);
			att.setIsIndexPic(0);
			att.setNewName(String.valueOf(new Date().getTime()) + "." + ext);
			att.setOldName(FilenameUtils.getBaseName(attach.getOriginalFilename()));
			att.setSuffix(ext);
			att.setType(attach.getContentType());
			att.setTopicId(null);
			att.setSize(attach.getSize());
			attachmentService.add(att, attach.getInputStream());
			ao = new AjaxObj(1, null, att);
		} catch (IOException e) {
			ao = new AjaxObj(0, e.getMessage());
		}
		resp.getWriter().write(JsonUtil.getInstance().obj2json(ao));
	}

	@RequestMapping("/treeAll")
	@AuthMethod(role = "ROLE_PUBLISH")
	public @ResponseBody List<ChannelTree> tree() {
		return channelService.generateTree();
	}
}
