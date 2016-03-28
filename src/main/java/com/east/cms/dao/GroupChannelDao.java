package com.east.cms.dao;

import java.util.List;

import com.east.cms.model.Channel;
import com.east.cms.model.ChannelTree;
import com.east.cms.model.GroupChannel;
import com.east.cms.model.Groupz;

public interface GroupChannelDao {
	int deleteByPrimaryKey(Integer groupChannelId);

	int insert(GroupChannel record);

	int insertSelective(GroupChannel record);

	GroupChannel selectByPrimaryKey(Integer groupChannelId);

	int updateByPrimaryKeySelective(GroupChannel record);

	int updateByPrimaryKey(GroupChannel record);

	/**
	 * 添加GroupChannel对象
	 * 
	 * @param group
	 * @param channel
	 */
	public void addGroupChannel(Groupz group, Channel channel);

	/**
	 * 加载GroupChannel对象
	 * 
	 * @param gid
	 * @param cid
	 * @return
	 */
	public GroupChannel loadGroupChannel(int gid, int cid);

	/**
	 * 清空组所管理的栏目
	 * 
	 * @param gid
	 */
	public void clearGroupChannel(int gid);

	/**
	 * 删除用户栏目
	 * 
	 * @param gid
	 * @param cid
	 */
	public void deleteGroupChannel(int gid, int cid);

	/**
	 * 获取某个组的所有管理栏目的id
	 * 
	 * @param gid
	 * @return
	 */
	public List<Integer> listGroupChannelIds(int gid);

	/**
	 * 获取某个组的栏目树
	 * 
	 * @param gid
	 * @return
	 */
	public List<ChannelTree> generateGroupChannelTree(int gid);

	/**
	 * 获取某个用户的栏目树
	 * 
	 * @param uid
	 * @return
	 */
	public List<ChannelTree> generateUserChannelTree(int uid);
}