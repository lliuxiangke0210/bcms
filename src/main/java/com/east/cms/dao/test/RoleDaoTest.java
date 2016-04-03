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

import com.east.cms.dao.RoleMapper;
import com.east.cms.model.Role;

@Service("roleDaoTest")
public class RoleDaoTest {

	@Resource
	private RoleMapper roleMapper;

	public void listRole() {

		List<Role> roles = roleMapper.listRole();
		System.out.println(roles);

	}

	public void deleteRoleUsers() {

		roleMapper.deleteRoleUsers(3);

	}

}