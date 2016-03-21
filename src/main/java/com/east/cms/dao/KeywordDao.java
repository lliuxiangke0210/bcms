package com.east.cms.dao;

import com.east.cms.model.Keyword;

public interface KeywordDao {
    int deleteByPrimaryKey(Integer keywordId);

    int insert(Keyword record);

    int insertSelective(Keyword record);

    Keyword selectByPrimaryKey(Integer keywordId);

    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);
}