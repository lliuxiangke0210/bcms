package com.east.cms.dao;

import com.east.cms.model.Groupz;

public interface GroupzDao {
    int deleteByPrimaryKey(Integer groupzId);

    int insert(Groupz record);

    int insertSelective(Groupz record);

    Groupz selectByPrimaryKey(Integer groupzId);

    int updateByPrimaryKeySelective(Groupz record);

    int updateByPrimaryKey(Groupz record);
}