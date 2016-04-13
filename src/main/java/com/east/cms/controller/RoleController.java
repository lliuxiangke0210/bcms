package com.east.cms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.model.Role;
import com.east.cms.pojo.RoleType;
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
	public ModelAndView list(ModelAndView model) {// oo
		model.addObject("roles", roleService.listRole());
		model.setViewName("role/list");
		return model;
	}

	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable int id, ModelAndView model) {// oo
		model.addObject("role", roleService.load(id));
		model.addObject("us", userService.listRoleUsers(id));
		model.setViewName("role/show");
		return model;
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable int id, ModelAndView model) {// oo
		roleService.delete(id);
		model.setViewName("redirect:/admin/role/roles");
		return model;
	}

	@RequestMapping("/clearUsers/{id}")
	public ModelAndView clearUsers(@PathVariable int id, ModelAndView model) {// oo
		roleService.deleteRoleUsers(id);
		model.setViewName("redirect:/admin/role/roles");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView model) {// oo
		model.addObject("role", new Role());
		List<String> roletypes = Arrays.asList(RoleType.ROLE_ADMIN, RoleType.ROLE_AUDIT, RoleType.ROLE_PUBLISH);
		// model.addObject("types", EnumUtils.enum2Name(RoleType.class));
		model.addObject("types", roletypes);
		model.setViewName("role/add");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(Role role, ModelAndView model) {// oo
		roleService.add(role);
		model.setViewName("redirect:/admin/role/roles");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable int id, ModelAndView model) {// oo
		model.addObject("role", roleService.load(id));
		List<String> roletypes = Arrays.asList(RoleType.ROLE_ADMIN, RoleType.ROLE_AUDIT, RoleType.ROLE_PUBLISH);
		// model.addObject("types", EnumUtils.enum2Name(RoleType.class));
		model.addObject("types", roletypes);
		model.setViewName("role/update");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable int id, Role role, ModelAndView model) {// oo
		Role er = roleService.load(id);
		er.setName(role.getName());
		er.setRoleType(role.getRoleType());
		// roleService.update(er);
		roleService.updateSelective(er);
		model.setViewName("redirect:/admin/role/roles");
		return model;
	}

}