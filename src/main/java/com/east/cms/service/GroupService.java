package com.east.cms.service;

import java.util.List;

import com.east.cms.model.ChannelTree;
import com.east.cms.model.GroupChannel;
import com.east.cms.model.Groupz;
import com.github.pagehelper.PageInfo;

public interface GroupService {
	public void add(Groupz group);

	public void delete(int id);

	public Groupz load(int id);

	public void update(Groupz group);

	public List<Groupz> listGroup();

	public PageInfo<Groupz> findGroup();

	public void deleteGroupUsers(int gid);

	/**
	 * 添加GroupChannel对象
	 * 
	 * @param group
	 * @param channel
	 */
	public void addGroupChannel(int gid, int cid);

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
