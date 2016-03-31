package com.east.cms.model;

public class Channel {
	private Integer id;

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