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

}