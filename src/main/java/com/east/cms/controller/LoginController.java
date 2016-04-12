package com.east.cms.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.east.cms.model.Role;
import com.east.cms.model.User;
import com.east.cms.pojo.CmsSessionContext;
import com.east.cms.pojo.RoleType;
import com.east.cms.service.UserService;
import com.east.cms.utils.Captcha;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(String username, String password, String checkcode, ModelAndView model,
			HttpSession session) {
		String cc = (String) session.getAttribute("cc");
		if (!cc.equals(checkcode)) {
			model.addObject("error", "验证码出错，请重新输入");
			model.setViewName("admin/login");
			return model;
		}
		User loginUser = userService.login(username, password);
		session.setAttribute("loginUser", loginUser);
		List<Role> rs = userService.listUserRoles(loginUser.getId());
		boolean isAdmin = isRole(rs, RoleType.ROLE_ADMIN);
		session.setAttribute("isAdmin", isAdmin);
		if (!isAdmin) {
			session.setAttribute("allActions", getAllActions(rs, session));
			session.setAttribute("isAudit", isRole(rs, RoleType.ROLE_AUDIT));
			session.setAttribute("isPublish", isRole(rs, RoleType.ROLE_PUBLISH));
		}
		session.removeAttribute("cc");
		CmsSessionContext.addSessoin(session);
		model.setViewName("redirect:/admin");
		return model;
	}

	@SuppressWarnings("unchecked")
	private Set<String> getAllActions(List<Role> rs, HttpSession session) {
		Set<String> actions = new HashSet<String>();
		Map<String, Set<String>> allAuths = (Map<String, Set<String>>) session.getServletContext()
				.getAttribute("allAuths");
		actions.addAll(allAuths.get("base"));
		for (Role r : rs) {
			if (r.getRoleType() == RoleType.ROLE_ADMIN)
				continue;
			actions.addAll(allAuths.get(r.getRoleType()));
		}
		return actions;
	}

	private boolean isRole(List<Role> rs, String rt) {
		for (Role r : rs) {
			if (r.getRoleType() == rt)
				return true;
		}
		return false;
	}

	@RequestMapping("/drawCheckCode")
	public void drawCheckCode(HttpServletResponse resp, HttpSession session) throws IOException {
		resp.setContentType("image/jpg");
		int width = 200;
		int height = 30;
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		session.setAttribute("cc", checkcode);
		OutputStream os = resp.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
	}
}
