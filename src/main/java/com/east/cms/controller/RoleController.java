package com.east.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.model.Role;
import com.east.cms.service.RoleService;
import com.east.cms.service.UserService;

@Controller
@RequestMapping("/admin/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;

	@RequestMapping("/roles")
	public ModelAndView list(ModelAndView model) {
		model.addObject("roles", roleService.listRole());
		model.setViewName("role/list");
		return model;
	}

	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable int id, ModelAndView model) {
		model.addObject(roleService.load(id));
		model.addObject("us", userService.listRoleUsers(id));
		model.setViewName("role/show");
		return model;
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable int id, ModelAndView model) {
		roleService.delete(id);
		model.setViewName("redirect:/admin/role/roles");
		return model;
	}

	@RequestMapping("/clearUsers/{id}")
	public ModelAndView clearUsers(@PathVariable int id, ModelAndView model) {
		roleService.deleteRoleUsers(id);
		model.setViewName("redirect:/admin/role/roles");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView model) {
		model.addObject(new Role());
		// model.addObject("types", EnumUtils.enum2Name(RoleType.class));
		model.setViewName("role/add");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(Role role, ModelAndView model) {
		roleService.add(role);
		model.setViewName("redirect:/admin/role/roles");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable int id, ModelAndView model) {
		model.addObject(roleService.load(id));
		// model.addObject("types", EnumUtils.enum2Name(RoleType.class));
		model.setViewName("role/update");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable int id, Role role, ModelAndView model) {
		Role er = roleService.load(id);
		er.setName(role.getName());
		er.setRoleType(role.getRoleType());
		roleService.update(er);
		model.setViewName("redirect:/admin/role/roles");
		return model;
	}

}