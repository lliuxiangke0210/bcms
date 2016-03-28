package com.east.cms.dao;

import java.util.List;

import com.east.cms.model.Role;
import com.east.cms.model.User;
import com.east.cms.model.UserRole;

public interface UserRoleDao {
	int deleteByPrimaryKey(Integer userRoleId);

	int insert(UserRole record);

	int insertSelective(UserRole record);

	UserRole selectByPrimaryKey(Integer userRoleId);

	int updateByPrimaryKeySelective(UserRole record);

	int updateByPrimaryKey(UserRole record);

	/**
	 * 获取用户的所有角色信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<Role> listUserRoles(int userId);

	/**
	 * 获取用户的所有角色的id
	 * 
	 * @param userId
	 * @return
	 */
	public List<Integer> listUserRoleIds(int userId);

	/**
	 * 根据用户和角色获取用户角色的关联对象
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public UserRole loadUserRole(int userId, int roleId);

	/**
	 * 根据角色id获取用户列表
	 * 
	 * @param roleId
	 * @return
	 */
	public List<User> listRoleUsers(int roleId);

	/**
	 * 根据角色类型获取用户对象
	 * 
	 * @param roleType
	 * @return
	 */
	public List<User> listRoleUsers(String roleType);

	/**
	 * 添加用户角色对象
	 * 
	 * @param user
	 * @param role
	 */
	public void addUserRole(User user, Role role);

	/**
	 * 删除用户的角色信息
	 * 
	 * @param uid
	 */
	public void deleteUserRoles(int uid);

	/**
	 * 删除用户角色对象
	 * 
	 * @param uid
	 * @param rid
	 */
	public void deleteUserRole(int uid, int rid);

	public void deleteRoleUsers(int rid);

}