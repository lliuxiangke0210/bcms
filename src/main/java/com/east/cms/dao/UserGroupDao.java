package com.east.cms.dao;

import com.east.cms.model.UserGroup;

public interface UserGroupDao {
    int deleteByPrimaryKey(Integer userGroupId);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(Integer userGroupId);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}