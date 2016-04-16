package com.east.cms.controller;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.east.cms.auth.AuthClass;
import com.east.cms.model.BaseInfo;
import com.east.cms.pojo.SystemContext;
import com.east.cms.service.AttachmentService;
import com.east.cms.service.IndexPicService;
import com.east.cms.service.IndexService;
import com.east.cms.utils.BaseInfoUtil;

@RequestMapping("/admin/system")
@Controller
@AuthClass
public class SystemController {

	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private IndexPicService indexPicService;
	@Autowired
	private IndexService indexService;

	@RequestMapping("/baseinfo")
	public String showBaseInfo() {
		return "system/showBaseInfo";
	}

	@RequestMapping(value = "/baseinfo/update", method = RequestMethod.GET)
	public String updateBaseInfo(HttpSession session, Model model) {
		model.addAttribute("baseInfo", session.getServletContext().getAttribute("baseInfo"));
		return "system/updateBaseInfo";
	}

	@RequestMapping(value = "/baseinfo/update", method = RequestMethod.POST)
	public String updateBaseInfo(@Validated BaseInfo baseInfo, BindingResult br, HttpSession session) {
		if (br.hasErrors()) {
			return "system/updateBaseInfo";
		}
		BaseInfo bi = BaseInfoUtil.getInstacne().write(baseInfo);
		session.getServletContext().setAttribute("baseInfo", bi);
		indexService.generateBottom();
		indexService.generateTop();
		return "redirect:/admin/system/baseinfo";
	}

	@RequestMapping("/cleans")
	public String listCleans(Model model) {
		model.addAttribute("attNums", attachmentService.findNoUseAttachmentNum());
		model.addAttribute("indexPics", listNoUseIndexPicNum(indexPicService.listAllIndexPicName()));
		return "system/cleans";
	}

	private File[] listPicFile() {
		String path = SystemContext.getRealPath();
		File f = new File(path + "/resources/indexPic");
		File[] fs = f.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isDirectory())
					return false;
				return true;
			}
		});
		return fs;
	}

	@RequestMapping("/cleanList/{name}")
	public String cleanList(@PathVariable String name, Model model) {
		if (name.equals("atts")) {
			model.addAttribute("datas", attachmentService.findNoUseAttachment());
			return "system/cleanAtts";
		} else if (name.equals("pics")) {
			model.addAttribute("datas", listNoUseIndexPic(indexPicService.listAllIndexPicName()));
			return "system/cleanPics";
		}
		return "";
	}

	@RequestMapping("/clean/{name}")
	public String clean(@PathVariable String name, Model model) throws IOException {
		if (name.equals("atts")) {
			attachmentService.clearNoUseAttachment();
		} else if (name.equals("pics")) {
			indexPicService.cleanNoUseIndexPic(listNoUseIndexPic(indexPicService.listAllIndexPicName()));
		}
		return "redirect:/admin/system/cleans";
	}

	/**
	 * 获取没有使用的首页图片数量
	 * 
	 * @param pics
	 * @return
	 */
	private int listNoUseIndexPicNum(List<String> pics) {
		File[] fs = listPicFile();
		int count = 0;
		for (File file : fs) {
			if (!pics.contains(file.getName()))
				count++;
		}
		return count;
	}

	/**
	 * 获取没有使用的首页图片列表
	 * 
	 * @param pics
	 * @return
	 */
	private List<String> listNoUseIndexPic(List<String> pics) {
		File[] fs = listPicFile();
		List<String> npics = new ArrayList<String>();
		for (File f : fs) {
			if (!pics.contains(f.getName()))
				npics.add(f.getName());
		}
		return npics;
	}
}
