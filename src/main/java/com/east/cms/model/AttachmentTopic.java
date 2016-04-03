package com.east.cms.model;

import java.util.Date;

public class AttachmentTopic {
	private Integer id;

	private String newName;

	private String oldName;

	private String type;

	private String suffix;

	private Integer size;

	private Integer isIndexPic;

	private Integer isImg;

	private Integer topicId;

	private Integer isAttach;

	// a.topic.id,a.topic.title,a.topic.publishDate,a.topic.author

	private String title;//

	private String keyword;

	private Integer status;

	private Integer recommend;

	private String content;

	private String summary;

	private Date publishDate;//

	private Date createDate;

	private String author;//

	private String cname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getIsIndexPic() {
		return isIndexPic;
	}

	public void setIsIndexPic(Integer isIndexPic) {
		this.isIndexPic = isIndexPic;
	}

	public Integer getIsImg() {
		return isImg;
	}

	public void setIsImg(Integer isImg) {
		this.isImg = isImg;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getIsAttach() {
		return isAttach;
	}

	public void setIsAttach(Integer isAttach) {
		this.isAttach = isAttach;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}