package com.east.cms.dao;

import com.east.cms.model.GroupChannel;

public interface GroupChannelDao {
    int deleteByPrimaryKey(Integer groupChannelId);

    int insert(GroupChannel record);

    int insertSelective(GroupChannel record);

    GroupChannel selectByPrimaryKey(Integer groupChannelId);

    int updateByPrimaryKeySelective(GroupChannel record);

    int updateByPrimaryKey(GroupChannel record);
}