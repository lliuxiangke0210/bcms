package com.east.cms.dao;

import com.east.cms.model.Groupz;

public interface GroupzMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Groupz record);

    int insertSelective(Groupz record);

    Groupz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Groupz record);

    int updateByPrimaryKey(Groupz record);
}