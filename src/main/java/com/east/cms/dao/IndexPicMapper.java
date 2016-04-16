package com.east.cms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.east.cms.model.IndexPic;

public interface IndexPicMapper {

	/**
	 * 根据数量来获取首页图片信息
	 * 
	 * @param num
	 * @return
	 */
	public List<IndexPic> listIndexPicByNum(@Param("num") int num);

	/**
	 * pageInfo
	 * 
	 * @return
	 */
	public List<IndexPic> findIndexPic();

	/**
	 * 获取所有的首页图片名称
	 * 
	 * @return
	 */
	public List<String> listAllIndexPicName();

	public Map<String, Integer> getMinAdnMaxPos();

	/**
	 * 更新位置，如果原位置小于新位置，让所有>原始位置，<=新位置的元素全部-1之后更新对象的位置
	 * 如果原位置大于新位置，让所有小于原位置>=新位置的元素全部+1，之后更新当前元素
	 * 
	 * @param id
	 * @param oldPos原始的位置
	 * @param newPos新的位置
	 */
	public void updatePos(@Param("id") int id, @Param("oldPos") int oldPos, @Param("newPos") int newPos);

	public IndexPic load(@Param("id") int id);

	public void add(@Param("indexPic") IndexPic indexPic);

	public void update(@Param("indexPic") IndexPic indexPic);

	public void delete(@Param("id") int id);

}