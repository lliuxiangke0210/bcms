package com.east.cms.model;

/**
 * 系统栏目树对象
 * 
 * @author Administrator
 *
 */
public class ChannelTree {

	private Integer id;
	private String channelName;
	private Integer parentId;

	public ChannelTree(Integer id, String channelName, Integer parentId) {
		super();
		this.id = id;
		this.channelName = channelName;
		this.parentId = parentId;
	}

	public ChannelTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChannelTree(String channelName, Integer parentId) {
		super();
		this.channelName = channelName;
		this.parentId = parentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
