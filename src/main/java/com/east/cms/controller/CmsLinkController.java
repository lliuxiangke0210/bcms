package com.east.cms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.model.CmsLink;
import com.east.cms.service.CmsLinkService;

@Controller
// @AuthClass
@RequestMapping("/admin/cmsLink")
public class CmsLinkController {
	@Autowired
	private CmsLinkService cmsLinkService;

	@RequestMapping("/links")
	public ModelAndView list(ModelAndView model, String type) {
		model.addObject("datas", cmsLinkService.findByType(type));
		model.addObject("types", cmsLinkService.listAllType());
		Map<String, Integer> m = cmsLinkService.getMinAndMaxPos();
		model.addObject("min", m.get("min"));
		model.addObject("max", m.get("max"));
		model.setViewName("cmsLink/list");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView model) {
		model.addObject(new CmsLink());
		model.addObject("types", cmsLinkService.listAllType());
		model.setViewName("cmsLink/add");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@Validated CmsLink cmsLink, BindingResult br, ModelAndView model) {
		if (br.hasFieldErrors()) {
			model.setViewName("cmsLink/add");
			return model;
		}
		cmsLinkService.add(cmsLink);
		model.setViewName("redirect:/admin/cmsLink/links");
		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id, ModelAndView model) {
		cmsLinkService.delete(id);
		model.setViewName("redirect:/admin/cmsLink/links");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable int id, ModelAndView model) {
		model.addObject(cmsLinkService.load(id));
		model.addObject("types", cmsLinkService.listAllType());
		model.setViewName("cmsLink/update");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable int id, @Validated CmsLink cmsLink, BindingResult br, ModelAndView model) {
		if (br.hasFieldErrors()) {
			model.setViewName("cmsLink/update");
			return model;
		}
		CmsLink tcl = cmsLinkService.load(id);
		tcl.setNewWin(cmsLink.getNewWin());
		tcl.setTitle(cmsLink.getTitle());
		tcl.setType(cmsLink.getType());
		tcl.setUrl(cmsLink.getUrl());
		tcl.setUrlClass(cmsLink.getUrlClass());
		tcl.setUrlId(cmsLink.getUrlId());
		cmsLinkService.update(tcl);
		model.setViewName("redirect:/admin/cmsLink/links");
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable int id, ModelAndView model) {
		model.addObject(cmsLinkService.load(id));
		model.setViewName("cmsLink/show");
		return model;
	}
}
