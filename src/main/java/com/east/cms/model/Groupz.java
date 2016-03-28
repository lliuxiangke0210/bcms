package com.east.cms.model;

import java.util.List;

public class Groupz {
	private Integer groupzId;

	private String name;

	private String descr;

	private List<User> users;

	public Integer getGroupzId() {
		return groupzId;
	}

	public void setGroupzId(Integer groupzId) {
		this.groupzId = groupzId;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}