package com.east.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.east.cms.model.Role;

public interface RoleMapper {

	public List<Role> listRole(); // oo

	public void deleteRoleUsers(@Param("roleId") int roleId); // oo

	public Role load(@Param("roleId") int roleId);

	public void add(@Param("role") Role role);

	public void delete(@Param("roleId") int roleId);

	public void update(@Param("role") Role role);

}