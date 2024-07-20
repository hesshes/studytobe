package com.hesshes.studytobe.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//list 1-31
@Configuration
public class CountingDaoFactory {

	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		return new CountingConnectionMaker(realConnectionMaker());
	}

	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new DConnectionMaker();
	}
}
