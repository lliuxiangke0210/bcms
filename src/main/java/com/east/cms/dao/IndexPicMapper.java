package com.east.cms.dao;

import com.east.cms.model.IndexPic;

public interface IndexPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexPic record);

    int insertSelective(IndexPic record);

    IndexPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexPic record);

    int updateByPrimaryKey(IndexPic record);
}