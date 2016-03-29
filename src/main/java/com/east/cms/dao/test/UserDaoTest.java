package com.east.cms.dao.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.east.cms.dao.UserDao;
import com.east.cms.model.Groupz;
import com.east.cms.model.Role;
import com.east.cms.model.User;
import com.east.cms.model.UserGroup;
import com.east.cms.model.UserRole;
import com.github.pagehelper.PageInfo;

@Service("userDaoTest")
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	public void loadByUsername() {

		String username = "lxk012";
		User user = userDao.loadByUsername(username);
		System.out.println(user.getEmail());
		System.out.println(user.getNickname());
		System.out.println(user.getUsername());
		System.out.println(user.getCreateDate());
		System.out.println(user);
		System.out.println("----------------------------");
	}

	public void findUser() {

		String username = "lxk012";
		PageInfo<User> pageInfo = userDao.findUser();
		List<User> users = pageInfo.getList();
		for (User user : users) {
			System.out.println(user.getEmail());
			System.out.println(user.getNickname());
			System.out.println(user.getUsername());
			System.out.println(user.getCreateDate());
			System.out.println(user);
			System.out.println("----------------------------");
		}
	}

	public void listUserRoles() {

		List<Role> roles = userDao.listUserRoles(200);
		for (Role role : roles) {
			System.out.println(role.getName());
			System.out.println(role.getRoleId());
			System.out.println(role.getRoleType());

			System.out.println("----------------------------");
		}
	}

	public void listUserRoleIds() {

		List<Integer> roleIds = userDao.listUserRoleIds(200);
		System.out.println(roleIds);

	}

	public void listUserGroups() {

		List<Groupz> groupzs = userDao.listUserGroups(200);
		for (Groupz groupz : groupzs) {
			System.out.println(groupz.getName());
			System.out.println(groupz.getDescr());
			System.out.println(groupz.getGroupzId());

			System.out.println("----------------------------");
		}
	}

	public void listUserGroupIds() {
		List<Integer> groupzIds = userDao.listUserGroupIds(200);
		System.out.println(groupzIds);

	}

	public void loadUserRole() {
		UserRole userRole = userDao.loadUserRole(200, 7);
		User user = userRole.getUser();
		Role role = userRole.getRole();
		System.out.println(userRole);

	}

	public void loadUserGroup() {
		UserGroup userGroup = userDao.loadUserGroup(200, 9);
		User user = userGroup.getUser();
		Groupz groupz = userGroup.getGroupz();
		System.out.println(userGroup);

	}

}
