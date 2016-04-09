package com.east.cms.service;

import java.util.List;

import com.east.cms.model.Role;

public interface RoleService {
	public void add(Role role);

	public void delete(int id);

	public Role load(int id);

	public List<Role> listRole();

	public void deleteRoleUsers(int rid);

	public void update(Role role);

	void updateSelective(Role role);
}
