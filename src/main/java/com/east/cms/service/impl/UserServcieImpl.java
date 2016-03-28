package com.east.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.UserDao;
import com.east.cms.model.Groupz;
import com.east.cms.model.Role;
import com.east.cms.model.User;
import com.east.com.service.UserServcie;

@Service("userService")
public class UserServcieImpl implements UserServcie {

	@Resource
	private UserDao userDao;

	@Override
	public void add(User user, Integer[] rids, Integer[] gids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		userDao.deleteByPrimaryKey(id);
	}

	@Override
	public void update(User user, Integer[] rids, Integer[] gids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePwd(Integer uid, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStatus(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findUser(Integer offset, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User load(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> listUserRoles(Integer id) { // 写时检查
		List<Role> roles = userDao.listUserRoles(id);
		return roles;
	}

	@Override
	public List<Groupz> listUserGroups(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> listUserRoleIds(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> listUserGroupIds(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listGroupUsers(Integer gid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listRoleUsers(Integer rid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
