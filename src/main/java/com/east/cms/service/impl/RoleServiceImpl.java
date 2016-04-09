package com.east.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.RoleMapper;
import com.east.cms.dao.UserMapper;
import com.east.cms.model.Role;
import com.east.cms.model.User;
import com.east.cms.pojo.CmsException;
import com.east.cms.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private UserMapper userDao;
	@Resource
	private RoleMapper roleDao;

	@Override
	public void add(Role role) {// oo
		roleDao.add(role);
	}

	@Override
	public void delete(int roleId) {// oo
		List<User> us = userDao.listRoleUsers(roleId);
		if (us != null && us.size() > 0)
			throw new CmsException("删除的角色对象中还有用户，不能删除");
		roleDao.delete(roleId);
	}

	@Override
	public void update(Role role) {// oo
		roleDao.update(role);
	}

	@Override
	public void updateSelective(Role role) {// oo
		roleDao.updateSelective(role);
	}

	@Override
	public Role load(int roleId) {// oo
		return roleDao.load(roleId);
	}

	@Override
	public List<Role> listRole() {// oo
		return roleDao.listRole();
	}

	@Override
	public void deleteRoleUsers(int roleId) {// oo
		roleDao.deleteRoleUsers(roleId);

	}

}
