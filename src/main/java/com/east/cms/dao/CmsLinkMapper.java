package com.east.cms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.east.cms.model.CmsLink;
import com.github.pagehelper.PageInfo;

public interface CmsLinkMapper {
	/**
	 * 根据类型获取超链接，如果type为空就获取所有的超链接，排序方式根据pos
	 * 
	 * @param type
	 * @return
	 */
	public PageInfo<CmsLink> findByType(@Param("type") String type);

	/**
	 * 获取某个类型中的所有链接，不进行分页
	 * 
	 * @param type
	 * @return
	 */
	public List<CmsLink> listByType(@Param("type") String type);

	/**
	 * 获取超链接的所有类型
	 * 
	 * @return
	 */
	public List<String> listAllType();

	/**
	 * 获取最大和最小的排序号
	 * 
	 * @return
	 */
	public Map<String, Integer> getMinAndMaxPos();

	/**
	 * 更新排序
	 * 
	 * @param id
	 * @param oldPos
	 * @param newPos
	 */
	public void updatePos(int id, int oldPos, int newPos);
}