package com.east.cms.dao.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.east.cms.dao.UserDao;
import com.east.cms.model.User;

@Service("userDaoTest")
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	public void loadByUsername() {

		String username = "lxk012";
		User user = userDao.loadByUsername(username);
		System.out.println(user.getEmail());
		System.out.println(user.getNickname());
		System.out.println(user.getUsername());
		System.out.println(user.getCreateDate());
		System.out.println(user);
		System.out.println("----------------------------");
	}

	public void findUser() {

		String username = "lxk012";
		List<User> users = userDao.findUser();
		for (User user : users) {
			System.out.println(user.getEmail());
			System.out.println(user.getNickname());
			System.out.println(user.getUsername());
			System.out.println(user.getCreateDate());
			System.out.println(user);
			System.out.println("----------------------------");
		}
	}

}
