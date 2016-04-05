package com.east.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.GroupzMapper;
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
	@Resource
	private GroupzMapper groupDao;

	@Override
	public void add(Role role) {
		roleDao.add(role);
	}

	@Override
	public void delete(int id) {
		List<User> us = userDao.listRoleUsers(id);
		if (us != null && us.size() > 0)
			throw new CmsException("删除的角色对象中还有用户，不能删除");
		roleDao.delete(id);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
	public Role load(int id) {
		return roleDao.load(id);
	}

	@Override
	public List<Role> listRole() {
		return roleDao.listRole();
	}

	@Override
	public void deleteRoleUsers(int rid) {
		roleDao.deleteRoleUsers(rid);

	}

}
