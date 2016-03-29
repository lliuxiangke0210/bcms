package com.east.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.east.cms.model.Groupz;
import com.east.cms.model.Role;
import com.east.cms.model.User;
import com.east.cms.model.UserGroup;
import com.east.cms.model.UserRole;
import com.github.pagehelper.PageInfo;

public interface UserDao {
	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/**
	 * 获取用户的所有角色信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<Role> listUserRoles(int userId);// oo

	/**
	 * 获取用户的所有角色的id
	 * 
	 * @param userId
	 * @return
	 */
	public List<Integer> listUserRoleIds(int userId);// oo

	/**
	 * 获取用户的所有组信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<Groupz> listUserGroups(int userId);// oo

	/**
	 * 获取用户的所有组的id
	 * 
	 * @param userId
	 * @return
	 */
	public List<Integer> listUserGroupIds(int userId);// oo

	/**
	 * 根据用户和角色获取用户角色的关联对象
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public UserRole loadUserRole(@Param("userId") int userId, @Param("roleId") int roleId);// oo

	/**
	 * 根据用户和组获取用户组关联对象
	 * 
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public UserGroup loadUserGroup(@Param("userId") int userId, @Param("groupId") int groupId);// oo

	/**
	 * 根据用户名获取用户对象
	 * 
	 * @param username
	 * @return
	 */
	public User loadByUsername(String username);

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
	 * 获取某个组中的用户对象
	 * 
	 * @param gid
	 * @return
	 */
	public List<User> listGroupUsers(int gid);

	/**
	 * 添加用户角色对象
	 * 
	 * @param user
	 * @param role
	 */
	public void addUserRole(User user, Role role);

	/**
	 * 添加用户组对象
	 * 
	 * @param user
	 * @param group
	 */
	public void addUserGroup(User user, Groupz group);

	/**
	 * 删除用户的角色信息
	 * 
	 * @param uid
	 */
	public void deleteUserRoles(int uid);

	/**
	 * 删除用户的组信息
	 * 
	 * @param gid
	 */
	public void deleteUserGroups(int gid);

	public PageInfo<User> findUser();

	/**
	 * 删除用户角色对象
	 * 
	 * @param uid
	 * @param rid
	 */
	public void deleteUserRole(int uid, int rid);

	/**
	 * 删除用户组对象
	 * 
	 * @param uid
	 * @param gid
	 */
	public void deleteUserGroup(int uid, int gid);

}