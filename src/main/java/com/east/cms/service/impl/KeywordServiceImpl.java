package com.east.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.ChannelMapper;
import com.east.cms.dao.KeywordMapper;
import com.east.cms.model.Keyword;
import com.east.cms.service.KeywordService;
import com.east.cms.service.TopicService;
import com.github.pagehelper.PageInfo;

@Service("keywordService")
public class KeywordServiceImpl implements KeywordService {
	@Resource
	private ChannelMapper channelDao;
	@Resource
	private TopicService topicService;
	@Resource
	private KeywordMapper keywordDao;

	@Override
	public void addOrUpdate(String name) {
		keywordDao.addOrUpdate(name);
	}

	@Override
	public List<Keyword> getKeywordByTimes(int num) {
		List<Keyword> ks = keywordDao.findUseKeyword();
		List<Keyword> kks = new ArrayList<Keyword>();
		for (Keyword k : ks) {
			if (k.getTimes() >= num)
				kks.add(k);
			else
				break;
		}
		return kks;
	}

	@Override
	public List<Keyword> getMaxTimesKeyword(int num) {
		List<Keyword> ks = keywordDao.findUseKeyword();
		List<Keyword> kks = new ArrayList<Keyword>();
		if (ks.size() <= num)
			return ks;
		for (int i = 0; i <= num; i++) {
			kks.add(ks.get(i));
		}
		return kks;
	}

	@Override
	public PageInfo<Keyword> findNoUseKeyword() {
		return keywordDao.findNoUseKeyword();
	}

	@Override
	public void clearNoUseKeyword() {
		keywordDao.clearNoUseKeyword();
	}

	@Override
	public List<Keyword> findUseKeyword() {
		return keywordDao.findUseKeyword();
	}

	@Override
	public List<Keyword> listKeywordByCon(String con) {
		return keywordDao.listKeywordByCon(con);
	}

	@Override
	public List<String> listKeywordStringByCon(String con) {
		return keywordDao.listKeywordStringByCon(con);
	}

}
