package com.east.cms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.auth.AuthClass;
import com.east.cms.auth.AuthMethod;
import com.east.cms.model.ChannelTree;
import com.east.cms.model.Role;
import com.east.cms.model.User;
import com.east.cms.pojo.RoleType;
import com.east.cms.pojo.UserDto;
import com.east.cms.service.ChannelService;
import com.east.cms.service.GroupService;
import com.east.cms.service.RoleService;
import com.east.cms.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/admin/user")
@AuthClass("login")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ChannelService channelService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView delete(ModelAndView model) {// oo

		model.setViewName("/index");
		return model;
	}

	@RequestMapping("/users")
	public ModelAndView list(ModelAndView model) {// oo
		PageInfo<User> pageInfo = userService.findUser();
		List<User> users = pageInfo.getList();
		model.addObject("datas", users);
		model.setViewName("user/list");
		return model;
	}

	private void initAddUser(ModelAndView model) {// oo
		model.addObject("roles", roleService.listRole());
		model.addObject("groups", groupService.listGroup());
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET) // oo
	public ModelAndView add(ModelAndView model) {
		model.addObject("userDto", new UserDto());// user,user
		initAddUser(model);
		model.setViewName("user/add");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(UserDto userDto, BindingResult br, ModelAndView model) {// oo
		if (br.hasErrors()) {
			initAddUser(model);
			model.setViewName("user/add");
			return model;
		}
		userService.add(userDto.getUser(), userDto.getRoleIds(), userDto.getGroupIds());
		model.setViewName("redirect:/admin/user/users");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable int id, ModelAndView model) {// oo
		User u = userService.load(id);
		model.addObject("userDto", new UserDto(u, userService.listUserRoleIds(id), userService.listUserGroupIds(id)));// user,user
		initAddUser(model);
		model.setViewName("user/update");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable int id, UserDto userDto, BindingResult br, ModelAndView model) {// oo
		if (br.hasErrors()) {
			System.out.println(br.hasErrors());
			initAddUser(model);
			model.setViewName("user/update");
			return model;
		}
		User ou = userService.load(id);
		ou.setNickname(userDto.getNickname());
		ou.setPhone(userDto.getPhone());
		ou.setEmail(userDto.getEmail());
		ou.setStatus(userDto.getStatus());
		userService.update(ou, userDto.getRoleIds(), userDto.getGroupIds());
		model.setViewName("redirect:/admin/user/users");
		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id, ModelAndView model) {// oo
		userService.delete(id);
		model.setViewName("redirect:/admin/user/users");
		return model;
	}

	@RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.GET)
	public ModelAndView updateStatus(@PathVariable int id, ModelAndView model) {// oo
		userService.updateStatus(id);
		model.setViewName("redirect:/admin/user/users");
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable int id, ModelAndView model) {// oo
		model.addObject("user", userService.load(id));
		model.addObject("gs", userService.listUserGroups(id));
		model.addObject("rs", userService.listUserRoles(id));
		model.setViewName("user/show");
		return model;
	}

	@RequestMapping("/showSelf")
	@AuthMethod
	public ModelAndView showSelf(ModelAndView model, HttpSession session) {// oo
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			user = userService.load(223);
		}
		model.addObject("user", user);
		model.addObject("gs", userService.listUserGroups(user.getId()));
		model.addObject("rs", userService.listUserRoles(user.getId()));
		model.setViewName("user/show");
		return model;
	}

	@RequestMapping(value = "/updatePwd", method = RequestMethod.GET)
	@AuthMethod
	public ModelAndView updatePwd(ModelAndView model, HttpSession session) {// oo
		User user = (User) session.getAttribute("loginUser");
		if (user == null) {
			user = userService.load(223);
		}
		model.addObject(user);
		model.setViewName("user/updatePwd");
		return model;
	}

	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	@AuthMethod
	public ModelAndView updatePwd(int id, String oldPwd, String password, ModelAndView model) {// oo
		userService.updatePwd(id, oldPwd, password);
		model.setViewName("redirect:/admin/user/showSelf");
		return model;
	}

	@RequestMapping(value = "/updateSelf", method = RequestMethod.GET)
	@AuthMethod
	public ModelAndView updateSelf(ModelAndView model, HttpSession session) {// oo
		User u = (User) session.getAttribute("loginUser");
		if (u == null) {
			u = userService.load(223);
		}
		model.addObject(new UserDto(u));
		model.setViewName("user/updateSelf");
		return model;
	}

	@RequestMapping(value = "/updateSelf", method = RequestMethod.POST)
	@AuthMethod
	public ModelAndView updateSelf(UserDto userDto, BindingResult br, ModelAndView model, HttpSession session) {// oo
		if (br.hasErrors()) {
			model.setViewName("user/updateSelf");
			return model;
		}
		User ou = userService.load(userDto.getId());
		ou.setNickname(userDto.getNickname());
		ou.setPhone(userDto.getPhone());
		ou.setEmail(userDto.getEmail());
		userService.update(ou);
		session.setAttribute("loginUser", ou);
		model.setViewName("redirect:/admin/user/showSelf");
		return model;
	}

	@RequestMapping("/listChannels/{uid}")
	public ModelAndView listChannels(@PathVariable int uid, ModelAndView model) {
		model.addObject(userService.load(uid));
		List<Role> rs = userService.listUserRoles(uid);
		for (Role r : rs) {
			if (r.getRoleType() == RoleType.ROLE_ADMIN) {
				model.addObject("isAdmin", 1);
			}
		}
		model.setViewName("/user/listChannel");
		return model;
	}

	@RequestMapping("/userTree/{uid}")
	public @ResponseBody List<ChannelTree> groupTree(@PathVariable Integer uid, @Param(value = "") Integer isAdmin) {
		if (isAdmin != null && isAdmin == 1) {
			return channelService.generateTree();
		}
		return groupService.generateUserChannelTree(uid);
	}

}