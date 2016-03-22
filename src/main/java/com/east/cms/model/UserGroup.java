package com.east.cms.model;

public class UserGroup {
	private Integer userGroupId;

	private User user;

	private Groupz groupz;

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Groupz getGroupz() {
		return groupz;
	}

	public void setGroupz(Groupz groupz) {
		this.groupz = groupz;
	}

}