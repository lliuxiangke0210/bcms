package com.east.cms.dao;

import java.util.List;

import com.east.cms.model.Role;

public interface RoleDao {
	int deleteByPrimaryKey(Integer roleId);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(Integer roleId);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	public List<Role> listRole();// oo

}