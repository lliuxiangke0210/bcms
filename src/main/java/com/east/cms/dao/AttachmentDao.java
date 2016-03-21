package com.east.cms.dao;

import com.east.cms.model.Attachment;

public interface AttachmentDao {
    int deleteByPrimaryKey(Integer attachmentId);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(Integer attachmentId);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKey(Attachment record);
}