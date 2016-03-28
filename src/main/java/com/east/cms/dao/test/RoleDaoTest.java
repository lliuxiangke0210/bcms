package com.east.cms.dao.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.east.cms.dao.RoleDao;
import com.east.cms.model.Role;

@Service("roleService")
public class RoleDaoTest {

	@Autowired
	private RoleDao roleDao;

	public void listRole() {

		String username = "lxk012";
		List<Role> roles = roleDao.listRole();
		for (Role role : roles) {
			System.out.println(role.getName());
			System.out.println(role.getRoleId());
			System.out.println(role.getRoleType());
			System.out.println(role);
			System.out.println("----------------------------");
		}
	}

}
