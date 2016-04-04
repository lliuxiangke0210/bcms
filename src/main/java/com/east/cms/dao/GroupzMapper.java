package com.east.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.east.cms.model.Channel;
import com.east.cms.model.ChannelTree;
import com.east.cms.model.GroupChannel;
import com.east.cms.model.Groupz;
import com.github.pagehelper.PageInfo;

public interface GroupzMapper {

	public List<Groupz> listGroup();

	public PageInfo<Groupz> findGroup();

	public void deleteGroupUsers(int groupId);

	/**
	 * 添加GroupChannel对象
	 * 
	 * @param group
	 * @param channel
	 */
	public void addGroupChannel(@Param("group") Groupz group, @Param("channel") Channel channel);

	/**
	 * 加载GroupChannel对象
	 * 
	 * @param gid
	 * @param cid
	 * @return
	 */
	public GroupChannel loadGroupChannelById(@Param("groupId") int groupId, @Param("channelId") int channelId);

	/**
	 * 清空组所管理的栏目
	 * 
	 * @param gid
	 */
	public void clearGroupChannel(int groupId);

	/**
	 * 删除用户栏目
	 * 
	 * @param gid
	 * @param cid
	 */
	public void deleteGroupChannel(int groupId, int channelId);

	/**
	 * 获取某个组的所有管理栏目的id
	 * 
	 * @param gid
	 * @return
	 */
	public List<Integer> listGroupChannelIds(int groupId);

	/**
	 * 获取某个组的栏目树
	 * 
	 * @param gid
	 * @return
	 */
	public List<ChannelTree> generateGroupChannelTree(int groupId);

	/**
	 * 获取某个用户的栏目树
	 * 
	 * @param uid
	 * @return
	 */
	public List<ChannelTree> generateUserChannelTree(int userId);
}