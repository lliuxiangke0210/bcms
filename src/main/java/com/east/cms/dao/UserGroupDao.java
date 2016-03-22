package com.east.cms.dao;

import java.util.List;

import com.east.cms.model.Groupz;
import com.east.cms.model.User;
import com.east.cms.model.UserGroup;

public interface UserGroupDao {
	int deleteByPrimaryKey(Integer userGroupId);

	int insert(UserGroup record);

	int insertSelective(UserGroup record);

	UserGroup selectByPrimaryKey(Integer userGroupId);

	int updateByPrimaryKeySelective(UserGroup record);

	int updateByPrimaryKey(UserGroup record);

	/**
	 * 获取用户的所有组信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<Groupz> listUserGroups(int userId);

	/**
	 * 获取用户的所有组的id
	 * 
	 * @param userId
	 * @return
	 */
	public List<Integer> listUserGroupIds(int userId);

	/**
	 * 根据用户和组获取用户组关联对象
	 * 
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public UserGroup loadUserGroup(int userId, int groupId);

	/**
	 * 获取某个组中的用户对象
	 * 
	 * @param gid
	 * @return
	 */
	public List<User> listGroupUsers(int gid);

	/**
	 * 添加用户组对象
	 * 
	 * @param user
	 * @param group
	 */
	public void addUserGroup(User user, Groupz group);

	/**
	 * 删除用户的组信息
	 * 
	 * @param gid
	 */
	public void deleteUserGroups(int gid);

	/**
	 * 删除用户组对象
	 * 
	 * @param uid
	 * @param gid
	 */
	public void deleteUserGroup(int uid, int gid);

}