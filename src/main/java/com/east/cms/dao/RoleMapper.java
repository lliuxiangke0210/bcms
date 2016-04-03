package com.east.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.east.cms.model.Role;

public interface RoleMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	// ------------------------------------------
	public List<Role> listRole(); // oo

	public void deleteRoleUsers(@Param("roleId") int roleId); // oo

}