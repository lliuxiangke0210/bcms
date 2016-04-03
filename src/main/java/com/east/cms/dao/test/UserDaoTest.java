/**
 * 
 */
/**
 * @author lxk
 *
 */
package com.east.cms.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.UserMapper;
import com.east.cms.model.Groupz;
import com.east.cms.model.Role;
import com.east.cms.model.User;
import com.east.cms.model.UserGroup;
import com.east.cms.model.UserRole;

@Service("userDaoTest")
public class UserDaoTest {

	@Resource
	private UserMapper userMapper;

	public void listUserRoles() {

		List<Role> roles = userMapper.listUserRoles(200);
		System.out.println(roles);

	}

	public void listUserRoleIds() {

		List<Integer> roleIds = userMapper.listUserRoleIds(200);
		System.out.println(roleIds);

	}

	public void listUserGroups() {

		List<Groupz> groupzs = userMapper.listUserGroups(200);
		System.out.println(groupzs);

	}

	public void listUserGroupIds() {

		List<Integer> groupzIds = userMapper.listUserGroupIds(200);
		System.out.println(groupzIds);

	}

	public void loadUserRole() {
		UserRole userRole = userMapper.loadUserRole(200, 3);
		System.out.println(userRole);

	}

	public void loadUserGroup() {
		UserGroup userGroup = userMapper.loadUserGroup(200, 10);
		System.out.println(userGroup);

	}

	public void loadByUsername() {
		User user = userMapper.loadByUsername("lxk012");
		System.out.println(user);

	}

	public void listRoleUsers() {
		List<User> users = userMapper.listRoleUsers(3);
		System.out.println(users);

	}

	public void listRoleUsersByType() {
		List<User> users = userMapper.listRoleUsersByType("1");
		System.out.println(users);
	}

	public void listGroupUsers() {
		List<User> users = userMapper.listGroupUsers(9);
		System.out.println(users);
	}

	public void addUserRole() {
		User user = new User();
		user.setId(201);
		Role role = new Role();
		role.setId(3);
		userMapper.addUserRole(user, role);
	}

	public void addUserGroup() {
		User user = new User();
		user.setId(201);
		Groupz groupz = new Groupz();
		groupz.setId(9);
		userMapper.addUserGroup(user, groupz);
	}

	public void deleteUserRoles() {

		userMapper.deleteUserRoles(200);
	}

}