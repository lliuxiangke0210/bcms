package com.east.cms.model;

public class GroupChannel {
	private Integer id;

	private Integer groupId;

	private Integer channelId;

	private String name;

	private String descr;

	private String channelName;

	private Integer isCustomLink;

	private String customLinkUrl;

	private String channelType;

	private Integer isIndex;

	private Integer isTopNav;

	private Integer isRecommend;

	private Integer channelStatus;

	private Integer orders;

	private Integer parentId;

	private Integer navOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Integer getIsCustomLink() {
		return isCustomLink;
	}

	public void setIsCustomLink(Integer isCustomLink) {
		this.isCustomLink = isCustomLink;
	}

	public String getCustomLinkUrl() {
		return customLinkUrl;
	}

	public void setCustomLinkUrl(String customLinkUrl) {
		this.customLinkUrl = customLinkUrl;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public Integer getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(Integer isIndex) {
		this.isIndex = isIndex;
	}

	public Integer getIsTopNav() {
		return isTopNav;
	}

	public void setIsTopNav(Integer isTopNav) {
		this.isTopNav = isTopNav;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Integer getChannelStatus() {
		return channelStatus;
	}

	public void setChannelStatus(Integer channelStatus) {
		this.channelStatus = channelStatus;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getNavOrder() {
		return navOrder;
	}

	public void setNavOrder(Integer navOrder) {
		this.navOrder = navOrder;
	}

}