package com.east.cms.model;

public class Attachment {
	private Integer attachmentId;

	private String newName;

	private String oldName;

	private String type;

	private String suffix;

	private Integer size;

	private Integer isIndexPic;

	private Integer isImg;

	private Topic topic;

	private Integer isAttach;

	public Integer getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Integer getIsAttach() {
		return isAttach;
	}

	public void setIsAttach(Integer isAttach) {
		this.isAttach = isAttach;
	}

}