/**
 * 
 */
/**
 * @author lxk
 *
 */
package com.east.cms.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.east.cms.dao.GroupzMapper;
import com.east.cms.model.Channel;
import com.east.cms.model.ChannelTree;
import com.east.cms.model.GroupChannel;
import com.east.cms.model.Groupz;

@Service("groupDaoTest")
public class GroupDaoTest {

	@Resource
	private GroupzMapper groupzMapper;

	public void listGroup() {// oo
		List<Groupz> groupzs = groupzMapper.listGroup();
		System.out.println(groupzs);
	}

	public void deleteGroupUsers() {// oo
		groupzMapper.deleteGroupUsers(8);
	}

	public void addGroupChannel() {// oo
		Groupz groupz = new Groupz();
		groupz.setId(8);
		Channel channel = new Channel();
		channel.setId(2);
		groupzMapper.addGroupChannel(groupz, channel);
	}

	public void loadGroupChannelById() {// oo

		GroupChannel groupChannel = groupzMapper.loadGroupChannelById(8, 2);
		System.out.println(groupChannel);

	}

	public void listGroupChannelIds() {// oo

		List<Integer> groupChannel = groupzMapper.listGroupChannelIds(8);
		System.out.println(groupChannel);

	}

	public void generateGroupChannelTree() {// oo

		List<ChannelTree> groupChannel = groupzMapper.generateGroupChannelTree(8);
		System.out.println(groupChannel);

	}

	public void generateUserChannelTree() {// oo

		List<ChannelTree> groupChannel = groupzMapper.generateUserChannelTree(2);
		System.out.println(groupChannel);

	}

	public void add() {// oo
		Groupz group = new Groupz();
		group.setDescr("groupddd");
		group.setName("china");
		groupzMapper.add(group);

	}

}