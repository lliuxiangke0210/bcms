package com.east.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.east.cms.model.Channel;
import com.east.cms.model.ChannelTree;

public interface ChannelMapper {

	/**
	 * 根据父id获取所有的子栏目
	 * 
	 * @param pid
	 * @return
	 */
	public List<Channel> listByParent(@Param("parentId") Integer parentId);// oo

	/**
	 * 获取子栏目的最大的排序号
	 * 
	 * @param pid
	 * @return
	 */
	public int getMaxOrderByParent(@Param("parentId") Integer parentId);// oo

	/**
	 * 把所有的栏目获取并生成一颗完整的树
	 * 
	 * @return
	 */
	public List<ChannelTree> generateTree();

	/**
	 * 根据父类对象获取子类栏目，并且生成树列表
	 * 
	 * @param pid
	 * @return
	 */
	public List<ChannelTree> generateTreeByParent(Integer parentId);

	/**
	 * 通过一个数组来完成排序
	 * 
	 * @param ids
	 */
	public void updateSort(@Param("ids") Integer[] ids);

	/**
	 * 所有的可以发布文章的栏目，栏目的状态必须为启用状态 channelType=ChannelType.NAV_CHANNEL
	 * 
	 */
	public List<Channel> listPublishChannel(@Param("channelType") String channelType);

	/**
	 * 根据栏目类型获取所有的首页栏目
	 * 
	 * @return
	 */
	public List<Channel> listAllIndexChannel(@Param("channelType") String channelType);// oo

	public List<Channel> listTopNavChannel();// oo

	/**
	 * 删除频道和组的对应关系
	 * 
	 * @param cid
	 * @return
	 */
	public void deleteChannelGroups(@Param("channelId") int channelId);

	/**
	 * 获取导航栏目中的第一个栏目
	 * 
	 * @param cid
	 * @return
	 */
	public Channel loadFirstChannelByNav(@Param("parentId") int parentId);

	public List<Channel> listUseChannelByParent(@Param("parentId") Integer parentId);

	/**
	 * 通过类型来获取所有未停用的栏目
	 * 
	 * @param ct
	 * @return
	 */
	public List<Channel> listChannelByType(@Param("channelType") String channelType);

	public Channel load(@Param("channelId") int channelId);

	public void add(@Param("channel") Channel channel);

	public void update(@Param("channel") Channel channel);

	public void delete(@Param("channelId") int channelId);

}