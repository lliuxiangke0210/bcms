package com.east.cms.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.east.cms.model.IndexPic;
import com.github.pagehelper.PageInfo;

public interface IndexPicService {

	public void add(IndexPic indexPic);

	public void update(IndexPic indexPic);

	public void delete(int id);

	public void updateStatus(int id);

	public IndexPic load(int id);

	/**
	 * 根据数量来获取首页图片信息
	 * 
	 * @param num
	 * @return
	 */
	public List<IndexPic> listIndexPicByNum(int num);

	public PageInfo<IndexPic> findIndexPic();

	public List<String> listAllIndexPicName();

	public void cleanNoUseIndexPic(List<String> pics) throws IOException;

	public Map<String, Integer> getMinAdnMaxPos();

	public void updatePos(int id, int oldPos, int newPos);

}
