package com.east.cms.dao;

import com.east.cms.model.CmsLink;

public interface CmsLinkDao {
    int deleteByPrimaryKey(Integer cmsLinkId);

    int insert(CmsLink record);

    int insertSelective(CmsLink record);

    CmsLink selectByPrimaryKey(Integer cmsLinkId);

    int updateByPrimaryKeySelective(CmsLink record);

    int updateByPrimaryKey(CmsLink record);
}