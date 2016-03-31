package com.east.cms.dao;

import com.east.cms.model.GroupChannel;

public interface GroupChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupChannel record);

    int insertSelective(GroupChannel record);

    GroupChannel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupChannel record);

    int updateByPrimaryKey(GroupChannel record);
}