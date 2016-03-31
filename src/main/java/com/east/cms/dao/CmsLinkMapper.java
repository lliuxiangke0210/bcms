package com.east.cms.dao;

import com.east.cms.model.CmsLink;

public interface CmsLinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CmsLink record);

    int insertSelective(CmsLink record);

    CmsLink selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CmsLink record);

    int updateByPrimaryKey(CmsLink record);
}